package org.jeecg.learning.chapter5.dao;

import org.jeecg.learning.chapter5.entity.Customer;
import org.jeecgframework.minidao.annotation.Sql;
import org.jeecgframework.minidao.hibernate.MiniDaoSupportHiber;
import org.springframework.stereotype.Repository;

@Repository("customerDao")
public interface CustomerDao extends MiniDaoSupportHiber<Customer> {

	@Sql("SELECT count(*) FROM tbl_customer")
	Integer getCount();
}
