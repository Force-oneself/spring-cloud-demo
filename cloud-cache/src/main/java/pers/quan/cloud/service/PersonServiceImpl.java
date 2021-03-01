package pers.quan.cloud.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import pers.quan.cloud.po.Person;

@Service
public class PersonServiceImpl implements PersonService {
	
	@Cacheable(value = "get", key = "#id")
	public Person get(String id) {
		Person p = new Person();
		p.setFirstname("xxx");
		p.setLastname("bbb");
		p.setId("111");
		return p;
	}
	
}
