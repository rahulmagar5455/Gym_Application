package Org_gym_Repo;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import OrgGymmodel.LoginMasterModel;
import OrgGymmodel.durationModel;
import Orggymconfig.GymappConfig;

public class AlgoRepo extends GymappConfig{
	List<durationModel>list= new ArrayList<durationModel>() ;
	
public List<durationModel> getDurationId() {
		
		try {

			stmt = conn.prepareStatement("select durperiod,durcharge from duration");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {       
				durationModel model = new durationModel();
                      model.setDurid(rs.getInt(1));
                      model.setDurcharge(rs.getInt(2));      
                      list.add(model);                     
			  } 
			return list.size()>0?list:null;
		} catch (Exception e) {
			return null;
		}	
	}


}
