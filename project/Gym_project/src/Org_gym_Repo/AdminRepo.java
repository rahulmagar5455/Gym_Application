package Org_gym_Repo;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import OrgGymmodel.AdminRegisterModel;
import OrgGymmodel.LoginMasterModel;
import OrgGymmodel.ProductModel;
import OrgGymmodel.SearchMasterModel;
import OrgGymmodel.TrainerModel;
import OrgGymmodel.deletemastermodel;
import Orggymconfig.GymappConfig;

public class AdminRepo extends GymappConfig { 
	List<LoginMasterModel> list =new ArrayList<LoginMasterModel>();
	List<AdminRegisterModel> list1 ;
	List<LoginMasterModel> list2 =new ArrayList<LoginMasterModel>();
	List<ProductModel> list3 ;
	List<TrainerModel> list5 ;
	
	

public List<LoginMasterModel> Alldata() {
		
		try {
			list = new ArrayList<LoginMasterModel> ();
			stmt = conn.prepareStatement("select *from userregister");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {       
                      LoginMasterModel model = new LoginMasterModel();
                      model.setId(rs.getInt(1));
                      model.setName(rs.getString(2));
                      model.setContact(rs.getString(3));
                      model.setEmail(rs.getString(4));
                      model.setAddress(rs.getString(5));
                      model.setAge(rs.getInt(6));
                      model.setGender(rs.getString(7));
                      model.setDurationperiod(rs.getInt(8));
                      model.setTrainerid(rs.getInt(10));
                      list.add(model);                     
			  } 
			return list.size()>0?list:null;
		} catch (Exception e) {
			return null;
		}	
	}


    public List<TrainerModel> getTrainers() {
	try {
		list5 = new ArrayList<TrainerModel> ();
		stmt = conn.prepareStatement("select *from trainertable");
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			TrainerModel  tmodel = new TrainerModel();
                  tmodel.setId(rs.getInt(1));
                  tmodel.setName(rs.getString(2));
                  tmodel.setType(rs.getString(3));
                  tmodel.setFees(rs.getInt(4));
                 list5.add(tmodel);		
		} 
		return list5.size()>0?list5:null;
	} catch (Exception e) {
		return null;
	}	
}
	
    public boolean deletetraineebyid(deletemastermodel dm) {
		try {		
			int id = dm.getId();
			Statement stmt = conn.createStatement();
			int value = stmt.executeUpdate("delete from userregister where uid ="+id);
			if (value>0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {

			return false;
		}
		
	}


	public List<LoginMasterModel> SearchTraineeById(SearchMasterModel sc) {
		try {		
			list2 = new ArrayList<LoginMasterModel> ();
			 
	         stmt = conn.prepareStatement("select * from userregister where uid =?");
			 stmt.setInt(1, sc.getId());
			  ResultSet rs =  stmt.executeQuery();
			  
			  while (rs.next()) {       
				  LoginMasterModel model = new LoginMasterModel();
                  model.setId(rs.getInt(1));
                  model.setName(rs.getString(2));
                  model.setContact(rs.getString(3));
                  model.setEmail(rs.getString(4));
                  model.setAddress(rs.getString(5));
                  model.setAge(rs.getInt(6));
                  model.setGender(rs.getString(7));
                  model.setDurationperiod(rs.getInt(8));
                  model.setTrainerid(rs.getInt(10));    
                  list2.add(model);
                  
		  } 
			  return list2.size()>0?list2:null;
			
		} catch (Exception e) {

			return null;
		}
		

	
		
	}


	public boolean AddProduct(ProductModel proModel) {
		try {
			stmt = conn.prepareStatement("insert into product values('0',?,?,?)");
       		stmt.setString(1, proModel.getName());
 			stmt.setInt(2, proModel.getPrice());
 			stmt.setString(3, proModel.getExdate());

			int value = stmt.executeUpdate();
			return value > 0 ? true : false;

		} catch (Exception ex) {
			System.out.println("error is here" + ex);
			return false;
		}
	

	}


	public List<ProductModel> ViewAllProduct() {
		try {
			list3 = new ArrayList<ProductModel> ();
			stmt = conn.prepareStatement("select *from product");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ProductModel  model = new ProductModel();
	                  model.setId(rs.getInt(1));
	                  model.setName(rs.getString(2));
	                  model.setPrice(rs.getInt(3));
	                  model.setExdate(rs.getString(4));
	                  list3.add(model);		
			} 
			return list3.size()>0?list3:null;
		} catch (Exception e) {
			
			return null;
		}	
	}


	public boolean NewtrainerRegiter(TrainerModel tmodel) {
		
		try {
			stmt = conn.prepareStatement("insert into trainertable values('0',?,?,?)");
       		stmt.setString(1, tmodel.getName());
 			stmt.setString(2, tmodel.getType());
 			stmt.setInt(3, tmodel.getFees());

			int value = stmt.executeUpdate();
			return value > 0 ? true : false;

		} catch (Exception ex) {
			System.out.println("error is here" + ex);
			return false;
		}	
	}
	
	
	public boolean deleteTrainerById(TrainerModel tmodel) {
		try {			
			int id = tmodel.getId();
			Statement stmt = conn.createStatement();
			int value = stmt.executeUpdate("delete from trainertable where tid ="+id);		
			if (value>0) {				
				return true;
			} else {				
				return false;
			}
		} catch (Exception e) {			
			return false;
		}
 }


	public boolean updateNameById(LoginMasterModel model1) {
		try {
			stmt = conn.prepareStatement("update userregister set uname=? where uid= ?");
			stmt.setString(1, model1.getName());
			stmt.setInt(2, model1.getId());

			int value = stmt.executeUpdate();			
			if (value == 1) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			
			return false;
		}
		
	}
}

