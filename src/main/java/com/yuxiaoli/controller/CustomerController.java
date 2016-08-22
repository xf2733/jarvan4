package com.yuxiaoli.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.yuxiaoli.pojo.Address;
import com.yuxiaoli.pojo.Customer;
import com.yuxiaoli.pojo.PageRoll;
import com.yuxiaoli.service.impl.AddressService;
import com.yuxiaoli.service.impl.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	public CustomerService customerService;
	@Autowired
	public AddressService addressService;
	
	//通过用户名来查找Customer
	@RequestMapping("/login")
	public String login(HttpServletRequest request,@RequestParam("first_name")String first_name) throws Exception{
		/*int page=Integer.parseInt(request.getParameter("page"));
		request.setAttribute("page", page);*/
		request.setCharacterEncoding("utf-8");
		Customer customer=customerService.findCustomerByFirst_name(first_name);
		if(customer!=null){
			request.getSession().setAttribute("username", first_name);
			return "forward:findAllCutomer.action";
		}else{
			request.setAttribute("msg", "error username!");
			return "login";
		}
		
	}
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request)throws Exception{
		
		request.getSession().invalidate();//关闭session
		
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}
	
	//通过页面传过来的当前页数来查找Customer list
	@RequestMapping("/findAllCutomer")
	public ModelAndView findAllCutomer(HttpServletRequest request)throws Exception{
		/*int page=Integer.parseInt(request.getParameter("page"));*/
		int page=1;
	    PageRoll pageRoll=new PageRoll();
	    pageRoll.setCurrPage(page);
		List<Customer> customerList=customerService.findAllCutomer();
		for(Customer customer:customerList){
			String address_name=addressService.findAddressById(customer.getAddress_id()).getAddress();
			customer.setAddress_name(address_name);
		}
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("customerList",customerList);
		
		modelAndView.setViewName("index");
		return modelAndView;
	}
	
	//添加Customer时获得address
	@RequestMapping("/getAllAddress")
	public ModelAndView getAllAddress()throws Exception{
		List<Address> addressList=addressService.findAllAddress();
		/*List<String> addressNameList=new ArrayList<String>();
		for(Address address:addressList){
			addressNameList.add(address.getAddress());
		}*/
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("addressList",addressList);
		modelAndView.setViewName("addCustomer");
		return modelAndView;
		
	}
	//添加Customer
	@RequestMapping("/addCustomer")
	public ModelAndView addCustomer(Customer customer)throws Exception{
		customer.setStore_id(1);
		Date date=new Date();
        customer.setCreate_date(date);
		customerService.addCustomer(customer);
		
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("msg","add customer success!");
		modelAndView.setViewName("addCustomer");
		return modelAndView;
	}
	
	//从列表点击修改按钮时所发生的跳转控制
	@RequestMapping("/editCustomer")
	public ModelAndView editCustomer(int id)throws Exception{
		Customer customer=customerService.findCustomerByid(id);
		
		List<Address> addressList=addressService.findAllAddress();
		/*List<String> addressNameList=new ArrayList<String>();
		for(Address address:addressList){
			addressNameList.add(address.getAddress());
		}*/
		
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("customer",customer);
		modelAndView.addObject("addressList",addressList);
		modelAndView.setViewName("editCustomer");
		return modelAndView;
	}
	
	//修改页面的提交按钮
	@RequestMapping("/editCustomerSubmit")
	public ModelAndView editCustomerSubmit(Customer customer)throws Exception{
		customerService.updateCustomer(customer);
		ModelAndView modelAndView=new ModelAndView();
		
		modelAndView.addObject("msg","update customer success!");
		modelAndView.setViewName("editCustomer");
		return modelAndView;
	}
	
	//删除Customer
	@RequestMapping("/deleteCustomer")
	public ModelAndView deleteCustomer(int id)throws Exception{
		customerService.deleteCustomerById(id);
		ModelAndView modelAndView=new ModelAndView();
		
		modelAndView.addObject("msg","delete customer success!");
		modelAndView.setViewName("index");
		return modelAndView;
	}
	
}
