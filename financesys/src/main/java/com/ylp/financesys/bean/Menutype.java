package com.ylp.financesys.bean;

public class Menutype {
	private String mtid;
	private String mtname;
	@Override
	public String toString() {
		return "Menutype [mtid=" + mtid + ", mtname=" + mtname + "]";
	}
	public Menutype(String mtid, String mtname) {
		super();
		this.mtid = mtid;
		this.mtname = mtname;
	}
	public Menutype() {
		super();
	}
	public String getMtid() {
		return mtid;
	}
	public void setMtid(String mtid) {
		this.mtid = mtid;
	}
	public String getMtname() {
		return mtname;
	}
	public void setMtname(String mtname) {
		this.mtname = mtname;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mtid == null) ? 0 : mtid.hashCode());
		result = prime * result + ((mtname == null) ? 0 : mtname.hashCode());
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
		Menutype other = (Menutype) obj;
		if (mtid == null) {
			if (other.mtid != null)
				return false;
		} else if (!mtid.equals(other.mtid))
			return false;
		if (mtname == null) {
			if (other.mtname != null)
				return false;
		} else if (!mtname.equals(other.mtname))
			return false;
		return true;
	}
}
