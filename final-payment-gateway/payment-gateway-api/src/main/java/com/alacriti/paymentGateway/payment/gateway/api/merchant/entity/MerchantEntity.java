package com.alacriti.paymentGateway.payment.gateway.api.merchant.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "merchant_info")
public class MerchantEntity {
	
	@Id
	private UUID id = UUID.randomUUID();
	
	@Column(name = "merchant_id")
	private String merchantId;
	
	@Column(name = "merchant_name")
	private String merchantName;
	
	@Column(name = "merchant_email")
	private String merchantEmail;
	
	@Column(name = "business_type")
	private String merchantBusinessType;
	
	@Column(name = "address")
	private String merchantAddress;
	
	@Column(name = "phone")
	private long merchantPhone;
	
	

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

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public String getMerchantEmail() {
		return merchantEmail;
	}

	public void setMerchantEmail(String merchantEmail) {
		this.merchantEmail = merchantEmail;
	}

	public String getMerchantBusinessType() {
		return merchantBusinessType;
	}

	public void setMerchantBusinessType(String merchantBusinessType) {
		this.merchantBusinessType = merchantBusinessType;
	}

	public String getMerchantAddress() {
		return merchantAddress;
	}

	public void setMerchantAddress(String merchantAddress) {
		this.merchantAddress = merchantAddress;
	}

	public long getMerchantPhone() {
		return merchantPhone;
	}

	public void setMerchantPhone(long l) {
		this.merchantPhone = l;
	}
}
