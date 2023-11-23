package com.alacriti.PaymentMediator.paymentmediator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class PaymentMediatorController {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${payment.gateway.url}")
	String baseURL;

	String url;
	@CrossOrigin(origins = "*")
	@GetMapping("/paymentStatus/{transactionID}")
	public String getStaus(@PathVariable String transactionID) {

		String url = baseURL + "/payment_status/{transactionID}";

		// Set the path variable
		url = url.replace("{transactionID}", transactionID);
		String rel = restTemplate.getForObject(url, String.class);

		return rel;

	}
	@CrossOrigin(origins = "*")
	@PostMapping("/Register")
	public String register(@RequestBody String data) {

		String url = baseURL + "/register_merchant";

		  
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> requestEntity = new HttpEntity<>(data, headers);
     
        String response = restTemplate.postForObject(url, requestEntity, String.class);


		return response;

	}
	@CrossOrigin(origins = "*")
	@PostMapping("/requestPayment")
	public String paymentRequest(@RequestBody String data) {
		
		String url = baseURL + "/payment";
		
		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		
		HttpEntity<String> requestPaymentEntity = new HttpEntity<>(data,headers);
		String response = restTemplate.postForObject(url, requestPaymentEntity, String.class);
		
				return response;
	}

}
