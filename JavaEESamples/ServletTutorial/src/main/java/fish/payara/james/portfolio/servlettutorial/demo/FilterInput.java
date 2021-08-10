package fish.payara.james.portfolio.servlettutorial.demo;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * Checks if the parameter entered ends with a number, if not it filters the request, otherwise directs to the ErrorMessage servlet
 */
public class FilterInput implements Filter {
	public void init(FilterConfig filterConfig) throws ServletException {
    }
	
	@Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
		String name = request.getParameter("first_name");
		
	    if(!name.matches(".*\\d.*")){
	        filterChain.doFilter(request, response);
	        return;
	    }
	    else {
	    	HttpServletResponse res = (HttpServletResponse) response;	    	
	    	res.sendRedirect("/ErrorMessage");
	    }
    }
}
