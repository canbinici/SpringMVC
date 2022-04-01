package com.rcan.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rcan.springmvc.customerhandler.CustomerHandlerInterface;
import com.rcan.springmvc.model.Customer;

@Controller
public class MainController {
	
	@Autowired
	private CustomerHandlerInterface customerhandler;
	

	@RequestMapping(value = "/list")
	public ModelAndView listCustomer(ModelAndView model) {
		List<Customer> listCustomer = customerhandler.list();
		model.addObject("listCustomer", listCustomer);
		model.setViewName("/customer_list");

		return model;
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public ModelAndView addCustomer(ModelAndView model) {

		Customer newCustomer = new Customer();
		model.addObject("customer", newCustomer);
		model.setViewName("/customer_form");

		return model;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute Customer customer) {
		customerhandler.save(customer);
		return new ModelAndView("redirect:/customer_list");
	}

}
