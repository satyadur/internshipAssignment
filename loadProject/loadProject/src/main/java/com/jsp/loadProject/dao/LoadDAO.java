package com.jsp.loadProject.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.loadProject.entity.LoadProject;
import com.jsp.loadProject.entity.Shipper;
import com.jsp.loadProject.repo.LoadRepo;

@Repository
public class LoadDAO {
	@Autowired
	private LoadRepo repo;

	public LoadProject saveLoad(LoadProject load) {
		return repo.save(load);

	}

	public List<LoadProject> listOfLoads() {
		return repo.findAll();
	}

	public LoadProject deleteLoad(int id) {
		LoadProject db = repo.findById(id).get();
		if (db != null) {
			repo.deleteById(db.getId());
			return db;
		}else {
			return null;
		}
	}

	public List<LoadProject> listOfLoadsByShipperId(String shipperId) {
		List<LoadProject> list = repo.findByShipperId(shipperId);
		System.out.println(list);
		if (list.isEmpty()) {
			return null;
		} else {
			return list;
		}
	}

	public LoadProject updateLoad(LoadProject load) {
		LoadProject db = repo.findById(load.getId()).get();
		System.out.println("from dao=" + db);
		if (db != null) {
			if (load.getLoadingPoint() == null) {
				load.setLoadingPoint(db.getLoadingPoint());
			} else if (load.getUnloadingPoint() == null) {
				load.setUnloadingPoint(db.getUnloadingPoint());
			} else if (load.getProductType() == null) {
				load.setProductType(db.getProductType());
			} else if (load.getTruckType() == null) {
				load.setTruckType(db.getTruckType());
			} else if (load.getNoOfTrucks() == 0) {
				load.setNoOfTrucks(db.getNoOfTrucks());
			} else if (load.getWeight() == 0) {
				load.setWeight(db.getWeight());
			} else if (load.getComment() == null) {
				load.setComment(db.getComment());
			} else if (load.getDate() == null) {
				load.setDate(db.getDate());
			} else if (load.getShipperId() == null) {
				load.setShipperId(db.getShipperId());
			}else if(load.getId() == 0){
				load.setId(db.getId());
			}
			repo.save(load);
			return load;
		} else {
			return null;
		}
	}

	public LoadProject singleLoad(int id) {
		try {
			LoadProject db = repo.findById(id).get();
			return db;
		} catch (Exception e) {
			return null;
		}

	}
}
