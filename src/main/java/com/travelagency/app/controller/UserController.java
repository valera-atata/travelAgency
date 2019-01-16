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
import org.springframework.web.bind.annotation.RequestParam;

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

    @RequestMapping(value = "/agent_form", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("agentForm", new AgentEntity());
        return "agent_form";
    }

    @RequestMapping(value = "/agent_form", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") AgentEntity userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "redirect:/agent_form";
        }
        agentService.add(userForm);
        securityService.autoLogin(userForm.getLogin(), userForm.getConfirmPassword());
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
    	if(securityService.isAdmin()) {
    		return "redirect:/admin_menu";
    	}
        return "menu";
    }
    
    @RequestMapping(value = {"/admin_menu"}, method = RequestMethod.GET)
    public String adminMenu(Model model) {
    	return "admin_menu";
    }
/////////////////////////////////////////////////////////////////////////// ///////////////////////////////////////////////////////////////////////////
    @RequestMapping(value = "/create_contract", method = RequestMethod.POST)
    public String createContract(Model model) {
    	System.out.println("create_contract");
    	
    	ContractEntity contract = new ContractEntity();
    	contract.setAgent(agentService.getByLogin(securityService.getCurrentUsername()));
    	List<ClientEntity> clients = clientService.getAll();
    	List<TourEntity> tours = tourService.getAll();
    	 
    	model.addAttribute("contractForm", contract);
    	model.addAttribute("clients", clients);
    	model.addAttribute("tours", tours);
    	return "contract_form";
    }
    
    @RequestMapping(value = "/create_contract", params = "submit_contract", method = RequestMethod.POST)
    public String confirmCreateContract(@ModelAttribute("contractForm") ContractEntity contractForm, Model model) {
    	System.out.println("submit_contract " + contractForm.getClient().getClientId());
    	contractForm.setAgent(agentService.getByLogin(securityService.getCurrentUsername()));
    	contractForm.setClient(clientService.getById(contractForm.getClient().getClientId()));
    	contractForm.setTour(tourService.getById(contractForm.getTour().getTourId()));
    	
    	return "forward:/my_contracts";
    }
    
    @RequestMapping(value = "/my_contracts", method = RequestMethod.POST)
    public String myContracts(Model model) {
    	System.out.println("my_contracts");
    	List<ContractEntity> myContracts = contractService.getAllByAgent(securityService.getCurrentUsername());
    	model.addAttribute("myContracts", myContracts);
    	return "my_contracts";
    }
    
    @RequestMapping(value = "/edit_contract", method = RequestMethod.POST)
    public String editContract(@RequestParam("contractId") Long contractId, Model model) {
    	System.out.println("edit_contract " + contractId);
    	
    	ContractEntity contract = contractService.getById(contractId);
    	List<ClientEntity> clients = clientService.getAll();
    	List<TourEntity> tours = tourService.getAll();
    	
    	model.addAttribute("contractForm", contract);
    	model.addAttribute("clients", clients);
    	model.addAttribute("tours", tours);
    	return "contract_form";
    }
    
    @RequestMapping(value = "/edit_contract", params = "submit_contract", method = RequestMethod.POST)
    public String SubmitEditContract(@ModelAttribute("contractForm") ContractEntity contractForm, Model model) {
    	System.out.println("submit_edit_contract");
    	
    	contractForm.setAgent(agentService.getByLogin(securityService.getCurrentUsername()));
    	contractForm.setClient(clientService.getById(contractForm.getClient().getClientId()));
    	contractForm.setTour(tourService.getById(contractForm.getTour().getTourId()));
    	
    	return "forward:/my_contracts";
    }
    
    @RequestMapping(value = "/delete_contract", method = RequestMethod.POST)
    public String deleteContract(@RequestParam("contractId") Long contracttId, Model model) {
    	System.out.println("delete_contract " + contracttId);
    	return "forward:/my_contracts";
    }
    
    /////////////////////////////////////////////////////////////////////////// ///////////////////////////////////////////////////////////////////////////
    @RequestMapping(value = "/my_clients", method = RequestMethod.POST)
    public String myClients(Model model) {
    	System.out.println("my_clients");
    	List<ClientEntity> myClients = clientService.getAllByAgent(securityService.getCurrentUsername());
    	model.addAttribute("myClients", myClients);
    	return "my_clients";
    }
    
    @RequestMapping(value = "/edit_client", method = RequestMethod.POST)
    public String editClient(@RequestParam("clientId") Long clientId, Model model) {
    	System.out.println("edit_client " + clientId);
    	model.addAttribute("clientForm", clientService.getById(clientId));
    	return "client_form";
    }
    
    @RequestMapping(value = "/edit_client", params = "submit_client", method = RequestMethod.POST)
    public String SubmitEditClient(@ModelAttribute("clientForm") ClientEntity clientForm, Model model) {
    	System.out.println("submit_client");
    	System.out.println(clientForm.getSurname());

    	return "forward:/my_clients";
    }
    
    @RequestMapping(value = "/delete_client", method = RequestMethod.POST)
    public String deleteClient(@RequestParam("clientId") Long clientId, Model model) {
    	System.out.println("delete_client " + clientId);
    	return "forward:/my_clients";
    }
    
    @RequestMapping(value = "/add_client", method = RequestMethod.POST)
    public String addClient(Model model) {
    	System.out.println("add_client");
    	model.addAttribute("clientForm", new ClientEntity());
    	return "client_form";
    }
    
    @RequestMapping(value = "/add_client", params = "submit_client", method = RequestMethod.POST)
    public String SubmitAddtClient(@ModelAttribute("clientForm") ClientEntity clientForm, Model model) {
    	System.out.println("submit_client");
    	System.out.println(clientForm.getSurname());
    	return "forward:/my_clients";
    }
    /////////////////////////////////////////////////////////////////////////// ///////////////////////////////////////////////////////////////////////////

	@RequestMapping(value = "/all_routes", method = RequestMethod.POST)
	public String allRoutes(Model model) {
		System.out.println("all_routes");
		List<RouteEntity> routes = routeService.getAll();
		System.out.println(routes.size());
		model.addAttribute("routes", routes);
		return "all_routes";
	}
