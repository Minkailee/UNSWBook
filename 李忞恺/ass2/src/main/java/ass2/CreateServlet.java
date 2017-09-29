package ass2;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(urlPatterns = {"/create_new_message"})
public class CreateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext context = getServletContext();
        String content = req.getParameter("content");
        String href = req.getParameter("href");
        Integer id = (Integer) context.getAttribute("user_id");
        ArrayList<Message_Databean> temp_list = (ArrayList<Message_Databean>) context.getAttribute("message_list");
        ArrayList<Integer> like= new ArrayList<Integer>();
        Message_Databean new_message = new Message_Databean(new Date(),id,content,href, like);
        temp_list.add(0,new_message);
        context.setAttribute("message_list",temp_list);
        req.getRequestDispatcher("homepage.jsp").forward(req,resp);

    }
}
