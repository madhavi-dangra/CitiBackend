package com.citi.trade.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "UserMaster")
public class User {

	@Id
	@Column(name ="userId")
	Long userId;
	
	@Column(name ="password")
	String password;
	
	@Column(name="userName")
	String userName;

	
	@Override
	public String toString() {
		return "UserMaster [userId=" + userId + ", password=" + password + "]";
	}


	public Long getUserId() {
		return userId;
	}


	public void setUserId(Long userId) {
		this.userId = userId;
	}


	

    
    

}
