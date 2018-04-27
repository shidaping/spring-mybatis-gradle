package com.sdp;

import java.util.HashSet;
import java.util.Set;
import org.eclipse.jetty.annotations.AnnotationConfiguration;
import org.eclipse.jetty.annotations.ClassInheritanceHandler;

import org.eclipse.jetty.server.Server;

import org.eclipse.jetty.webapp.Configuration;
import org.eclipse.jetty.webapp.WebAppContext;
import org.springframework.web.WebApplicationInitializer;



import com.sdp.config.ServletInitializer;

public class AppBack {
	public static void main(String[] args) {
		Server server = new Server(8080);
		WebAppContext webAppContext = new WebAppContext();
		webAppContext.setResourceBase("src/main/webapp");
		webAppContext.setContextPath("/");
		webAppContext.setConfigurations(new Configuration[] { new AnnotationConfiguration() {
			@Override
	        public void preConfigure(WebAppContext context) throws Exception {				
				ClassInheritanceMap map = new ClassInheritanceMap();
				Set<String> set = new HashSet<String>();
				set.add(ServletInitializer.class.getName());
                map.put(WebApplicationInitializer.class.getName(), set);
                context.setAttribute(CLASS_INHERITANCE_MAP, map);
                _classInheritanceHandler = new ClassInheritanceHandler(map);
	        }
		} });
		webAppContext.setParentLoaderPriority(true);
		server.setHandler(webAppContext);
		try {
			server.start();
			server.dumpStdErr();
			server.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

