<<<<<<< HEAD
package com.zensar.department;

public class Department {
	private int depId;
	private String depName;
	private Department() {
		super();
	}
	private Department(int depId, String depName) {
		super();
		this.depId = depId;
		this.depName = depName;
	}
	public int getDepId() {
		return depId;
	}
	public void setDepId(int depId) {
		this.depId = depId;
	}
	public String getDepName() {
		return depName;
	}
	public void setDepName(String depName) {
		this.depName = depName;
	}
	@Override
	public String toString() {
		return "Department [depId=" + depId + ", depName=" + depName + "]";
	}
}
=======
package com.zensar.department;

public class Department {
	private int depId;
	private String depName;
	private Department() {
		super();
	}
	private Department(int depId, String depName) {
		super();
		this.depId = depId;
		this.depName = depName;
	}
	public int getDepId() {
		return depId;
	}
	public void setDepId(int depId) {
		this.depId = depId;
	}
	public String getDepName() {
		return depName;
	}
	public void setDepName(String depName) {
		this.depName = depName;
	}
	@Override
	public String toString() {
		return "Department [depId=" + depId + ", depName=" + depName + "]";
	}
}
>>>>>>> branch 'main' of https://github.com/srilaxmipillalamarri/java.git
