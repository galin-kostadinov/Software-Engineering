package app.web.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter({"/views/home.jsf", "/views/add-job.jsf", "/views/job-details.jsf", "/views/delete-job.jsf"})
public class AuthorizationFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        Object username = request.getSession().getAttribute("username");

        if (username == null) {
            response.sendRedirect("/views/login.jsf");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
