package pers.quan.cloud.client.query;


import pers.quan.cloud.client.common.PageQueryParam;

public class MessageQuery extends PageQueryParam {

	private int status;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
}
