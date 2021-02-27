package pers.quan.cloud.service;

import org.springframework.stereotype.Service;
import pers.quan.cloud.feign.AuthQuery;
import pers.quan.cloud.po.User;


@Service
public class AuthServiceImpl implements AuthService {

	@Override
	public User auth(AuthQuery query) {
		return new User(1L);
	}

}
