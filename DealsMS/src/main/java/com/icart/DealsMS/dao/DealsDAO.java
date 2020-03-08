package com.icart.DealsMS.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.icart.DealsMS.bean.Deals;
import com.icart.DealsMS.entity.DealsEntity;

@Repository
public class DealsDAO implements DealsDAOInterface {
	
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public int addNewDeal(Deals deal) throws Exception {
		DealsEntity dealEntity = new DealsEntity();
		
		//dealEntity.setDealId(deal.getDealId());
		dealEntity.setProductId(deal.getProductId());
		dealEntity.setDealDiscount(deal.getDealDiscount());
		dealEntity.setSellerEmailId(deal.getSellerEmailId());
		
		entityManager.persist(dealEntity);
		
		return dealEntity.getProductId();
	}

	@Override
	public List<Deals> getMyDeals(String emailId) throws Exception {
		//DealsEntity dealsEntity = entityManager.find(DealsEntity.class, emailId);
		
		List<Deals> dealsList = new ArrayList<Deals>();
		Query query = entityManager.createQuery("select d from DealsEntity d where SELLER_EMAIL_ID= :emailId");
		query.setParameter("emailId", emailId);
		List<DealsEntity> dealsEntityList = query.getResultList();
		
		dealsEntityList.forEach(deal ->{
			Deals dealBean = new Deals();
			dealBean.setDealId(deal.getDealId());
			dealBean.setProductId(deal.getProductId());
			dealBean.setSellerEmailId(deal.getSellerEmailId());
			dealBean.setDealDiscount(deal.getDealDiscount());
			dealsList.add(dealBean);
			});

		return dealsList;
	}

	@Override
	public void removeDeal(Integer dealId) throws Exception {
		DealsEntity dealsEntity = entityManager.find(DealsEntity.class, dealId);
		entityManager.remove(dealsEntity);
		
	}

}