///////////////////////////////////////////////////////////////////////// ///////////////////////////////////////////////////////////////////////////
	@RequestMapping(value = "/all_tours", method = RequestMethod.POST)
	public String allTours(Model model) {
		System.out.println("all_tours");
		List<TourEntity> tours = tourService.getAll();
		model.addAttribute("tours", tours);
		return "all_tours";
	}
///////////////////////////////////////////////////////////////////////// ///////////////////////////////////////////////////////////////////////////
    
	@RequestMapping(value = "/admin_all_routes", method = RequestMethod.POST)
		public String allAdminRoutes(Model model) {
		System.out.println("all_routes");
		List<RouteEntity> routes = routeService.getAll();
		System.out.println(routes.size());
		model.addAttribute("routes", routes);
		return "admin_all_routes";
	}
    
    @RequestMapping(value = "/edit_route", method = RequestMethod.POST)
    public String editRoute(@RequestParam("routeId") Long routeId, Model model) {
    	System.out.println("edit_route " + routeId);
    	model.addAttribute("routeForm", routeService.getById(routeId));
    	return "route_form";
    }
    
    @RequestMapping(value = "/edit_route", params = "submit_route", method = RequestMethod.POST)
    public String SubmitEditRoute(@ModelAttribute("routeForm") RouteEntity routeForm, Model model) {
    	System.out.println("submit_route");
    	System.out.println(routeForm.getRoute());

    	return "forward:/admin_all_routes";
    }
    
    @RequestMapping(value = "/delete_route", method = RequestMethod.POST)
    public String deleteRoute(@RequestParam("routeId") Long routeId, Model model) {
    	System.out.println("delete_route " + routeId);
    	return "forward:/admin_all_routes";
    }
    
    @RequestMapping(value = "/add_route", method = RequestMethod.POST)
    public String addRoute(Model model) {
    	System.out.println("add_route");
    	model.addAttribute("routeForm", new RouteEntity());
    	return "route_form";
    }
    
    @RequestMapping(value = "/add_route", params = "submit_route", method = RequestMethod.POST)
    public String SubmitAddRoute(@ModelAttribute("routeForm") RouteEntity routeForm, Model model) {
    	System.out.println("submit_client");
    	System.out.println(routeForm.getRoute());
    	return "forward:/admin_all_routes";
    }
    
    /////////////////////////////////////////////////////////////////////////// ///////////////////////////////////////////////////////////////////////////
	  
    @RequestMapping(value = "/admin_all_tours", method = RequestMethod.POST)
	public String allAdminTours(Model model) {
	System.out.println("admin_all_tours");
	List<TourEntity> tours = tourService.getAll();
	model.addAttribute("tours", tours);
	return "admin_all_tours";
}

	@RequestMapping(value = "/edit_tour", method = RequestMethod.POST)
	public String editTour(@RequestParam("tourId") Long tourId, Model model) {
		System.out.println("edit_tour " + tourId);
		model.addAttribute("routes", routeService.getAll());
		model.addAttribute("tourForm", tourService.getById(tourId));
		return "tour_form";
	}
	
	@RequestMapping(value = "/edit_tour", params = "submit_tour", method = RequestMethod.POST)
	public String SubmitEditTour(@ModelAttribute("tourForm") TourEntity tourForm, Model model) {
		System.out.println("submit_tour");
		System.out.println(tourForm.getOrganizer());
	
		return "forward:/admin_all_tours";
	}
	
	@RequestMapping(value = "/delete_tour", method = RequestMethod.POST)
	public String deleteTour(@RequestParam("tourId") Long tourId, Model model) {
		System.out.println("delete_tour " + tourId);
		return "forward:/admin_all_tours";
	}
	
	@RequestMapping(value = "/add_tour", method = RequestMethod.POST)
	public String addTour(Model model) {
		System.out.println("add_tour");
		model.addAttribute("routes", routeService.getAll());
		model.addAttribute("tourForm", new TourEntity());
		return "tour_form";
	}
	
	@RequestMapping(value = "/add_tour", params = "submit_tour", method = RequestMethod.POST)
	public String SubmitAddTour(@ModelAttribute("tourForm") TourEntity tourForm, Model model) {
		System.out.println("submit_tour");
		tourForm.setRoute(routeService.getById(tourForm.getRoute().getRouteId()));
		System.out.println(tourForm.getRoute());
		return "forward:/admin_all_tours";
	}

