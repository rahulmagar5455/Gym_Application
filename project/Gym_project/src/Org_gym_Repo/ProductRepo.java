package Org_gym_Repo;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import OrgGymmodel.LoginMasterModel;
import OrgGymmodel.ProductModel;
import Orggymconfig.GymappConfig;

public class ProductRepo  extends GymappConfig {

	List<ProductModel> list4 =new ArrayList<ProductModel>();
	
	public List<ProductModel> getBill(ProductModel pmodel) {
		try {		
			


			ProductModel model = new ProductModel();
	         stmt = conn.prepareStatement("select * from product where id =?");
	       
			 stmt.setInt(1, pmodel.getId());
			  ResultSet rs =  stmt.executeQuery();
			  
			  while (rs.next()) { 

				  model.setName(rs.getString(2));
                  model.setPrice(rs.getInt(3));
                  list4.add(model);
                  
		  } 
			  return list4.size()>0?list4:null;
			
		} catch (Exception e) {

			return null;
		}
		

	}

	

}
