package pers.quan.cloud.service;


import pers.quan.cloud.feign.AuthQuery;
import pers.quan.cloud.po.User;

public interface AuthService {

	User auth(AuthQuery query);
	
}
