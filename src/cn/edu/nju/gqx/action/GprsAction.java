package cn.edu.nju.gqx.action;

import java.util.ArrayList;
import java.util.List;

import cn.edu.nju.gqx.bean.GprsBean;
import cn.edu.nju.gqx.db.po.Gprs;
import cn.edu.nju.gqx.db.po.Historydata;
import cn.edu.nju.gqx.provider.GprsService;

public class GprsAction {
	GprsService service = (GprsService)ContextFactory.getBean("gprsService");
	
	public boolean addNewGprsName(String name){
		return service.addNewGprsName(name);
	}
	
	public List<GprsBean> getAllGprsBeans(){
		return (List<GprsBean>) service.getAllGprsBeans();
	}
	
	public List<Gprs> getAllGprs(){
		return (List<Gprs>) service.getAllGprs();
	}
	
	public List<Historydata> getHistoryDataByGid(int gid){
		return (List<Historydata>) service.getDataByGid(gid);
	}
	
	public List<Historydata> getTodayHistoryDataByGid(int gid){
		return (List<Historydata>) service.getTodayDataByGid(gid);
	}
	
	public List<GprsBean> getGprsBeans(ArrayList<String> names){
		ArrayList<GprsBean> gbeans = new ArrayList<GprsBean>();
		for(String name:names){
			GprsBean gbean = service.getGprsBean(name);
			if(gbean != null)
				gbeans.add(gbean);
		}
		return gbeans;
	}
}
