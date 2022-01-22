package com.web.data.model;


import java.util.List;



import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="newusers")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="uid")
  private Integer uid;
	@Column(name="name")
  private String name;


	@Column(name="email")
  private String email;
	@Column(name="pwd")
  private String pwd;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name="rolestab",//table name
	joinColumns=@JoinColumn(name="uid")) //join column or key column
	@Column(name="role")//element column
  private List<String> roles;	
}
