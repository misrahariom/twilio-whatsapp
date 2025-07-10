package com.metyis.customer.care.helper;

import java.util.Map;

public class WhatsappHelper {

	public static String format(String propertyName, Map<String, String> values) {
		String result = propertyName;
		for (Map.Entry<String, String> entry : values.entrySet()) {
			String placeholder = "{{" + entry.getKey() + "}}";
			result = result.replace(placeholder, entry.getValue());
		}
		return result;
	}
}
