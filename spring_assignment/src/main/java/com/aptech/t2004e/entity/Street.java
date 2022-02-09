package com.aptech.t2004e.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "street")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Street {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "street_id")
	private long id ;
	@Column(name = "street_name" , nullable = false)
	private String name ;
	@Column(name = "founding_date" , nullable =  true)
	private LocalDate  foundingDate ;
	@Column(name = "description" , nullable = false)
	private String description ;
	@Column(name = "stauts" , nullable = false)
	private String status ;
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
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="district_id",referencedColumnName = "district_id")
	private District district ;
	
	@PrePersist
	public void prePersist() {
		setCreatedAt(LocalDateTime.now());
	}
	
	@PreUpdate
	public void preUpdate() {
		setUpdatedAt(LocalDateTime.now());
	}
	
	
}
