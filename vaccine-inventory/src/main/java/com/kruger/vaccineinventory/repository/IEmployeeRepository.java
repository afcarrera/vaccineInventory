package com.kruger.vaccineinventory.repository;

import com.kruger.vaccineinventory.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.Collection;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query("SELECT COUNT(e) FROM Employee e WHERE e.emplIdentification LIKE %:identification%")
    Integer countByIdentification(@Param("identification") String identification);
    @Query("SELECT e FROM Employee e WHERE e.vastId = :status")
    Collection<Employee> findByStatus(@Param("status") String status);
    @Query("SELECT DISTINCT(v.employeeByEmplId) FROM Vaccination v, VaccineDose d WHERE v.vaccDoseId = d.vaccDoseId " +
            "AND d.vatyId = :vaccineType")
    Collection<Employee> findByVaccineType(@Param("vaccineType") String vaccineType);

    @Query("SELECT DISTINCT(v.employeeByEmplId) FROM Vaccination v WHERE v.vaccVaccinationDate " +
            "BETWEEN :startDate AND :endDate")
    Collection<Employee> findByDate(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
}
