package com.amdocs.pojos.Dao;

import java.util.*;
import com.amdocs.pojos.Doctor;
import java.util.ArrayList;
//import com.amdocs.pojos.Dao.DoctorDao;
import com.amdocs.pojos.exception.DoctorNotFoundException;

public class DoctorDaoDriven implements DoctorDao {
	List<Doctor> list=new ArrayList<>();
	@Override
	public int addDoctor(Doctor doctor) {

		list.add(doctor);
		list.add(new Doctor(101,"Sharma","8097882233","Surgeon","morning",100));
		list.add(new Doctor(102,"Ram","8097982298","Orthopedics","morning",100));
		list.add(new Doctor(103,"Sita","8097989998","Neurology","morning",300));
		list.add(new Doctor(104,"Ravan","8097989998","Dermatology","evening",60));
		return doctor.getDoctorId();
	}

	@Override
	public int deleteDoctor (int doctorId)throws DoctorNotFoundException {
		
		for (int i = 0; i < list.size(); i++) 
		{
            if (list.get(i).getDoctorId() == doctorId) 
            {
            	list.remove(i);
            	return doctorId;
            }
		}
		return 0;
	}

	@Override
	public boolean updateDoctorFees (int doctorId, double fees)throws DoctorNotFoundException {
		
		for (int i = 0; i < list.size(); i++) 
		{
            if (list.get(i).getDoctorId() == doctorId) 
            {
            	list.get(i).setFees(fees);
            	return true;
            }
//            list.get(i).setFees(fees);
		}

		return false;
	}

	@Override
	public List<Doctor> showAllDoctors() {
		return list;
	}

	@Override
	public List<Doctor> searchBySpecialization (String specialization) throws DoctorNotFoundException {
		List<Doctor> doctemp=new ArrayList<>();
		for(int i=0;i<list.size();i++)
		{
			if(list.get(i).getSpecialization().equals(specialization))
				doctemp.add(list.get(i));
		}
		return doctemp;
	}

	@Override
	public List<Doctor> searchByFeesAndShift (String availableShift,double fees)throws DoctorNotFoundException {
		List<Doctor> doctortempList=new ArrayList<>();
		for(Doctor doctor:list)
		{
			if(doctor.getAvailableShift().equals(availableShift) && doctor.getFees()<=fees)
			{				
				doctortempList.add(doctor);
			}			
		}
		return doctortempList;
	}

	@Override
	public int countDoctorsByShift(String availableShift) {
		
		int count=0;
		for(int i=0;i<list.size();i++)
		{
			if(list.get(i).getAvailableShift().equals(availableShift))
			{
				count++;
			}
			
		}
		return count;
	}
}
