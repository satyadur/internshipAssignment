package com.jsp.loadProject.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.loadProject.entity.Shipper;
import com.jsp.loadProject.repo.ShipperRepo;

@Repository
public class ShipperDao {
@Autowired
private ShipperRepo repo;

public Shipper saveShipper(Shipper shipper) {
	return repo.save(shipper);
}

public Shipper findBYShipperId(String uuid) {
	return repo.findByShipperId(uuid);
}

public Shipper findById(int id) {
	return repo.findById(id).get();
}

public Shipper deleteShipper(int id) {
	Shipper db = repo.findById(id).get();
	if(db != null) {
		repo.deleteById(id);
		return db;
	}else {
		return null;
	}
}
}
