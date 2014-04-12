package cn.edu.nju.gqx.action;

import cn.edu.nju.gqx.db.po.Switch;
import cn.edu.nju.gqx.provider.SwitchService;

public class GetSwitchAction {
	public Switch getSwitchBySid(String sid){
		SwitchService service = (SwitchService)ContextFactory.getBean("switchService");
		Switch swc = service.getSwitchBySid(sid);
//		Switch swc = null;
		if(swc == null){
			swc = new Switch();
			swc.setId(0);
			swc.setName("没有此开关");
			swc.setState(0);
		}
		return swc;
	}
}
