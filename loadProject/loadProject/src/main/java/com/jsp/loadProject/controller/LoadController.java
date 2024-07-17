package com.jsp.loadProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.loadProject.entity.LoadProject;
import com.jsp.loadProject.entity.Shipper;
import com.jsp.loadProject.service.LoadService;
import com.jsp.loadProject.service.ShipperService;
import com.jsp.loadProject.util.ResponseStructure;
import com.jsp.loadProject.util.ResponseStructure2;

@RestController
public class LoadController {
	@Autowired
	private LoadService service;
	
	@Autowired
	private ShipperService shipperservice;
	@PostMapping("/load")
	public ResponseEntity<ResponseStructure<LoadProject>> saveLOad(@RequestBody LoadProject load) {
		return service.saveLoad(load);
	}
	
	@GetMapping("/load")
	public ResponseEntity<ResponseStructure2<LoadProject>> fetchListOfLoadByShipperId(@RequestParam String shipperId) {
		return service.fetchLIstOfLoadByShipperId(shipperId);
	}
	
	@GetMapping("/load/{loadId}")
	public ResponseEntity<ResponseStructure<LoadProject>> fetchSingleLoad(@PathVariable int loadId) {
		return service.singleLOad(loadId);
	}
	
	@PutMapping("/load/{loadId}")
	public ResponseEntity<ResponseStructure<LoadProject>> updateLoad(@RequestBody LoadProject loadId) {
		return service.updateLoad(loadId);
	}
	
	@DeleteMapping("/load/{loadId}")
	public ResponseEntity<ResponseStructure<Shipper>> deleteLoad(@PathVariable int loadId) {
		return shipperservice.deleteShipper(loadId);
	}
}
