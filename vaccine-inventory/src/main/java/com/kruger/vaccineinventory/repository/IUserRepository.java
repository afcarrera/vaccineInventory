package com.kruger.vaccineinventory.repository;

import com.kruger.vaccineinventory.model.EndUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository <EndUser, Integer>  {
    @Query("SELECT COUNT(u) FROM EndUser u WHERE u.userName LIKE %:name%")
    Integer countByName(@Param("name") String name);
}
