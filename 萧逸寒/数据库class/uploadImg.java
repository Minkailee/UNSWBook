package myData;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.eclipse.jdt.core.compiler.InvalidInputException;

/**
 * Servlet implementation class uploadImg
 */
@WebServlet(name="uploadImg", urlPatterns="/uploadImg")
public class uploadImg extends HttpServlet {

	private static final long serialVersionUID = 1L;
	// 上传文件存储目录
    private static final String UPLOAD_DIRECTORY = "uploadfile";
    // 上传配置
    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 1; // 1MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 2; // 2MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 5; // 5MB
    
    public uploadImg() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 检测是否为多媒体上传
        if (!ServletFileUpload.isMultipartContent(request)) {
            // 如果不是则停止
            PrintWriter writer = response.getWriter();
            writer.println("Error: 表单必须包含 enctype=multipart/form-data");
            writer.flush();
            return;
        }
        // 连接数据库
        Connection c = DatabaseConnect.connect("postgres", "Fresh-2017");
        
        // 配置上传参数
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // 设置内存临界值 - 超过后将产生临时文件并存储于临时目录中
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        // 设置临时存储目录
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
        // 构造临时路径来存储上传的文件
        // 这个路径相对当前应用的目录
        String uploadPath = getServletContext().getRealPath("./") + File.separator + UPLOAD_DIRECTORY;
        //String uploadPath = UPLOAD_DIRECTORY;
        System.out.println(uploadPath);
        // 如果目录不存在则创建
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        ServletFileUpload upload = new ServletFileUpload(factory);
        // 设置最大文件上传值
        upload.setFileSizeMax(MAX_FILE_SIZE);
        // 设置最大请求值 (包含文件和表单数据)
        upload.setSizeMax(MAX_REQUEST_SIZE); 
        // 中文处理
        upload.setHeaderEncoding("UTF-8"); 

        // 解析提交来的表单
        try{
			List<FileItem> formItems = upload.parseRequest(request);
	        if (formItems != null && formItems.size() > 0) {
		        // 迭代表单数据
		        for (FileItem item : formItems) {
		        	// 处理不在表单中的字段
				    if (!item.isFormField()) {
				        String wholeName = new File(item.getName()).getName(); 
				        if(wholeName.equals("")){
				        	request.setAttribute("imgPath", "");
					        request.setAttribute("message", "Empty file!");
				        	throw new InvalidInputException("Empty file!");
				        }
				        // 图片后缀名
				    	String suffix = wholeName.substring(wholeName.lastIndexOf(".") + 1);
				    	// 获取图片索引
						int image_index = DatabaseConnect.getIndex(c)[1];
						
				        String fileName = Integer.toString(image_index++) + "." + suffix;
				        String filePath = uploadPath + File.separator + fileName;
				        
				        // 图片的相对路径，非常重要，显示图片时依靠此路径
				        String dataPath = UPLOAD_DIRECTORY + "\\" + fileName;
				        File storeFile = new File(filePath);
				        // 在控制台输出文件的上传路径
				        System.out.println(filePath);
				        
				        // 保存文件到硬盘
				        item.write(storeFile);
				       
				        DatabaseConnect.uploadImg(c, image_index, dataPath);
				        request.setAttribute("img", dataPath);
				        request.setAttribute("message", "Upload Done");
				       
				    	}
		        }
	        }
        } catch (Exception e) {
        	request.setAttribute("message", e.getMessage());
        	//e.printStackTrace();
	        System.err.println(e.getClass().getName()+": "+e.getMessage());
	        
        }
      
        // 跳转到show
        getServletContext().getRequestDispatcher("/show.jsp").forward(
                request, response);
	}

}
