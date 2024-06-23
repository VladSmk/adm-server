package com.amazon.adMonitor.repositories;

import com.amazon.adMonitor.models.Advertising;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvertisingRepository extends JpaRepository<Advertising, Integer> {

}
