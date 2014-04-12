package cn.edu.nju.gqx.action;
/**
 * 这个类目前没用
 */
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Consumer {

	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext.xml" });
		context.start();

//		DemoService demoService = (DemoService) context.getBean("demoService");
//		String hello = demoService.sayHello("tom");
//		System.out.println(hello);
//
//		SwitchOnAction action = new SwitchOnAction();
//		int result = action.switchOn(5);
//		System.out.println(result);
//		
//		SwitchOffAction action2 = new SwitchOffAction();
//		int result2 = action2.switchOff(5);
//		System.out.println(result2);
//		List list = demoService.getUsers();
//		if (list != null && list.size() > 0) {
//			for (int i = 0; i < list.size(); i++) {
//				System.out.println(list.get(i));
//			}
//		}
		System.in.read();
	}

}