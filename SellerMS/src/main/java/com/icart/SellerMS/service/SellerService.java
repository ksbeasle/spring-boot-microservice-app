package com.icart.SellerMS.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icart.SellerMS.Validator.Validator;
import com.icart.SellerMS.bean.Deals;
import com.icart.SellerMS.bean.Seller;
import com.icart.SellerMS.dao.SellerDAO;

@Service
public class SellerService implements SellerServiceInterface {

	@Autowired
	SellerDAO sellerDAO;
	
	
	@Override
	public String registerSeller(Seller seller) throws Exception {
		Boolean b = Validator.validateName(seller.getName());
		if(b == false) {
			throw new Exception("SellerService.INVALID_NAME");
		}
		return sellerDAO.registerSeller(seller);
	}


	@Override
	public List<String> getAllSellers() throws Exception {
		List<String> list = new ArrayList<String>();
		list = sellerDAO.getAllSellers();
		return list;
	}


	@Override
	public void updateSeller(Seller seller) throws Exception {
		sellerDAO.updateSeller(seller);
	}


	@Override
	public String updatePassword(Seller seller) throws Exception {
		return sellerDAO.updatePassword(seller);
	}


	@Override
	public Seller getSellerDetails(Seller seller) throws Exception {
		return sellerDAO.getSellerDetails(seller);
	}


	@Override
	public Boolean authenticateLogin(Seller seller) throws Exception {
		return sellerDAO.authenticateLogin(seller);
	}


	@Override
	public List<Deals> getSellerDeals(Seller seller) throws Exception {
		return sellerDAO.getAllDeals(seller);
	}

	
}
