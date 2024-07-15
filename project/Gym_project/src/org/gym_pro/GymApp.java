package org.gym_pro;

import java.util.*;

import org.gym.service.AdminFunctions;
import org.gym.service.AdminLoginService;
import org.gym.service.Loginservice;
import org.gym.service.OwnerService;
import org.gym.service.ProductService;
import org.gym.service.TrainerService;

import OrgGymmodel.AdminRegisterModel;
import OrgGymmodel.LoginMasterModel;
import OrgGymmodel.OwnerModel;
import OrgGymmodel.ProductModel;
import OrgGymmodel.SearchMasterModel;
import OrgGymmodel.TrainerModel;
import OrgGymmodel.checkUserModel;
import OrgGymmodel.deletemastermodel;
import Org_gym_Repo.LoginRepo;

public class GymApp {

	public static void main(String[] args) {

		Scanner xyz = new Scanner(System.in);

		LoginMasterModel model1 = new LoginMasterModel();
		AdminRegisterModel AdModel = new AdminRegisterModel();
		Loginservice ls = new Loginservice();
		AdminLoginService als = new AdminLoginService();
		checkUserModel model = new checkUserModel();
		AdminFunctions Afun = new AdminFunctions();
		deletemastermodel dm = new deletemastermodel();
		OwnerService Ownerserv = new OwnerService();
		List<LoginMasterModel> list = new ArrayList<LoginMasterModel>();
		List<LoginMasterModel> list2 = new ArrayList<LoginMasterModel>();
		List<ProductModel> list3 = new ArrayList<ProductModel>();
		SearchMasterModel sc = new SearchMasterModel();
		OwnerModel Om = new OwnerModel();
		TrainerModel tmodel = new TrainerModel();
		ProductModel pmodel = new ProductModel();
		ProductService pservice = new ProductService();
		TrainerService trainerService = new TrainerService();
		

		System.out.println("-------------*-WELCOME IN ABC Gym APPLICATION-*------------------------------- ");

		
		do {
			System.out.println("   1.owner");
			System.out.println("   2.admin");
			System.out.println("   3.user");
			System.out.println("   4.Trainer");
			int choice = xyz.nextInt();

			switch (choice) {
			

			case 1:                                                     // Owner Modele
				System.out.println("---------+ welcome Owner +------------------ ");
				xyz.nextLine();
				System.out.println("  enter your username");//abc@gmail.com
				String uname = xyz.nextLine();
				System.out.println("enter your password");//12345
				String pass = xyz.nextLine();
				 Om.setPass(pass);
				 Om.setUsername(uname);
				 
				boolean  e = Ownerserv.CheckOwner(Om);
				
				 if(e) {
					 System.out.println("--------Owner login get success----------");	 
					 System.out.println("----------------------------------------- ");
				do {
					System.out.println("1:view All Admin data");					
					System.out.println("2.View All Trainee data");
					System.out.println("3.View All Trainers Data");
					System.out.println("4.Delete Admin by Id");
					System.out.println("5.View All Products Data");
					System.out.println("6.Register New Admin in System");
					System.out.println("7.update Admin Data");
					System.out.println("8. view Trainerswise  Trainee");
					System.out.println("9.Log-out");
					
					choice = xyz.nextInt();
					switch (choice) {
					case 1:
						boolean b = Ownerserv.getAllAdmin();

						break;
					case 2:
						System.out.println("All Trainee Data ");
						System.out.println("ID\t Name\t Email\t\t Contact\tAddress\t Gender\t TrainerId\t Age\t Duration");
						list = Afun.getAllTraineedata();
						for (LoginMasterModel c : list) {
							System.out.println(c.getId()+"\t" + c.getName()+"\t" + c.getEmail()
							+"\t\t"	+ c.getContact()+"\t\t" +  c.getAddress()+"\t" + c.getGender() 
							+"\t"	+ c.getTrainerid() +"\t"+  c.getAge()+"\t" +c.getDurationperiod());
						}
						System.out.println("----------------------------------------- ");
						break;
					case 3:
						System.out.println("All trainers data ");
						System.out.println("----------------------------------------- ");
						List<TrainerModel> list1 = Afun.getTrainers();
						for (TrainerModel c : list1) {
							System.out.println(
									c.getId() + "\t" + c.getName() + "\t" + c.getType() + "\t" + c.getFees());
						}
						System.out.println("----------------------------------------- ");
						break;
					case 4:
						System.out.println("enter Id to delete");
						int id = xyz.nextInt();
						dm.setId(id);
						b = Ownerserv.deleteAdminbyid(dm);
						if (b) {
							System.out.println("----------------------------------------- ");
							System.out.println("deleted sucessfully");
						} else {
							System.out.println("----------------------------------------- ");
							System.out.println("not deleted");
						}
						
						break;
					case 5:
						System.out.println("view product");
						
						list3 = Afun.ViewAllProduct();
						System.out.printf("%-10s  %-10s %-10s %-10s","Id","Name","Price","expiry-Date");
						System.out.println();
						System.out.println("-------------------------------------------------------------------------------------------");
						for (ProductModel c : list3) {
							System.out.printf("%-10s  %-10s %-10s %-10s",c.getId(),  c.getName(), c.getPrice()
									,c.getExdate());
							System.out.println();
						}
						break;
					case 6:                                     
						xyz.nextLine();
						boolean c = als.Adminregister();// method for new Admin register
						if (c) {
							System.out.println("registeration  success");
						} else {
							System.out.println("not added");
						}
						break;
					case 7:
						 System.out.println("select what you want to update");					
						 System.out.println("1.update Admin Name ");
						 System.out.println("2.update Admin contact ");
						 System.out.println("3.update Admin Email ");
						 choice=xyz.nextInt();
							switch (choice) {

							case 1:
								System.out.println("Enter Admin id ");
								id = xyz.nextInt();
								AdModel.setId(id);
								xyz.nextLine();
								System.out.println("enter name");
								String name = xyz.nextLine();
								AdModel.setName(name);
								b = Ownerserv.UpdateAdminNameById(AdModel);
								if(b) {
									System.out.println("updated successfully");
								}
								else {
									System.out.println("not updated");
								}
								break;
							case 2:
								System.out.println("Enter Admin id ");
								id = xyz.nextInt();
								AdModel.setId(id);
								xyz.nextLine();
								System.out.println("enter contact");
								String contact = xyz.nextLine();
								AdModel.setContact(contact);
								b = Ownerserv.UpdateAdminContactById(AdModel);
								if(b) {
									System.out.println(" contact updated successfully");
								}
								else {
									System.out.println("not updated");
								}
								break;
								
							case 3:
								System.out.println("Enter Admin id ");
								id = xyz.nextInt();
								AdModel.setId(id);
								xyz.nextLine();
								System.out.println("enter email");
								String email = xyz.nextLine();
								AdModel.setEmail(email);
								b = Ownerserv.UpdateAdminEmailById(AdModel);
								if(b) {
									System.out.println(" email updated successfully");
								}
								else {
									System.out.println("not updated");
								}
								break;								
							}

				    break;
					case 8:
						
						System.out.println("enter your Id");
						 id = xyz.nextInt();
						tmodel.setId(id);											
						 b = trainerService.checkTrainer(tmodel);					
						if(b) {
							List<LoginMasterModel> list5 = new ArrayList<LoginMasterModel>();
							System.out.println("view All allocated Trainee........");
							System.out.println("----------------------------------------- ");
							 list5 = trainerService.ViewAllAllocatedTraine(tmodel);
							 for (LoginMasterModel l : list5) {
									System.out.printf("%-10s  %-10s %-10s %-10s",  l.getName(), l.getContact(),l.getAge(),l.getGender());
						
									System.out.println();
									
								}
							
						}
						
						else {
							System.out.println("please enter your corrrect id");
						}
						
						break;
					case 9:
						System.out.println("Logged-out....");
						 
						break;
						     
					
					
					default:
						
						System.out.println("invalid choice");
						
						
					}
					if(choice==9) {
						break;
					}
					
					

				} while (true);
			  }
			 else {
					 System.out.println("enter correct username and password");
			 }
			break;

			case 2:                                              //Admin module
				System.out.println("welcome Admin");
				System.out.println("----------------------------------------- ");

						xyz.nextLine();
					
						System.out.println("enter your email as userid");   //userid-mahesh@gmail.com
						String email = xyz.nextLine();
						System.out.println("enter your contact as password");//pass-7977144361
						String password = xyz.nextLine();

						model.setEmail(email);
						model.setContact(password);
						boolean b = ls.checkadmin(model);
						if (b) 
						{
							System.out.println("Welcome admin in xyz Gym Application");
							System.out.println("----------------------------------------- ");
							do {
								
								System.out.println("1.View All trainee data");							
								System.out.println("2.View All Trainers Data");
								System.out.println("3.delete Trainee by id");
								System.out.println("4.Search trainee by id");
								System.out.println("5.Add products in Gym Store");
								System.out.println("6.view All products in gym");
								System.out.println("7.update trainee by id");
								System.out.println("8.Add New Trainer");
								System.out.println("9.delete trainer by Id");
								System.out.println("10. view Trainerwise trainee");
								System.out.println("11. Log-out from account");

								choice = xyz.nextInt();

								switch (choice) {
								case 1:
									System.out.println("All trainee data ");
									System.out.println("----------------------------------------- ");
									list = Afun.getAllTraineedata(); 
									for (LoginMasterModel c : list) {
										System.out.println(c.getId() + "\t\t" + c.getName() + "\t\t" + c.getEmail()
												+ "\t\t" + c.getContact() + "\t\t" + c.getAddress() + "\t\t"
												+ c.getGender() + "\t" + c.getTrainerid() + "\t" + c.getAge() + "\t"
												+ c.getDurationperiod());
									}
									break;

								case 2:
									System.out.println("All trainee data ");
									System.out.println("----------------------------------------- ");
									List<TrainerModel> list1 = Afun.getTrainers();
									for (TrainerModel c : list1) {
										System.out.println(c.getId() + "\t" + c.getName() + "\t" + c.getType() + "\t"
												+ c.getFees());
									}
									break;

								case 3:
									System.out.println("enter trainer id to delete");
									System.out.println("enter id to delete");
									int id = xyz.nextInt();
									dm.setId(id);
									b = Afun.deletetraineebyid(dm);
									if (b) {
										System.out.println("----------------------------------------- ");
										System.out.println("deleted sucessfully");
									} else {
										System.out.println("----------------------------------------- ");
										System.out.println("not deleted");
									}

									break;
								case 4:
									System.out.println("Enetr id to search Trainee");
									id = xyz.nextInt();
									sc.setId(id);
									list2 = Afun.SearchTraineeById(sc);

									for (LoginMasterModel c : list2) {
										System.out.println(c.getId() + "\t\t" + c.getName() + "\t\t" + c.getEmail()
												+ "\t\t" + c.getContact() + "\t\t" + c.getAddress() + "\t\t"
												+ c.getGender() + "\t" + c.getTrainerid() + "\t" + c.getAge() + "\t"
												+ c.getDurationperiod());
									}

									break;
								case 5:
									int i;
									do {
										b = als.AddProduct();
										if (b) {
											System.out.println("product  added succesfully");
										} else {
											System.out.println("product not added");
										}
										System.out.println("Do you Want continue...");
										System.out.println("1.yes");
										System.out.println("2.No");
										i = xyz.nextInt();
									} while (i == 1);															  
									break;
								case 6:
									System.out.println("view product");
									
									list3 = Afun.ViewAllProduct();
									System.out.printf("%-10s  %-10s %-10s %-10s","Id","Name","Price","expiry-Date");
									System.out.println();
									System.out.println("-------------------------------------------------------------------------------------------");
									for (ProductModel c : list3) {
										System.out.printf("%-10s  %-10s %-10s %-10s",c.getId(),  c.getName(), c.getPrice()
												,c.getExdate());
										System.out.println();
									}
									break;
								
								case 7:
									System.out.println("enter trainee id to update");									
									 id = xyz.nextInt();
									 model1.setId(id);
//							
									 xyz.nextLine();
									 System.out.println("enter name");
									String name = xyz.nextLine();
									 model1.setName(name);
									b = Afun.updateNameById(model1);
									if (b) {
										System.out.println("----------------------------------------- ");
										System.out.println("updated sucessfully");
									} else {
										System.out.println("----------------------------------------- ");
										System.out.println("not updated");
									}

									break;
									

								case 8:
									xyz.nextLine();
									System.out.println("enter name ");
									 name = xyz.nextLine();
									System.out.println("enter type ");
									String type = xyz.nextLine();
									System.out.println("enter fees");
									int fees = xyz.nextInt();
									tmodel.setName(name);
									tmodel.setType(type);
									tmodel.setFees(fees);								
									b= Afun.NewtrainerRegiter(tmodel);
									if(b) {
										System.out.println("new trainer added sucessfully");
									}
									else {
										System.out.println("not added");
									}
									break;	
								case 9:
									
									System.out.println("enter Trainer Id to delete");
									 id = xyz.nextInt();
									 tmodel.setId(id);
									 b = Afun.deleteTrainerById(tmodel);
									 if(b) {
										 System.out.println("trainer deleted successfully.........");
									 }
									 else {
										 System.out.println("not deleted");
									 }
									break;
								
								case 10:
									  
									System.out.println("enter trainer Id");
									 id = xyz.nextInt();
									tmodel.setId(id);											
									 b = trainerService.checkTrainer(tmodel);					
									if(b) {
										List<LoginMasterModel> list5 = new ArrayList<LoginMasterModel>();
										System.out.println("view All allocated Trainee........");
										System.out.println("----------------------------------------- ");
										 list5 = trainerService.ViewAllAllocatedTraine(tmodel);
										 for (LoginMasterModel l : list5) {
												System.out.printf("%-10s  %-10s %-10s %-10s",  l.getName(), l.getContact(),l.getAge(),l.getGender());
									
												System.out.println();
												
											}
										
									}
									else {
										System.out.println("please enter your corrrect id");
									}
									
									break;
								case 11:
									System.out.println("Logged-out....");
									 
									break;	
								
								

							default:
								
								System.out.println("invalid choice");
								
								
							}
							if(choice==11) {
									break;
								}
							
							} while (true);

						} else {

							System.out.println("check id and password");
						}
						
	
							
						
						break;


			case 3:                                                               // user module
				System.out.println("welcome user"); 
				System.out.println("----------------------------------------- ");
				do {
					System.out.println("enter choice");
					System.out.println("1.sign-In");
					System.out.println("2.sign_up");
					choice = xyz.nextInt();
					switch (choice) {
					case 1:					
						xyz.nextLine();
						System.out.println("sign in page ");     
						System.out.println("enter your email as userid"); //userid- ram@gmail.com 
						 email = xyz.nextLine();
						System.out.println("enter your contact as password"); //pass-7057705455
						 password = xyz.nextLine();

						model.setEmail(email);
						model.setContact(password);						
						 b = ls.checkuser(model);
						
						if (b) {
							
							System.out.println("Welcome  in xyz Gym Application");    // user functions when login get success.		
							System.out.println("----------------------------------------- ");
							do {
							
							System.out.println("Enter your choice");
							System.out.println("1.View All Products of the Gym");
							System.out.println("2.Log-out");
							choice = xyz.nextInt();							
							switch(choice) {						
							case 1:
								System.out.println("----------------------------------------- ");
								System.out.println("---WELCOME IN XYZ GYM PRODUCT STORE ");
								list3 = Afun.ViewAllProduct();
								  System.out.printf("%-10s  %-10s %-10s %-10s","Id","Name","Price","expiry-Date");
								  System.out.println();
									for (ProductModel c : list3) {
										System.out.printf("%-10s  %-10s %-10s %-10s",c.getId(),  c.getName(), c.getPrice()
												,c.getExdate());
										System.out.println();
									}
								 System.out.println("Do you want to buy products");
								 System.out.println("1.yes");
								 System.out.println("2.no");
								 choice =xyz.nextInt();
								  switch(choice) {
								  
								  case 1:
									  List<ProductModel> list4 = new ArrayList<ProductModel>();
									  System.out.println(" product List ");
									  list3 = Afun.ViewAllProduct();
									  System.out.printf("%-10s  %-10s %-10s %-10s","Id","Name","Price","expiry-Date");
									  System.out.println();
										for (ProductModel c : list3) {
											System.out.printf("%-10s  %-10s %-10s %-10s",c.getId(),  c.getName(), c.getPrice()
													,c.getExdate());
											System.out.println();
											
										}
										
										do {
										
											System.out.println("enter products id... ");
											int id = xyz.nextInt();
											pmodel.setId(id);
											
											
											System.out.println("1.continue..");
											System.out.println("2.get bill");
											choice =xyz.nextInt();
											list4 = pservice.getBill(pmodel);
										}while(choice==1);
										
											System.out.println(" name \t\t price");
											for (ProductModel c : list4) {
												System.out.println(c.getName()+"\t\t"+c.getPrice());									
											 }
											int totalbill=0;
                                                 System.out.println("---------------------------");
											for (ProductModel c : list4) {
												totalbill= (totalbill+c.getPrice());									
											}
											System.out.println("total=\t\t"+totalbill);
																				  
									  break;
								  }							     
								break;
		
						   case 2:
							System.out.println("Logged-out....");
							 
							break;	
					  default:						
						System.out.println("invalid choice");						
					  }
							
							if(choice==3) {
								break;
							}
								
														
						
							} while(true);
						
						
						}
						else {
							System.out.println("you are not a user please check your id password or register first");
						}
						
						
				
						break;
					case 2:
						System.out.println("welcome user");
						boolean c = ls.Userregister();                                   //  method for new user register if user directly want to register
						if (c) {
							System.out.println("new user added");
					
							} else {
							System.out.println("not added");
						}
						break;
						
						
					}
					
					if(choice==3) {
						break;
					}
				} while (true);
			
            break;
			case 4:
				
				System.out.println("welcome Trainer "); 
				System.out.println("----------------------------------------- ");
                 do {
						System.out.println("enter your Id");// id-2
						int id = xyz.nextInt();
						tmodel.setId(id);											
						 b = trainerService.checkTrainer(tmodel);					
						if(b) {
							List<LoginMasterModel> list6;
							System.out.println("view All allocated Trainee........");
							System.out.println("----------------------------------------- ");
							 list6 = trainerService.ViewAllAllocatedTraine(tmodel);
							 for (LoginMasterModel c : list6) {
									System.out.printf("%-10s  %-10s %-10s %-10s",  c.getName(), c.getContact(),c.getAge(),c.getGender());						
									System.out.println();								
								}
							 
							 System.out.println("Enter 1 for Logout");
							 choice = xyz.nextInt();
							 if(choice ==1) {
								 System.out.println("-----log-out sucessfully----------");
								 break;
								 
							 }
						}
						else {
							System.out.println("please enter your corrrect id");
						}
									 
			     break;
                 }while(true);
			}
			
		} while (true);

	}
}
