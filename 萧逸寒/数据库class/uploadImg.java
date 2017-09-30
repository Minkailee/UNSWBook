package ass2;

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


/**
 * Servlet implementation class uploadImg
 */
@WebServlet(name="uploadImg", urlPatterns="/uploadImg")
public class uploadImg extends HttpServlet {

	private static final long serialVersionUID = 1L;
	// �ϴ��ļ��洢Ŀ¼
    private static final String UPLOAD_DIRECTORY = "uploadfile";
    // �ϴ�����
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
		// ����Ƿ�Ϊ��ý���ϴ�
        if (!ServletFileUpload.isMultipartContent(request)) {
            // ���������ֹͣ
            PrintWriter writer = response.getWriter();
            writer.println("Error: ��������� enctype=multipart/form-data");
            writer.flush();
            return;
        }
        // �������ݿ�
        Connection c = DatabaseConnect.connect("postgres", "Fresh-2017");
        
        // �����ϴ�����
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // �����ڴ��ٽ�ֵ - �����󽫲�����ʱ�ļ����洢����ʱĿ¼��
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        // ������ʱ�洢Ŀ¼
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
        // ������ʱ·�����洢�ϴ����ļ�
        // ���·����Ե�ǰӦ�õ�Ŀ¼
        String uploadPath = getServletContext().getRealPath("./") + File.separator + UPLOAD_DIRECTORY;
        //String uploadPath = UPLOAD_DIRECTORY;
        System.out.println(uploadPath);
        // ���Ŀ¼�������򴴽�
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        ServletFileUpload upload = new ServletFileUpload(factory);
        // ��������ļ��ϴ�ֵ
        upload.setFileSizeMax(MAX_FILE_SIZE);
        // �����������ֵ (�����ļ��ͱ�����)
        upload.setSizeMax(MAX_REQUEST_SIZE); 
        // ���Ĵ���
        upload.setHeaderEncoding("UTF-8"); 

        // �����ύ���ı�
        try{
			List<FileItem> formItems = upload.parseRequest(request);
	        if (formItems != null && formItems.size() > 0) {
		        // ����������
		        for (FileItem item : formItems) {
		        	// �����ڱ��е��ֶ�
				    if (!item.isFormField()) {
				        String wholeName = new File(item.getName()).getName(); 
				        if(wholeName.equals("")){
				        	request.setAttribute("imgPath", "");
					        request.setAttribute("message", "Empty file!");
				        	throw new Exception("Empty file!");
				        }
				        // ͼƬ��׺��
				    	String suffix = wholeName.substring(wholeName.lastIndexOf(".") + 1);
				    	// ��ȡͼƬ����
						int image_index = DatabaseConnect.getIndex(c)[1];
						
				        String fileName = Integer.toString(image_index++) + "." + suffix;
				        String filePath = uploadPath + File.separator + fileName;
				        
				        // ͼƬ�����·�����ǳ���Ҫ����ʾͼƬʱ������·��
				        String dataPath = UPLOAD_DIRECTORY + "\\" + fileName;
				        File storeFile = new File(filePath);
				        // �ڿ���̨����ļ����ϴ�·��
				        System.out.println(filePath);
				        
				        // �����ļ���Ӳ��
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
      
        // ��ת��show
        getServletContext().getRequestDispatcher("/show.jsp").forward(
                request, response);
	}

}
