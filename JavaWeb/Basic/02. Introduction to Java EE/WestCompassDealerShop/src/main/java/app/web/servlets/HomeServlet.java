package app.web.servlets;

import app.util.FileUtil;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/")
public class HomeServlet extends HttpServlet {
    private static String HOME_FILE_VIEW_PATH ="F:\\ComputerProgramming\\GitHubRepoSoftUniTasks\\Software-Engineering\\JavaWeb\\Basic\\02. Introduction to Java EE\\WestCompassDealerShop\\src\\main\\webapp\\views\\home.html";
    private final FileUtil fileUtil;

    @Inject
    public HomeServlet(FileUtil fileUtil) {
        this.fileUtil = fileUtil;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String html = fileUtil.readFile(HOME_FILE_VIEW_PATH);
        resp.getWriter().println(html);
    }
}