/////////////////////////////////////////////////////////////////////////// ///////////////////////////////////////////////////////////////////////////

	@RequestMapping(value = {"/sum_of_contracts"}, method = RequestMethod.POST)
	public String sumOfContracts(Model model) {
	  	System.out.println("sum_of_contracts");
	  	List<Object[]> sumOfContracts = tourService.getSumOfContracts();
	  	model.addAttribute("sumOfContracts", sumOfContracts);
	  	return "admin_sum_of_contracts";
  	}
/////////////////////////////////////////////////////////////////////// ///////////////////////////////////////////////////////////////////////////
	
  @RequestMapping(value = "/all_contracts", method = RequestMethod.POST)
  public String allContracts(Model model) {
  	System.out.println("admin_all_contracts");
  	List<ContractEntity> contracts = contractService.getAll();
  	model.addAttribute("contracts", contracts);
	return "admin_all_contracts";
  }

/////////////////////////////////////////////////////////////////////// ///////////////////////////////////////////////////////////////////////////
  
  @RequestMapping(value = "/all_clients", method = RequestMethod.POST)
  public String allClients(Model model) {
  	System.out.println("all_clients");
  	List<ClientEntity> clients = clientService.getAll();
  	model.addAttribute("clients", clients);
  	return "admin_all_clients";
  }
  
/////////////////////////////////////////////////////////////////////// ///////////////////////////////////////////////////////////////////////////
  
	@RequestMapping(value = "/statistics_of_agents", method = RequestMethod.POST)
	public String statisticsOfAgents(Model model) {
		System.out.println("admin_statistics");
		List<Object[]> agents = agentService.getStatistics();
		model.addAttribute("agents", agents);
		return "admin_statistics";
	}

	
//    @RequestMapping(value = {"/", "/menu", "/admin_menu"}, params = "my_clients", method = RequestMethod.POST)
//    public String myClients(Model model) {
//    	System.out.println("my_clients");
//    	List<ClientEntity> myClients = clientService.getAllByAgent(securityService.getCurrentUsername());
//    	model.addAttribute("myClients", myClients);
//    	if(securityService.isAdmin()) {
//    		return "admin_menu";
//    	}
//        return "my_clients";
//    }
//    
//    @RequestMapping(value = {"/edit_client"}, method = RequestMethod.GET)
//    public String saveOrUpdateClient(Model model) {
//    	System.out.println("edit_client");
//        model.addAttribute("clientForm", new ClientEntity());
//        return "client_form";
//    	
////    	if(securityService.isAdmin()) {
////    		return "admin_menu";
////    	}
////    	return "menu";
////      return "edit_client";
//    }
//    
//    @RequestMapping(value = "/edit_client", method = RequestMethod.POST)
//    public String saveOrUpdateClient(@ModelAttribute("clientForm") ClientEntity clientForm, BindingResult bindingResult, Model model) {
//      System.out.println(clientForm.getClientId());
//    	System.out.println(clientForm.getSurname());
//    	System.out.println(clientForm.getName());
//    	System.out.println(clientForm.getPatron());
//    	System.out.println(clientForm.getPassport());
//    	System.out.println(clientForm.getAddress());
//    	System.out.println(clientForm.getPhone());
////        userValidator.validate(clientForm, bindingResult);
////        if (bindingResult.hasErrors()) {
////            return "redirect:/agent_form";
////        }
////        agentService.add(userForm);
////        securityService.autoLogin(userForm.getLogin(), userForm.getConfirmPassword());
//        return "redirect:/menu";
//    }
//    
//    
////    @RequestMapping(value = {"/", "/menu", "/admin_menu"}, params = "edit_client", method = RequestMethod.POST)
////    public String saveOrUpdateClient(Model model) {
////    	System.out.println("edit_client");
//////    	List<ClientEntity> myClients = clientService.getAllByAgent(securityService.getCurrentUsername());
////    	if(securityService.isAdmin()) {
////    		return "admin_menu";
////    	}
////    	return "menu";
//////        return "edit_client";
////    }
//   
//    @RequestMapping(value = {"/", "/menu", "/admin_menu"}, params = "my_contracts", method = RequestMethod.POST)
//    public String myContracts(Model model) {
//    	System.out.println("my_contracts");
//    	List<ContractEntity> myContracts = contractService.getAllByAgent(securityService.getCurrentUsername());
//    	for(ContractEntity c : myContracts) {
//    		System.out.println(c.getAgent().getSurname() + " " + c.getClient().getSurname());
//    	}
//    	if(securityService.isAdmin()) {
//    		return "admin_menu";
//    	}
//        return "menu";
////        return "my_contracts";
//    }
//    

