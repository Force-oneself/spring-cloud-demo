package pers.quan.cloud.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pers.quan.cloud.common.ResponseData;


/**
 * 认证服务API调用客户端   
 * @author yinjihuan  
 * 
 **/ 
@FeignClient(value = "cloud-auth-jwt", path = "/oauth")
public interface AuthRemoteClient {
	
  /**      
   * 调用认证,获取token      
   * @param query      
   * @return      
   */ 
   @PostMapping("/token")
   ResponseData auth(@RequestBody AuthQuery query);
   
}