package com.rcan.springmvc.customerhandler;

import java.util.List;

import com.rcan.springmvc.model.Customer;

public interface CustomerHandlerInterface {
	
	public int save(Customer customer);

	public int delete(Integer id);

	public int update(Customer customer);

	public Customer get(Integer id);

	public List<Customer> list();

}
