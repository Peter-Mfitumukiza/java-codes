package com.example.enterprisedemo;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("<p style='background-color: black; padding: 10px; width: fit-content; color: white;" +
                " font: Roboto'> Simply trying something </p>");
        out.println("</body></html>");
        System.out.println("Hello Peter");
    }

    public void destroy() {
    }
}