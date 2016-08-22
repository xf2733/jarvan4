package com.yuxiaoli.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.yuxiaoli.pojo.Customer;
import com.yuxiaoli.pojo.PageRoll;


public interface CustomerService {
	//通过用户名来查找Customer
	public Customer findCustomerByFirst_name(String first_name) throws Exception;
	//通过分页来查找Customer表
	public List<Customer> findAllCutomer() throws Exception;
	//增加Customer
	public int addCustomer(Customer customer)throws Exception;
	//通过id来查找Customer信息
	public Customer findCustomerByid(int id) throws Exception;
	//更新Customer
	public int updateCustomer(Customer customer) throws Exception;
	//删除Customer
	public int deleteCustomerById(int id) throws Exception;
	
}
