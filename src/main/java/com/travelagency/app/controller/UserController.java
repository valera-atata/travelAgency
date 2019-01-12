package com.travelagency.app.controller;

import java.util.ArrayList;
import java.util.List;

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
import com.travelagency.app.service.abstracts.TourService;
import com.travelagency.app.service.abstracts.AgentService;
import com.travelagency.app.service.abstracts.ClientService;
import com.travelagency.app.service.abstracts.ContractService;
import com.travelagency.app.service.abstracts.RouteService;
import com.travelagency.app.validator.UserValidator;

@Controller
public class UserController {

	@Autowired
    private AgentService agentService;
	
	@Autowired
    private ClientService clientService;
	
	@Autowired
	private ContractService contractService;
	
	@Autowired
	private RouteService routeService;

	@Autowired
    private SecurityService securityService;
	
	@Autowired
	private TourService tourService;

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
        agentService.add(userForm);
        securityService.autoLogin(userForm.getLogin(), userForm.getConfirmPassword());
        model.addAttribute("form", new EmailForm());
        return "redirect:/menu";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
    	System.out.println(333333333333L);
    	System.out.println(agentService);
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

    @RequestMapping(value = {"/", "/menu"}, method = RequestMethod.GET)
    public String welcome(Model model) {
    	System.out.println(444444444);
        return "menu";
    }
    
    @RequestMapping(value = {"/", "/menu"}, params = "my_clients", method = RequestMethod.GET)
    public String myClients(Model model) {
    	System.out.println("my_clients");
    	String login = securityService.getCurrentUsername();
    	clientService.getAllByAgent(securityService.getCurrentUsername());
//    	ArrayList<ClientEntity> clients = c
        return "menu";
    }
   
    
    @RequestMapping(value = {"/", "/menu"}, params = "adminPage", method = RequestMethod.POST)
    public String adminPage(Model model){
    	return "redirect:/admin";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(Model model) {
    	List<AgentEntity> list = agentService.getAll();
		model.addAttribute("users", list);
        return "admin";
    }
}
