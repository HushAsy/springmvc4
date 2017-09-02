package org.hhs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hewater on 2017/9/2.
 */
@Configuration
@ComponentScan(basePackages = "org.hhs")
@EnableWebMvc
public class Config {

    @Bean
    public UrlBasedViewResolver setViewResolver(){
        UrlBasedViewResolver urlBasedViewResolver = new UrlBasedViewResolver();
        urlBasedViewResolver.setPrefix("/WEB-INF/");
        urlBasedViewResolver.setSuffix(".jsp");
        urlBasedViewResolver.setViewClass(JstlView.class);
        return urlBasedViewResolver;
    }

    /**
     * json与对象之间的转换
     * @return
     */
    @Bean
    public MappingJackson2HttpMessageConverter getMappingJacksonJsonView(){
        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        return mappingJackson2HttpMessageConverter;
    }

    /**
     * json与string之间的转换
     * @return
     */
    @Bean
    public StringHttpMessageConverter getStringMessageConverter(){
        StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter();
        stringHttpMessageConverter.setDefaultCharset(StandardCharsets.UTF_8);
        return stringHttpMessageConverter;
    }

    /**
     * 将上面两个转换器设置到请求映射适配器中
     * @return
     */
    @Bean
    public RequestMappingHandlerAdapter getRequestMappingHandlerAdapter(){
        List<HttpMessageConverter<?>> list = new ArrayList<HttpMessageConverter<?>>();
        list.add(getMappingJacksonJsonView());
        list.add(getStringMessageConverter());
        RequestMappingHandlerAdapter requestMappingHandlerAdapter = new RequestMappingHandlerAdapter();
        requestMappingHandlerAdapter.setMessageConverters(list);
        return requestMappingHandlerAdapter;
    }
}
