package cn.edu.nju.gqx.action;

import java.util.ArrayList;
import java.util.List;

import cn.edu.nju.gqx.bean.ZigbeeBean;
import cn.edu.nju.gqx.db.po.Switch;
import cn.edu.nju.gqx.provider.ZigbeeService;

public class ZigbeeAction {
	ZigbeeService service = (ZigbeeService)ContextFactory.getBean("zigbeeService");
	
	public List<?> getAll(){
		return service.getAll();
	}
	
	public List<?> getSwitchesByZigbeeType(int ztype){
		ArrayList<Switch> switchlist = new ArrayList<Switch>();
		ArrayList<ZigbeeBean> zigbeeBeanlist = (ArrayList<ZigbeeBean>) service.getZigbeesByType(ztype);
		
		if(zigbeeBeanlist != null){
			for(ZigbeeBean zigbeeBean : zigbeeBeanlist){
				ArrayList<Switch> slist = (ArrayList<Switch>) zigbeeBean.getSwitchList();
				if(slist != null){
					switchlist.addAll(slist);
				}
			}
		}
		
		return switchlist;
	}
	
}
