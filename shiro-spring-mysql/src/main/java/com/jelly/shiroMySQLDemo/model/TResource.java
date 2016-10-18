
/**
* Author:Collonn, Email:collonn@126.com, QQ:195358385
*/
package com.jelly.shiroMySQLDemo.model;

import java.math.BigDecimal;
import java.util.Date;

public class TResource {
	public static final String Insert = "com.jelly.shiroMySQLDemo.model.TResource.Insert";
	public static final String Update = "com.jelly.shiroMySQLDemo.model.TResource.Update";
	public static final String UpdateWithNull = "com.jelly.shiroMySQLDemo.model.TResource.UpdateWithNull";
	public static final String DeleteByPk = "com.jelly.shiroMySQLDemo.model.TResource.DeleteByPk";
	public static final String DeleteByPojo = "com.jelly.shiroMySQLDemo.model.TResource.DeleteByPojo";
	public static final String Select = "com.jelly.shiroMySQLDemo.model.TResource.Select";
	public static final String SelectCount = "com.jelly.shiroMySQLDemo.model.TResource.SelectCount";
	public static final String SelectByPk = "com.jelly.shiroMySQLDemo.model.TResource.SelectByPk";
	
	private String id;
	
	private String reName;
	
	private String rePath;


	public TResource setId (String id) {
		this.id = id;
		return this;
	}
	
	public String getId () {
		return this.id;
	}

	public TResource setReName (String reName) {
		this.reName = reName;
		return this;
	}
	
	public String getReName () {
		return this.reName;
	}

	public TResource setRePath (String rePath) {
		this.rePath = rePath;
		return this;
	}
	
	public String getRePath () {
		return this.rePath;
	}

}