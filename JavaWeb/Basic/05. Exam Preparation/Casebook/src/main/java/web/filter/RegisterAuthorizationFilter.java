package web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter({"/views/profile.jsf", "/views/friends.jsf", "/views/home.jsf"})
public class RegisterAuthorizationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        Object username = request.getSession().getAttribute("username");

        if (username == null) {
            ((HttpServletResponse) servletResponse).sendRedirect("/views/login.jsf");
            return;
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
