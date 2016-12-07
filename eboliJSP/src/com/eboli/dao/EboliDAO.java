package com.eboli.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.eboli.beans.ProductDetailsBean;
import com.eboli.beans.TransactionDetailsBean;
import com.eboli.common.DBgen;



public class EboliDAO {
	
	public int insertUserDetails(String uid,String fname,String lname,String addr1) throws SQLException, ClassNotFoundException
	{
		
		String insUsrDetQry = "insert into userdetails(uid,fname,lname,addr1) values("+
				"?,?,?,?);";
		DBgen.loadMySqlDriver();//load JdbcOdbcDriver class
		Connection con = DBgen.getMySqlConn();
		PreparedStatement ps = con.prepareStatement(insUsrDetQry);
		ps.setString(1, uid);
		ps.setString(2, fname);
		ps.setString(3, lname);
		ps.setString(4, addr1);
		System.out.println("getUsrDetQry "+ps);
		int count = ps.executeUpdate();
		System.out.println("count "+count);
		return count;
	}
	
	public int insertLoginDetails(String uname,String upwd) throws SQLException, ClassNotFoundException
	{
		System.out.println("in insertLoginDetails: uname fetched= "+uname);
		String insLoginDetQry = "insert into login(uname,upwd) values(?,?)";
		DBgen.loadMySqlDriver();//load JdbcOdbcDriver class
		Connection con = DBgen.getMySqlConn();
		PreparedStatement ps = con.prepareStatement(insLoginDetQry);
		ps.setString(1, uname);
		ps.setString(2, upwd);

		System.out.println("insLoginDetQry "+ps);
		int count = ps.executeUpdate();
		System.out.println("count "+count);
		return count;
	}
	
