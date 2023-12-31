package com.example.myapp.biz.type3.service;

import java.util.List;

import com.example.myapp.biz.type3.domain.Customer;
import com.example.myapp.errors.DataNotFoundException;
import com.example.myapp.form.type3.CustomerForm;

/**
 * 顧客情報を操作するインターフェース
 * 
 */
public interface CustomerService {

	List<Customer> findAll();
	
	void save(CustomerForm customer);
	
	Customer findById(int customerId) throws DataNotFoundException;
	
	void update(CustomerForm customer) throws DataNotFoundException;
	
	void delete(int customerId) throws DataNotFoundException;
}
