
/**
* Author:Collonn, Email:collonn@126.com, QQ:195358385
*/
package com.jelly.shiroMySQLDemo.model;

import java.math.BigDecimal;
import java.util.Date;

public class TUserRole {
	public static final String Insert = "com.jelly.shiroMySQLDemo.model.TUserRole.Insert";
	public static final String Update = "com.jelly.shiroMySQLDemo.model.TUserRole.Update";
	public static final String UpdateWithNull = "com.jelly.shiroMySQLDemo.model.TUserRole.UpdateWithNull";
	public static final String DeleteByPk = "com.jelly.shiroMySQLDemo.model.TUserRole.DeleteByPk";
	public static final String DeleteByPojo = "com.jelly.shiroMySQLDemo.model.TUserRole.DeleteByPojo";
	public static final String Select = "com.jelly.shiroMySQLDemo.model.TUserRole.Select";
	public static final String SelectCount = "com.jelly.shiroMySQLDemo.model.TUserRole.SelectCount";
	public static final String SelectByPk = "com.jelly.shiroMySQLDemo.model.TUserRole.SelectByPk";
	
	private String id;
	
	private String userId;
	
	private String roleId;


	public TUserRole setId (String id) {
		this.id = id;
		return this;
	}
	
	public String getId () {
		return this.id;
	}

	public TUserRole setUserId (String userId) {
		this.userId = userId;
		return this;
	}
	
	public String getUserId () {
		return this.userId;
	}

	public TUserRole setRoleId (String roleId) {
		this.roleId = roleId;
		return this;
	}
	
	public String getRoleId () {
		return this.roleId;
	}

}