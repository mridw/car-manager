package org.mridul.loginAndRegistration.Repository;

import org.mridul.loginAndRegistration.Entity.userCredEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface loginRegRepo extends JpaRepository<userCredEntity,Long>{
    Optional<userCredEntity> findOneByEmailAndPassword(String email, String password);
    userCredEntity findByEmail(String email);
}
