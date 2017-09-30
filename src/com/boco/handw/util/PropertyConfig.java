package com.boco.handw.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.util.PropertyPlaceholderHelper;

public class PropertyConfig extends PropertyPlaceholderConfigurer {
	private static Map<String, String> properties = new HashMap<String, String>();

	protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props) throws BeansException {
		// cache the properties
		PropertyPlaceholderHelper helper = new PropertyPlaceholderHelper(DEFAULT_PLACEHOLDER_PREFIX, DEFAULT_PLACEHOLDER_SUFFIX, DEFAULT_VALUE_SEPARATOR, false);
		for (Entry<Object, Object> entry : props.entrySet()) {
			String key = String.valueOf(entry.getKey());
			String value = String.valueOf(entry.getValue());
			value = helper.replacePlaceholders(value, props);
			properties.put(key, value);
		}
		super.processProperties(beanFactoryToProcess, props);
	}

	public static Map<String, String> getProperties() {
		return properties;
	}

	public static String getProperty(String key) {
		return properties.get(key);
	}

	/*
	 * 用配置文件中key值（中英文键值对）的英文替换jsonStr的对应中文
	 */
	public static String ReplaceFieldNameChEoEn(String jsonStr, String key) {
		String map = PropertyConfig.getProperty(key);
		String[] pairs = map.split(",");
		for (String pair : pairs) {
			String en = pair.split(":")[0];
			String ch = pair.split(":")[1];
			if (jsonStr.contains(String.format("'%s'", ch))) {
				jsonStr = jsonStr.replace(ch, en);
			}
		}
		return jsonStr;
	}
}
