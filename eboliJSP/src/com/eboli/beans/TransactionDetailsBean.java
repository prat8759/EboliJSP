package com.eboli.beans;

import java.sql.Date;

public class TransactionDetailsBean {
	
	private int trnid;
	private int uid;
	private int pid;
	private double tamt;
	private Date ttime;
	private int tstatus;
	private int ttype;
	public int getTrnid() {
		return trnid;
	}
	public void setTrnid(int trnid) {
		this.trnid = trnid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public double getTamt() {
		return tamt;
	}
	public void setTamt(double tamt) {
		this.tamt = tamt;
	}
	public Date getTtime() {
		return ttime;
	}
	public void setTtime(Date ttime) {
		this.ttime = ttime;
	}
	public int getTstatus() {
		return tstatus;
	}
	public void setTstatus(int tstatus) {
		this.tstatus = tstatus;
	}
	public int getTtype() {
		return ttype;
	}
	public void setTtype(int ttype) {
		this.ttype = ttype;
	}
	
	public TransactionDetailsBean()
	{
		
	}
	public TransactionDetailsBean(int uid, int pid, double tamt,
			Date ttime, int tstatus, int ttype) {
		super();
		//this.trnid = trnid;
		this.uid = uid;
		this.pid = pid;
		this.tamt = tamt;
		this.ttime = ttime;
		this.tstatus = tstatus;
		this.ttype = ttype;
	}
	
	
}
