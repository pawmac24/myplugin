package com.pm.mycompany.tutorial.jira.webwork;

import com.atlassian.jira.web.action.JiraWebActionSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SecondWebworkAction extends JiraWebActionSupport
{
    private static final Logger log = LoggerFactory.getLogger(SecondWebworkAction.class);

    @Override
    public String execute() throws Exception {
        log.debug("=== (1) Entering execute ===");
        return super.execute(); //returns SUCCESS
    }

    @Override
    protected void doValidation() {
        log.debug("=== (2) Entering doValidation ===");
    }

    @Override
    protected String doExecute() throws Exception {
        log.debug("=== (3) Entering doExecute ===");

        String myfirstparameter = getHttpRequest().getParameter("myfirstparameter");
        this.myfirstparameter = myfirstparameter;
        log.debug("=== parameter myfirstparameter = {}", myfirstparameter);
        return SUCCESS;
    }

    @Override
    public String doDefault() throws Exception {
        log.debug("=== Entering doDefault ===");
        return super.doDefault();
    }

    public String doMycommand() throws Exception {
        log.debug("=== (2) Entering doMycommand ===");
        return SUCCESS;
    }

    private String myfirstparameter;

    public String getMyfirstparameter() {
        log.debug("=== Getting myfirstparameter === ");
        return myfirstparameter;
    }
}
