package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dao.GuestImpl;
import dao.IGuest;
import dao.UserImpl;
import model.Guest;
import model.User;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class GuestController {
	Guest gues=new Guest();
	IGuest guest = new GuestImpl();
	UserImpl userImpl=new UserImpl();

	@RequestMapping("about")
	public ModelAndView about() {
		return new ModelAndView("about");// about.jsp
	}
	
	@RequestMapping("register2")
	public ModelAndView register2() {
		return new ModelAndView("register2");// about.jsp
	}
	
	@RequestMapping("showGuests")
	public ModelAndView showGuests() {
		return new ModelAndView("showGuests", "b", guest.viewGuests());
	}
	
	@RequestMapping("booking")
	public ModelAndView booking(HttpServletRequest request,HttpServletResponse response,HttpSession session,@ModelAttribute("b") Guest b) {
		return new ModelAndView("booking", "b", guest.getGuestByUsername((String)session.getAttribute("name")));
	}

	@RequestMapping("home")
	public ModelAndView home() {
		return new ModelAndView("home");// home.jsp
	}

	@RequestMapping("login")
	public ModelAndView login() {
		return new ModelAndView("login");
	}
	@RequestMapping(path = "signin",method = RequestMethod.POST)
	public String signin(@RequestParam("email") String email,@RequestParam("password") String password,Model model,HttpSession session) {
		User user= userImpl.getUserByUsername(email);
		if(user==null) {
			model.addAttribute("error","Incorrect username or password!");
			return "login";
		}
		if(!(user.getPassword().equals(password))){
			model.addAttribute("error","Incorrect username or password!");
			return "login";
		}
		session.setAttribute("current-email", email);

		session.setAttribute("current-user", user.getName());
		return "redirect:/normal";
	}
	
//	@RequestMapping(path = "login",method = RequestMethod.POST)
//	public String signin(@RequestParam("email") String email,@RequestParam("password") String password,Model model,HttpSession session) {
//		User user=userImpl.getUserByUsername(email);
//		if(user==null) {
//			model.addAttribute("error","Incorrect username or password!");
//			return "signin";
//		}
//		if(!(user.getPassword().equals(password))){
//			model.addAttribute("error","Incorrect username or password!");
//			return "signin";
//		}
//		
//		session.setAttribute("username", user.getName());
//		return "redirect:/home";
//	}
	

	@RequestMapping("view")
	public ModelAndView viewGuests() {
		return new ModelAndView("showGuests", "b", guest.viewGuests());
	}

	@RequestMapping("delete")
	public ModelAndView delete(@RequestParam("id") int id) {
		ModelAndView view = new ModelAndView("showGuests");
		view.addObject("msg", guest.delete(id));
		view.addObject("b", guest.viewGuests());
		return view;

	}

	@RequestMapping("update")
	public ModelAndView delete(@RequestParam("id") int id, @RequestParam("name") String name,
			@RequestParam("check_in") String check_in, @RequestParam("check_out") String check_out,
			@RequestParam("room") int room, @RequestParam("nosguest") int nosguest) {
		ModelAndView view = new ModelAndView("update");// update.jsp
		view.addObject("id", id);
		view.addObject("name", name);
		view.addObject("check_in", check_in);
		view.addObject("check_out", check_out);
		view.addObject("room", room);
		view.addObject("nosguest", nosguest);
		view.addObject("b", new Guest());
		return view;

	}

	@RequestMapping("updatedValue")
	public ModelAndView updatedValue(@ModelAttribute("b") Guest b) {
		ModelAndView view = new ModelAndView("showGuests");
		view.addObject("msg", guest.update(b));
		view.addObject("b", guest.viewGuests());
		return view;

	}

	@RequestMapping("add")
	public ModelAndView add() {
		return new ModelAndView("add", "b", new Guest());// add.jsp

	}
	@RequestMapping("bookastay")
	public ModelAndView bookastay(HttpServletRequest request,HttpServletResponse response,@ModelAttribute("b") Guest b) {
		ModelAndView view = new ModelAndView("bill");
		String str=request.getParameter("name");
		System.out.println(str);
		view.addObject("msg", guest.add(b));
		System.out.println(gues.getId());
		
		view.addObject("b", guest.viewGuests());
		HttpSession httpsession=request.getSession();
		
		httpsession.setAttribute("message", "Guest added successfully");
		httpsession.setAttribute("name", str);
		
		return new ModelAndView("normal");// add.jsp

	}

	@RequestMapping("addGuest")
	public ModelAndView addGuest(HttpServletRequest request,HttpServletResponse response,@ModelAttribute("b") Guest b) {
		ModelAndView view = new ModelAndView("bill");
		String str=request.getParameter("name");
		System.out.println(str);
		view.addObject("msg", guest.add(b));
		System.out.println(gues.getId());
		
		view.addObject("b", guest.viewGuests());
		HttpSession httpsession=request.getSession();
		
		httpsession.setAttribute("message", "Guest added successfully");
		httpsession.setAttribute("name", str);
		
		return new ModelAndView("admin");// add.jsp

	}

	@RequestMapping("bill")
	public ModelAndView bill(@RequestParam("id") int id, @RequestParam("name") String name,
			@RequestParam("check_in") String check_in, @RequestParam("check_out") String check_out,
			@RequestParam("room") int room, @RequestParam("nosguest") int nosguest) {
//		Date.valueOf(check_in).getTime();
//		Date.valueOf(check_in).getTime();
		long difference_In_Time=Date.valueOf(check_out).getTime()-Date.valueOf(check_in).getTime();
        long difference_In_Days
            = (difference_In_Time
               / (1000 * 60 * 60 * 24))
              % 365;
		ModelAndView view=new ModelAndView("bill");
		long k=room*nosguest*difference_In_Days*1000;
		view.addObject("result",k);
		view.addObject("id", id);
		view.addObject("name", name);
		view.addObject("check_in", check_in);
		view.addObject("check_out", check_out);
		view.addObject("room", room);
		view.addObject("nosguest", nosguest);
		view.addObject("b", new Guest());
		return  view;
	}

}
