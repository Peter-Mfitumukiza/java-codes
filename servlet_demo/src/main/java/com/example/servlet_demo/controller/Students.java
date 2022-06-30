package com.example.servlet_demo.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.crypto.spec.PSource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.servlet_demo.Models.Student;
import com.example.servlet_demo.dao.StudentDao;
import com.example.servlet_demo.dao.StudentDaoHbnt;


/**
 * Servlet implementation class Students
 */
@WebServlet(name = "students",value = "/students")
public class Students extends HttpServlet {
    private static final long serialVersionUID = 1L;
//    private StudentDao studentDao;
private StudentDaoHbnt studentDao;

    public void init() {
//        String jdbcURL =  getServletContext().getInitParameter("jdbc:mysql://localhost:3306/cgroup_db");
//        String jdbcUsername = getServletContext().getInitParameter("root");
//        String jdbcPassword = getServletContext().getInitParameter("2352003");

        // CREATE TABLE CALLED STUDENT IN YOUR DATABASE WITH id, first_name,last_name and gender
//        studentDao = new StudentDao("jdbc:mysql://localhost:3306/servlet_demo", "peter", "2021");
          studentDao = new StudentDaoHbnt();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        System.out.println(action);
        try {
            switch (action) {
                case "/students/new":
                    showNewForm(request, response);
                    break;
                case "/students/insert":
                    insertStudent(request, response);
                    break;
                case "/students/delete":
                    deleteStudent(request, response);
                    break;
                case "/students/edit":
                    showEditForm(request, response);
                    break;
                case "/students/update":
                    updateStudent(request, response);
                    break;
                default:
                    listStudent(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listStudent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Student> listStudent = studentDao.listAllStudents();
        request.setAttribute("listStudent", listStudent);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/students.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/add_student.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        Student existingStudent = studentDao.getStudent(new Student(new Long(id)));

        RequestDispatcher dispatcher = request.getRequestDispatcher("/add_student.jsp");
        request.setAttribute("student", existingStudent);
        dispatcher.forward(request, response);

    }
    //list of students
    private void insertStudent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String gender = request.getParameter("gender");
        Student newStudent = new Student(firstName, lastName, gender);

        studentDao.insertStudent(newStudent);
       response.sendRedirect("list");
    }

    private void updateStudent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("firstName");
        String author = request.getParameter("lastName");
        String gender = request.getParameter("gender");

        Student student = new Student(Long.valueOf(id), title, author, gender);
        studentDao.updateStudent(student);
        response.sendRedirect("list");
    }

    private void deleteStudent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = new Student(Long.valueOf(id));
        studentDao.deleteStudent(student);
        response.sendRedirect("list");

    }

}




