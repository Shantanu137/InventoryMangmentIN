package com.IMS.GKK.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Data;


@Data
@Entity
@Table
public class Income {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long productId;
	
	@NotBlank(message = "product Name is mandatory field")
	@Size(min = 5,max=50,message = "product Name shall be between 5 and 50 chars in length")
	@Column(name="productname",nullable = false)
	private String pname;
	
	@NotNull(message = "Product quantity is mandatory field")
	private long pquantity;
	 
	

	@NotBlank(message = "Name is mandatory field")
	@Size(min = 4,max=50,message = "Name shall be between 5 and 50 chars in length")
	@Column(name="name",nullable = false)
	private String name;
	
	
	@NotNull(message = "Dateis a mandatory field")
	@Column(name="date",nullable = false)
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate date;	
	
}