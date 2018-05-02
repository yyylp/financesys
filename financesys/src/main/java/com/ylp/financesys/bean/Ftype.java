package com.ylp.financesys.bean;

public class Ftype {
	private String fid;
	private String fname;
	@Override
	public String toString() {
		return "Ftype [fid=" + fid + ", fname=" + fname + "]";
	}
	public Ftype(String fid, String fname) {
		super();
		this.fid = fid;
		this.fname = fname;
	}
	public Ftype() {
		super();
	}
	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fid == null) ? 0 : fid.hashCode());
		result = prime * result + ((fname == null) ? 0 : fname.hashCode());
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
		Ftype other = (Ftype) obj;
		if (fid == null) {
			if (other.fid != null)
				return false;
		} else if (!fid.equals(other.fid))
			return false;
		if (fname == null) {
			if (other.fname != null)
				return false;
		} else if (!fname.equals(other.fname))
			return false;
		return true;
	}
	
}
