package com.metyis.customer.care.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Configuration
@Getter
@Setter
public class PropertiesConfig {

	@Value("${ORDER_NOTIFICATION}")
	private String orderNotification;

	@Value("${ORDER_CONFIRMATION}")
	private String orderConfirmation;

	@Value("${ACCOUNT_SID}")
	private String twilioAuthSid;

	@Value("${AUTH_TOKEN}")
	private String twilioAuthToken;

}
