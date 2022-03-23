package edu.polytech;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

public class MainAff {

    public static void main(String[] args) {

    }

    private static Object getRemote() throws NamingException {
        Properties jndiProperties = new Properties();
        jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        jndiProperties.put(Context.PROVIDER_URL, "remote+http://localhost:8080");//

        Context ctx = new InitialContext(jndiProperties);

        String appName = "ArchiSI_TP";
        String projectName = "ArchiSI_TP_EJB-1.0-SNAPSHOT";
        String className = "";
        String remote = Object.class.getName();

        String url = "ejb:" + appName + "/" + projectName + "/" + className + "!" + remote;//


        Object remoteEJB = (Object) ctx.lookup(url);

        return remoteEJB;
    }
}
