package org.jeecg.learning.chapter5.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.jeecg.learning.chapter5.core.entity.BaseUuidEntity;
import org.springframework.util.Assert;

/**
 * A customer.
 * 
 */
@Entity
@Table(name = "tbl_customer")
@Inheritance(strategy = InheritanceType.JOINED)
public class Customer extends BaseUuidEntity implements Serializable {

	private static final long serialVersionUID = 6466632427349712204L;

	private String firstname;

	private String lastname;

	private EmailAddress emailAddress;

	private Set<Address> addresses = new HashSet<Address>();

	/**
	 * Returns the firstname of the {@link Customer}.
	 * 
	 * @return
	 */
	@Column(nullable=false,length=60)
	public String getFirstname() {
		return firstname;
	}

	/**
	 * Sets the firstname of the {@link Customer}.
	 * 
	 * @param firstname
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * Returns the lastname of the {@link Customer}.
	 * 
	 * @return
	 */
	@Column(nullable=false,length=60)
	public String getLastname() {
		return lastname;
	}

	/**
	 * Sets the lastname of the {@link Customer}.
	 * 
	 * @param lastname
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * Returns the {@link EmailAddress} of the {@link Customer}.
	 * 
	 * @return
	 */
	@Embedded
	@Column(unique = true)
	@AttributeOverrides({@AttributeOverride(name="email", column=@Column(name="email", table="tbl_customer"))})
	public EmailAddress getEmailAddress() {
		return emailAddress;
	}

	/**
	 * Sets the {@link Customer}'s {@link EmailAddress}.
	 * 
	 * @param emailAddress must not be {@literal null}.
	 */
	public void setEmailAddress(EmailAddress emailAddress) {
		this.emailAddress = emailAddress;
	}

	/**
	 * Return the {@link Customer}'s addresses.
	 * 
	 * @return
	 */
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@OrderBy("id ASC")
	public Set<Address> getAddresses() {
		return addresses;
	}

	/**
	 * Adds the given {@link Address} to the {@link Customer}.
	 * 
	 * @param address must not be {@literal null}.
	 */
	public void setAddresses(Set<Address> addresses) {

		Assert.notNull(addresses);
		this.addresses = addresses;
	}
}
