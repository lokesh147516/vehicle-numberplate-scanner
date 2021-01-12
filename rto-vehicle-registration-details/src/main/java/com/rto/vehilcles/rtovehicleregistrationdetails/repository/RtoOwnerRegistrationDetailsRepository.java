package com.rto.vehilcles.rtovehicleregistrationdetails.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.internal.CriteriaUpdateImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rto.vehilcles.rtovehicleregistrationdetails.model.OwnerDTO;
import com.rto.vehilcles.rtovehicleregistrationdetails.model.VehicleDTO;

@Repository
public interface RtoOwnerRegistrationDetailsRepository extends JpaRepository<OwnerDTO, String> {
}
