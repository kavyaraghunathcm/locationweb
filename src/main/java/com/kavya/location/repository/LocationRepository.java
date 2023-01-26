package com.kavya.location.repository;

import com.kavya.location.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface LocationRepository extends JpaRepository<Location,Integer> {

}
