package com.pratik;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws LifecycleException
    {
        System.out.println( "Hello World!" );
        Tomcat tomcat=new Tomcat();
        tomcat.setPort(5678);
        
        
        //addContext(String:docpath,,String:docbase)
        Context context=tomcat.addContext("", null);
        //addServlet(context, "Servlet name", Servlet onject)
        Tomcat.addServlet(context, "HelloServlet", new HelloServlet());
        context.addServletMappingDecoded("/hello","HelloServlet");
        

        tomcat.start();
        tomcat.getServer().await();
    
    }
}
