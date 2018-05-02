package com.ylp.financesys.bean;

public class Empright {
	private String erid;
	private String mid;//权限
	private String eid;//员工
	@Override
	public String toString() {
		return "Empright [erid=" + erid + ", mid=" + mid + ", eid=" + eid + "]";
	}
	public Empright(String erid, String mid, String eid) {
		super();
		this.erid = erid;
		this.mid = mid;
		this.eid = eid;
	}
	public Empright() {
		super();
	}
	public String getErid() {
		return erid;
	}
	public void setErid(String erid) {
		this.erid = erid;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((eid == null) ? 0 : eid.hashCode());
		result = prime * result + ((erid == null) ? 0 : erid.hashCode());
		result = prime * result + ((mid == null) ? 0 : mid.hashCode());
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
		Empright other = (Empright) obj;
		if (eid == null) {
			if (other.eid != null)
				return false;
		} else if (!eid.equals(other.eid))
			return false;
		if (erid == null) {
			if (other.erid != null)
				return false;
		} else if (!erid.equals(other.erid))
			return false;
		if (mid == null) {
			if (other.mid != null)
				return false;
		} else if (!mid.equals(other.mid))
			return false;
		return true;
	}
	
}
