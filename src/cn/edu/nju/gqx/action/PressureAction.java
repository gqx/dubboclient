package cn.edu.nju.gqx.action;

import java.util.ArrayList;

import cn.edu.nju.gqx.db.po.Pressure;
import cn.edu.nju.gqx.db.po.Switch;
import cn.edu.nju.gqx.provider.PressureService;
import cn.edu.nju.gqx.provider.SwitchService;

public class PressureAction {
	PressureService service = (PressureService)ContextFactory.getBean("pressureService");
	SwitchService switchservice = (SwitchService)ContextFactory.getBean("switchService");
	
	public ArrayList<Pressure> getPressureBySid(int sid){
		return (ArrayList<Pressure>) service.getPressureBySid(sid, 200);
	}
	
	public int getLastPressureBySysname(String sysname){
		Switch s = switchservice.getSwitchByName(sysname+"_press");
		if(s != null){
			ArrayList<Pressure> p = (ArrayList<Pressure>) service.getPressureBySid(s.getId(), 1);
			if(p != null && p.size() != 0){
				return p.get(0).getPvalue();
			}
		}
		return -1;
	}
	
	
	public String getPressureInfoStr(){
		int pvalue = (int) (Math.random()*10);
		if(pvalue > 6){
			return "压力过高"+"  压力值:"+pvalue;
		}
		else if(pvalue < 5){
			return "压力过低"+"  压力值:"+pvalue;
		}
		else{
			return null;
		}
	}
}
