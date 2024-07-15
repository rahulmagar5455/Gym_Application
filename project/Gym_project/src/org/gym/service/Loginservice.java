package org.gym.service;

import java.util.List;
import java.util.Scanner;

import org.Algo.LinearRegression;

import OrgGymmodel.AdminRegisterModel;
import OrgGymmodel.LoginMasterModel;
import OrgGymmodel.TrainerModel;
import OrgGymmodel.checkUserModel;
import OrgGymmodel.durationModel;
import Org_gym_Repo.AdminRepo;
import Org_gym_Repo.LoginRepo;

public class Loginservice {

	LoginRepo Lrepo = new LoginRepo();
	AdminRepo Ar = new AdminRepo();
	AdminFunctions Afun = new AdminFunctions();
	Scanner xyz = new Scanner(System.in);
	LoginMasterModel model = new LoginMasterModel();
	durationModel dm = new durationModel();
	LinearRegression lr = new LinearRegression(null, null);
	AlgoService alservice = new AlgoService();

	public boolean Userregister() {

		System.out.println("enter details for register");
		System.out.println("enter name");
		String name = xyz.nextLine();
		System.out.println("enter contact");
		String contact = xyz.nextLine();
		System.out.println("enter email");
		String email = xyz.nextLine();
		System.out.println("enter address");
		String address = xyz.nextLine();
		System.out.println("enter age");
		int age = xyz.nextInt();
		System.out.println("enter gender");
		xyz.nextLine();
		String gender = xyz.nextLine();

		   System.out.println("enter months");
		   int durationperiod = xyz.nextInt();
	      	new LinearRegression(durationperiod);
	      	
		System.out.println("do you want trainer");
		System.out.println("1.yes");
		System.out.println("0.no");
		int choice = xyz.nextInt();
		if (choice == 1) {
			System.out.println("enter trainer id ");
//				boolean  b=  Ar.getTrainers();
		}
		List<TrainerModel> list1 = Afun.getTrainers();
		for (TrainerModel c : list1) {
			System.out.println(c.getId() + "\t" + c.getName() + "\t" + c.getType() + "\t" + c.getFees());
		}
		int trainer = xyz.nextInt();

		model.setName(name);
		model.setContact(contact);
		model.setEmail(email);
		model.setAddress(address);
		model.setAge(age);
		model.setGender(gender);
		model.setDurationperiod(durationperiod);
		model.setTrainerid(trainer);

		return Lrepo.Userregister(model);

	}

	public boolean checkuser(checkUserModel model) {

		return Lrepo.checkuser(model);
	}

	public boolean checkadmin(checkUserModel model) {
		return Lrepo.checkadmin(model);
	}

}
