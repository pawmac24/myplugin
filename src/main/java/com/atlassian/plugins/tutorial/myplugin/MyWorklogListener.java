package com.atlassian.plugins.tutorial.myplugin;

import com.atlassian.event.api.EventListener;
import com.atlassian.event.api.EventPublisher;
import com.atlassian.jira.event.worklog.WorklogEvent;
import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by pmackiewicz on 2016-02-26.
 */
@Component
public class MyWorklogListener implements InitializingBean, DisposableBean {

    private static final Logger logger = LoggerFactory.getLogger(MyWorklogListener.class);

    @ComponentImport
    private EventPublisher eventPublisher;


    @Autowired
    public MyWorklogListener(EventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    public void destroy() throws Exception {
        eventPublisher.unregister(this);
    }

    public void afterPropertiesSet() throws Exception {
        eventPublisher.register(this);
    }

    @EventListener
    public void onWorlogEvent(WorklogEvent event) {
        logger.info("Worlog event called");
    }
}
