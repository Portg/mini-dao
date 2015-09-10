package org.jeecg.learning.chapter5.dao;

import org.jeecg.learning.chapter5.entity.Address;
import org.jeecgframework.minidao.annotation.Arguments;
import org.jeecgframework.minidao.annotation.ResultType;
import org.jeecgframework.minidao.annotation.Sql;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Repository;

@Repository("addressDao")
public interface AddressDao {

	@Arguments({ "address", "page", "rows" })
	@ResultType(Address.class)
	public MiniDaoPage<Address> getAllAddressList(Address address, int page,
			int rows);

	@Arguments({"street", "city", "country"})
	Address getAddress(String street, String city, String country);


	@Sql("SELECT count(*) FROM tbl_address")
	Integer getCount();

	@Arguments("address")
	int update(Address address);

	@Arguments("address")
	void insert(Address address);
}
