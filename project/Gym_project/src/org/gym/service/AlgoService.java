package org.gym.service;

import java.util.List;

import org.Algo.LinearRegression;

import OrgGymmodel.LoginMasterModel;
import OrgGymmodel.durationModel;
import Org_gym_Repo.AlgoRepo;

public class AlgoService {
	
	AlgoRepo algo = new AlgoRepo(); 
	LinearRegression lrr = new LinearRegression(null, null);
	
	public List<durationModel> getDurationId(){
		
		return algo.getDurationId();
	}
//	
//	public double getpredictedprice(durationModel dm) {
//		return lrr.getpredictedprice(dm);
//		
//	}

}
