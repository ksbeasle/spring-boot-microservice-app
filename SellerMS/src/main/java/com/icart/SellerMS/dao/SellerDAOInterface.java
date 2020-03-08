package com.icart.SellerMS.dao;

import java.util.List;

import com.icart.SellerMS.bean.Deals;
import com.icart.SellerMS.bean.Seller;

public interface SellerDAOInterface {

	public String registerSeller(Seller seller) throws Exception;
	public List<String> getAllSellers() throws Exception;
	public void updateSeller(Seller seller) throws Exception;
	public String updatePassword(Seller seller) throws Exception;
	public Seller getSellerDetails(Seller seller) throws Exception;
	public Boolean authenticateLogin(Seller seller) throws Exception;
	public List<Deals> getAllDeals(Seller seller) throws Exception;
}
