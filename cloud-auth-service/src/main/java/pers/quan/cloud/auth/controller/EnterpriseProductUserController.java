package pers.quan.cloud.auth.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.quan.cloud.auth.param.LoginParam;
import pers.quan.cloud.auth.service.EnterpriseProductUserService;
import pers.quan.cloud.common.bean.ResponseData;


@RestController
@RequestMapping("/user")
public class EnterpriseProductUserController {

    @Autowired
    private EnterpriseProductUserService enterpriseProductUserService;

    @Autowired
    private HttpServletRequest request;

    /**
     * 用户登录
     *
     * @return
     */
    @PostMapping("/login")
    public ResponseData login(@RequestBody LoginParam param) {
        if (param == null || param.getEid() == null || StringUtils.isBlank(param.getUid())) {
            return ResponseData.failByParam("eid和uid不能为空");
        }
        return ResponseData.ok(enterpriseProductUserService.login(param.getEid(), param.getUid()));
    }

    @GetMapping("/hello")
    public String hello() {
        System.err.println("用户ID:" + request.getHeader("uid"));
        return "hello";
    }

}
