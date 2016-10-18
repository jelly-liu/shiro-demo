
/**
* Author:Collonn, Email:collonn@126.com, QQ:195358385
*/
package com.jelly.shiroMySQLDemo.model;

import java.math.BigDecimal;
import java.util.Date;

public class TRole {
	public static final String Insert = "com.jelly.shiroMySQLDemo.model.TRole.Insert";
	public static final String Update = "com.jelly.shiroMySQLDemo.model.TRole.Update";
	public static final String UpdateWithNull = "com.jelly.shiroMySQLDemo.model.TRole.UpdateWithNull";
	public static final String DeleteByPk = "com.jelly.shiroMySQLDemo.model.TRole.DeleteByPk";
	public static final String DeleteByPojo = "com.jelly.shiroMySQLDemo.model.TRole.DeleteByPojo";
	public static final String Select = "com.jelly.shiroMySQLDemo.model.TRole.Select";
	public static final String SelectCount = "com.jelly.shiroMySQLDemo.model.TRole.SelectCount";
	public static final String SelectByPk = "com.jelly.shiroMySQLDemo.model.TRole.SelectByPk";
	
	private String id;
	
	private String roName;


	public TRole setId (String id) {
		this.id = id;
		return this;
	}
	
	public String getId () {
		return this.id;
	}

	public TRole setRoName (String roName) {
		this.roName = roName;
		return this;
	}
	
	public String getRoName () {
		return this.roName;
	}

}