package classConfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

// instead of xml configuration file
@Configuration
// instead of xml context component scan
@ComponentScan(basePackages="classConfig")
// instead of xml context propertie file
@PropertySource("classpath:properties.properties")
public class F1studentComponentConfig {

	
	
}
