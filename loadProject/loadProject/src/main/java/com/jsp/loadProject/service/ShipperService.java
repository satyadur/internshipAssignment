package com.jsp.loadProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.loadProject.dao.ShipperDao;
import com.jsp.loadProject.entity.Shipper;
import com.jsp.loadProject.util.ResponseStructure;

@Service
public class ShipperService {
	@Autowired
	private ShipperDao dao;

	public ResponseEntity<ResponseStructure<Shipper>> saveShipper(Shipper shipper) {
		ResponseStructure<Shipper> structure = new ResponseStructure<Shipper>();
		structure.setPayload(dao.saveShipper(shipper));
		structure.setResponse("loads details added successfully");
		structure.setStatus(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Shipper>>(structure, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Shipper>> deleteShipper(int id) {
		ResponseStructure<Shipper> structure = new ResponseStructure<Shipper>();
		Shipper db = dao.findById(id);
		if(db != null) {
			structure.setPayload(dao.deleteShipper(id));
			structure.setResponse("loads deleted successfully");
			structure.setStatus(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<Shipper>>(structure, HttpStatus.CREATED);
		}else {
			structure.setPayload(dao.deleteShipper(id));
			structure.setResponse("loads deleted successfully");
			structure.setStatus(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<Shipper>>(structure, HttpStatus.BAD_REQUEST);
		}
	}
}
