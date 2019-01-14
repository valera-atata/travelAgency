package com.travelagency.app.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.travelagency.app.entity.AgentEntity;
import com.travelagency.app.entity.ClientEntity;
import com.travelagency.app.entity.ContractEntity;
import com.travelagency.app.entity.EmailForm;
import com.travelagency.app.entity.RouteEntity;
import com.travelagency.app.entity.TourEntity;
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
    	if(securityService.isAdmin()) {
    		return "redirect:/admin_menu";
    	}
        return "menu";
    }
    
    @RequestMapping(value = {"/", "/menu", "/admin_menu"}, params = "create_contract", method = RequestMethod.POST)
    public String createContract(Model model) {
    	System.out.println("create_contract");
    	List<ClientEntity> myClients = clientService.getAllByAgent(securityService.getCurrentUsername());
    	for(ClientEntity c : myClients) {
    		System.out.println(c.getSurname());
    	}
    	if(securityService.isAdmin()) {
    		return "admin_menu";
    	}
    	return "menu";
//        return "create_contract_form";
    }
    
    @RequestMapping(value = {"/", "/menu", "/admin_menu"}, params = "my_clients", method = RequestMethod.POST)
    public String myClients(Model model) {
    	System.out.println("my_clients");
    	List<ClientEntity> myClients = clientService.getAllByAgent(securityService.getCurrentUsername());
    	for(ClientEntity c : myClients) {
    		System.out.println(c.getSurname());
    	}
    	if(securityService.isAdmin()) {
    		return "admin_menu";
    	}
    	return "menu";
//        return "my_clients";
    }
   
    @RequestMapping(value = {"/", "/menu", "/admin_menu"}, params = "my_contracts", method = RequestMethod.POST)
    public String myContracts(Model model) {
    	System.out.println("my_contracts");
    	List<ContractEntity> myContracts = contractService.getAllByAgent(securityService.getCurrentUsername());
    	for(ContractEntity c : myContracts) {
    		System.out.println(c.getAgent().getSurname() + " " + c.getClient().getSurname());
    	}
    	if(securityService.isAdmin()) {
    		return "admin_menu";
    	}
        return "menu";
//        return "my_contracts";
    }
    
    @RequestMapping(value = {"/", "/menu"}, params = "all_routes", method = RequestMethod.POST)
    public String allRoutes(Model model) {
    	System.out.println("all_routes");
    	List<RouteEntity> myContracts = routeService.getAll();
    	for(RouteEntity c : myContracts) {
    		System.out.println(c.getCountry());
    	}
        return "menu";
//        return "all_routes";
    }
    
    @RequestMapping(value = {"/", "/menu"}, params = "all_tours", method = RequestMethod.POST)
    public String allTours(Model model) {
    	System.out.println("all_tours");
    	List<TourEntity> myContracts = tourService.getAll();
    	for(TourEntity c : myContracts) {
    		System.out.println(c.getDate());
    	}
        return "menu";
//        return "all_tours";
    }
    
    @RequestMapping(value = {"/admin_menu"}, method = RequestMethod.GET)
    public String adminMenu(Model model) {
    	return "admin_menu";
    }
    
    
    @RequestMapping(value = {"/admin_menu"}, params = "sum_of_contracts", method = RequestMethod.POST)
    public String sumOfContracts(Model model) {
    	System.out.println("sum_of_contracts");
    	List<Object[]> myClients = tourService.getSumOfContracts();
    	for(Object[] o : myClients) {
    		for(int i = 0; i < o.length; i++) {
    			System.out.println(o[i] + " ");
    		}
    		System.out.println();
    	}
    	
    	return "admin_menu";
    		//        return "sum_of_contracts";
    }
    
    @RequestMapping(value = {"/admin_menu"}, params = "all_routes", method = RequestMethod.POST)
    public String allAdminRoutes(Model model) {
    	System.out.println("admin_all_routes");
    	List<RouteEntity> myContracts = routeService.getAll();
    	for(RouteEntity c : myContracts) {
    		System.out.println(c.getCountry());
    	}
    	return "admin_menu";
//   		return "admin_all_routes";
    }
    
    @RequestMapping(value = {"/admin_menu"}, params = "all_tours", method = RequestMethod.POST)
    public String allAdminTours(Model model) {
    	System.out.println("admin_all_tours");
    	List<TourEntity> myContracts = tourService.getAll();
    	for(TourEntity c : myContracts) {
    		System.out.println(c.getDate());
    	}
    	return "admin_menu";
//		return "admin_all_tours";
    }
    
    @RequestMapping(value = {"/admin_menu"}, params = "all_contracts", method = RequestMethod.POST)
    public String allContracts(Model model) {
    	System.out.println("admin_all_contracts");
    	List<ContractEntity> myContracts = contractService.getAll();
    	for(ContractEntity c : myContracts) {
    		System.out.println(c.getAgent().getSurname() + " " + c.getClient().getSurname());
    	}
    	return "admin_menu";
//		return "admin_all_contracts";
    }
    
    @RequestMapping(value = {"/admin_menu"}, params = "statistics_of_agents", method = RequestMethod.POST)
    public String statisticsOfAgents(Model model) {
    	System.out.println("admin_statistics");
    	List<Object[]> myClients = agentService.getStatistics();
    	for(Object[] o : myClients) {
    		for(int i = 0; i < o.length; i++) {
    			System.out.println(o[i] + " ");
    		}
    		System.out.println();
    	}
    	return "admin_menu";
//		return "admin_statistics";
    }
    
    @RequestMapping(value = {"/admin_menu"}, params = "all_clients", method = RequestMethod.POST)
    public String allClients(Model model) {
    	System.out.println("admin_all_clients");
    	List<ClientEntity> myClients = clientService.getAll();
    	for(ClientEntity c : myClients) {
    		System.out.println(c.getSurname());
    	}
    	return "admin_menu";
//		return "admin_all_clients";
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
    
    
    
    private void input() {
//    	RouteEntity route = new RouteEntity();
//    	TourEntity tour1 = new TourEntity();
//    	TourEntity tour2 = new TourEntity();
//    	AgentEntity agent1 = new AgentEntity();
//    	AgentEntity agent2 = new AgentEntity();
//    	ClientEntity client1 = new ClientEntity();
//    	ClientEntity client2 = new ClientEntity();
//    	ContractEntity contract1 = new ContractEntity();
//    	ContractEntity contract2 = new ContractEntity();
//    	ContractEntity contract3 = new ContractEntity();
//    	ContractEntity contract4 = new ContractEntity();
//    	
//    	route.setCountry("Ukraine");
//    	route.setRoute("KR - Dnepr - Kyiv");
//    	
//    	tour1.setOrganizer("Fast");
//    	tour1.setDate(new Date(108, 3, 25));
//    	tour1.setType("VIP");
//    	tour1.setCost(2000);
//    	tour1.setRoute(route);
//    	
//    	tour2.setOrganizer("Slow");
//    	tour2.setDate(new Date(109, 3, 26));
//    	tour2.setType("Standart");
//    	tour2.setCost(1000);
//    	tour2.setRoute(route);
//    	
//    	agent1.setSurname("Petrenko");
//    	agent1.setName("Petr");
//    	agent1.setPatron("Petrovich");
//    	agent1.setPassport("AA123456");
//    	agent1.setAddress("Petrenko street");
//    	agent1.setPhone(971234567L);
//    	agent1.setLogin("petrenko");
//    	agent1.setPassword("11111111");
//    	agent1.setConfirmPassword("11111111");
//    
//    	agent2.setSurname("Ivanov");
//    	agent2.setName("Ivan");
//    	agent2.setPatron("Ivanovich");
//    	agent2.setPassport("AE234567");
//    	agent2.setAddress("Ivanov street");
//    	agent2.setPhone(97334456L);
//    	agent2.setLogin("ivanov");
//    	agent2.setPassword("22222222");
//    	agent2.setConfirmPassword("22222222");
//    	
//    	client1.setSurname("Doronin");
//    	client1.setName("Valeriy");
//    	client1.setPatron("Olegovich");
//    	client1.setPassport("AO222333");
//    	client1.setAddress("Meleshkina street");
//    	client1.setPhone(970028770L);
//    	
//    	client2.setSurname("Govoruha");
//    	client2.setName("Veronika");
//    	client2.setPatron("Vasilievna");
//    	client2.setPassport("AO333444");
//    	client2.setAddress("Puteynaya street");
//    	client2.setPhone(979050293L);
//    	
//    	contract1.setDate(new Date(99, 8, 6));
//    	contract1.setAgent(agent1);
//    	contract1.setClient(client1);
//    	contract1.setTour(tour1);
//    	
//    	contract2.setDate(new Date(99, 8, 7));
//    	contract2.setAgent(agent2);
//    	contract2.setClient(client1);
//    	contract2.setTour(tour2);
//    	
//    	contract3.setDate(new Date(99, 8, 8));
//    	contract3.setAgent(agent1);
//    	contract3.setClient(client2);
//    	contract3.setTour(tour1);
//    	
//    	contract4.setDate(new Date(99, 8, 9));
//    	contract4.setAgent(agent2);
//    	contract4.setClient(client2);
//    	contract4.setTour(tour2);
    
//    	routeService.add(route);
//    	tourService.add(tour1);
//    	tourService.add(tour2);
//    	agentService.add(agent1);
//    	agentService.add(agent2);
//    	clientService.add(client1);
//    	clientService.add(client2);
//    	contractService.add(contract1);
//    	contractService.add(contract2);
//    	contractService.add(contract3);
//    	contractService.add(contract4);
    }
}
