package com.jsp.loadProject.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.loadProject.entity.LoadProject;

public interface LoadRepo extends JpaRepository<LoadProject, Integer> {
	@Query("select a from LoadProject a where shipperId=?1")
	public List<LoadProject> findByShipperId(String shipperId);
}
