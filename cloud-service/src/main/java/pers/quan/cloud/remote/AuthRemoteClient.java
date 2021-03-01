package pers.quan.cloud.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pers.quan.cloud.common.bean.ResponseData;


/**
 * 认证服务API调用客户端
 *
 * @author yinjihuan
 **/
@FeignClient(value = "cloud-auth-service")
public interface AuthRemoteClient {

    /**
     * 调用认证,获取token
     *
     * @param query
     * @return
     */
    @PostMapping("/oauth/token")
    ResponseData auth(@RequestBody AuthQuery query);

    @GetMapping("/user/hello")
    String hello();
}