package org.jeecg.learning.chapter5.dao;

import javax.annotation.Resource;

import org.jeecg.learning.chapter5.entity.Address;
import org.jeecg.learning.chapter5.entity.Customer;
import org.jeecg.learning.chapter5.service.CustomerService;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.jeecgframework.minidao.util.UUIDGenerator;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import test.spring.SpringTxTestCase;

public class AddressDaoJunit extends SpringTxTestCase {

	@Resource(name = "addressDao")
	private AddressDao addressDao;

	@Autowired
	private CustomerService customerService;

	@Test
	public void testInsert() {
		logger.info("--------testInsert--------------------------------------------------------------");

		Address address = new Address();
		address.setId(UUIDGenerator.generate().toLowerCase());
		address.setStreet("格林第一大道");
		address.setCity("纽约");
		address.setCountry("美国");
		Customer c = customerService.getByIdHiber(Customer.class, "e4e4e4084fb58ab9014fb58acb4d0000");
		address.setCustomer(c);
		addressDao.insert(address);
	}

	@Test
	public void testGetAllAddressList() {

		logger.info("--------testGetAllAddressList--------------------------------------------------------------");
		Address address = new Address();
		address.setCountry("美国");
		address.setCity("纽约");
		MiniDaoPage<Address> list = addressDao
				.getAllAddressList(address, 0, 10);

		for (Address ad : list.getResults()) {
			logger.info(ad.getId());
			logger.info(ad.getCountry());
			logger.info(ad.getCity());
			logger.info(ad.getStreet());
		}
	}

	@Test
	public void testUpdate() {
		logger.info("--------testUpdate--------------------------------------------------------------");

		Address address = new Address();
		address.setId("E4E4E4084FB58AC2014FB58AC2580000");
		address.setStreet("曼哈顿第二大道");
		int num = addressDao.update(address);
		logger.info("------update---count---" + num);
	}

	@Test
	public void testGetAddress() {
		Address address = addressDao.getAddress("格林第一大道", "纽约","美国");
		logger.info("testGetEntity --" + address.getCity());
	}
}
