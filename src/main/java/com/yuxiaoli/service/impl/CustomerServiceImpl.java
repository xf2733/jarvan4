package com.yuxiaoli.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.yuxiaoli.mapper.CustomerMapper;
import com.yuxiaoli.pojo.Customer;
import com.yuxiaoli.pojo.PageRoll;


public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	public CustomerMapper customerMapper;
	
	public Customer findCustomerByFirst_name(String first_name)
			throws Exception {
		Customer customer = customerMapper.findCustomerByFirst_name(first_name);
//		System.out.println(customer.getEmail());
		return customer;
	}

	public List<Customer> findAllCutomer() throws Exception {
		// TODO Auto-generated method stub
		/*int count=customerMapper.findTotalCount();
		pageRoll.setTotalCount(count);*/
		return customerMapper.findAllCutomer();
	}
	
	public int addCustomer(Customer customer) throws Exception {
		return customerMapper.addCustomer(customer);
	}

	public Customer findCustomerByid(int id) throws Exception {
		// TODO Auto-generated method stub
		return customerMapper.findCustomerByid(id);
	}

	public int updateCustomer(Customer customer) throws Exception {
		// TODO Auto-generated method stub
		return customerMapper.updateCustomer(customer);
	}

	public int deleteCustomerById(int id) throws Exception {
		// TODO Auto-generated method stub
		customerMapper.change();
		return customerMapper.deleteCustomerById(id);
	}

	


}
