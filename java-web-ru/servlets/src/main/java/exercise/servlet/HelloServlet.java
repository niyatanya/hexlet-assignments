package io.hexlet.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "HelloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {
    // BEGIN
    @Override
    protected void doGet(HttpServletRequest req,
                             HttpServletResponse resp) throws IOException,
                                                            ServletException {

        System.out.println("___NAME___: " + req.getParameter("name") + " ___");

        if (req.getParameter("name") != null) {
            String name = req.getParameter("name").toString();
            String message = "Hello, " + name + "!";
            req.setAttribute("message", message);
        } else {
            String message = "Hello, Guest!";
            req.setAttribute("message", message);
        }
        req.getRequestDispatcher("/WEB-INF/hello.jsp").forward(req, resp);
    }
    // END
}
