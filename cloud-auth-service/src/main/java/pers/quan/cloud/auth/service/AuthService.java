package pers.quan.cloud.auth.service;


import pers.quan.cloud.auth.po.User;
import pers.quan.cloud.auth.query.AuthQuery;

public interface AuthService {

	User auth(AuthQuery query);
	
}
