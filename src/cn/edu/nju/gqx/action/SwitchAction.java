package cn.edu.nju.gqx.action;

import java.util.ArrayList;
import java.util.List;

import cn.edu.nju.gqx.db.po.Switch;
import cn.edu.nju.gqx.provider.SwitchService;

public class SwitchAction {
	
	SwitchService service = (SwitchService)ContextFactory.getBean("switchService");
	
	public int switchOn(String name){		
		return service.switchOn(name);
	}
	
	public int switchOff(String name){		
		return service.switchOff(name);
	}
	
	public List<?> getAll(){
		return service.getAll();
	}

	public List<Switch> getSiwitchsByTid(int tid){
		return service.getSwitchByTid(tid);
	}
	
	public Switch getSwitchBySid(String sid){
		SwitchService service = (SwitchService)ContextFactory.getBean("switchService");
		Switch swc = service.getSwitchBySid(sid);
		if(swc == null){
			swc = new Switch();
			swc.setId(0);
			swc.setName("没有此开关");
			swc.setState(0);
		}
		return swc;
	}
	
	public Switch getSwitchByName(String name){
		SwitchService service = (SwitchService)ContextFactory.getBean("switchService");
		Switch swc = service.getSwitchByName(name);
		if(swc == null){
			swc = new Switch();
			swc.setId(0);
			swc.setName("没有此开关");
			swc.setState(0);
		}
		return swc;
	}
	
	public void switchesOn(ArrayList<String> nameList){
		SwitchService service = (SwitchService)ContextFactory.getBean("switchService");
		service.switchesOn(nameList);
	}
	
	public void switchesOff(ArrayList<String> nameList){
		SwitchService service = (SwitchService)ContextFactory.getBean("switchService");
		service.switchesOff(nameList);
	}
	
}