//    

//    
//    
//    @RequestMapping(value = {"/admin_menu"}, params = "sum_of_contracts", method = RequestMethod.POST)
//    public String sumOfContracts(Model model) {
//    	System.out.println("sum_of_contracts");
//    	List<Object[]> myClients = tourService.getSumOfContracts();
//    	for(Object[] o : myClients) {
//    		for(int i = 0; i < o.length; i++) {
//    			System.out.println(o[i] + " ");
//    		}
//    		System.out.println();
//    	}
//    	
//    	return "admin_menu";
//    		//        return "sum_of_contracts";
//    }
//    
//    @RequestMapping(value = {"/admin_menu"}, params = "all_routes", method = RequestMethod.POST)
//    public String allAdminRoutes(Model model) {
//    	System.out.println("admin_all_routes");
//    	List<RouteEntity> myContracts = routeService.getAll();
//    	for(RouteEntity c : myContracts) {
//    		System.out.println(c.getCountry());
//    	}
//    	return "admin_menu";
////   		return "admin_all_routes";
//    }
//    
//    @RequestMapping(value = {"/admin_menu"}, params = "all_tours", method = RequestMethod.POST)
//    public String allAdminTours(Model model) {
//    	System.out.println("admin_all_tours");
//    	List<TourEntity> myContracts = tourService.getAll();
//    	for(TourEntity c : myContracts) {
//    		System.out.println(c.getDate());
//    	}
//    	return "admin_menu";
////		return "admin_all_tours";
//    }
//    
//    @RequestMapping(value = {"/admin_menu"}, params = "all_contracts", method = RequestMethod.POST)
//    public String allContracts(Model model) {
//    	System.out.println("admin_all_contracts");
//    	List<ContractEntity> myContracts = contractService.getAll();
//    	for(ContractEntity c : myContracts) {
//    		System.out.println(c.getAgent().getSurname() + " " + c.getClient().getSurname());
//    	}
//    	return "admin_menu";
////		return "admin_all_contracts";
//    }
//    
//    @RequestMapping(value = {"/admin_menu"}, params = "statistics_of_agents", method = RequestMethod.POST)
//    public String statisticsOfAgents(Model model) {
//    	System.out.println("admin_statistics");
//    	List<Object[]> myClients = agentService.getStatistics();
//    	for(Object[] o : myClients) {
//    		for(int i = 0; i < o.length; i++) {
//    			System.out.println(o[i] + " ");
//    		}
//    		System.out.println();
//    	}
//    	return "admin_menu";
////		return "admin_statistics";
//    }
//    
//    @RequestMapping(value = {"/admin_menu"}, params = "all_clients", method = RequestMethod.POST)
//    public String allClients(Model model) {
//    	System.out.println("admin_all_clients");
//    	List<ClientEntity> myClients = clientService.getAll();
//    	for(ClientEntity c : myClients) {
//    		System.out.println(c.getSurname());
//    	}
//    	return "admin_menu";
////		return "admin_all_clients";
//    }
//    
//    
//    
//    
//    
//    @RequestMapping(value = {"/", "/menu"}, params = "adminPage", method = RequestMethod.POST)
//    public String adminPage(Model model){
//    	return "redirect:/admin";
//    }
//
//    @RequestMapping(value = "/admin", method = RequestMethod.GET)
//    public String admin(Model model) {
//    	List<AgentEntity> list = agentService.getAll();
//		model.addAttribute("users", list);
//        return "admin";
//    }
    
    
    
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
