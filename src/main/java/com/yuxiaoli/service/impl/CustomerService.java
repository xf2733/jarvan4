package com.yuxiaoli.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.yuxiaoli.pojo.Customer;
import com.yuxiaoli.pojo.PageRoll;


public interface CustomerService {
	//ͨ���û���������Customer
	public Customer findCustomerByFirst_name(String first_name) throws Exception;
	//ͨ����ҳ������Customer��
	public List<Customer> findAllCutomer() throws Exception;
	//����Customer
	public int addCustomer(Customer customer)throws Exception;
	//ͨ��id������Customer��Ϣ
	public Customer findCustomerByid(int id) throws Exception;
	//����Customer
	public int updateCustomer(Customer customer) throws Exception;
	//ɾ��Customer
	public int deleteCustomerById(int id) throws Exception;
	
}
