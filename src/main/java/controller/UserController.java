package controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dao.IUser;
import dao.UserImpl;
import model.Guest;
import model.User;

@Controller
public class UserController {
	
	IUser user = new UserImpl();
	UserImpl userImpl=new UserImpl();

	@RequestMapping("userchangepassword")
	public ModelAndView changepassword(HttpServletRequest request,HttpServletResponse response,@RequestParam("pr_password") String pr_password,@RequestParam("new_password") String new_password,Model model,HttpSession session) {
	
		
		//session.getAttribute("current-user");
		userImpl.userchangepassword(pr_password, new_password,(String)session.getAttribute("current-user"));
		HttpSession httpsession=request.getSession();
		httpsession.setAttribute("message", "Password change successfully");
		return new ModelAndView("normal");
		
		
	}
	
	@RequestMapping("alluser")
	public ModelAndView viewGuests() {
		return new ModelAndView("alluser", "b", user.viewUsers());
	}
	
	@RequestMapping("deleteuser")
	public ModelAndView delete(@RequestParam("id") int id) {
		ModelAndView view = new ModelAndView("alluser");
		view.addObject("msg", user.delete(id));
		view.addObject("b", user.viewUsers());
		return view;

	}
	
	@RequestMapping("updateuser")
	public ModelAndView updatedUser(@RequestParam("id") int id, @RequestParam("name") String name,
			@RequestParam("mobile") long mobile, @RequestParam("email") String email,
			@RequestParam("password") String password, @RequestParam("address") String address) {
		ModelAndView view = new ModelAndView("updateuser");// updateuser.jsp
		view.addObject("id", id);
		view.addObject("name", name);
		view.addObject("mobile", mobile);
		view.addObject("email", email);
		view.addObject("password", password);
		view.addObject("address", address);
		view.addObject("b", new User());
		return view;

	}
	@RequestMapping("updatedUserValue")
	public ModelAndView updatedUserValue(@ModelAttribute("b") User b) {
		ModelAndView view = new ModelAndView("userdetail");
		view.addObject("msg", user.update(b));
		view.addObject("b", user.viewUsers());
		return new ModelAndView("normal");

	}

	
	@RequestMapping(value="/registeruser",method=RequestMethod.POST)
	public ModelAndView addUser(HttpServletRequest request,HttpServletResponse response,@ModelAttribute("b") User b) throws IOException {
		ModelAndView view = new ModelAndView("userpage");
		view.addObject("msg", user.add(b));
		//user.add(b);
		HttpSession httpSession = request.getSession();
		httpSession.setAttribute("message", "Registration Successful !! "+b.getName());
		response.sendRedirect("register2");
		
		return new ModelAndView("userpage","name",b.getName());// add.jsp

	}
	
	
	
	
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public ModelAndView showRegister(HttpServletRequest request,HttpServletResponse response,@ModelAttribute("b") User b) throws IOException {
		//ModelAndView view = new ModelAndView("alluser");
		//view.addObject("msg", user.add(b));
		ModelAndView view = new ModelAndView("register");
		
		view.addObject("msg", new User());
		
	
		//view.addObject("alert","Registration Successful");
		return view;// add.jsp

	}
	
	@RequestMapping("normal")
	public ModelAndView normal() {
		return new ModelAndView("normal");
	}
	
	
	
	
	@RequestMapping(path = "/login",method = RequestMethod.POST)
	public String signin(HttpServletRequest request,HttpServletResponse response,@RequestParam("email") String email,@RequestParam("password") String password,Model model) {
		HttpSession session=request.getSession();
		User user= userImpl.getUserByUsername(email);
		if(user==null) {
			model.addAttribute("error","Incorrect username or password!");
			return "signin";
		}
		if(!(user.getPassword().equals(password))){
			model.addAttribute("error","Incorrect username or password!");
			return "signin";
		}
		String str=request.getParameter("email");

		session.setAttribute("current-user", user.getName());
		session.setAttribute("current-id", user.getId());
		System.out.println((Integer)session.getAttribute("current-id"));
		System.out.println((String)session.getAttribute("current-user"));

		return "redirect:/normal";
	}
	
	
	@RequestMapping("user")
	public ModelAndView user() {
		
		return new ModelAndView("user");// user.jsp
	}
	
	@RequestMapping("userdetail")
	public ModelAndView userdetail(HttpServletRequest request,HttpServletResponse response,Model model) {
		HttpSession session=request.getSession();
		

		return new ModelAndView("userdetail", "b", userImpl.getUserByemail((String)session.getAttribute("current-email")));

	}

}
