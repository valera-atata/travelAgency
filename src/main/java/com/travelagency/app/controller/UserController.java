package com.travelagency.app.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class UserController {

	
//	@RequestMapping(value="/page", method = RequestMethod.GET)
//	public ModelAndView getPage(){
//		System.out.println("111111111111111111111111111111");
//		ModelAndView view =new ModelAndView("home");
//		return view;
//	}
	
	@RequestMapping(value="/page", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private SecurityService securityService;
//
//    @Autowired
//    private UserValidator userValidator;
//
//    @RequestMapping(value = "/registration", method = RequestMethod.GET)
//    public String registration(Model model) {
//    	System.out.println("111111111111111");
//        model.addAttribute("userForm", new User());
//        return "registration";
//    }
//
//    @RequestMapping(value = "/registration", method = RequestMethod.POST)
//    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
//    	System.out.println("2222222222222222");
//    	System.out.println(userForm.getUsername() + " " + userForm.getPassword());
//        userValidator.validate(userForm, bindingResult);
//        if (bindingResult.hasErrors()) {
//            return "registration";
//        }
//        System.out.println(new RoleDao().getById(1L));
//        System.out.println("let`s save");
//        userService.save(userForm);
//        System.out.println("it has been saved");
//        securityService.autoLogin(userForm.getUsername(), userForm.getConfirmPassword());
//       
//        model.addAttribute("form", new EmailForm());
//        return "redirect:/welcome";
//    }
//
//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    public String login(Model model, String error, String logout) {
//    	System.out.println("333333333333333333");
//        if (error != null) {
//            model.addAttribute("error", "Username or password is incorrect.");
//        }
//        if (logout != null) {
//            model.addAttribute("message", "Logged out successfully.");
//        }
//        return "login";
//    }
//
//    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
//    public String welcome(Model model) {
//    	System.out.println("444444444444444444444");
//    	System.out.println(123);
//    	model.addAttribute("form", new EmailForm());
//        return "welcome";
//    }
//    
//    @RequestMapping(value = {"/", "/welcome"}, params = "send", method = RequestMethod.POST)
//    public String sendEmail(@ModelAttribute("form") EmailForm form, Model model){
//    	System.out.println("5555555555555555555555");
//    	try{
//    		new Sender().send(form.getSendEmail(), form.getPassword(), form.getRecipEmail(), form.getMessage());
//    		model.addAttribute("result", "successful");	
//    	} catch(MessagingException ex){
//    		model.addAttribute("result", "error");
//    		ex.printStackTrace();
//    	}
//    	model.addAttribute("form", new EmailForm());
//        return "welcome";
//    }
//    
//    @RequestMapping(value = {"/", "/welcome"}, params = "adminPage", method = RequestMethod.POST)
//    public String adminPage(Model model){
//    	System.out.println("666666666666666666666666");
//    	return "redirect:/admin";
//    }
//
//    @RequestMapping(value = "/admin", method = RequestMethod.GET)
//    public String admin(Model model) {
//    	System.out.println("7777777777777777777777777");
//    	List<User> list = userService.findAll();
//		model.addAttribute("users", list);
//        return "admin";
//    }
}
