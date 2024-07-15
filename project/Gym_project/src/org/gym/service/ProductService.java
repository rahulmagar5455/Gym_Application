package org.gym.service;

import java.util.List;

import OrgGymmodel.ProductModel;
import Org_gym_Repo.ProductRepo;

public class ProductService {
	ProductRepo Prepo = new ProductRepo();
	public List<ProductModel>getBill (ProductModel pmodel) {
		
		
		return Prepo.getBill(pmodel);
	}

}
