package controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dao.IService;
import dao.ServiceImpl;
import model.Service;
import model.User;

@Controller
public class ServiceController {

	IService service = new ServiceImpl();
	
	
	@RequestMapping("deleteservice")
	public ModelAndView delete(@RequestParam("id") int id) {
		ModelAndView view = new ModelAndView("services");
		view.addObject("msg", service.delete(id));
		view.addObject("b", service.viewService());
		return view;

	}
	
	@RequestMapping("updateservice")
	public ModelAndView updateservice(@RequestParam("id") int id,@RequestParam("name") String name,@RequestParam("desc") String desc,@RequestParam("contact") int contact) {
		ModelAndView view = new ModelAndView("services");
		view.addObject("id", id);
		view.addObject("name", name);
		view.addObject("desc", desc);
		view.addObject("contact", contact);
		view.addObject("b", new User());
		view.addObject("msg", service.delete(id));
		view.addObject("b", service.viewService());
		return view;

	}
	
	@RequestMapping("services")
	public ModelAndView admin() {
		return new ModelAndView("services","b",service.viewService());
	}
	
	@RequestMapping("servicesinfo")
	public ModelAndView serviceinfo() {
		return new ModelAndView("servicesinfo","b",service.viewService());
	}
	
	
	@RequestMapping("addService")
	public ModelAndView addService(HttpServletRequest request,HttpServletResponse response,@ModelAttribute("b") Service b) throws IOException {
		ModelAndView view = new ModelAndView("bill");
		view.addObject("msg", service.add(b));

		view.addObject("b", service.viewService());
		HttpSession httpsession=request.getSession();
		httpsession.setAttribute("message", "Service added successfully");
//		response.sendRedirect("admin");

		return new ModelAndView("admin");// add.jsp

	}
	
	
	
}
