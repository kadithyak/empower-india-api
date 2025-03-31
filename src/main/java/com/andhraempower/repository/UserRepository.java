package com.andhraempower.repository;

import com.andhraempower.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserName(String userName);

    boolean existsByUserName(String userName);

    boolean existsByEmail(String email);

    boolean existsByPhoneNumber(String phoneNumber);

    Optional<User> findById(Long id);

    @Query("SELECT u FROM User u WHERE " +
            "(:firstName IS NULL OR u.firstName LIKE %:firstName%) AND " +
            "(:lastName IS NULL OR u.lastName LIKE %:lastName%) AND " +
            "(:phoneNumber IS NULL OR u.phoneNumber = :phoneNumber) AND " +
            "(:email IS NULL OR u.email = :email) AND " +
            "(:districtId IS NULL OR u.districtId = :districtId) AND " +
            "(:roleId IS NULL OR :roleId IN (SELECT r.id FROM u.roles r))")
    List<User> findUsers(
            @Param("firstName") String firstName,
            @Param("lastName") String lastName,
            @Param("phoneNumber") String phoneNumber,
            @Param("email") String email,
            @Param("districtId") Integer districtId,
            @Param("roleId") Integer roleId
    );
}
