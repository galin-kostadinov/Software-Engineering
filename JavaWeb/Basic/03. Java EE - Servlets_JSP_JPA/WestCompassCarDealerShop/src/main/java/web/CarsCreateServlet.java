package web;

import models.entity.Engine;
import models.entity.User;
import services.CarsService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/cars/create")
public class CarsCreateServlet extends HttpServlet {
    private final CarsService carsService;

    @Inject
    public CarsCreateServlet(CarsService carsService) {
        this.carsService = carsService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/car-create.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String brand = req.getParameter("brand");
        String model = req.getParameter("model");
        Integer year = Integer.parseInt(req.getParameter("year"));
        Engine engine = Engine.valueOf(req.getParameter("engine"));

        String username = req.getSession().getAttribute("user").toString();

        try {
            this.carsService.create(brand, model, year, engine, username);
            resp.sendRedirect("/home");
        } catch (Exception e) {
            resp.sendRedirect("/cars/create");
        }
    }
}
