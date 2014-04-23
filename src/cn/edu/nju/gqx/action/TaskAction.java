package cn.edu.nju.gqx.action;

import java.util.List;

import cn.edu.nju.gqx.db.po.Task;
import cn.edu.nju.gqx.provider.TaskService;

public class TaskAction {
	TaskService service = (TaskService)ContextFactory.getBean("taskService");
	
	public void setClock(String[] names,String tname, String onTime,String offTime){
		service.setClock(names,tname, onTime, offTime);
	}
	
	public List getAllTasks(){
		return service.getAll();
	}
	
	public Task getTaskById(int id){
		return service.getTaskById(id);
	}
	
	public void modifyTask(int tid,String onTime,String offTime){
		service.updateTask(tid, onTime, offTime);
	}
	
	public void deleteTask(int tid){
		service.deleteTaskById(tid);
	}
}
