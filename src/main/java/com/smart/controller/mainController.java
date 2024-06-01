package com.smart.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import com.smart.entities.User;
import com.smart.helper.Message;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import com.smart.dao.MyRepo;

@Controller
public class mainController {

	@Autowired
	private MyRepo MyRepo;

	@GetMapping(value = "/")
	public String home(Model m) {
		m.addAttribute("title", "Home - Online Contact Manager");
		return "home";
	}

	@GetMapping(value = "/about")
	public String about(Model m) {
		m.addAttribute("title", "About - Online Contact Manager");
		return "about";
	}

	@GetMapping(value = "/signup")
	public String signup(Model m) {
		m.addAttribute("title", "SignUp - Online Contact Manager");
		m.addAttribute("user", new User());
		return "signup";
	}

	@GetMapping(value = "/login")
	public String login(Model m) {
		m.addAttribute("title", "LogIn - Online Contact Manager");
		return "login";
	}

	@PostMapping(value = "/do_register")
	public String do_register(@Valid @ModelAttribute("user") User user,BindingResult result,
			@RequestParam(value = "aggrement", defaultValue = "false") boolean aggrement, Model m,
			HttpSession session) {
		try {
			if (!aggrement) {
				throw new Exception("Please select Terms and Conditions");
			}
			if(result.hasErrors()) {
				System.out.println(result.toString());
				m.addAttribute("user",user);
				return "signup";	
			}
			user.setActive(true);
			user.setRole("User_Role");
			user.setImgURL("default.png");
			User res = this.MyRepo.save(user);
			System.out.println(result);
			m.addAttribute("user", new User());
			session.setAttribute("message", new Message("Successfully Registered...", "alert-success"));
			return "signup";

		} catch (Exception e) {
			System.out.println("Error");
			m.addAttribute("user", user);
			session.setAttribute("message",new Message(e.getMessage(), "alert-danger"));
			return "signup";
		}
	}
	@ModelAttribute("message")
	public void removeMessage(SessionStatus status) {
	    status.setComplete();
	}
}