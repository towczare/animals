package pl.sda.animals.controller;

import pl.sda.animals.service.AnimalService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "animals", urlPatterns = {"/", "/add", "/details" })
public class AnimalServlet extends HttpServlet {

    public static final String TEXT_HTML = "text/html";

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType(TEXT_HTML);

        if(request.getServletPath().equals("/add")) {
            request.getRequestDispatcher("add.jsp").forward(request, response);
        } else if(request.getServletPath().equals("/details")) {
            String id = request.getParameter("id");
            request.setAttribute("animal", AnimalService.findById(id));
            request.getRequestDispatcher("details.jsp").forward(request, response);
        } else {
            request.setAttribute("animals", AnimalService.findAll());
            request.getRequestDispatcher("list.jsp").forward(request, response);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("name");
        AnimalService.add(name);
        response.sendRedirect("/animals");
    }

}
