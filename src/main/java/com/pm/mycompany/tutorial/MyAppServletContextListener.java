package com.pm.mycompany.tutorial;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Enumeration;

/**
 * Created by pmackiewicz on 2016-03-09.
 */
public class MyAppServletContextListener implements ServletContextListener {

    private static final Logger logger = LoggerFactory.getLogger(MyAppServletContextListener.class);

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        logger.debug("== contextInitialized ==");
        logger.debug(servletContextEvent.getServletContext().getServletContextName());
        Enumeration<String> attributeNames = servletContextEvent.getServletContext().getAttributeNames();
        while(attributeNames.hasMoreElements()) {
            logger.debug(attributeNames.nextElement());
        }
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        logger.debug("== contextDestroyed ==");
    }
}
