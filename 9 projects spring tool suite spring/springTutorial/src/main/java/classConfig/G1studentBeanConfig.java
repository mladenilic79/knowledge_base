package classConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// instead of xml configuration file
@Configuration
public class G1studentBeanConfig {

	// returns specified object just like <bean> or @Component
	// method name is bean id
	// @Bean(name="newName") override bean id
	@Bean
	public B1cheatMath eMathCheatBean() {
//		CheatScience cheatScience = new CheatScience();
//		return cheatScience;
		// or
		return new B1cheatMath();
	}

	// interface type variant
	@Bean
	public A1Cheat eCheatBean() {
		return new B2cheatScience();
	}
	
	// constructor variant
	@Bean
	public G3studentBeanClass student2bean() {
		
		G3studentBeanClass studentComponentDirect = 
				new G3studentBeanClass(5, "marko", eMathCheatBean(), eCheatBean());
		return studentComponentDirect;
	}
	
	// setter variant
	@Bean
	public G3studentBeanClass student3bean() {
		
		G3studentBeanClass studentComponentDirect = 
				new G3studentBeanClass();
		studentComponentDirect.setMathCheat(eMathCheatBean());
		studentComponentDirect.setCheat(eCheatBean());
		return studentComponentDirect;
	}

}
