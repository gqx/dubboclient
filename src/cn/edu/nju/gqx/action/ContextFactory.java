package cn.edu.nju.gqx.action;

import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * Î¬»¤SpringµÄContext
 * @author gqx
 *
 */
public class ContextFactory {
	
	private final static String contextString = "applicationContext.xml";
	private static ClassPathXmlApplicationContext context;
	
	public static ClassPathXmlApplicationContext getContext(){
		if(context == null){
			context = new ClassPathXmlApplicationContext(contextString);
		}
		context.start();
		return context;
	}
	
	public static Object getBean(String bean){
		if(context == null){
			getContext();
		}
		return context.getBean(bean);
	}
	
	public static void CloseContext(){
		context.stop();
		context.close();
	}
}
