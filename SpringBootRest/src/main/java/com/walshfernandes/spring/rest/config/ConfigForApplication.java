package com.walshfernandes.spring.rest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.walshfernandes.spring.rest.service.GreetingService;

/*
 * Basic spring object initialization and mangement setup
 * Steps
 * 1. Define class and annotate with @Configuration
 * 2. Create methods in this class that return required beans and annotate with @Bean
 * 3. In the caller class, initialize the context as follows
 * AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
 * 4. Now register the bean class in the context
 * ctx.register(ConfigForApplication.class);
 * 5. To access any bean, you can do the following
 * ctx.getBean(GreetingService.class); 
 *  OR
 *  annotate instance variables of constructor arguments with
 *  @Autowired
 *  eg. 
 *  @Autowired
 *  private GreetingService greetingService;
 * 
 * Key catches: 
 * 1. It is necessary to annotate the methods with @Bean.
 * 2. By default the beans are considered singleton, if you need to change this 
 * behaviour use @Scope with it 
 * eg. add this annotation to make it non-singleton
 * @Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
 * 3. if you dont want to write these methods to return the beans, you can annotate
 * the class using @Component
 * 4. Even if dont add @Configuration, the code works exactly the same, when we manually 
 * register the config class in the context. @Configuration is needed in the cases where
 * Spring creates the context, eg. SpringApplication.run(Main.class)
 * 5. @ComponentScan is required when you want to initialize objects of @Component annotated
 * classes, when Spring is not initializing the context.
 * */
@Configuration
@ComponentScan(basePackages = {"com.walshfernandes"})
public class ConfigForApplication {
	
	@Bean
	public GreetingService greetingService() {
		return new GreetingService();
	}
}
