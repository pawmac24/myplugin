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
        log.debug("=== (1) Entering execute ===");
        return super.execute(); //returns SUCCESS
    }
    protected void doValidation() {
        log.debug("=== (2) Entering doValidation ===");
    }

    protected String doExecute() throws Exception {
        log.debug("=== (3) Entering doExecute ===");
        return SUCCESS;
    }

    public String doDefault() throws Exception {
        log.debug("=== Entering doDefault ===");
        return super.doDefault();
    }

    private String myfirstparameter = "a default value";

    public void setMyfirstparameter(String value) {
        log.debug("=== Setting aStringVariable to: " + value + "====");
        this.myfirstparameter = value;
    }

    public String getMyfirstparameter() {
        log.debug("=== Getting aStringVariable === ");
        return myfirstparameter;
    }

}
