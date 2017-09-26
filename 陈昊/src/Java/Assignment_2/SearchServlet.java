package Assignment_2;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/SearchController"})
public class SearchServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        ServletContext servletContext = getServletContext();
        String Control_Search = req.getParameter("Ad");
        if(Control_Search.equalsIgnoreCase("show_ad"))
        {
            servletContext.setAttribute("Index",1);
        }
        else
        {
            servletContext.setAttribute("Index",0);
        }
        req.getRequestDispatcher("search.jsp").forward(req,resp);

    }
}
