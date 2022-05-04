package com.kruger.vaccineinventory.repository;

import com.kruger.vaccineinventory.model.Vaccination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.Collection;

@Repository
public interface IVaccinationRepository  extends JpaRepository<Vaccination, Integer> {

}
