package cn.edu.nju.gqx.action;

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
	
}
