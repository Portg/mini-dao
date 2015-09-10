package org.jeecg.learning.chapter5.entity;

import java.io.Serializable;
import java.util.regex.Pattern;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.springframework.util.Assert;

/**
 * A value object abstraction of an email address.
 * 
 * @author Oliver Gierke
 */
@Embeddable
public class EmailAddress implements Serializable {

	private static final long serialVersionUID = -7252475664258488335L;
	private static final String EMAIL_REGEX = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private static final Pattern PATTERN = Pattern.compile(EMAIL_REGEX);

	private String value;

	/**
	 * Creates a new {@link EmailAddress} from the given string source.
	 * 
	 * @param emailAddress must not be {@literal null} or empty.
	 */
	public EmailAddress(String emailAddress) {
		Assert.isTrue(isValid(emailAddress), "Invalid email address!");
		this.value = emailAddress;
	}

	public EmailAddress() {

	}

	/**
	 * Returns whether the given {@link String} is a valid {@link EmailAddress} which means you can safely instantiate the
	 * class.
	 * 
	 * @param source
	 * @return
	 */
	public static boolean isValid(String source) {
		return PATTERN.matcher(source).matches();
	}

	@Column(name = "email", length = 60)
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
