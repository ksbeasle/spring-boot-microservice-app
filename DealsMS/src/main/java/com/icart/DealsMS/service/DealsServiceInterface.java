package com.icart.DealsMS.service;

import java.util.List;

import com.icart.DealsMS.bean.Deals;

public interface DealsServiceInterface {

	public int addNewDeal(Deals deal) throws Exception;
	public List<Deals> getMyDeals(String emailId) throws Exception;
	public void removeDeal(Integer dealId) throws Exception;
}
