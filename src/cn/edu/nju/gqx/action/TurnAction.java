package cn.edu.nju.gqx.action;

import java.util.ArrayList;

import cn.edu.nju.gqx.db.po.Switch;
import cn.edu.nju.gqx.db.po.Turngroup;
import cn.edu.nju.gqx.db.po.Turntask;
import cn.edu.nju.gqx.provider.TurnService;

public class TurnAction {
	TurnService service = (TurnService)ContextFactory.getBean("turnService");
	
	public void initTurnTask(){
		service.createTurngroupByConfig();
		service.createTurntaskByConfig();
	}
	
	public String[] getSysnames(){
		ArrayList<String> list = service.getSysname();
		list.add(0, "ȫ������");
		String[] namelist= new String[list.size()];
		for(int i = 0;i < list.size();i++){
			namelist[i] = list.get(i);
		}
		return namelist;
	}
	
	public ArrayList<Turntask> getTurntaskBySysname(String sysname){
		return service.getTurntaskBySysname(sysname);
	}
	
	public ArrayList<Turntask> getRunnableTurntaskBySysname(String sysname){
		return service.getRunnableTurntaskBySysname(sysname);
	}
	
	public ArrayList<Turngroup> getTurngroupByGrpid(int grpid){
		return service.getTurngroupByGrpid(grpid);
	}
	
	public void restartTaskBySysname(String sysname){
		service.stopAutoTaskBySysname(sysname);
		service.createTurngroupByConfig();
		service.createTurntaskByConfig();
		service.startAutoTaskBySysname(true,sysname);
	}
	
	public void resumeTaskBySysname(String sysname){
		service.startAutoTaskBySysname(false,sysname);
	}
	
	public void stopTaskBySysname(String sysname){
		service.stopAutoTaskBySysname(sysname);
	}
	
	public String[][] getSystemState(){
		ArrayList<String> sysnames = service.getSysname();
		if(sysnames != null && sysnames.size() != 0){
			String[][] result = new String[sysnames.size()][2];
			for(int i = 0; i < sysnames.size();i++){
				String sysname = sysnames.get(i);
				ArrayList<Switch> list1 = service.getRunningTaskSwitchesBySysname(sysname);
				long onSwitchNumBySysname = service.getOnSwitchNumBySysname(sysname);
				result[i][0] = sysname+": "+"  Ӧ����������: "+list1.size()+
						"   ʵ����������: "+onSwitchNumBySysname+getPressureBySysname(sysname);
				if(Math.abs(list1.size()-onSwitchNumBySysname) < 3){
					result[i][1] = "ok";
				}else{
					result[i][1] = "nok";
				}
			}
			return result;
		}else{
			return null;
		}
	}
	
	public String[][] getSystemStateBySysname(String sysname){
		String[][] result = new String[1][2];
		ArrayList<Switch> list1 = service.getRunningTaskSwitchesBySysname(sysname);
		long onSwitchNumBySysname = service.getOnSwitchNumBySysname(sysname);
		String blank ="                          ";
		result[0][0] = blank+sysname+": "+"  Ӧ����������: "+list1.size()+
				"   ʵ����������: "+onSwitchNumBySysname+getPressureBySysname(sysname);
		if(Math.abs(list1.size()-onSwitchNumBySysname) < 3){
			result[0][1] = "ok";
		}else{
			result[0][1] = "nok";
		}
		return result;
	}
	
	private String getPressureBySysname(String sysname){
		PressureAction action = new PressureAction();
		int pressure = action.getLastPressureBySysname(sysname);
		if(pressure >= 0){
			return "   ˮ��ѹ��: "+pressure;
		}else{
			return "   ˮ��ѹ��: ����ֵ";
		}
	}
}
