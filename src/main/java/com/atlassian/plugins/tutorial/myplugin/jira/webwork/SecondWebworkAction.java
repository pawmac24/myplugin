package com.atlassian.plugins.tutorial.myplugin.jira.webwork;

import com.atlassian.jira.web.action.JiraWebActionSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Enumeration;

//@Component
public class SecondWebworkAction extends JiraWebActionSupport
{
    private static final Logger log = LoggerFactory.getLogger(SecondWebworkAction.class);

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

//        Enumeration<String> parameterNames = getHttpRequest().getParameterNames();
//        while (parameterNames.hasMoreElements()){
//            log.debug("=== parameter = {}" ,parameterNames.nextElement());
//        }

        String myfirstparameter = getHttpRequest().getParameter("myfirstparameter");
        log.debug("=== parameter myfirstparameter = {}", myfirstparameter);
        return SUCCESS;
    }

    public String doDefault() throws Exception {
        log.debug("=== Entering doDefault ===");
        return super.doDefault();
    }

    public String doMycommand() throws Exception {
        log.debug("=== Entering doMycommand ===");
        return SUCCESS;
    }
}