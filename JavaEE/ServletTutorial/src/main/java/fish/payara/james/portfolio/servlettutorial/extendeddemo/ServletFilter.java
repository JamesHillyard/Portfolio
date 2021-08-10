package fish.payara.james.portfolio.servlettutorial.extendeddemo;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

/**
 * Intercepts the redirect to "Login Servlet", checking if the user is banned from the list, if so sending them to a banned page
 * otherwise filtering the request
 */
@WebFilter({"/LoginServlet"})
public class ServletFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        String username = request.getParameter("username");
        List<String> bannedUsers = Arrays.asList("Josh", "Seb");

        if (!bannedUsers.contains(username)) {
            filterChain.doFilter(request, response);
        } else {
            HttpServletResponse res = (HttpServletResponse) response;
            res.sendRedirect("BannedUser.html");
        }
    }
}
