package com.example.demo;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Address_table")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "Village")
	private String village;
	@Column(name = "Town")
	private String town;
	@Column(name = "City")
	private String city;
	@Column(name = "State")
	private String state;
	@Column(name = "PinCode")
	private Integer pinCode;
	@ManyToOne
	@JoinColumn(name = "uid")
	@JsonBackReference
	private Customer customer;
	
}
