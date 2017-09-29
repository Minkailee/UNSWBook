package Assignment_2;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = {"/SearchResult"})
public class result_search extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String Name_o = req.getParameter("name_search");
        String Sex_o = req.getParameter("sex_search");
        String Birth_o = req.getParameter("bir_search");

        ArrayList NameList = new ArrayList();

        if(Name_o!=null)
        {

            String Name = Name_o.replace(" ", "");
            System.out.println(Name);
            for(int i=0; i<Name.length(); i++)
            {
                if(Name.charAt(i) == ' ')
                {
                    Name = Name.substring(i+1);
                    continue;
                }
                if(Name.charAt(i) == ';')
                {

                    NameList.add(Name.substring(0,i));
                    Name = Name.substring(i+1);
                    i = 0;
                }
                if(!Name.contains(";"))
                {
                    NameList.add(Name);
                    break;
                }
            }
        }

        ServletContext con = getServletContext();
        con.setAttribute("NameList_search", NameList);

//        System.out.println("-------------------");
//        System.out.println(NameList);
        if(Sex_o!=null)
        {
            String Sex = Sex_o.trim();
//            System.out.println(Sex);
            con.setAttribute("Sex_search", Sex);

        }
        if(Birth_o!=null)
        {
            String Birth = Birth_o.trim();
//            System.out.println(Birth);
            con.setAttribute("Birth_search", Birth);
        }







        req.getRequestDispatcher("search_result.jsp").forward(req,resp);

    }
}
