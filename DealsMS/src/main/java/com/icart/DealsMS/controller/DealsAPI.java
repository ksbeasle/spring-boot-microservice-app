package com.icart.DealsMS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.icart.DealsMS.bean.Deals;
import com.icart.DealsMS.service.DealsService;

@RestController
@CrossOrigin
@RequestMapping("DealsAPI")
public class DealsAPI {

	@Autowired
	DealsService dealsService;
	
	@PostMapping(value="NewDeal")
	public ResponseEntity<Integer> addNewDeal(@RequestBody Deals deal) throws Exception{
		ResponseEntity<Integer> responseEntity = null;
		Integer id = 0;
		try {
			id = dealsService.addNewDeal(deal);
			responseEntity = new ResponseEntity<Integer>(id, HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return responseEntity;
	}
	
	@GetMapping(value="deals/{emailId}")
	public ResponseEntity<List<Deals>> getMyDeals(@PathVariable("emailId") String emailId) throws Exception{
		ResponseEntity<List<Deals>> responseEntity = null;
		try {
			List<Deals> deals = dealsService.getMyDeals(emailId);
			responseEntity = new ResponseEntity<List<Deals>>(deals, HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return responseEntity;
	}
	
	@DeleteMapping(value="RemoveDeal/{dealId}")
	public void removeDeal(@PathVariable("dealId") Integer dealId) throws Exception {
		dealsService.removeDeal(dealId);
	}
	
	
}
