package com.metyis.customer.care.service;

import java.text.MessageFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.metyis.customer.care.config.PropertiesConfig;
import com.metyis.customer.care.helper.MessageType;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class WhatsappService {

	@Autowired
	private PropertiesConfig propConfig;

	@Autowired

	private Environment env;

	public String processWhatsAppMessage(MessageType messageType, String mobileNumber) {

		String propertyMessage = env.getProperty(messageType.name());
		String propertyMessageValue = MessageFormat.format(propertyMessage, "12345", "15-July-2025");
		Twilio.init(propConfig.getTwilioAuthSid(), propConfig.getTwilioAuthToken());

		
		Message message = Message .creator(new PhoneNumber("whatsapp:+91" + mobileNumber), new PhoneNumber("whatsapp:+14155238886"),
			propertyMessageValue) .create();
		 

		System.out.println("mesage:"+ message);
		return propertyMessageValue;
	}

}
