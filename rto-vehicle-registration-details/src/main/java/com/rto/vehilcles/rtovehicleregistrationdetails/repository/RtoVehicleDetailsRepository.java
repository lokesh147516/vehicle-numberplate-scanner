package com.rto.vehilcles.rtovehicleregistrationdetails.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rto.vehilcles.rtovehicleregistrationdetails.model.VehicleDTO;

public interface RtoVehicleDetailsRepository extends JpaRepository<VehicleDTO, String>{

}
