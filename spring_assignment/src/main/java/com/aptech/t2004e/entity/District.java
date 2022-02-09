package com.aptech.t2004e.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Table(name = "district")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class District {
	@Id
	@Column(name = "district_id")
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private long id ;
	
	@Column(name = "district_name" , nullable = false)
	private String name ;
	@OneToMany(cascade = CascadeType.ALL ,mappedBy = "district" )
	private List<Street> streets ;	
	
	/*
	 * 
	 */
	@Column(name = "created_by" , nullable = true)
	private String createdBy ;
	@Column(name = "created_date" , nullable =  true)
	private LocalDateTime createdAt ;
	@Column(name = "updated_by",  nullable = true)
	private String updatedBy ;
	@Column(name ="updated_at", nullable = true)
	private LocalDateTime updatedAt ;
	
	
	
	@PrePersist
	public void prePersist() {
		setCreatedAt(LocalDateTime.now());
	}
	
	@PreUpdate
	public void preUpdate() {
		setUpdatedAt(LocalDateTime.now());
	}
	
}
