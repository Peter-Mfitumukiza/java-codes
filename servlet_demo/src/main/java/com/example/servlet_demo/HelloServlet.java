package com.example.servlet_demo;
import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World! HelloServlet file";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        String requestPath = request.getServletPath();
        if (requestPath.equals("/hello-servlet/student")){
            //redirecting to list.jsp
            RequestDispatcher dispatcher = request.getRequestDispatcher("/Student_list.jsp");
            dispatcher.forward(request, response);
        }
        else if (requestPath.equals("/hello-servlet/student/new")){
            //redirecting to list.jsp
            RequestDispatcher dispatcher = request.getRequestDispatcher("/add_student.jsp");
            dispatcher.forward(request, response);
        }
        System.out.println("ELSE");
    }

    public void destroy() {
    }
}