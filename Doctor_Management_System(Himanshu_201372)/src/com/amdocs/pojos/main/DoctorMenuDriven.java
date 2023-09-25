package com.amdocs.pojos.main;

import java.util.*;
import com.amdocs.pojos.exception.DoctorNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.amdocs.pojos.Dao.DoctorDao;
import com.amdocs.pojos.Dao.DoctorDaoDriven;
import com.amdocs.pojos.Doctor;
public class DoctorMenuDriven {
		
		public static void main(String[] args){
		
		Scanner sc=new Scanner(System.in);
		DoctorDao dao=new DoctorDaoDriven(); 

		
		
		
		do {
			
			System.out.println("1. Add new doctor\r\n"
					+ "2. Update doctor fees\r\n"
					+ "3. Delete doctor\r\n"
					+ "4. View all doctors\r\n"
					+ "5. Find doctor by specialization\r\n"
					+ "6. Find doctors who’s fees is less than all doctors of given shift\r\n"
					+ "7. Count number of doctors by shift\r\n"
					+ "8. Exit\r\n"
					+ "");
			
			System.out.println("Enter your choice:");
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("To Add new doctor");
				System.out.println("Enter unique Doctor ID");
				int id =sc.nextInt();
				System.out.println("Enter Doctor name");
				String name=sc.next();
				System.out.println("Enter Doctor mobile number");
				String number=sc.next();
				System.out.println("Enter Doctor specialization");
				String specialization=sc.next();
				System.out.println("Enter Doctor availableshift");
				String shift=sc.next();
				System.out.println("Enter Doctor fees");
				double fees;
				fees=sc.nextDouble();
				Doctor doctor=new Doctor(id,name,number,specialization,shift,fees);
				int y = dao.addDoctor(doctor);
				System.out.println(y);
				System.out.println("Doctor Added Successfully");
				break;
				
			case 2:
				System.out.println("update doctor fees");
				System.out.println("First Enter Doctor id");
				int Doctor_id=sc.nextInt();
				System.out.println("Enter new doctor fees");
				int New_fee=sc.nextInt();
				boolean flag;
				try {
					flag = dao.updateDoctorFees(Doctor_id, New_fee);
					if(flag)
						System.out.println("Doctor fees updated");
					 else
						 throw new DoctorNotFoundException("Doctor Not Found");
					
				} catch (DoctorNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				 
				break;
				
			case 3:
				System.out.println("delete doctor");
				System.out.println("Enter Doctor's Id to delete");
				Doctor_id=sc.nextInt();
				int x=0;
				try {
					x = dao.deleteDoctor(Doctor_id);
//					System.out.println("The doctor has been deleted");
					if(x!=0)
						System.out.println("The doctor has been deleted");
					else
						 throw new DoctorNotFoundException("Doctor Not Found");
				} catch (DoctorNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				break;

				
			case 4:
				System.out.println("view all doctor");
				List<Doctor> doctorList=dao.showAllDoctors();
				for(int i=0;i<doctorList.size();i++)
				{
					System.out.println(doctorList.get(i));
				}
				break;	
			case 5:
				System.out.println("search doctor by specialization");
				System.out.println("Enter Doctor specialization");
				String sp=sc.next();
				List<Doctor> doctemplist = null;
				try {
					doctemplist = dao.searchBySpecialization(sp);
					if(doctemplist.size()<=0)
						throw new DoctorNotFoundException("Doctor Not Found");
				} catch (DoctorNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for(int i=0;i<doctemplist.size();i++)
				{
						System.out.println(doctemplist.get(i));
				}
				break;
			case 6:
				System.out.println("search doctors who’s fees is less than all doctors of given shift");
				System.out.println("Enter shift of a doctor");
				String shif=sc.next();
				System.out.println("Enter your fees range");
				double fee = sc.nextInt();
				List<Doctor> docTemp = null;
				try {
					docTemp = dao.searchByFeesAndShift(shif, fee);
					if(docTemp.size()<=0)
						throw new DoctorNotFoundException("Doctor Not Found");
				} catch (DoctorNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for(Doctor doc:docTemp) {
					System.out.println(doc);
				}

				break;
			case 7:
				System.out.println("Count number of doctors by shift");
				System.out.println("Enter  shift of doctors");
				String shift1 = sc.next();
				int docCount = dao.countDoctorsByShift(shift1);
				
				System.out.println("number of doctors available: " + docCount);
				
				break;
			case 8:
				System.out.println("Program Exit");
                System.exit(0);
			}
			
		}
		while(true);
		
		
	}
}
