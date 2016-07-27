package com.example;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class PlaceInfo {

	@Id
	// beacon mac address
	//PK
	private String plcId;
	private String plcName;
	private String plcPw;
	private String plcAdrs;
	private String plcOption;
	
	//FK
	@JoinColumn
	private String userName;
}
