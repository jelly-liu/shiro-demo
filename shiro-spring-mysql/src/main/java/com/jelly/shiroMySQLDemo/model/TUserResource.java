
/**
* Author:Collonn, Email:collonn@126.com, QQ:195358385
*/
package com.jelly.shiroMySQLDemo.model;

import java.math.BigDecimal;
import java.util.Date;

public class TUserResource {
	public static final String Insert = "com.jelly.shiroMySQLDemo.model.TUserResource.Insert";
	public static final String Update = "com.jelly.shiroMySQLDemo.model.TUserResource.Update";
	public static final String UpdateWithNull = "com.jelly.shiroMySQLDemo.model.TUserResource.UpdateWithNull";
	public static final String DeleteByPk = "com.jelly.shiroMySQLDemo.model.TUserResource.DeleteByPk";
	public static final String DeleteByPojo = "com.jelly.shiroMySQLDemo.model.TUserResource.DeleteByPojo";
	public static final String Select = "com.jelly.shiroMySQLDemo.model.TUserResource.Select";
	public static final String SelectCount = "com.jelly.shiroMySQLDemo.model.TUserResource.SelectCount";
	public static final String SelectByPk = "com.jelly.shiroMySQLDemo.model.TUserResource.SelectByPk";
	
	private String id;
	
	private String userId;
	
	private String resourceId;


	public TUserResource setId (String id) {
		this.id = id;
		return this;
	}
	
	public String getId () {
		return this.id;
	}

	public TUserResource setUserId (String userId) {
		this.userId = userId;
		return this;
	}
	
	public String getUserId () {
		return this.userId;
	}

	public TUserResource setResourceId (String resourceId) {
		this.resourceId = resourceId;
		return this;
	}
	
	public String getResourceId () {
		return this.resourceId;
	}

}