package com.yuxiaoli.service.impl;

import java.util.List;

import com.yuxiaoli.pojo.Address;

public interface AddressService {
	public List<Address> findAllAddress() throws Exception;
	public Address findAddressById(int id) throws Exception;
}
