package org.amalitech.traineesdatarest.repository;

//import org.springframework.stereotype.Repository;
import org.amalitech.traineesdatarest.entity.Trainee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@RepositoryRestResource(collectionResourceRel="trainee", path="trainee")
public interface TraineeRepository extends JpaRepository<Trainee, Integer>{

}
