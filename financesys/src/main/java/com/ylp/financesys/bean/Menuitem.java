package com.ylp.financesys.bean;

public class Menuitem {
	private String mid;
	private String mname;
	private String mtid;
	private String attr;//打开选项卡名称
	private String mtname;//所属类型
	private int flag;//是否拥有此菜单项的权限
	
	@Override
	public String toString() {
		return "Menuitem [mid=" + mid + ", mname=" + mname + ", mtid=" + mtid
				+ ", attr=" + attr + ", mtname=" + mtname + ", flag=" + flag
				+ "]";
	}
	
	public Menuitem(String mid, String mname, String mtid, String attr,
			String mtname) {
		super();
		this.mid = mid;
		this.mname = mname;
		this.mtid = mtid;
		this.attr = attr;
		this.mtname = mtname;
	}


	public Menuitem() {
		super();
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMtid() {
		return mtid;
	}
	public void setMtid(String mtid) {
		this.mtid = mtid;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((attr == null) ? 0 : attr.hashCode());
		result = prime * result + ((mid == null) ? 0 : mid.hashCode());
		result = prime * result + ((mname == null) ? 0 : mname.hashCode());
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
		Menuitem other = (Menuitem) obj;
		if (attr == null) {
			if (other.attr != null)
				return false;
		} else if (!attr.equals(other.attr))
			return false;
		if (mid == null) {
			if (other.mid != null)
				return false;
		} else if (!mid.equals(other.mid))
			return false;
		if (mname == null) {
			if (other.mname != null)
				return false;
		} else if (!mname.equals(other.mname))
			return false;
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
	public String getMtname() {
		return mtname;
	}
	public void setMtname(String mtname) {
		this.mtname = mtname;
	}

	public String getAttr() {
		return attr;
	}

	public void setAttr(String attr) {
		this.attr = attr;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}
	
}
