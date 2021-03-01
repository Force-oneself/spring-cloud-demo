package pers.quan.cloud.controller;


import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import com.ctrip.framework.apollo.spring.annotation.ApolloJsonValue;
import pers.quan.cloud.config.Student;
import pers.quan.cloud.spring.annotation.SpringValueProcessor;
import pers.quan.cloud.spring.annotation.property.SpringValue;

@RestController
public class ConfigController {


	@ApolloConfig
	private Config config;
	 
	@ApolloJsonValue("${stus:[]}")
	private List<Student> stus;
	
	@GetMapping("/config/stus")
	public List<Student> stus() {
		return stus;
	}

	@Value("${cxytiandiName:yinjihuan}")
	private String name;

	@Value("${cxytiandiUrl}")
	private String cxytiandiUrl;

	@Autowired
	private SpringValueProcessor springValueProcessor;

	@Autowired
	private ConfigurableBeanFactory beanFactory;

	@GetMapping("/get")
	public String get() {
		return name + cxytiandiUrl;
	}

	@GetMapping("/update")
	public String update(String value) {
		Collection<SpringValue> targetValues = springValueProcessor.springValueRegistry.get(beanFactory,
				"cxytiandiName");
		for (SpringValue val : targetValues) {
			try {
				val.update(value);
			} catch (IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		return name;
	}

	@ApolloConfigChangeListener
	private void someOnChange(ConfigChangeEvent changeEvent) {
		if(changeEvent.isChanged("username")) {
			System.out.println("username发生修改了");
		}
	}
	 
}
