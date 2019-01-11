package com.travelagency.app.controller;

import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.travelagency.app.entity.AgentEntity;
import com.travelagency.app.entity.EmailForm;
import com.travelagency.app.service.abstracts.SecurityService;
import com.travelagency.app.service.abstracts.UserService;
import com.travelagency.app.validator.UserValidator;

@Controller
public class UserController {

	@Autowired
    private UserService userService;

	@Autowired
    private SecurityService securityService;

	@Autowired
    private UserValidator userValidator;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
    	System.out.println(1111111111);
        model.addAttribute("userForm", new AgentEntity());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") AgentEntity userForm, BindingResult bindingResult, Model model) {
    	System.out.println(222222222);
    	userForm.setSurname("surname");
    	userForm.setName("name");
    	userForm.setPatron("patron");
    	userForm.setPassport("passport");
    	userForm.setAddress("address");
    	userForm.setPhone(9700000000L);
    	
    	System.out.println(userForm.getAgentId());
    	System.out.println(userForm.getSurname());
    	System.out.println(userForm.getName());
    	System.out.println(userForm.getPatron());
    	System.out.println(userForm.getPassport());
    	System.out.println(userForm.getAddress());
    	System.out.println(userForm.getPhone());
    	System.out.println(userForm.getLogin());
    	System.out.println(userForm.getPassword());
    	System.out.println(userForm.getConfirmPassword());
        userValidator.validate(userForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        userService.save(userForm);
        securityService.autoLogin(userForm.getLogin(), userForm.getConfirmPassword());
        model.addAttribute("form", new EmailForm());
        return "redirect:/welcome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
    	System.out.println(333333333333L);
    	System.out.println(userService);
    	System.out.println(userValidator);
    	System.out.println(securityService);
        if (error != null) {
            model.addAttribute("error", "Username or password is incorrect.");
        }
        if (logout != null) {
            model.addAttribute("message", "Logged out successfully.");
        }
        return "login";
    }

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
    	System.out.println(444444444);
    	model.addAttribute("form", new EmailForm());
        return "welcome";
    }
    
    
//    @RequestMapping(value = {"/", "/welcome"}, params = "send", method = RequestMethod.POST)
//    public String sendEmail(@ModelAttribute("form") EmailForm form, Model model){
//    	System.out.println(55555555555L);
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
    
    @RequestMapping(value = {"/", "/welcome"}, params = "adminPage", method = RequestMethod.POST)
    public String adminPage(Model model){
    	return "redirect:/admin";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(Model model) {
    	List<AgentEntity> list = userService.findAll();
		model.addAttribute("users", list);
        return "admin";
    }
}
