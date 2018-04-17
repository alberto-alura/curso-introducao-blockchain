package br.com.ideiasaleatorias.eleicaoonline.infra;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextHolder implements ApplicationContextAware{
     
    private static ApplicationContext instance;
 
    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        ApplicationContextHolder.instance = applicationContext;
    }
 
    public static ApplicationContext getInstance(){
        return instance;
    }
 
 
}