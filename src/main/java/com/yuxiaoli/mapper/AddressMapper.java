package com.yuxiaoli.mapper;

import java.util.List;

import com.yuxiaoli.pojo.Address;
import com.yuxiaoli.pojo.Customer;
import com.yuxiaoli.pojo.CustomerCustom;
import com.yuxiaoli.pojo.PageRoll;

public interface AddressMapper {
	public List<Address> findAllAddress() throws Exception;
	public Address findAddressById(int id) throws Exception;
}
