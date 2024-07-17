package com.jsp.loadProject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.loadProject.dao.LoadDAO;
import com.jsp.loadProject.dao.ShipperDao;
import com.jsp.loadProject.entity.LoadProject;
import com.jsp.loadProject.entity.Shipper;
import com.jsp.loadProject.util.ResponseStructure;
import com.jsp.loadProject.util.ResponseStructure2;

@Service
public class LoadService {
	@Autowired
	private LoadDAO dao1;

	@Autowired
	private ShipperDao dao2;

	public ResponseEntity<ResponseStructure<LoadProject>> saveLoad(LoadProject load) {
		ResponseStructure<LoadProject> structure = new ResponseStructure<LoadProject>();

		Shipper db = dao2.findBYShipperId(load.getShipperId());
		if (db != null) {
			List<LoadProject> list = new ArrayList<LoadProject>();
			list.addAll(db.getLoad());
			list.add(load);
			db.setLoad(list);
			structure.setPayload(dao1.saveLoad(load));
			structure.setResponse("loads details added successfully");
			structure.setStatus(HttpStatus.CREATED.value());
		} else {
			structure.setPayload(null);
			structure.setResponse("loads details not added");
			structure.setStatus(HttpStatus.BAD_REQUEST.value());
		}

		return new ResponseEntity<ResponseStructure<LoadProject>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure2<LoadProject>> fetchLIstOfLoadByShipperId(String shipperId) {
		List<LoadProject> list = dao1.listOfLoadsByShipperId(shipperId);
		ResponseStructure2<LoadProject> str = new ResponseStructure2<LoadProject>();
		if (list != null) {
			str.setPayload(list);
			;
			str.setResponse("list of loads with this shipperId");
			str.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure2<LoadProject>>(str, HttpStatus.FOUND);
		} else {
			str.setPayload(null);
			;
			str.setResponse("data not found...!!!");
			str.setStatus(HttpStatus.BAD_REQUEST.value());
			return new ResponseEntity<ResponseStructure2<LoadProject>>(str, HttpStatus.BAD_REQUEST);
		}

	}

	public ResponseEntity<ResponseStructure<LoadProject>> singleLOad(int id) {
		LoadProject db = dao1.singleLoad(id);
		ResponseStructure<LoadProject> str = new ResponseStructure<LoadProject>();
		if (db != null) {
			str.setPayload(db);
			str.setResponse("single load...");
			str.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<LoadProject>>(str, HttpStatus.FOUND);
		} else {
			str.setPayload(null);
			str.setResponse("Data not Found");
			str.setStatus(HttpStatus.BAD_REQUEST.value());
			return new ResponseEntity<ResponseStructure<LoadProject>>(str, HttpStatus.BAD_REQUEST);
		}
	}
	
	public ResponseEntity<ResponseStructure<LoadProject>> updateLoad(LoadProject load) {
		ResponseStructure<LoadProject> str = new ResponseStructure<LoadProject>();
		LoadProject details = dao1.singleLoad(load.getId());
		System.out.println("from servicxe:__"+details);
		if (details != null) {
			LoadProject db = dao1.updateLoad(load);
			str.setPayload(db);
			str.setResponse("LOAD updated successfully...");
			str.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<LoadProject>>(str, HttpStatus.FOUND);
		} else {
			str.setPayload(null);
			str.setResponse("Data not Found");
			str.setStatus(HttpStatus.BAD_REQUEST.value());
			return new ResponseEntity<ResponseStructure<LoadProject>>(str, HttpStatus.BAD_REQUEST);
		}
	}
	
	public ResponseEntity<ResponseStructure<LoadProject>> deleteLoad(int id) {
		ResponseStructure<LoadProject> str = new ResponseStructure<LoadProject>();
		Shipper details = dao2.findById(id);
		System.out.println("delete servide:-"+details);
		if(details != null) {
			LoadProject db = dao1.deleteLoad(id);
			str.setPayload(db);
			str.setResponse("LOAD Deleted successfully...");
			str.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<LoadProject>>(str, HttpStatus.FOUND);
		}else {
			str.setPayload(null);
			str.setResponse("Data not Found");
			str.setStatus(HttpStatus.BAD_REQUEST.value());
			return new ResponseEntity<ResponseStructure<LoadProject>>(str, HttpStatus.BAD_REQUEST);
		}
		
	}
}
