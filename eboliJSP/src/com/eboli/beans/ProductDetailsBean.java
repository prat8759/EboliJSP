package com.eboli.beans;

public class ProductDetailsBean {
	
	private int pid;
	private String pcode;
	private String pname;
	private String pdesc;
	private String pcat;
	private double pminbid;
	private double pcurbid;
	private double pbuynow;
	private int pstatus;
	private String pchbidder;

	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPcode() {
		return pcode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPdesc() {
		return pdesc;
	}
	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}
	public String getPcat() {
		return pcat;
	}
	public void setPcat(String pcat) {
		this.pcat = pcat;
	}
	public double getPminbid() {
		return pminbid;
	}
	public void setPminbid(double pminbid) {
		this.pminbid = pminbid;
	}
	public double getPcurbid() {
		return pcurbid;
	}
	public void setPcurbid(double pcurbid) {
		this.pcurbid = pcurbid;
	}
	public double getPbuynow() {
		return pbuynow;
	}
	public void setPbuynow(double pbuynow) {
		this.pbuynow = pbuynow;
	}
	public int getPstatus() {
		return pstatus;
	}
	public void setPstatus(int pstatus) {
		this.pstatus = pstatus;
	}
	public String getPchbidder() {
		return pchbidder;
	}
	public void setPchbidder(String pchbidder) {
		this.pchbidder = pchbidder;
	}
}
