package cn.edu.nju.gqx.provider;

import java.util.ArrayList;

import cn.edu.nju.gqx.db.po.Switch;
import cn.edu.nju.gqx.db.po.Turngroup;
import cn.edu.nju.gqx.db.po.Turntask;

public interface TurnService {
	
	public void createTurngroupByConfig();
	public void createTurntaskByConfig(int daysBeforeStart);
	public ArrayList<Turntask> getTurntaskBySysname(String sysname);
	public ArrayList<Turngroup> getTurngroupByGrpid(int grpid);
	public ArrayList<Turntask> getRunnableTurntaskBySysname(String sysname);
	public ArrayList<String> getSysname();
	public void startAutoTaskBySysname(boolean isRestart, String sysname);
	public void stopAutoTaskBySysname(String sysname,boolean stopSwitches);
	public ArrayList<Switch> getRunningTaskSwitchesBySysname(String sysname);
	public ArrayList<Switch> getOnSwitchesBySysname(String sysname);
	public long getOnSwitchNumBySysname(String sysname);
	public String getTurntaskNameBySwitchName(String switchName);
}
