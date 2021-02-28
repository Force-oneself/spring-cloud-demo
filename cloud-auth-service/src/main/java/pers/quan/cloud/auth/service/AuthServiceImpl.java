package pers.quan.cloud.auth.service;

import org.springframework.stereotype.Service;
import pers.quan.cloud.auth.po.User;
import pers.quan.cloud.auth.query.AuthQuery;


@Service
public class AuthServiceImpl implements AuthService {

	@Override
	public User auth(AuthQuery query) {
		return new User(1L);
	}

}
