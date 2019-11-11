package classConfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ZMainComponentBean {
	
	public static void main(String[] args) {

		// component
		ApplicationContext context1 = 
				new AnnotationConfigApplicationContext(F1studentComponentConfig.class);
		
		F2studentComponentClass studentComponentAnnotation = 
				context1.getBean("studentComponentAnnotation", F2studentComponentClass.class);
		studentComponentAnnotation.cheating();
		
		((AnnotationConfigApplicationContext)context1).close();
		
		// bean
		ApplicationContext context2 = 
				new AnnotationConfigApplicationContext(G1studentBeanConfig.class);
		
		G3studentBeanClass studentBeanConstructor = 
				context2.getBean("student2bean", G3studentBeanClass.class);
		studentBeanConstructor.cheating();

		G3studentBeanClass studentBeanSetter = 
				context2.getBean("student3bean", G3studentBeanClass.class);
		studentBeanSetter.cheating();
		
		((AnnotationConfigApplicationContext)context2).close();

	}

}
