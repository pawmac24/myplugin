package com.atlassian.plugins.tutorial.myplugin;

/**
 * Created by pmackiewicz on 2016-02-23.
 */
public class MyHelloWorldService implements HelloWorldService{
    public String sayHello() {
        return "Hello from plugin";
    }
}
