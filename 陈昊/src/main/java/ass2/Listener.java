package ass2;

import javax.servlet.ServletContext;

import javax.servlet.ServletContextEvent;

import javax.servlet.ServletContextListener;



public class Listener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent servletContextEvent)

    {

        ServletContext con = servletContextEvent.getServletContext();

        con.setAttribute("Index",0);

    }



    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

}
