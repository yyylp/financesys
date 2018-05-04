package com.ylp.financesys.bean;

public class Sysright {
	private String srid;
	private String mid;//菜单项（权限）id
	private String sid;//角色id
	
	
	public Sysright() {
		super();
	}
	public Sysright(String srid, String mid, String sid) {
		super();
		this.srid = srid;
		this.mid = mid;
		this.sid = sid;
	}
	public String getSrid() {
		return srid;
	}
	public void setSrid(String srid) {
		this.srid = srid;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mid == null) ? 0 : mid.hashCode());
		result = prime * result + ((sid == null) ? 0 : sid.hashCode());
		result = prime * result + ((srid == null) ? 0 : srid.hashCode());
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
		Sysright other = (Sysright) obj;
		if (mid == null) {
			if (other.mid != null)
				return false;
		} else if (!mid.equals(other.mid))
			return false;
		if (sid == null) {
			if (other.sid != null)
				return false;
		} else if (!sid.equals(other.sid))
			return false;
		if (srid == null) {
			if (other.srid != null)
				return false;
		} else if (!srid.equals(other.srid))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Sysright [srid=" + srid + ", mid=" + mid + ", sid=" + sid + "]";
	}
	
}
