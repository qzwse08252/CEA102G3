package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginEmpFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("------------LoginEmpFilter------------in");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		Object employeeVO = session.getAttribute("employeeVO");
		System.out.println("LoginEmpFilter:" + session.getId());
		System.out.println("employeeVO is : "+employeeVO);
//		System.out.println("employeeVO is null : " + (employeeVO == null));

		if (employeeVO == null) {
			session.setAttribute("location", req.getRequestURI());
			System.out.println("location:" + session.getAttribute("location"));
			res.sendRedirect(req.getContextPath() + "/back-end/LoginEmp.jsp");
			return;
		} else {
			chain.doFilter(request, response);
		}
		System.out.println("------------LoginEmpFilter------------out");
	}

}
