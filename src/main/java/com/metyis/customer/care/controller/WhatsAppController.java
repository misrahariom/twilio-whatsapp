package com.metyis.customer.care.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.metyis.customer.care.helper.MessageType;
import com.metyis.customer.care.service.WhatsappService;

@RestController
public class WhatsAppController {

	@Autowired
	private WhatsappService whatsappService;

	@GetMapping("/send-whatsapp-msg")
	public ResponseEntity<Map<String, String>> sendWhatsappMessage(
			@RequestParam(name = "messageType", defaultValue = "ORDER_CONFIRMATION") MessageType messageType,
			@RequestParam(name = "contactNumber") String mobileNumber) {

		String msgStatus = whatsappService.processWhatsAppMessage(messageType, mobileNumber);
		
		Map<String, String> reportStatus = Map.of("messageType", messageType.name(), "msgStatus", msgStatus);
		return new ResponseEntity(reportStatus, HttpStatus.OK);

	}

}