	public String getUserId(String uname) throws SQLException, ClassNotFoundException
	{
		String id=null;
		String getLoginDetQry = "select * from login where uname=? ;";
		DBgen.loadMySqlDriver();//load JdbcOdbcDriver class
		Connection con = DBgen.getMySqlConn();
		PreparedStatement ps = con.prepareStatement(getLoginDetQry);
		ps.setString(1, uname);
		System.out.println("getLoginDetQry "+ps);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next())
		{
			//System.out.println("System");
			String db_uname = rs.getString("uname");
			String db_pwd = rs.getString("upwd");
			String db_uid = rs.getString("userid");
			System.out.println(db_uid + " ---  " + db_pwd + " --- "+ db_uname);				
			id=db_uid;
		}						
		return id;
	}
	
	public static boolean isUserPresent(String uname) 
	{
	
		String fetchUserQry = QueryMaster.isUnamePresQry;
		
		try{
			//System.out.println("System");
		Connection con = DBgen.getMySqlConn();
		PreparedStatement ps = con.prepareStatement(fetchUserQry);
		ResultSet rs = ps.executeQuery();
		int count=0;
			while(rs.next())
			{
				//System.out.println("System");
				count = rs.getInt("count");
				System.out.print("count " + count);
				if(count>=1)
				{				
					return true;
				}
			}			
		}
		catch(SQLException e){
			System.out.println("SQLException : " + e);
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException : " + e);
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	public int getProductId(String pname, String pcat) //is product present
	{
	
		String getProdIdFromPnamePcatQry = QueryMaster.getProdIdFromPnamePcatQry;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int pid=0;
		try{
			//System.out.println("System");
		con = DBgen.getMySqlConn();
		ps = con.prepareStatement(getProdIdFromPnamePcatQry);
		ps.setString(1, pname);
		ps.setString(2, pcat);
		System.out.println("getProdIdFromPnamePcatQry "+ps);
		rs = ps.executeQuery();
		//int count=0;
			while(rs.next())
			{
				//System.out.println("System");
				pid = rs.getInt("pid");
				System.out.print("pid " + pid);				
			}			
		}
		catch(SQLException e){
			System.out.println("SQLException : " + e);
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException : " + e);
			e.printStackTrace();
		}
		finally
		{
			if(con!=null)
			{
				try {
					con.close();
				} catch (SQLException e1) {
					System.out.println("SQLException : " + e1);
					e1.printStackTrace();
				}
			}
			if(ps!=null)
			{
				try {
					ps.close();
				} catch (SQLException e1) {
					System.out.println("SQLException : " + e1);
					e1.printStackTrace();
				}
			}
			if(rs!=null)
			{
				try {
					rs.close();
				} catch (SQLException e1) {
					System.out.println("SQLException : " + e1);
					e1.printStackTrace();
				}
			}
		}
		return pid;
	}
	
	
	public double[] getProdCurBid(int pid) 
	{
	
		String getCurBidForProdQry = QueryMaster.getCurBidForProdQry;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		double pcurbid=-1, pminbid=-1;
		double[] retarr = new double[2]; 
		try{
			//System.out.println("System");
		con = DBgen.getMySqlConn();
		ps = con.prepareStatement(getCurBidForProdQry);
		ps.setInt(1, pid);
		System.out.println("getCurBidForProdQry "+ps);
		rs = ps.executeQuery();
		//int count=0;
			while(rs.next())
			{
				//System.out.println("System");
				pcurbid = rs.getDouble("pcurbid");
				pminbid = rs.getDouble("pminbid");
				System.out.print("pcurbid " + pcurbid+" pminbid " + pminbid);				
			}			
		}
		catch(SQLException e){
			System.out.println("SQLException : " + e);
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException : " + e);
			e.printStackTrace();
		}
		finally
		{
			if(con!=null)
			{
				try {
					con.close();
				} catch (SQLException e1) {
					System.out.println("SQLException : " + e1);
					e1.printStackTrace();
				}
			}
			if(ps!=null)
			{
				try {
					ps.close();
				} catch (SQLException e1) {
					System.out.println("SQLException : " + e1);
					e1.printStackTrace();
				}
			}
			if(rs!=null)
			{
				try {
					rs.close();
				} catch (SQLException e1) {
					System.out.println("SQLException : " + e1);
					e1.printStackTrace();
				}
			}
		}
		retarr[0]=pcurbid;retarr[1]=pminbid;
		return retarr;
	}
	
	
	public int getTxnId(int uid,int pid) 
	{
	
		String getTxnIdQry = QueryMaster.getTxnIdQry;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int tid=0;
		try{
			//System.out.println("System");
		con = DBgen.getMySqlConn();
		ps = con.prepareStatement(getTxnIdQry);
		ps.setInt(1, uid);
		ps.setInt(2, pid);
		System.out.println("getTxnIdQry "+ps);
		rs = ps.executeQuery();
		//int count=0;
			while(rs.next())
			{
				//System.out.println("System");
				tid = rs.getInt("tid");
				System.out.print("tid " + tid);				
			}			
		}
		catch(SQLException e){
			System.out.println("SQLException : " + e);
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException : " + e);
			e.printStackTrace();
		}
		finally
		{
			if(con!=null)
			{
				try {
					con.close();
				} catch (SQLException e1) {
					System.out.println("SQLException : " + e1);
					e1.printStackTrace();
				}
			}
			if(ps!=null)
			{
				try {
					ps.close();
				} catch (SQLException e1) {
					System.out.println("SQLException : " + e1);
					e1.printStackTrace();
				}
			}
			if(rs!=null)
			{
				try {
					rs.close();
				} catch (SQLException e1) {
					System.out.println("SQLException : " + e1);
					e1.printStackTrace();
				}
			}
		}
		return tid;
	}
	
	public int insertProductDetails(ProductDetailsBean pdb,int uid) throws SQLException, ClassNotFoundException
	{
		//System.out.println("in insertLoginDetails: uname fetched= "+uname);
		String insertProdDetQry = QueryMaster.insertProdDetQry;
		DBgen.loadMySqlDriver();//load JdbcOdbcDriver class
		Connection con = DBgen.getMySqlConn();
		PreparedStatement ps = con.prepareStatement(insertProdDetQry);
		ps.setString(1, pdb.getPcode());
		ps.setString(2, pdb.getPname());
		ps.setString(3, pdb.getPdesc());
		ps.setString(4, pdb.getPcat());
		ps.setDouble(5, pdb.getPminbid());
		ps.setDouble(6, pdb.getPcurbid());
		ps.setDouble(7, pdb.getPbuynow());
		ps.setInt(8, pdb.getPstatus());
		ps.setInt(9, uid);
		System.out.println("insertProdDetQry "+ps);
		int count = ps.executeUpdate();
		System.out.println("count "+count);
		return count;
	}
	
	public int insertTransactionDetails(TransactionDetailsBean tdb) throws SQLException, ClassNotFoundException
	{
		//System.out.println("in insertLoginDetails: uname fetched= "+uname);
		String insTxnDetQry = QueryMaster.insTxnDetQry;
		DBgen.loadMySqlDriver();//load JdbcOdbcDriver class
		Connection con = DBgen.getMySqlConn();
		PreparedStatement ps = con.prepareStatement(insTxnDetQry);
		ps.setInt(1, tdb.getUid());
		ps.setInt(2, tdb.getPid());
		ps.setDouble(3, tdb.getTamt());
		ps.setDate(4, tdb.getTtime());
		ps.setInt(5, tdb.getTstatus());
		ps.setInt(6, tdb.getTtype());

		System.out.println("insTxnDetQry "+ps);
		int count = ps.executeUpdate();
		System.out.println("count "+count);
		return count;
	}
	
	
	public ArrayList<ProductDetailsBean> getProductDetails(int pid,String pcat,boolean all) throws SQLException, ClassNotFoundException
	{
		ArrayList<ProductDetailsBean> pdbList = new ArrayList<ProductDetailsBean>();
		ProductDetailsBean pdb=null;
		
		String getProdDetQry = null ;
		if(pid>0)
		{
			getProdDetQry = QueryMaster.getProdDetFromPidQry;
		}
		else if(pcat!=null && !pcat.equals(""))
		{
			getProdDetQry = QueryMaster.getCatWiseProdDetailsQry;
		}
		else if(all)
		{
			getProdDetQry = QueryMaster.getAllProductsQry;
		}
		else
		{
			System.out.println("Error Condition");
			return null;
		}
		Connection con = DBgen.getMySqlConn();
		PreparedStatement ps = con.prepareStatement(getProdDetQry);
		if(pid>0)
		{
			ps.setInt(1, pid);
		}
		else if(pcat!=null && !pcat.equals(""))
		{
			ps.setString(1, pcat);
		}
		
		System.out.println("getProdDetQry "+ps);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next())
		{
			pdb= new ProductDetailsBean();
			pdb.setPid(rs.getInt(1));
			pdb.setPcode(rs.getString(2));
			pdb.setPname(rs.getString(3));
			pdb.setPdesc(rs.getString(4));
			pdb.setPcat(rs.getString(5));
			pdb.setPminbid(rs.getDouble(6));
			pdb.setPcurbid(rs.getDouble(7));
			pdb.setPbuynow(rs.getDouble(8));
			pdb.setPstatus(rs.getInt(9));
			pdb.setPchbidder(rs.getString("pchbidder"));
			pdbList.add(pdb);
		}						
		return pdbList;
	}
	
	
	public int updUserPwd(int uid,String upwd) 
	{
	
		String updUserPwdQry = QueryMaster.updUserPwdQry;
		Connection con=null;
		PreparedStatement ps=null;
		int res=0;
		try{
			con = DBgen.getMySqlConn();
			ps = con.prepareStatement(updUserPwdQry);
			ps.setString(1, upwd);
			ps.setInt(2, uid);
			System.out.println("updUserPwdQry "+ps);
			res = ps.executeUpdate();
			System.out.print("res " + res);							
		}
		catch(SQLException e){
			System.out.println("SQLException : " + e);
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException : " + e);
			e.printStackTrace();
		}
		finally
		{
			if(con!=null)
			{
				try {
					con.close();
				} catch (SQLException e1) {
					System.out.println("SQLException : " + e1);
					e1.printStackTrace();
				}
			}
			if(ps!=null)
			{
				try {
					ps.close();
				} catch (SQLException e1) {
					System.out.println("SQLException : " + e1);
					e1.printStackTrace();
				}
			}
		}
		return res;
	}
	
	
	public int updProdStatus(int pid,int pstatus) 
	{
	
		String updProdStatusQry = QueryMaster.updProdStatusQry;
		Connection con=null;
		PreparedStatement ps=null;
		int res=0;
		try{
			con = DBgen.getMySqlConn();
			ps = con.prepareStatement(updProdStatusQry);
			ps.setInt(1, pstatus);
			ps.setInt(2, pid);
			System.out.println("updProdStatusQry "+ps);
			res = ps.executeUpdate();
			System.out.print("res " + res);							
		}
		catch(SQLException e){
			System.out.println("SQLException : " + e);
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException : " + e);
			e.printStackTrace();
		}
		finally
		{
			if(con!=null)
			{
				try {
					con.close();
				} catch (SQLException e1) {
					System.out.println("SQLException : " + e1);
					e1.printStackTrace();
				}
			}
			if(ps!=null)
			{
				try {
					ps.close();
				} catch (SQLException e1) {
					System.out.println("SQLException : " + e1);
					e1.printStackTrace();
				}
			}
		}
		return res;
	}
	
	public int updProdChBid(int pid,double pcurbid,int pchbidder) 
	{
	
		String updCurBidForProdQry = QueryMaster.updCurBidForProdQry;
		Connection con=null;
		PreparedStatement ps=null;
		int res=0;
		try{
			con = DBgen.getMySqlConn();
			ps = con.prepareStatement(updCurBidForProdQry);
			ps.setDouble(1, pcurbid);
			ps.setInt(2, pchbidder);
			ps.setInt(3, pid);
			System.out.println("updCurBidForProdQry "+ps);
			res = ps.executeUpdate();
			System.out.print("res " + res);							
		}
		catch(SQLException e){
			System.out.println("SQLException : " + e);
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException : " + e);
			e.printStackTrace();
		}
		finally
		{
			if(con!=null)
			{
				try {
					con.close();
				} catch (SQLException e1) {
					System.out.println("SQLException : " + e1);
					e1.printStackTrace();
				}
			}
			if(ps!=null)
			{
				try {
					ps.close();
				} catch (SQLException e1) {
					System.out.println("SQLException : " + e1);
					e1.printStackTrace();
				}
			}
		}
		return res;
	}
	
	public int updTxnDetails(TransactionDetailsBean tdb) 
	{
	
		String updTxnDetQry = QueryMaster.updTxnDetQry;
		Connection con=null;
		PreparedStatement ps=null;
		int res=0;
		try{
			con = DBgen.getMySqlConn();
			ps = con.prepareStatement(updTxnDetQry);
			ps.setDouble(1, tdb.getTamt());
			ps.setDate(2, tdb.getTtime());
			ps.setInt(3, tdb.getTstatus());
			ps.setInt(4, tdb.getTtype());
			ps.setInt(5, tdb.getUid());
			ps.setInt(6, tdb.getPid());
			System.out.println("updTxnDetQry "+ps);
			res = ps.executeUpdate();
			System.out.print("res " + res);							
		}
		catch(SQLException e){
			System.out.println("SQLException : " + e);
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException : " + e);
			e.printStackTrace();
		}
		finally
		{
			if(con!=null)
			{
				try {
					con.close();
				} catch (SQLException e1) {
					System.out.println("SQLException : " + e1);
					e1.printStackTrace();
				}
			}
			if(ps!=null)
			{
				try {
					ps.close();
				} catch (SQLException e1) {
					System.out.println("SQLException : " + e1);
					e1.printStackTrace();
				}
			}
		}
		return res;
	}
	
}
