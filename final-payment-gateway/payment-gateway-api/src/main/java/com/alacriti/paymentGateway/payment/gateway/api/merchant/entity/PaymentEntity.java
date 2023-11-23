package com.alacriti.paymentGateway.payment.gateway.api.merchant.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "payment_info")
public class PaymentEntity {
	
	@Id
	private UUID id = UUID.randomUUID();
	
	@Column(name = "merchant_id")
	private String merchantId;
	
	@Column(name = "amount")
	private String amount;
	
	@Column(name = "currency",nullable = false)
	private String currency;
	
	@Column(name = "order_id",unique = true,nullable = false)
	private String orderId;
	@Column(name = "transaction_id",nullable = false,unique = true)
	private String transactionId;
	@Column(name="status",nullable = false)
	private String status;
	@Column(name = "message")
	private String message;

	public String gettransactionId() {
		return transactionId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setTransaction_id(String transaction_id) {
		this.transactionId = transaction_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	
	
}
