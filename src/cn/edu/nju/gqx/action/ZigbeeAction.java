package cn.edu.nju.gqx.action;

import java.util.List;
import cn.edu.nju.gqx.provider.ZigbeeService;

public class ZigbeeAction {
	ZigbeeService service = (ZigbeeService)ContextFactory.getBean("zigbeeService");
	
	public List<?> getAll(){
		return service.getAll();
	}
}
