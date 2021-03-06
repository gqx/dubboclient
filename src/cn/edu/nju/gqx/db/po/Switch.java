package cn.edu.nju.gqx.db.po;

import java.sql.Timestamp;


public class Switch implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5773760490716691306L;
	public static final int OFF_STATE = 0;
	public static final int ON_STATE = 1;
	
	private Integer id;
	private Integer zid;
	private String name;
	private Integer state;
	private Integer tid;
	private Timestamp update_time;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getZid() {
		return zid;
	}
	public void setZid(Integer zid) {
		this.zid = zid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Timestamp getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Timestamp update_time) {
		this.update_time = update_time;
	}
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}

}
