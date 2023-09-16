package com.example.myapp.biz.type3.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.example.myapp.biz.type3.domain.Customer;
import com.example.myapp.form.type3.CustomerForm;

@Service
public class MockCustomerServiceImpl implements CustomerService{

	private static final SimpleDateFormat FORMATTER = new SimpleDateFormat("yyyyMMdd");
	
	private Map<Integer, Customer> customer_data = new LinkedHashMap<Integer, Customer>();
	
	private Integer count;

	
	/**
	 * 顧客一覧リスト取得
	 * 
	 */
	@Override
	public List<Customer> findAll() {
		return new ArrayList<>(customer_data.values());
	}

	/**
	 * 顧客データ保存
	 * 
	 */
	@Override
	public void save(CustomerForm customer) {
		customer.setId(count++);
		Customer target = new Customer();
		BeanUtils.copyProperties(customer, target);
		customer_data.put(target.getId(), target);
	}
	
	/**
	 * @PostConstructはBeanが初期化されるときに実行される。
	 */
	@PostConstruct
	public void init() {
		count = 1;
		save(new CustomerForm("山田", "yamada@yamada.com", convertDate("19900102"), 1));
		save(new CustomerForm("佐藤", "satou@satou.com", convertDate("18970405"), 2));
		save(new CustomerForm("木村", "kimura@kimura.com", convertDate("19891010"), 3));
	}
	
	/**
	 * String型からDate型に型変換
	 * 
	 * @param dateStr
	 * @return
	 */
	public static Date convertDate(String dateStr) {
		Date resDate = null;
		try {
			resDate = FORMATTER.parse(dateStr);
			
		} catch (ParseException e) {
			throw new RuntimeException();
		}
		
		return resDate;
	}
	
}
