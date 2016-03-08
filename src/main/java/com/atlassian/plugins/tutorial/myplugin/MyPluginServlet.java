package com.atlassian.plugins.tutorial.myplugin;

import com.atlassian.jira.bc.issue.IssueService;
import com.atlassian.jira.user.ApplicationUser;
import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;
import com.atlassian.sal.api.auth.LoginUriProvider;
import com.atlassian.sal.api.pluginsettings.PluginSettingsFactory;
import com.atlassian.sal.api.user.UserManager;
import com.atlassian.sal.api.user.UserProfile;
import com.atlassian.templaterenderer.TemplateRenderer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.text.MessageFormat;

@Named("myServlet")
public class MyPluginServlet extends HttpServlet{

    private static final Logger log = LoggerFactory.getLogger(MyPluginServlet.class);

    @ComponentImport
    private UserManager userManager;

    @ComponentImport
    private LoginUriProvider loginUriProvider;

    @ComponentImport
    private IssueService issueService;

    @ComponentImport("jiraUserManager")
    private com.atlassian.jira.user.util.UserManager jiraUserManager;

    @ComponentImport
    private TemplateRenderer templateRenderer;

    @ComponentImport
    private final PluginSettingsFactory pluginSettingsFactory;

    @Inject
    public MyPluginServlet(UserManager userManager,
                           LoginUriProvider loginUriProvider,
                           IssueService issueService,
                           com.atlassian.jira.user.util.UserManager jiraUserManager,
                           TemplateRenderer templateRenderer,
                           PluginSettingsFactory pluginSettingsFactory) {
        this.userManager = userManager;
        this.loginUriProvider = loginUriProvider;
        this.issueService = issueService;
        this.jiraUserManager = jiraUserManager;
        this.templateRenderer = templateRenderer;
        this.pluginSettingsFactory = pluginSettingsFactory;
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        UserProfile user = userManager.getRemoteUser();
        if (user == null || !userManager.isAdmin(user.getUserKey())) {
            redirectToLogin(request, response);
            return;
        }

//        response.setContentType("text/html");
//        response.getWriter().write(MessageFormat.format("<html><body>Hi {0}({1})! Looking good.</body></html>", user.getUsername(), user.getEmail()));
//        response.getWriter().write(MessageFormat.format("Hi {0}({1})! Looking good.", user.getUsername(), user.getEmail()));

        ApplicationUser appUser = getCurrentUser(request);

        //I assume that you have created project :"TEST_PROJ" and issue "TEST-1"
        IssueService.IssueResult issueResult = issueService.getIssue(appUser, "TEST-1");
        templateRenderer.render("admin.vm", response.getWriter());
    }

    private void redirectToLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect(loginUriProvider.getLoginUri(getUri(request)).toASCIIString());
    }

    private ApplicationUser getCurrentUser(HttpServletRequest req) {
        // To get the current user, we first get the username from the session.
        // Then we pass that over to the jiraUserManager in order to get an
        // actual User object.
        UserProfile remoteUser = userManager.getRemoteUser(req);
        ApplicationUser user = jiraUserManager.getUserByName(remoteUser.getUsername());
        return user;
    }

    private URI getUri(HttpServletRequest request) {
        StringBuffer builder = request.getRequestURL();
        if (request.getQueryString() != null) {
            builder.append("?");
            builder.append(request.getQueryString());
        }
        return URI.create(builder.toString());
    }


}