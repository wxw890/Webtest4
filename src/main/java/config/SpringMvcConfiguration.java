package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import controller.UploadController;
//즉, dispatcher.xml대신사용
//dispatcher.xml 설정 파일을 대신해서 사용한다 생각하면 된다.
@Configuration   //이 annotation은 spring 설정파일을 대신해서 클래스에서 설정을 사용할 수 있게 해준다.
public class SpringMvcConfiguration {
	@Bean
	public UploadController uploadController(){
		return new UploadController();
		/*
		 * <bean id=""uploadController" class="/../UploadController"/>과 같은 뜻이다.
		 */
	}
	
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	@Bean
	public CommonsMultipartResolver multipartResolver(){
		return new CommonsMultipartResolver();
		/*
		 * <bean id="multipartResolver" class="/.../CommonsMultipartResolver" />과 같은 뜻이다. 또한 여기서 id는 반드시 multipartResolver로 해야한다.
		 */
	}

}
