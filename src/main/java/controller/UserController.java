package controller;

import model.User;
import service.UserInterFace;
import service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserController", value = "/UserController")
public class UserController extends HttpServlet {
    private UserInterFace userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                formCreate(request, response);
                break;
            case "update":
                formUpdate(request, response);
                break;
            case "remove":
                formRemove(request, response);
                break;
            default:
                showAllUser(request, response);
                break;
        }
    }

    private void formRemove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/remove.jsp");
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userService.findById(id);
        request.setAttribute("user",user);
        requestDispatcher.forward(request, response);
    }

    private void formUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/update.jsp");
        int id = Integer.parseInt(request.getParameter("id"));
        User user1 = userService.findById(id);
        request.setAttribute("user", user1);
        requestDispatcher.forward(request, response);
    }

    private void formCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/create.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showAllUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/list.jsp");
        List<User> list = userService.showAllAscName();
        request.setAttribute("list", list);
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createUser(request, response);
                break;
            case "update":
                updateUser(request,response);
                break;
            case "remove":
                removeUser(request, response);
                break;
            default:
                showAllUser(request, response);
                break;
        }
    }

    private void removeUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        userService.remove(id);
        response.sendRedirect("/UserController");
    }

    private void updateUser(HttpServletRequest request,HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name1 = request.getParameter("name");
        String email = request.getParameter("email");
        String  country= request.getParameter("country");
        User user = new User(name1,email,country);
        userService.update(id,user);
        response.sendRedirect("/UserController");

    }

    private void createUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User user = new User(name,email,country);
        userService.create(user);
        response.sendRedirect("/UserController");
    }
}