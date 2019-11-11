package xmlConfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ZMainXML {
	
	public static void main(String[] args) {
		
		// container object
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("beans.xml");
		// check if config is loaded
		System.out.println("configuration beans loaded");

		// setter & constructor injection

		// create object with injection (class/interface left, class with
		// dependency injection right)
		D1studentXMLclass studentXMLsetter = context.getBean("D1studentXMLclassSetterBean", D1studentXMLclass.class);
		studentXMLsetter.cheating();
		// instead you can typecast it
		// Airtel air = (Airtel)context.getBean("airtel");
		
		D2studentXMLinterface studentXMLconstructor = context.getBean("D2studentXMLinterfaceConstructorBean", D2studentXMLinterface.class);
		studentXMLconstructor.cheating();
		
		// autowiring
		
		D2studentXMLinterface studentXMLAutowiringByName = 
				context.getBean("studentXMLannotationAutowiringByNameBean", D2studentXMLinterface.class);
		studentXMLAutowiringByName.cheating();
		
		D1studentXMLclass studentXMLAutowiringByType = 
				context.getBean("studentXMLannotationAutowiringByTypeBean", D1studentXMLclass.class);
		studentXMLAutowiringByType.cheating();
		
		D2studentXMLinterface studentXMLAutowiringConstructor = 
				context.getBean("studentXMLannotationAutowiringConstructorBean", D2studentXMLinterface.class);
		studentXMLAutowiringConstructor.cheating();
		
		// autowiring with java annotations

		D3studentXMLAnnotation studentXMLAnnotation = 
				context.getBean("D3studentXMLAnnotationBean", D3studentXMLAnnotation.class);
		studentXMLAnnotation.cheating();
		
		D4studentXMLAnnotationDirect studentXMLAnnotationDirect = 
				context.getBean("D4studentXMLAnnotationDirectBean", D4studentXMLAnnotationDirect.class);
		studentXMLAnnotationDirect.cheating();
		
		// xml properties
		
		D5studentXMLproperties studentXMLproperties = 
				context.getBean("D5studentXMLpropertiesBean", D5studentXMLproperties.class);
		studentXMLproperties.cheating();
		
		D6studentXMLpropertiesAnnotations studentXMLpropertiesAnnotations = 
				context.getBean("D6studentXMLpropertiesAnnotationsBean", D6studentXMLpropertiesAnnotations.class);
		studentXMLpropertiesAnnotations.cheating();
		
	}

}
