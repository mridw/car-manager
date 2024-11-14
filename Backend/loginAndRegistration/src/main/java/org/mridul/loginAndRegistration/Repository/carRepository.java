package org.mridul.loginAndRegistration.Repository;

import org.mridul.loginAndRegistration.Entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface carRepository extends JpaRepository<CarEntity,Long> {
}
