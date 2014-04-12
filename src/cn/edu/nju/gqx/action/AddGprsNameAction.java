package cn.edu.nju.gqx.action;

import cn.edu.nju.gqx.provider.GprsService;

public class AddGprsNameAction {	

	public boolean addNewGprsName(String name){
		GprsService service = (GprsService)ContextFactory.getBean("gprsService");
		return service.addNewGprsName(name);
	}
	
}
