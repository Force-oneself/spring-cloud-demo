package pers.quan.cloud.filter;


import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import pers.quan.cloud.common.bean.ResponseCode;
import pers.quan.cloud.common.bean.ResponseData;
import pers.quan.cloud.common.util.JsonUtils;
import pers.quan.cloud.config.BasicConf;

/**
 * 服务降级过滤器
 *
 * @author yinjihuan
 **/
public class DownGradeFilter extends ZuulFilter {

    @Autowired
    private BasicConf basicConf;

    public DownGradeFilter() {
        super();
    }

    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        Object success = ctx.get("isSuccess");
        return success == null ? true : Boolean.parseBoolean(success.toString());
    }

    @Override
    public String filterType() {
        return "route";
    }

    @Override
    public int filterOrder() {
        return 4;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        Object serviceId = ctx.get("serviceId");
        if (serviceId != null && basicConf != null) {
            List<String> serviceIds = Arrays.asList(basicConf.getDownGradeServiceStr().split(","));
            if (serviceIds.contains(serviceId.toString())) {
                ctx.setSendZuulResponse(false);
                ctx.set("isSuccess", false);
                ResponseData data = ResponseData.fail("服务降级中", ResponseCode.DOWNGRADE.getCode());
                ctx.setResponseBody(JsonUtils.toJson(data));
                ctx.getResponse().setContentType("application/json; charset=utf-8");
                return null;
            }
        }
        return null;
    }
}
