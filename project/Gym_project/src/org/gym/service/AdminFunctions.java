package org.gym.service;

import java.util.List;

import OrgGymmodel.AdminRegisterModel;
import OrgGymmodel.LoginMasterModel;
import OrgGymmodel.ProductModel;
import OrgGymmodel.SearchMasterModel;
import OrgGymmodel.TrainerModel;
import OrgGymmodel.deletemastermodel;
import Org_gym_Repo.AdminRepo;
import Org_gym_Repo.LoginRepo;

public class AdminFunctions {

	
	AdminRepo Ar = new AdminRepo(); 
	
	
    public List<LoginMasterModel> getAllTraineedata() {
		
		return Ar.Alldata();
	}
	
   public List<TrainerModel> getTrainers() {
		
		return Ar.getTrainers();
	}

   public boolean deletetraineebyid(deletemastermodel dm) {
	
	return Ar.deletetraineebyid(dm);
	
   }
   
   public List<LoginMasterModel> SearchTraineeById(SearchMasterModel sc ) {
	   
	   return Ar.SearchTraineeById(sc);
	   
   }

   public List<ProductModel> ViewAllProduct() {
	
	return Ar.ViewAllProduct();
    }
   
   public boolean NewtrainerRegiter(TrainerModel tmodel) {
		return Ar.NewtrainerRegiter(tmodel);
	}

public boolean deleteTrainerById(TrainerModel tmodel) {
	
	return Ar.deleteTrainerById(tmodel);
}

public boolean updateNameById(LoginMasterModel model1) {
	
	return Ar.updateNameById(model1);
}
  
}
