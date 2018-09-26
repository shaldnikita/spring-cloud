package ru.shaldnikita.library.configuration.security;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*@EnableWebMvc
@Configuration*/
public class WebConfig implements WebMvcConfigurer {

    /*@Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        registry.addViewController("/")
                .setViewName("forward:/index");

        registry.addViewController("/index");
        registry.addViewController("/secure");

    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/resources/");
    }

    @Bean
    public RequestContextListener requestContextListener() {
        return new RequestContextListener();
    }


    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }*/
}
