package com.project1.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@Entity
public class Category {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	private Long idParent;
	private String title;
	private String icon;
	private String description;
	
	@CreationTimestamp
	private LocalDateTime createTimestamp;
	@UpdateTimestamp
	private LocalDateTime updateTimestamp;
	
	
	
}
