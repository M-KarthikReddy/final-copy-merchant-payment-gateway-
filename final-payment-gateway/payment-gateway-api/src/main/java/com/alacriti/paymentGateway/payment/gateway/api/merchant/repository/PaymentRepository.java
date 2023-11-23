package com.alacriti.paymentGateway.payment.gateway.api.merchant.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.alacriti.paymentGateway.payment.gateway.api.merchant.entity.PaymentEntity;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentEntity, UUID>{
	
	 List<PaymentEntity> findByTransactionId(String tID);
	 
	 List<PaymentEntity> findByMerchantId(String mID);

}
