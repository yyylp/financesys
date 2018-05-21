package com.ylp.financesys.bean;

public class Reiminfo {
	private String rid;
	private String eid;
	private String rdate;
	private String proof;
	private double price;
	private String remark;
	private String imid;//报销类目
	private String topmanager;//总经理
	private String deptmanager ;//部门经理
	private String cashier;//出纳
	private String rstatus;//报销状态 已申请0、部门经理已审核1、总经理已审核2、已发放3、已入账4
	
	private String ename;//报销人
	private String iname;//报销类目
	public Reiminfo(String rid, String eid, String rdate, String proof,
			double price, String remark, String imid, String topmanager,
			String deptmanager, String cashier, 
			String rstatus, String ename, String iname) {
		super();
		this.rid = rid;
		this.eid = eid;
		this.rdate = rdate;
		this.proof = proof;
		this.price = price;
		this.remark = remark;
		this.imid = imid;
		this.topmanager = topmanager;
		this.deptmanager = deptmanager;
		this.cashier = cashier;
		this.rstatus = rstatus;
		this.ename = ename;
		this.iname = iname;
	}
	public Reiminfo() {
		super();
	}
	public String getRid() {
		return rid;
	}
	public void setRid(String rid) {
		this.rid = rid;
	}
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	public String getRdate() {
		return rdate;
	}
	public void setRdate(String rdate) {
		this.rdate = rdate;
	}
	public String getProof() {
		return proof;
	}
	public void setProof(String proof) {
		this.proof = proof;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getImid() {
		return imid;
	}
	public void setImid(String imid) {
		this.imid = imid;
	}
	public String getTopmanager() {
		return topmanager;
	}
	public void setTopmanager(String topmanager) {
		this.topmanager = topmanager;
	}
	public String getDeptmanager() {
		return deptmanager;
	}
	public void setDeptmanager(String deptmanager) {
		this.deptmanager = deptmanager;
	}
	public String getCashier() {
		return cashier;
	}
	public void setCashier(String cashier) {
		this.cashier = cashier;
	}
	public String getRstatus() {
		return rstatus;
	}
	public void setRstatus(String rstatus) {
		this.rstatus = rstatus;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getIname() {
		return iname;
	}
	public void setIname(String iname) {
		this.iname = iname;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cashier == null) ? 0 : cashier.hashCode());
		result = prime * result
				+ ((deptmanager == null) ? 0 : deptmanager.hashCode());
		result = prime * result + ((eid == null) ? 0 : eid.hashCode());
		result = prime * result + ((ename == null) ? 0 : ename.hashCode());
		result = prime * result + ((imid == null) ? 0 : imid.hashCode());
		result = prime * result + ((iname == null) ? 0 : iname.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((proof == null) ? 0 : proof.hashCode());
		result = prime * result + ((rdate == null) ? 0 : rdate.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result + ((rid == null) ? 0 : rid.hashCode());
		result = prime * result + ((rstatus == null) ? 0 : rstatus.hashCode());
		result = prime * result
				+ ((topmanager == null) ? 0 : topmanager.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reiminfo other = (Reiminfo) obj;
		if (cashier == null) {
			if (other.cashier != null)
				return false;
		} else if (!cashier.equals(other.cashier))
			return false;
		if (deptmanager == null) {
			if (other.deptmanager != null)
				return false;
		} else if (!deptmanager.equals(other.deptmanager))
			return false;
		if (eid == null) {
			if (other.eid != null)
				return false;
		} else if (!eid.equals(other.eid))
			return false;
		if (ename == null) {
			if (other.ename != null)
				return false;
		} else if (!ename.equals(other.ename))
			return false;
	
		if (imid == null) {
			if (other.imid != null)
				return false;
		} else if (!imid.equals(other.imid))
			return false;
		if (iname == null) {
			if (other.iname != null)
				return false;
		} else if (!iname.equals(other.iname))
			return false;
		if (Double.doubleToLongBits(price) != Double
				.doubleToLongBits(other.price))
			return false;
		if (proof == null) {
			if (other.proof != null)
				return false;
		} else if (!proof.equals(other.proof))
			return false;
		if (rdate == null) {
			if (other.rdate != null)
				return false;
		} else if (!rdate.equals(other.rdate))
			return false;
		if (remark == null) {
			if (other.remark != null)
				return false;
		} else if (!remark.equals(other.remark))
			return false;
		if (rid == null) {
			if (other.rid != null)
				return false;
		} else if (!rid.equals(other.rid))
			return false;
		if (rstatus == null) {
			if (other.rstatus != null)
				return false;
		} else if (!rstatus.equals(other.rstatus))
			return false;
		if (topmanager == null) {
			if (other.topmanager != null)
				return false;
		} else if (!topmanager.equals(other.topmanager))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Reiminfo [rid=" + rid + ", eid=" + eid + ", rdate=" + rdate
				+ ", proof=" + proof + ", price=" + price + ", remark="
				+ remark + ", imid=" + imid + ", topmanager=" + topmanager
				+ ", deptmanager=" + deptmanager + ", cashier=" + cashier
				+ ", rstatus=" + rstatus
				+ ", ename=" + ename + ", iname=" + iname + "]";
	}

}
