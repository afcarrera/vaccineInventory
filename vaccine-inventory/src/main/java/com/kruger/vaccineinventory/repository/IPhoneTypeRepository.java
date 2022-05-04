package com.kruger.vaccineinventory.repository;

import com.kruger.vaccineinventory.model.PhoneType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPhoneTypeRepository extends JpaRepository<PhoneType, Integer> {
}
