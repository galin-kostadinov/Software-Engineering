package web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter({"/views/index.jsf", "/views/register.jsf", "/views/login.jsf"})
public class LoggedAuthorizationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        Object username = request.getSession().getAttribute("username");

        if (username != null) {
            ((HttpServletResponse) servletResponse).sendRedirect("/views/home.jsf");
            return;
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
