package com.jsp.loadProject.entity;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Component
@Entity
@Data
public class Shipper {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(unique = true)
	private String uuid = (UUID.randomUUID()).toString();
	
	
	private String name;
	private long phone;
	

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<LoadProject> load;
}
