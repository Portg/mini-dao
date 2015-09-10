package org.jeecg.learning.chapter5.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * An address.
 * 
 */
@Entity
@Table(name = "tbl_address")
public class Address implements Serializable {

	private static final long serialVersionUID = 7111360072768976388L;

	private String id;

	private String street, city, country;

	private Customer customer;

	@Id
	@Column(name = "id", nullable = false, length = 32)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Sets the street of the {@link Address}.
	 * 
	 * @param street
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * Returns the street.
	 * 
	 * @return
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * Sets the city of the {@link Address}.
	 * 
	 * @param city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Returns the city.
	 * 
	 * @return
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Sets the country of the {@link Address}.
	 * 
	 * @param country
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * Returns the country.
	 * 
	 * @return
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * Returns the customer.
	 * 
	 * @return
	 */
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER, optional = true)
	@JoinColumn(name="customer_id", referencedColumnName="id")
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * Sets the customer of the {@link Address}.
	 * 
	 * @param customer
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
