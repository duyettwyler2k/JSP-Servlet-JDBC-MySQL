package Serverlet;

import Dao.UserDao;
import model.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/users")
public class UserServlet extends HttpServlet {
    private UserDao userDao = new UserDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showNewForm(request, response);
                break;
            case "update":
                updateForm(request, response);
                break;
            case "delete":
                deleteForm(request,response);
                break;
            default:
                showListUser(request, response);
                break;


        }
    }

    private void deleteForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       int id= Integer.parseInt(request.getParameter("id"));
       userDao.deleteUser(id);
       RequestDispatcher dispatcher;
       response.sendRedirect("/users");
    }

    private void updateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/update.jsp");
        dispatcher.forward(request, response);

    }


    private void showListUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<user> users = userDao.selectAllUsers();
        request.setAttribute("users", users);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/user/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/create.jsp");
        dispatcher.forward(request, response);
    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                insertUser(request, response);
                break;
            case "update":
                updateUser(request,response);
                break;

            default:
                showListUser(request, response);
                break;
        }
    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        user users = new user(name, email, country);
        userDao.insertUser(users);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/create.jsp");
        dispatcher.forward(request, response);
    }
    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        user user = new user(id, name, email, country);
        userDao.updateUser(user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/user/update.jsp");
        dispatcher.forward(request, response);

    }

}
