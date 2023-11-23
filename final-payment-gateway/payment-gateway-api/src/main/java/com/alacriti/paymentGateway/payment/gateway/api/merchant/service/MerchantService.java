package com.alacriti.paymentGateway.payment.gateway.api.merchant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alacriti.paymentGateway.payment.gateway.api.merchant.entity.MerchantEntity;
import com.alacriti.paymentGateway.payment.gateway.api.merchant.model.Merchant;
import com.alacriti.paymentGateway.payment.gateway.api.merchant.model.MerchantResponse;
import com.alacriti.paymentGateway.payment.gateway.api.merchant.model.PaymentResponse;
import com.alacriti.paymentGateway.payment.gateway.api.merchant.repository.MerchantRepository;

@Service
public class MerchantService {

	@Autowired
	private MerchantRepository merchantRepository;

	/**
	 * this method will register the pojo merchant details into entity
	 */

	String mid="";
	public MerchantResponse saveMerchantDetails(Merchant merchant) {

		MerchantEntity entity = new MerchantEntity();
		
		
		
		

		String message = "data is saved sucessfully";

		try {
			validateData(merchant);
			validateMerchantName(merchant.getMerchantName());
			saveMerchantData(merchant,entity);
			

		} catch (Exception e) {
		
			message = e.getMessage();
			
		}
		
		MerchantResponse response = sendMerchantRegisterStatus(merchant, message,entity);
		
		return response;
	}

	public void saveMerchantData(Merchant merchant,MerchantEntity entity) {

		
		entity.setMerchantId("M-ID" + Math.random());
		entity.setMerchantName(merchant.getMerchantName());
		entity.setMerchantEmail(merchant.getMerchantEmail());
		entity.setMerchantBusinessType(merchant.getMerchantBusinesstype());
		entity.setMerchantAddress(merchant.getMerchantAddress());
		entity.setMerchantPhone(Long.parseLong(merchant.getMerchantPhone()));

		merchantRepository.save(entity);

	}

	public void validateData(Merchant merchant) throws Exception {

		String merchantMessage = "";

		if (merchant.getMerchantName() == null || merchant.getMerchantName() == "") {
			throw new Exception("no field/invalid merchant id /");
		}
		if (merchant.getMerchantEmail() == null || merchant.getMerchantEmail() == "") {
			throw new Exception("no field/invalid merchant email /");
		}
		if (merchant.getMerchantBusinesstype() == null || merchant.getMerchantBusinesstype() == "") {
			throw new Exception("no field/invalid merchant Business type /");
		}
		if (merchant.getMerchantAddress() == null || merchant.getMerchantAddress() == "") {
			throw new Exception("no field/invalid merchant address /");
		}
		if (merchant.getMerchantPhone() == null || merchant.getMerchantPhone() == "") {
			throw new Exception("no field/invalid merchant phone /");

		}

		if (merchantMessage != "") {
			throw new Exception(merchantMessage);
		}

	}
	
	public MerchantResponse sendMerchantRegisterStatus(Merchant merchant,String message,MerchantEntity e) {
		
		MerchantResponse response = new MerchantResponse();
		
		mid = e.getMerchantId();
		
		response.setMerchantID(mid);
		response.setMerchantName(merchant.getMerchantName());
		response.setMerchantEmail(merchant.getMerchantEmail());
		response.setMerchantAddress(merchant.getMerchantAddress());
		response.setMerchantBusinesstype(merchant.getMerchantBusinesstype());
		response.setMerchantPhone(merchant.getMerchantPhone());
		response.setMessage(message + "" + mid);
		
		return response;
	}
	
	public void validateMerchantName(String merchantName) throws Exception {
		List<MerchantEntity> listOfMerchantName = merchantRepository.findByMerchantName(merchantName);
		
		if(!listOfMerchantName.isEmpty()) {
			mid=listOfMerchantName.get(0).getMerchantId();
			throw new Exception("merchant already registered with name :" + merchantName+" and ID :"+mid+". please go to payment");
		}
	}

}
