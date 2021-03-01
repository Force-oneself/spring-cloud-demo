package pers.quan.cloud.filter;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import pers.quan.cloud.common.bean.ResponseCode;
import pers.quan.cloud.common.bean.ResponseData;
import pers.quan.cloud.common.util.IpUtils;
import pers.quan.cloud.common.util.JsonUtils;

public class IpFilter extends ZuulFilter {

	// IP黑名单列表
	private List<String> blackIpList = Arrays.asList("127.0.0.1");

	public IpFilter() {
		super();
	}

	@Override     
	public boolean shouldFilter() {              
	    return true;
	}

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

	@Override
	public Object run() {
		//System.err.println(2/0);
		RequestContext ctx = RequestContext.getCurrentContext();
		String ip = IpUtils.getIpAddr(ctx.getRequest());
		// 在黑名单中禁用
		if (StringUtils.isNotBlank(ip) && blackIpList.contains(ip)) {
			ctx.setSendZuulResponse(false);
			ctx.set("sendForwardFilter.ran", true);
			ResponseData data = ResponseData.fail("非法请求", ResponseCode.NO_AUTH_CODE.getCode());
			ctx.setResponseBody(JsonUtils.toJson(data));
			ctx.getResponse().setContentType("application/json; charset=utf-8");
			return null;
		}
		return null;
	}

}
