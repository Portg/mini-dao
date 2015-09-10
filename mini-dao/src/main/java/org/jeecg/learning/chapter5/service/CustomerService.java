package org.jeecg.learning.chapter5.service;

import java.util.List;

import org.jeecg.learning.chapter5.dao.CustomerDao;
import org.jeecg.learning.chapter5.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerDao customerDao;

	public void saveByHiber(Customer customer) {
		customerDao.saveByHiber(customer);
	}

	public void updateByHiber(Customer customer) {
		customerDao.updateByHiber(customer);
	}

	public Customer getByIdHiber(Class<Customer> class1, String id) {
		return customerDao.getByIdHiber(Customer.class, id);
	}

	public void deleteByIdHiber(Class<Customer> class1, String id) {
		customerDao.deleteByIdHiber(class1, id);
	}

	public List<Customer> listByHiber(Customer customer) {
		return customerDao.listByHiber(customer);
	}
}
