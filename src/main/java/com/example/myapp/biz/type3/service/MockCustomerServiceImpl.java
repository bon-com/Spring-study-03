package com.example.myapp.biz.type3.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.example.myapp.biz.type3.common.Type3Constant;
import com.example.myapp.biz.type3.domain.Customer;
import com.example.myapp.errors.DataNotFoundException;
import com.example.myapp.form.type3.CustomerForm;

@Service
public class MockCustomerServiceImpl implements CustomerService {
	/** 仮顧客一覧DBマップ */
	private Map<Integer, Customer> customer_data = new LinkedHashMap<>();
	
	/** 顧客IDカウント */
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
	 * 顧客情報の取得
	 * @throws DataNotFoundException 
	 * 
	 */
	@Override
	public Customer findById(int customerId) throws DataNotFoundException {
		if (!customer_data.containsKey(customerId)) {
			throw new DataNotFoundException();
		}
		return customer_data.get(customerId);
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
	 * 顧客データ更新
	 * @throws DataNotFoundException 
	 * 
	 */
	@Override
	public void update(CustomerForm customer) throws DataNotFoundException {
		if (!customer_data.containsKey(customer.getId())) {
			throw new DataNotFoundException();
		}
		
		Customer target = new Customer();
		BeanUtils.copyProperties(customer, target);
		
		customer_data.put(target.getId(), target);
	}
	
	/**
	 * 顧客データ削除
	 * 
	 */
	@Override
	public void delete(int customerId) throws DataNotFoundException {
		if (!customer_data.containsKey(customerId)) {
			throw new DataNotFoundException();
		}
		
		customer_data.remove(customerId);
	}
	/**
	 * PostConstructアノテーションはBeanが初期化されるときに実行される。
	 */
	@PostConstruct
	public void init() {
		count = 1;
		save(new CustomerForm("山田", "yamada@yamada.com", convertDate("1990-01-02"), 1, "02"));
		save(new CustomerForm("佐藤", "satou@satou.com", convertDate("1897-04-05"), 2, "23"));
		save(new CustomerForm("木村", "kimura@kimura.com", convertDate("1989-10-10"), 3, "41"));
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
			resDate = Type3Constant.DATE_FORMATTER.parse(dateStr);

		} catch (ParseException e) {
			throw new RuntimeException();
		}

		return resDate;
	}


}
