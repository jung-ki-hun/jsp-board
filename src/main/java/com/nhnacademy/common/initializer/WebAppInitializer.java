package com.nhnacademy.common.initializer;

import java.util.Set;
import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;

@HandlesTypes({
    javax.servlet.http.HttpServlet.class,
    javax.servlet.Filter.class,
    javax.servlet.ServletContextListener.class,
    javax.servlet.http.HttpSessionListener.class,
})
public class WebAppInitializer implements ServletContainerInitializer  {
    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext)
        throws ServletException {
//        servletContext.setInitParameter("orion", "2");
//        servletContext.setInitParameter("egg", "5");
//        servletContext.setInitParameter("pa", "10");
//        servletContext.setInitParameter("apple", "20");
    }
}
/*
<context-param>
        <param-name>orion</param-name>
        <param-value>2</param-value>
    </context-param>
    <context-param>
        <param-name>egg</param-name>
        <param-value>5</param-value>
    </context-param>
    <context-param>
        <param-name>pa</param-name>
        <param-value>10</param-value>
    </context-param>
    <context-param>
        <param-name>apple</param-name>
        <param-value>20</param-value>
    </context-param>
* */