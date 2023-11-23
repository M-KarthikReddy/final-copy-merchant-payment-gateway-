package com.alacriti.paymentGateway.payment.gateway.api.merchant.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alacriti.paymentGateway.payment.gateway.api.merchant.entity.MerchantEntity;

@Repository
public interface MerchantRepository extends JpaRepository<MerchantEntity, UUID> {
	public List<MerchantEntity> findByMerchantId(String merchantId);
	public List<MerchantEntity> findByMerchantName(String merchantName);
	
}
