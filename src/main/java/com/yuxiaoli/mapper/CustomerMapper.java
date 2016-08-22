package com.yuxiaoli.mapper;

import java.util.List;

import com.yuxiaoli.pojo.Customer;
import com.yuxiaoli.pojo.CustomerCustom;
import com.yuxiaoli.pojo.PageRoll;

public interface CustomerMapper {
	public Customer findCustomerByFirst_name(String first_name) throws Exception;
	public List<Customer> findAllCutomer() throws Exception;
	public int findTotalCount() throws Exception;
	public int addCustomer(Customer customer)throws Exception;
	public Customer findCustomerByid(int id) throws Exception;
	public int updateCustomer(Customer customer) throws Exception;
	public int deleteCustomerById(int id) throws Exception;
	public int change() throws Exception;
}
