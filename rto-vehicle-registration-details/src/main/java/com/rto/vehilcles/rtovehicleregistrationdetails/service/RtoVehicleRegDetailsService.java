package com.rto.vehilcles.rtovehicleregistrationdetails.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rto.vehilcles.rtovehicleregistrationdetails.model.OwnerDTO;
import com.rto.vehilcles.rtovehicleregistrationdetails.model.VehicleDTO;
import com.rto.vehilcles.rtovehicleregistrationdetails.repository.RtoOwnerRegistrationDetailsRepository;
import com.rto.vehilcles.rtovehicleregistrationdetails.repository.RtoVehicleDetailsRepository;

@Service
public class RtoVehicleRegDetailsService {

	@Autowired
	RtoOwnerRegistrationDetailsRepository repository;

	@Autowired
	RtoVehicleDetailsRepository  vehicleDetailsRepository;
	public List<OwnerDTO> getOwnerDTOs() {
		List<OwnerDTO> ownerDTOs = new ArrayList<OwnerDTO>();
		repository.findAll().forEach(owner1 -> ownerDTOs.add(owner1));
		return ownerDTOs;
	}
	
	public OwnerDTO getOwnerDetail(String id){
		if(repository.findById(id).isPresent()) {
			return repository.findById(id).get();
		}
		
		return null;
	}
	
	public VehicleDTO getVehicleDetailById(String id){
		if(vehicleDetailsRepository.findById(id).isPresent()) {
			return vehicleDetailsRepository.findById(id).get();
		}
		return null;
	}
}
