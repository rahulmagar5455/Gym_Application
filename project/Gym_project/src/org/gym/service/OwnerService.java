package org.gym.service;

import OrgGymmodel.AdminRegisterModel;
import OrgGymmodel.OwnerModel;
import OrgGymmodel.deletemastermodel;
import Org_gym_Repo.OwnerRepo;

public class OwnerService {

	OwnerRepo or = new OwnerRepo();
	public boolean getAllAdmin() {
		
		return  or.getAllAdmin();
	}
	public boolean deleteAdminbyid(deletemastermodel dm) {
		
		return or.deleteAdminbyid(dm);
	}
	public boolean CheckOwner(OwnerModel Om) {
		
		return or.CheckOwner( Om);
	
	}
	public boolean UpdateAdminNameById(AdminRegisterModel AdModel) {
		
		return or.UpdateAdminNameById(AdModel);
	}
	public boolean UpdateAdminContactById(AdminRegisterModel AdModel) {
		
		return or.UpdateAdminContactById(AdModel);
	}
	public boolean UpdateAdminEmailById(AdminRegisterModel AdModel) {
		
		return or.UpdateAdminEmailById(AdModel) ;
	}
	

}
