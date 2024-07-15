package org.gym.service;

import java.util.List;

import OrgGymmodel.LoginMasterModel;
import OrgGymmodel.TrainerModel;
import Org_gym_Repo.TrainerRepo;

public class TrainerService {

	TrainerRepo trepo = new TrainerRepo();
	public boolean checkTrainer(TrainerModel tmodel) {
		
		return trepo.checkTrainer(tmodel);
	}
	
	
	
	public List<LoginMasterModel> ViewAllAllocatedTraine(TrainerModel tmodel) {
		
		return trepo.ViewAllAllocatedTraine(tmodel);
	}

}
