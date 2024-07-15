package org.gym.service;

import java.util.Scanner;

import OrgGymmodel.AdminRegisterModel;
import OrgGymmodel.LoginMasterModel;
import OrgGymmodel.ProductModel;
import Org_gym_Repo.AdminRepo;
import Org_gym_Repo.LoginRepo;

public class AdminLoginService {
	
	LoginRepo Lrepo = new LoginRepo();
	AdminRepo ar = new AdminRepo();
	
	Scanner xyz = new Scanner(System.in);
	public boolean Adminregister() {
		
		System.out.println("welcome Admin Register page");
		System.out.println("enter details for register");
		System.out.println("enter name");
		String name = xyz.nextLine();
		System.out.println("enter contact");
		String contact = xyz.nextLine();
		System.out.println("enter email");
		String email = xyz.nextLine();
		System.out.println("enter address");
		String address = xyz.nextLine();
		
		 
		AdminRegisterModel model = new AdminRegisterModel();
		model.setName(name);
		model.setContact(contact);
		model.setEmail(email);
		model.setAddress(address);
		
		
		return Lrepo.Adminregister(model);
		
	}
	public boolean AddProduct() {
		
	
			System.out.println("Enter Products Detail");
			System.out.println("Enter product Name");
			String Name = xyz.nextLine();
			System.out.println("Enter Price ");
			int Price = xyz.nextInt();
			xyz.nextLine();
			System.out.println("Enter Expiry-Date ");
			String Exdate = xyz.nextLine();
		
			ProductModel proModel = new ProductModel();
			proModel.setName(Name);
			proModel.setPrice(Price);
			proModel.setExdate(Exdate);		
	    	return 	ar.AddProduct(proModel);				

	
	}

}
