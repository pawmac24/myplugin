package com.atlassian.plugins.tutorial.myplugin.jira.webwork;

import com.atlassian.jira.web.action.JiraWebActionSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//@Component
public class MyWebworkAction extends JiraWebActionSupport
{
    private static final Logger log = LoggerFactory.getLogger(MyWebworkAction.class);

//    @ComponentImport
//    private ApplicationProperties applicationProperties;

//    @Autowired
//    public MyWebworkAction(ApplicationProperties applicationProperties) {
//        this.applicationProperties = applicationProperties;
//    }

    @Override
    public String execute() throws Exception {
        log.debug("=== Entering execute ===");
        return super.execute(); //returns SUCCESS
    }
    protected void doValidation() {
        log.debug("=== Entering doValidation ===");
    }

    protected String doExecute() throws Exception {
        log.debug("=== Entering doExecute ===");
        return SUCCESS;
    }

    public String doDefault() throws Exception {
        log.debug("=== Entering doDefault ===");
        return super.doDefault();
    }
}
