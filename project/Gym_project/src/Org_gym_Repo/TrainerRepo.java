package Org_gym_Repo;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import OrgGymmodel.LoginMasterModel;
import OrgGymmodel.ProductModel;
import OrgGymmodel.TrainerModel;
import Orggymconfig.GymappConfig;

public class TrainerRepo extends GymappConfig{
	
	
	LoginMasterModel lmodel = new LoginMasterModel();
	List<LoginMasterModel> list =new ArrayList<LoginMasterModel>();
//	List<LoginMasterModel> list4 ;

	public boolean checkTrainer(TrainerModel tmodel) {
		try {
		       
			
			stmt = conn.prepareStatement(" select *from trainertable where tid=?");
			stmt.setInt(1, tmodel.getId());
	         

			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
             
				return true;
			} else {

				return false;
			}

		} catch (Exception e) {
			System.out.println("error is"+e);

			return false;
		}
	}

	public List<LoginMasterModel> ViewAllAllocatedTraine(TrainerModel tmodel) {
		try {
			
			list = new ArrayList<LoginMasterModel> ();
			stmt = conn.prepareStatement("select u.uname, u.contact,u.age,u.gender from userregister u inner join trainertable t on u.trainerid=t.tid where tid=?");
			stmt.setInt(1, tmodel.getId());
			ResultSet rs = stmt.executeQuery();
//			LoginMasterModel +model = new LoginMasterModel();
			while (rs.next()) {
			    LoginMasterModel lmodel = new LoginMasterModel();
			     lmodel.setName(rs.getString(1));
			     lmodel.setContact(rs.getString(2));
			     lmodel.setAge(rs.getInt(3));
			     lmodel.setGender(rs.getString(4));
			     list.add(lmodel);			    
				
			} 
			return list.size()>0?list:null;

		} catch (Exception e) {
		

			return null;
		}
	}

}
