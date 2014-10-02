package cn.edu.nju.gqx.db.po;

import java.sql.Timestamp;

public class Turngroup implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9048672552447967521L;
	private Integer id;
	private Integer grpid;
	private String sname;
	private Timestamp update_time;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getGrpid() {
		return grpid;
	}
	public void setGrpid(Integer grpid) {
		this.grpid = grpid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public Timestamp getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Timestamp update_time) {
		this.update_time = update_time;
	}
	
	
}
