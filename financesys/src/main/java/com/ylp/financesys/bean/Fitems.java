package com.ylp.financesys.bean;

public class Fitems {
	private String imid;
	private String iname;
	private String fid; //所属类别
	private String fname;
	@Override
	public String toString() {
		return "Fitems [imid=" + imid + ", iname=" + iname + ", fid=" + fid
				+ ", fname=" + fname + "]";
	}
	public Fitems(String imid, String iname, String fid) {
		super();
		this.imid = imid;
		this.iname = iname;
		this.fid = fid;
	}
	public Fitems() {
		super();
	}
	public String getImid() {
		return imid;
	}
	public void setImid(String imid) {
		this.imid = imid;
	}
	public String getIname() {
		return iname;
	}
	public void setIname(String iname) {
		this.iname = iname;
	}
	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fid == null) ? 0 : fid.hashCode());
		result = prime * result + ((fname == null) ? 0 : fname.hashCode());
		result = prime * result + ((imid == null) ? 0 : imid.hashCode());
		result = prime * result + ((iname == null) ? 0 : iname.hashCode());
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
		Fitems other = (Fitems) obj;
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
		return true;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	
}
