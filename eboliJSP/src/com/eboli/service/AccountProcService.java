package com.eboli.service;
import java.sql.SQLException;

import com.eboli.common.Validations;
import com.eboli.dao.EboliDAO;


public class AccountProcService {
	
	EboliDAO ebolidao = new EboliDAO();
	
	public boolean registerUser(String uname,String upwd,String fname,String lname,String addr1) throws SQLException, ClassNotFoundException
	{
		String uid=null;
		int status2=-1;
		boolean finstatus=false;
		System.out.println("uname fetched= "+uname+" upwd= "+upwd);
		//username exist logic missing
		 if(ebolidao.insertLoginDetails(uname, upwd)>0)
		 {
			 uid = ebolidao.getUserId(uname);
			 status2 = ebolidao.insertUserDetails(uid, fname, lname, addr1);
			 System.out.println("status2 = "+status2);
			 finstatus=true;
		 }
		 return finstatus;
	}
	
	public int valUserLogin(String uname,String pwd)
	{
		int uid=0;
		//boolean status=false;
		try {
			if(Validations.LoginFrmDB(uname,pwd))
			{
				uid=Integer.parseInt(ebolidao.getUserId(uname));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(uid);
		return uid;
	}
}
