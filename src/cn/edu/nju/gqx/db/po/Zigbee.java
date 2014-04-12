package cn.edu.nju.gqx.db.po;

import java.sql.Timestamp;

public class Zigbee implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7193983493385027889L;
	
	private Integer id;
	private String name;
	private Integer gid;
	private String mac;
	private Timestamp update_time;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getGid() {
		return gid;
	}
	public void setGid(Integer gid) {
		this.gid = gid;
	}
	public String getMac() {
		return mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}
	public Timestamp getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Timestamp update_time) {
		this.update_time = update_time;
	}
	
	

}
