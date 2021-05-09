package org.amalitech.traineesdatarest.repository;

import org.springframework.stereotype.Repository;
import org.amalitech.traineesdatarest.entity.Trainee;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface TraineeRepository extends JpaRepository<Trainee, Integer>{

}
