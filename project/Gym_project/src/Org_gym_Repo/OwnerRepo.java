package Org_gym_Repo;

import java.sql.ResultSet;
import java.sql.Statement;

import OrgGymmodel.AdminRegisterModel;
import OrgGymmodel.OwnerModel;
import OrgGymmodel.deletemastermodel;
import Orggymconfig.GymappConfig;

public class OwnerRepo  extends GymappConfig{

	public boolean getAllAdmin() {
		
		try {

			stmt = conn.prepareStatement("select *from admininfo");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
	                  System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5));
				
			} 
			return false;

		} catch (Exception e) {

			return false;
		}
		
	}

	public boolean deleteAdminbyid(deletemastermodel dm) {
           try {
			
			int id = dm.getId();
			 System.out.println(id);
			Statement stmt = conn.createStatement();
			int value = stmt.executeUpdate("delete from admininfo where id ="+id);
			if (value>0) {
				 
				return true;
			} else {
             
				return false;
			}

		} catch (Exception e) {
			
			return false;
		}
	}

	public boolean CheckOwner(OwnerModel Om) {
		try {
			stmt = conn.prepareStatement("select *from owner where email=? and password=?");
			
			stmt.setString(1,Om.getUsername());
			stmt.setString(2, Om.getPass());
			  ResultSet rs =  stmt.executeQuery();
			if(rs.next()) {
				 System.out.println(rs.getString(1)+"\t"+rs.getString(2));
				
				return true;
			} else {
				
				return false;
			}

		} catch (Exception e) {

			
			return false;
		}

	}

	public boolean UpdateAdminNameById(AdminRegisterModel AdModel) {		
		try {
			stmt = conn.prepareStatement("update admininfo set name=? where id= ?");
			stmt.setString(1, AdModel.getName());
			stmt.setInt(2, AdModel.getId());

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

	public boolean UpdateAdminContactById(AdminRegisterModel AdModel) {
		
		try {
			stmt = conn.prepareStatement("update admininfo set contact=? where id= ?");
			stmt.setString(1, AdModel.getContact());
			stmt.setInt(2, AdModel.getId());

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

	public boolean UpdateAdminEmailById(AdminRegisterModel AdModel) {
		try {
			stmt = conn.prepareStatement("update admininfo set email=? where id= ?");
			stmt.setString(1, AdModel.getEmail());
			stmt.setInt(2, AdModel.getId());

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









