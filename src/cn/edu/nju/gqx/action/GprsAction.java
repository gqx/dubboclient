package cn.edu.nju.gqx.action;

import java.util.List;

import cn.edu.nju.gqx.bean.GprsBean;
import cn.edu.nju.gqx.provider.GprsService;

public class GprsAction {
	GprsService service = (GprsService)ContextFactory.getBean("gprsService");
	
	public List<GprsBean> getAllGprs(){
		return (List<GprsBean>) service.getAllGprs();
	}
}
