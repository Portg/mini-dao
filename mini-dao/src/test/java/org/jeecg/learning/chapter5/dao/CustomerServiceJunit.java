package org.jeecg.learning.chapter5.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.jeecg.learning.chapter5.entity.Address;
import org.jeecg.learning.chapter5.entity.Customer;
import org.jeecg.learning.chapter5.entity.EmailAddress;
import org.jeecg.learning.chapter5.service.CustomerService;
import org.jeecgframework.minidao.util.UUIDGenerator;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import test.spring.SpringTxTestCase;

public class CustomerServiceJunit extends SpringTxTestCase {

	@Autowired
	private CustomerService customerService;

	String  id = "e4e4e4084fb58ab9014fb58acb4d0000";

	@Test
	public void testInsert() {
		logger.info("--------testInsert--------------------------------------------------------------");

		Customer customer = new Customer();
		EmailAddress email = new EmailAddress("george@google.com");
		customer.setFirstname("乔治");
		customer.setLastname("鲁尼");
		customer.setEmailAddress(email);
		Set<Address> addresses = new HashSet<Address>();
		Address address = new Address();
		address.setId(UUIDGenerator.generate().toUpperCase());
		address.setStreet("曼哈顿第一大道");
		address.setCity("纽约");
		address.setCountry("美国");
		address.setCustomer(customer);
		addresses.add(address);
		customer.setAddresses(addresses);
		customerService.saveByHiber(customer);
	}

	@Test
	public void testUpdate() {
		logger.info("--------testUpdate--------------------------------------------------------------");

		Customer customer = new Customer();
		customer.setId(id);
		customer.setFirstname("乔治");
		customer.setLastname("鲁尼");
		EmailAddress email = new EmailAddress("george@google.com.cn");
		customer.setEmailAddress(email);
		customerService.updateByHiber(customer);
	}

	@Test
	public void testListByHiber() {
		logger.info("--------testListByHiber--------------------------------------------------------------");
		Customer customer = new Customer();
		customer.setFirstname("乔治");
		List<Customer> list = customerService.listByHiber(customer);
		for(Customer c:list){
			System.out.println(c.getFirstname());
			System.out.println(c.getLastname());
			System.out.println(c.getEmailAddress().getValue());
		}

	}

	@Test
	public void testDeleteByIdHiber() {
		customerService.deleteByIdHiber(Customer.class, "e4e4e4084fb5beeb014fb5beeb540000");
	}

}
