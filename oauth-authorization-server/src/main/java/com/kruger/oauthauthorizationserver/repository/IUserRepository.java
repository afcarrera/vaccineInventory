package com.kruger.oauthauthorizationserver.repository;

import com.kruger.oauthauthorizationserver.model.EndUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<EndUser,Integer> {
    @Query("SELECT u FROM EndUser u WHERE u.userName = :name")
    EndUser findByName(@Param("name") String name);
}
