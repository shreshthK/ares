package com.movieFlex.Model.Pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
public class Directors {
	@Id
	@GeneratedValue(generator="uuid2")
	@GenericGenerator(name="uuid2", strategy="uuid2")
	@Getter @Setter private String directorId;
	
	@Column(nullable=false, unique=true)
	@Getter @Setter private String directorName;
	
	@Column(nullable=false)
	@Getter @Setter private boolean  deleted;
	
	@PrePersist
	void preInsert() {
	   deleted = false;
	}
	
	
}	
