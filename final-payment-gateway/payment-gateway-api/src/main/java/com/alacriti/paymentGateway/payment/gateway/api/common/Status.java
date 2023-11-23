package com.alacriti.paymentGateway.payment.gateway.api.common;

public enum Status {
	SUCESS("sucess"),
	FAIL("fail");
	
	public String status;
	Status(String status) {
		this.status = status;
	}
}
