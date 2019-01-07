package com.travelagency.app.controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
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

import com.travelagency.app.dao.BaseDao;
import com.travelagency.app.dao.hibernatedao.RouteHibernateDao;
import com.travelagency.app.entity.RouteEntity;

@Controller
public class UserController {

	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "menu";
	}
	
	
	@RequestMapping(value = {"/", "/menu"}, params = "create_contract", method = RequestMethod.POST)
    public String createContract(){
    	System.out.println("create");
        return "menu";
    }
	
	@RequestMapping(value = {"/", "/menu"}, params = "my_clients", method = RequestMethod.POST)
    public String myClients(){
    	System.out.println("myClients");
        return "menu";
    }
	
	@RequestMapping(value = {"/", "/menu"}, params = "sum_of_contracts", method = RequestMethod.POST)
    public String sumOfContracts(){
    	System.out.println("sumOfContracts");
        return "menu";
    }
	
	@RequestMapping(value = {"/", "/menu"}, params = "my_contracts_on_period", method = RequestMethod.POST)
    public String myContractsOnPeriod(){
    	System.out.println("myContractsOnPeriod");
        return "menu";
    }
	
	@RequestMapping(value = {"/", "/menu"}, params = "all_routes", method = RequestMethod.POST)
    public String allRoutes(Model model){
		BaseDao<RouteEntity> routeDao = new RouteHibernateDao();
		System.out.println(routeDao);
		String[] cols = new String[] {"id", "country", "route"};
		List<RouteEntity> list = routeDao.getAll();
		System.out.println(list);
		System.out.println(list.size());

		model.addAttribute("routes", routeDao.getAll());
		model.addAttribute("columns", new ArrayList<String>(Arrays.asList(cols)));
    	System.out.println("allRoutes");
        return "routes";
    }
	
	@RequestMapping(value = {"/", "/menu"}, params = "all_contracts", method = RequestMethod.POST)
    public String allContracts(){
    	System.out.println("allContracts");
        return "menu";
    }
	
	@RequestMapping(value = {"/", "/menu"}, params = "statistics_of_agents", method = RequestMethod.POST)
    public String statisticsOfAgents(){
    	System.out.println("statisticsOfAgents");
        return "menu";
    }
	
	@RequestMapping(value = {"/", "/menu"}, params = "all_agents", method = RequestMethod.POST)
    public String allAgents(){
    	System.out.println("allAgents");
        return "menu";
    }
	
	@RequestMapping(value = {"/", "/menu"}, params = "log_out", method = RequestMethod.POST)
    public String logOut(){
    	System.out.println("logOut");
        return "menu";
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
