package org.hhs;

import org.hhs.config.Config;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

/**
 * Created by hewater on 2017/9/2.
 */
public class WebInitializer implements WebApplicationInitializer {
    public void onStartup(ServletContext servletContext) {
        AnnotationConfigWebApplicationContext acw = new AnnotationConfigWebApplicationContext();
        acw.register(Config.class);
        acw.setServletContext(servletContext);
        ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(acw));
        servlet.addMapping("/");
        servlet.setLoadOnStartup(1);
    }
}
