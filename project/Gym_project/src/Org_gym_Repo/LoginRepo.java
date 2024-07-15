package Org_gym_Repo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import OrgGymmodel.AdminRegisterModel;
import OrgGymmodel.LoginMasterModel;
import OrgGymmodel.ProductModel;
import OrgGymmodel.checkUserModel;
import OrgGymmodel.deletemastermodel;
import Orggymconfig.GymappConfig;

public class LoginRepo extends GymappConfig {

	public boolean Userregister(LoginMasterModel model) {
		try {
			stmt = conn.prepareStatement("insert into userregister values('0',?,?,?,?,?,?,?,curdate(),?)");
			stmt.setString(1, model.getName());
			stmt.setString(2, model.getContact());
			stmt.setString(3, model.getEmail());
			stmt.setString(4, model.getAddress());
			stmt.setInt(5, model.getAge());
			stmt.setString(6, model.getGender());
			stmt.setInt(7, model.getDurationperiod());
			stmt.setInt(8, model.getTrainerid());

			int value = stmt.executeUpdate();
			return value > 0 ? true : false;

		} catch (Exception ex) {
			System.out.println("error is here" + ex);
			return false;
		}

	}
	
	public boolean Adminregister(AdminRegisterModel model) {
		try {
			stmt = conn.prepareStatement("insert into admininfo values('0',?,?,?,?)");
			stmt.setString(1, model.getName());
			stmt.setString(2, model.getContact());
			stmt.setString(3, model.getEmail());
			stmt.setString(4, model.getAddress());
			

			int value = stmt.executeUpdate();
			return value > 0 ? true : false;

		} catch (Exception ex) {
			System.out.println("error is here" + ex);
			return false;
		}

	}
	public boolean checkuser(checkUserModel model) {
		try {

			stmt = conn.prepareStatement("select *from userregister where email = ? && contact =?");
			stmt.setString(1, model.getEmail());
			stmt.setString(2, model.getContact());
			

			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {

				return true;
			} else {

				return false;
			}

		} catch (Exception e) {

			return false;
		}
		
		
	}
//	public List<LoginMasterModel> checkuser() {
//		try {
//			ArrayList<LoginMasterModel> list3 = new ArrayList<LoginMasterModel> ();
//			stmt = conn.prepareStatement("select *from userregister");
//			ResultSet rs = stmt.executeQuery();
//			while (rs.next()) {
//				LoginMasterModel  model = new LoginMasterModel();
//	                 
//	                  model.setName(rs.getString(2));
//	                 
//	                 list3.add(model);		
//			} 
//			return list3.size()>0?list3:null;
//		} catch (Exception e) {
//			
//			return null;
//		}	
//	}
	
	

	public boolean checkadmin(checkUserModel model) {
		try {

			stmt = conn.prepareStatement("select *from admininfo where email = ? && contact =?");
			stmt.setString(1, model.getEmail());
			stmt.setString(2, model.getContact());

			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {

				return true;
			} else {

				return false;
			}

		} catch (Exception e) {

			return false;
		}
	}
	
//	public boolean getAllTrainersdata() {
//		
//		try {
//
//			stmt = conn.prepareStatement("select *from admininfo ");
//			ResultSet rs = stmt.executeQuery();
//			if (rs.next()) {
//	                  System.out.println("hiiii");
//				return true;
//			} else {
//
//				return false;
//			}
//
//		} catch (Exception e) {
//
//			return false;
//		}
//	}

	
	

	
	


}











