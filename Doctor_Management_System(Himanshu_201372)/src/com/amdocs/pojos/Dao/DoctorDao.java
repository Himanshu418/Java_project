package com.amdocs.pojos.Dao;

import java.util.List;

import com.amdocs.pojos.Doctor;
import com.amdocs.pojos.exception.DoctorNotFoundException;

public interface DoctorDao {
	public int addDoctor(Doctor doctor);
	
	public  int deleteDoctor(int doctorId)throws DoctorNotFoundException;
	public boolean updateDoctorFees(int doctorId,double fees)throws DoctorNotFoundException;
	public List<Doctor> showAllDoctors();
	public  List<Doctor> searchBySpecialization(String specialization) throws DoctorNotFoundException;
	public  List<Doctor>searchByFeesAndShift(String availableShift,double fees)throws DoctorNotFoundException;
	public int countDoctorsByShift(String availableShift);
	
}
