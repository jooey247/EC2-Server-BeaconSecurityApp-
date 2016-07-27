package cse.knu.kr.deagu.beaconsecurityapp.Users;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

/**
 * Created by juhee on 2016-07-26.
 */

@Entity
public class PlaceInfo{
	
	@id //beacon mac address ,PK
    private String plcId;
    private String plcName;
    private String plcPw;
    private String plcAdrs;
    private String plcOption;
    
    @JoinCloumn //FK
    private String userName;
    

    public PlaceInfo(String plcId, String plcPw) {
        this.plcName = plcId;
        this.plcPw = plcPw;
    }

    public PlaceInfo(String plcId, String plcName, String plcPw, String plcAdrs, String plcOption, String userName) {
        this.plcId = plcId;
        this.plcName = plcName;
        this.plcPw = plcPw;
        this.plcAdrs = plcAdrs;
        this.plcOption = plcOption;
        this.userName = userName;
    }
    
    public String getUserName()
    {
    	return userName;
    }
    
    public void setUserName(String userName){
    	this.userName = userName;
    }
    

    public String getPlcId() {
        return plcId;
    }

    public void setPlcId(String plcId) {
        this.plcId = plcId;
    }

    public String getPlcName() {
        return plcName;
    }

    public void setPlcName(String plcName) {
        this.plcName = plcName;
    }

    public String getPlcPw() {
        return plcPw;
    }

    public void setPlcPw(String plcPw) {
        this.plcPw = plcPw;
    }

    public String getPlcAdrs() {
        return plcAdrs;
    }

    public void setPlcAdrs(String plcAdrs) {
        this.plcAdrs = plcAdrs;
    }

    public String getPlcOption() {
        return plcOption;
    }

    public void setPlcOption(String plcOption) {
        this.plcOption = plcOption;
    }
    
    

}

/*package com.example;

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
 */ 
