package com.yuxiaoli.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yuxiaoli.mapper.AddressMapper;
import com.yuxiaoli.pojo.Address;

@Component
public class AddressServiceImpl implements AddressService {
	@Autowired
	public AddressMapper addressMapper;
	
	public List<Address> findAllAddress() throws Exception {
		return addressMapper.findAllAddress();
	}

	public Address findAddressById(int id) throws Exception {
		return addressMapper.findAddressById(id);
	}

}
