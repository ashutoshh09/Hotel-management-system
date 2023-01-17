package controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dao.AdminImpl;
import dao.IAdmin;
import model.Admin;

@Controller
public class AdminController {

	IAdmin impl = new AdminImpl();
	Admin admin;
	/*
	 * @RequestMapping("admin") public ModelAndView admin1() { return new
	 * ModelAndView("admin");// about.jsp }
	 */

	@RequestMapping("changepassword")
	public ModelAndView changepassword(HttpServletRequest request,HttpServletResponse response,@RequestParam("pr_password") String pr_password,@RequestParam("new_password") String new_password,Model model,HttpSession session) {
	
		
		//session.getAttribute("current-user");
		impl.changepassword(pr_password, new_password,(String)session.getAttribute("current-user"));
		HttpSession httpsession=request.getSession();
		httpsession.setAttribute("message", "Password change successfully");
		return new ModelAndView("admin");
		
		
	}
	
	@SuppressWarnings({ "null" })
	@RequestMapping("adminvalidation")
	public ModelAndView adminLoginValidation(@RequestParam("email") String email,
			@RequestParam("password") String password, Model model, HttpSession session,HttpServletResponse response) throws IOException {

		admin = new Admin();
		admin.setUsername(email);
		admin.setPassword(password);
		ModelAndView view = new ModelAndView("adminlogin");
		
		view.addObject("msg", impl.adminLoginValidate(admin));
		session.setAttribute("current-user", admin.getUsername());
		
		if (impl.adminLoginValidate(admin).contains("success")) {
			
			
			return new ModelAndView("admin");
		} else {
			return new ModelAndView("adminlogin");
		}
	}

	@RequestMapping("adminlogin")
	public ModelAndView admin() {
		return new ModelAndView("adminlogin");
	}
	
	@RequestMapping("logout")
	public void logout(HttpServletRequest request,HttpServletResponse response) throws IOException {
		HttpSession httpSession=request.getSession();
		httpSession.removeAttribute("current-user");
		response.sendRedirect("home");
	}

}
