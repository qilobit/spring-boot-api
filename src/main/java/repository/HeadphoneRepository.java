package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import models.Headphone;

@Repository
public interface HeadphoneRepository extends JpaRepository<Headphone, Long>{

}
