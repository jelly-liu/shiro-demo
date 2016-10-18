
/**
* Author:Collonn, Email:collonn@126.com, QQ:195358385
*/
package com.jelly.shiroMySQLDemo.model;

import java.math.BigDecimal;
import java.util.Date;

public class TUser {
	public static final String Insert = "com.jelly.shiroMySQLDemo.model.TUser.Insert";
	public static final String Update = "com.jelly.shiroMySQLDemo.model.TUser.Update";
	public static final String UpdateWithNull = "com.jelly.shiroMySQLDemo.model.TUser.UpdateWithNull";
	public static final String DeleteByPk = "com.jelly.shiroMySQLDemo.model.TUser.DeleteByPk";
	public static final String DeleteByPojo = "com.jelly.shiroMySQLDemo.model.TUser.DeleteByPojo";
	public static final String Select = "com.jelly.shiroMySQLDemo.model.TUser.Select";
	public static final String SelectCount = "com.jelly.shiroMySQLDemo.model.TUser.SelectCount";
	public static final String SelectByPk = "com.jelly.shiroMySQLDemo.model.TUser.SelectByPk";
	
	private String id;
	
	private String username;
	
	private String password;
	
	private String salt;


	public TUser setId (String id) {
		this.id = id;
		return this;
	}
	
	public String getId () {
		return this.id;
	}

	public TUser setUsername (String username) {
		this.username = username;
		return this;
	}
	
	public String getUsername () {
		return this.username;
	}

	public TUser setPassword (String password) {
		this.password = password;
		return this;
	}
	
	public String getPassword () {
		return this.password;
	}

	public TUser setSalt (String salt) {
		this.salt = salt;
		return this;
	}
	
	public String getSalt () {
		return this.salt;
	}

}