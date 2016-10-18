
/**
* Author:Collonn, Email:collonn@126.com, QQ:195358385
*/
package com.jelly.shiroMySQLDemo.model;

import java.math.BigDecimal;
import java.util.Date;

public class TPermission {
	public static final String Insert = "com.jelly.shiroMySQLDemo.model.TPermission.Insert";
	public static final String Update = "com.jelly.shiroMySQLDemo.model.TPermission.Update";
	public static final String UpdateWithNull = "com.jelly.shiroMySQLDemo.model.TPermission.UpdateWithNull";
	public static final String DeleteByPk = "com.jelly.shiroMySQLDemo.model.TPermission.DeleteByPk";
	public static final String DeleteByPojo = "com.jelly.shiroMySQLDemo.model.TPermission.DeleteByPojo";
	public static final String Select = "com.jelly.shiroMySQLDemo.model.TPermission.Select";
	public static final String SelectCount = "com.jelly.shiroMySQLDemo.model.TPermission.SelectCount";
	public static final String SelectByPk = "com.jelly.shiroMySQLDemo.model.TPermission.SelectByPk";
	
	private String id;
	
	private String peName;


	public TPermission setId (String id) {
		this.id = id;
		return this;
	}
	
	public String getId () {
		return this.id;
	}

	public TPermission setPeName (String peName) {
		this.peName = peName;
		return this;
	}
	
	public String getPeName () {
		return this.peName;
	}

}