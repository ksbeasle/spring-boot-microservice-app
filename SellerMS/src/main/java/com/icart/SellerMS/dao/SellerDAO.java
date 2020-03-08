package com.icart.SellerMS.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.icart.SellerMS.bean.Deals;
import com.icart.SellerMS.bean.Seller;
import com.icart.SellerMS.entity.SellerEntity;

@Repository
@Transactional
public class SellerDAO implements SellerDAOInterface{

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public String registerSeller(Seller seller) {

		SellerEntity sellerEntity = new SellerEntity();
		
		sellerEntity.setAddress(seller.getAddress());
		sellerEntity.setEmail_id(seller.getEmail_id());
		sellerEntity.setName(seller.getName());
		sellerEntity.setPassword(seller.getPassword());
		sellerEntity.setPhone(seller.getPhone());
		
		entityManager.persist(sellerEntity);
		
		return sellerEntity.getEmail_id();
	}

	@Override
	public List<String> getAllSellers() throws Exception {
		
		List<SellerEntity> sellerEntityList;
		List<String> sellersList = new ArrayList<String>();
		
		Query query = entityManager.createQuery("select s from SellerEntity s");
		
		sellerEntityList = query.getResultList();
		
		sellerEntityList.forEach(sellerEntity -> {
			Seller seller = new Seller();
			seller.setEmail_id(sellerEntity.getEmail_id());
			sellersList.add(seller.getEmail_id());
		});
	
		return sellersList;
	}

	@Override
	public void updateSeller(Seller seller) throws Exception {
			SellerEntity sellerEntity = entityManager.find(SellerEntity.class, seller.getEmail_id());
			sellerEntity.setAddress(seller.getAddress());
			sellerEntity.setEmail_id(seller.getEmail_id());
			sellerEntity.setName(seller.getName());
			sellerEntity.setPhone(seller.getPhone());
	}

	@Override
	public String updatePassword(Seller seller) throws Exception {
		SellerEntity sellerEntity = entityManager.find(SellerEntity.class, seller.getEmail_id());
		sellerEntity.setPassword(seller.getPassword());
		return "SUCCESSFULLY CHANGED PASSWORD";
	}

	@Override
	public Seller getSellerDetails(Seller seller) throws Exception {
		SellerEntity sellerEntity = entityManager.find(SellerEntity.class, seller.getEmail_id());
		Seller sellerInfo = new Seller();
		sellerInfo.setEmail_id(sellerEntity.getEmail_id());
		sellerInfo.setAddress(sellerEntity.getAddress());
		sellerInfo.setName(sellerEntity.getName());
		sellerInfo.setPassword(sellerEntity.getPassword());
		sellerInfo.setPhone(sellerEntity.getPhone());
		return sellerInfo;
	}

	@Override
	public Boolean authenticateLogin(Seller seller) throws Exception {
		SellerEntity sellerEntity = entityManager.find(SellerEntity.class, seller.getEmail_id());
		if(sellerEntity == null) {
			return false;
		}
		if(sellerEntity.getPassword().equals(seller.getPassword())) {
			return true;
		}
		return false;
	}

	@Override
	public List<Deals> getAllDeals(Seller seller) throws Exception {
		List<Deals> dealEntityList = null;
		//TODO: Reach the Deals Microservice and retrieve all Deals related to the seller (seller Email Id)
		return dealEntityList;
	}

}
