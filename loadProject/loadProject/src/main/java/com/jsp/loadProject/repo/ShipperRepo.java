package com.jsp.loadProject.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.loadProject.entity.Shipper;

public interface ShipperRepo extends JpaRepository<Shipper, Integer> {
	@Query("select a from Shipper a where uuid=?1")
	public Shipper findByShipperId(String uuid);
}