package com.jsp.loadProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.loadProject.entity.Shipper;
import com.jsp.loadProject.service.ShipperService;
import com.jsp.loadProject.util.ResponseStructure;

@RestController
public class ShipperController {
	@Autowired
private ShipperService service;
	
	@PostMapping("/saveShipper")
	public ResponseEntity<ResponseStructure<Shipper>> saveShipper(@RequestBody Shipper shipper) {
	return service.saveShipper(shipper);
	}
}


//{
//	"loadingPoint": "delhi",
//	"unloadingPoint": "jaipur",
//	"productType": "chemicals",
//	"truckType": "canter",
//	"noOfTrucks": "1",
//	"weight": "100",
//    "comment": "baga"
//	
//}
