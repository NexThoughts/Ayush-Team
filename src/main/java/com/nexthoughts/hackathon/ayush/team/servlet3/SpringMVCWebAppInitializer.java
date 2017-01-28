package com.nexthoughts.hackathon.ayush.team.servlet3;


import com.nexthoughts.hackathon.ayush.team.config.HibernateConfig;
import com.nexthoughts.hackathon.ayush.team.config.SpringRootConfig;
import com.nexthoughts.hackathon.ayush.team.config.SpringSecurityConfig;
import com.nexthoughts.hackathon.ayush.team.config.SpringWebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


public class SpringMVCWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringRootConfig.class, HibernateConfig.class, SpringSecurityConfig.class,};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringWebConfig.class};
    }
}
