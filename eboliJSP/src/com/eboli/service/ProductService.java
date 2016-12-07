package com.eboli.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.eboli.beans.ProductDetailsBean;
import com.eboli.beans.TransactionDetailsBean;
import com.eboli.dao.EboliDAO;

public class ProductService {

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
	
	public String addProduct(ProductDetailsBean pdb,int uid)
	{
		int res=0;
		int pid=0;
		int chkpid=0;
		int tid=0;
		String msg=null;
		try {
			
			chkpid = ebolidao.getProductId(pdb.getPname(),pdb.getPcat());
			if(chkpid>0)
			{
				msg="Product: "+pdb.getPname()+" already present";
			}
			else
			{			
				res = ebolidao.insertProductDetails(pdb,uid);				
				if(res>0)
				{
					pid = ebolidao.getProductId(pdb.getPname(),pdb.getPcat());
					if(pid>0)
					{	
						java.util.Date today = new java.util.Date();
						java.sql.Date d = new java.sql.Date(today.getTime());
						TransactionDetailsBean tdb = new TransactionDetailsBean(uid,pid,pdb.getPbuynow(),d,1,1);
						tid = ebolidao.insertTransactionDetails(tdb);
						if(tid>0)
						{
							msg="Product created and saved sucessfully";
						}
						else
						{
							msg = "Some error occured in creating product(transaction)";
						}
					}
					else
					{
						msg = "Some error occured in creating product(retrieval)";
					}
				}
				else
				{
					msg = "Some error occured in creating product";
				}
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return msg;
	}
	
	
	public ArrayList<ProductDetailsBean> getProductDetails(int pid,String pcat,boolean all)
	{
		ArrayList<ProductDetailsBean> pdb = null;
		try
		{
			pdb = ebolidao.getProductDetails(pid, pcat, all);
			System.out.println("pdb.size()"+ pdb.size());
		}
		catch(SQLException se)
		{
			System.out.println(se);
		}
		catch(ClassNotFoundException cnf)
		{
			System.out.println(cnf);
		}
		return pdb;
	}
	
	
	public String bidForProduct(int pid, double pnewbid,int uid)
	{
		String msg=null;
		double[] retarr = new double[2]; 
		double pcurbid=-1,pminbid=-1;
		int pupdsta=0,tupdsta=0;
		try
		{
			retarr = ebolidao.getProdCurBid(pid);
			pcurbid = retarr[0];
			pminbid = retarr[1];
			System.out.println("pnewbid fetched from form: "+pnewbid+" pid="+pid+" and uid="+uid);
			if(pnewbid<pminbid)
			{
				msg="Invalid bid. New Bid Value must be greater than product min bid ("+pminbid+").";
			}
			else if(pnewbid<pcurbid)
			{
				msg="Invalid bid. New Bid Value must be greater than product's current highest bid ("+pcurbid+").";
			}
			else
			{
				pupdsta = ebolidao.updProdChBid(pid, pnewbid, uid);
				if(pupdsta>0)
				{
					java.util.Date today = new java.util.Date();
					java.sql.Date d = new java.sql.Date(today.getTime());
					TransactionDetailsBean tdb = new TransactionDetailsBean(uid,pid,pnewbid,d,1,2);
					tupdsta = ebolidao.updTxnDetails(tdb);
					if(tupdsta>0)
					{
						msg="Product bid was successful!";
					}
					else
					{
						msg="Some error occured in updating product(transaction).";
					}
				}
				else
				{
					msg="Some error occured in updating product.";
				}
			}
		}
		catch(Exception ex)
		{
			System.out.println("ex "+ex);
		}
		return msg;
	}
	
	public String buyProduct(int pid, int uid,String pname,double pbuynow)
	{
		String msg=null;
		int pupdsta=0,tupdsta=0;
		try
		{
				System.out.println("buyProducr Rcvd param: "+pid+" "+uid+" "+pname+" "+pbuynow);
				pupdsta = ebolidao.updProdStatus(pid, 5);
				if(pupdsta>0)
				{
					java.util.Date today = new java.util.Date();
					java.sql.Date d = new java.sql.Date(today.getTime());
					TransactionDetailsBean tdb = new TransactionDetailsBean(uid,pid,pbuynow,d,1,3);
					tupdsta = ebolidao.updTxnDetails(tdb);
					if(tupdsta>0)
					{
						msg="Congratulations! You are a proud owner of "+pname+"!";
					}
					else
					{
						msg="Some error occured in updating product(transaction).";
					}
				}
				else
				{
					msg="Some error occured in updating product.";
				}
			
		}
		catch(Exception ex)
		{
			System.out.println("ex "+ex);
		}
		return msg;
	}
	
}
