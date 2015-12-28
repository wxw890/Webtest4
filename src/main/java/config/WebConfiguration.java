package config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import myservlet.ServletTest;
//즉, web.xml대신사용
//web.xml에 servlet을 대신해서 사용할수 있는 클래스를 만들거다
//WebApplicationInitializer란 인터페이스는 servlet과 spring관련 설정을 해줄수 있는 인터페이스이다.
public class WebConfiguration implements WebApplicationInitializer {
	//오버라이딩 됨, onStartup란 프로그램이 실행되면 제일 번저 실행되는 변수를 뜻함
	public void onStartup(ServletContext arg0) throws ServletException {
		System.out.println("WebConfiguration 실행됨");
		
		//이렇게 자바코드를 이용하면 web.xml파일이 필요없게 된다.
		ServletTest st = new ServletTest();//servletTest라는 인스턴스 생성
		ServletRegistration.Dynamic servletTest = arg0.addServlet("servletTest", st);// 하나의 서블릿을 등록
		/* web.xml에서 이부분을 java코드로 만든 것이다.
		 *   <servlet>
  			<servlet-name>servletTest</servlet-name>           //servletTest이란 서블릿 인터페이스를 생성해준다는 뜻
  			<servlet-class>myservlet.ServletTest</servlet-class>
  			</servlet>
		 */
		
		servletTest.addMapping("*.test");
		/*
		 *   <servlet-mapping>
  			<servlet-name>servletTest</servlet-name>
  			<url-pattern>*.test</url-pattern>
  			</servlet-mapping>
		 * 
		 */
		
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext(); //Annotation설정??
		ctx.register(SpringMvcConfiguration.class);
		
		DispatcherServlet ds = new DispatcherServlet(ctx);//
		ServletRegistration.Dynamic dispatcher = arg0.addServlet("dispatcher", ds);
		dispatcher.addMapping("*.spring");
	}

}
