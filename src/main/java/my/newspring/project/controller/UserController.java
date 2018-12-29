package my.newspring.project.controller;

import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import my.newspring.project.model.EmailForm;
import my.newspring.project.model.User;
import my.newspring.project.service.SecurityService;
import my.newspring.project.service.Sender;
import my.newspring.project.service.UserService;
import my.newspring.project.utils.UserValidator;


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
        model.addAttribute("userForm", new User());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        userService.save(userForm);
        securityService.autoLogin(userForm.getUsername(), userForm.getConfirmPassword());
       
        model.addAttribute("form", new EmailForm());
        return "redirect:/welcome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
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
    	System.out.println(123);
    	model.addAttribute("form", new EmailForm());
        return "welcome";
    }
    
    @RequestMapping(value = {"/", "/welcome"}, params = "send", method = RequestMethod.POST)
    public String sendEmail(@ModelAttribute("form") EmailForm form, Model model){
    	try{
    		new Sender().send(form.getSendEmail(), form.getPassword(), form.getRecipEmail(), form.getMessage());
    		model.addAttribute("result", "successful");	
    	} catch(MessagingException ex){
    		model.addAttribute("result", "error");
    		ex.printStackTrace();
    	}
    	model.addAttribute("form", new EmailForm());
        return "welcome";
    }
    
    @RequestMapping(value = {"/", "/welcome"}, params = "adminPage", method = RequestMethod.POST)
    public String adminPage(Model model){
    	return "redirect:/admin";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(Model model) {
    	List<User> list = userService.findAll();
		model.addAttribute("users", list);
        return "admin";
    }
}
