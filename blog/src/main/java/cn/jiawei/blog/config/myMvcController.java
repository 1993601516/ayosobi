package cn.jiawei.blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
@Configuration
@EnableWebMvc
public class myMvcController implements WebMvcConfigurer {
    @Autowired
    AdminInterceptor adminInterceptor;
    /*静态资源过滤*/
    private static final String [] CLASSPATH_RESOURCE_LOCATIONS={
            "classpath:/META-INF/resources","classpath:/resources/",
            "classpath:/static/","classpath:/public/"
    };
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        if(!registry.hasMappingForPattern("/webjars/**")){
            registry.addResourceHandler("/webjars/**")
                    .addResourceLocations("classpath:/META-INF/resources/webjars/");
        }
        if(!registry.hasMappingForPattern("/**")){
            registry.addResourceHandler("/**")
                    .addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
        }

    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(adminInterceptor)
                        .excludePathPatterns("/admin","/admin/login","/admin/blog");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/admin").setViewName("/admin/login");
    }
}
