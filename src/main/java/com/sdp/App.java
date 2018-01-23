package com.sdp;

//import java.io.IOException;
//import java.net.URL;
//import java.security.ProtectionDomain;
//import java.util.HashSet;
//import java.util.Set;
//import java.util.concurrent.ConcurrentHashMap;
//
//import org.eclipse.jetty.annotations.AnnotationConfiguration;
//import org.eclipse.jetty.annotations.ClassInheritanceHandler;
//import org.eclipse.jetty.server.Connector;
//import org.eclipse.jetty.server.Server;
////import org.eclipse.jetty.server.ServerConnector;
//import org.eclipse.jetty.servlet.ServletContextHandler;
//import org.eclipse.jetty.servlet.ServletHolder;
//import org.eclipse.jetty.util.ConcurrentHashSet;
//import org.eclipse.jetty.util.MultiMap;
//import org.eclipse.jetty.webapp.Configuration;
//import org.eclipse.jetty.webapp.WebAppContext;
//import org.springframework.web.WebApplicationInitializer;
//import org.springframework.web.context.ContextLoaderListener;
//import org.springframework.web.context.WebApplicationContext;
//import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
//import org.springframework.web.servlet.DispatcherServlet;
//
//
//import com.sdp.config.ServletInitializer;

public class App {
	public static void main(String[] args) {
		// Server server = new Server();

		// Connector connector = new ServerConnector(server);
		// connector.
		// connector.setPort(8888);
		// connector.setHost("127.0.0.1");
		// server.addConnector(connector);

		// server.setStopAtShutdown(true);
		// WebAppContext context = new WebAppContext();
		// context.setServer(server);
		// context.setContextPath("/");
		//
		// ProtectionDomain protectionDomain =
		// DataImporterMain.class.getProtectionDomain();
		// URL location = protectionDomain.getCodeSource().getLocation();
		// context.setWar(location.toExternalForm());
		// System.out.println("WAR URL: ${location.toExternalForm()}")
		// server.addHandler(context);
		//
		// try {
		// server.start();
		// System.in.read();
		// server.stop();
		// server.join();
		// } catch (Exception e) {
		// e.printStackTrace();
		// System.exit(100);
		// }
		
		/*
		
		Server server = new Server(8080);
		WebAppContext webAppContext = new WebAppContext();
		webAppContext.setResourceBase("src/main/webapp");
		webAppContext.setContextPath("/");
		webAppContext.setConfigurations(new Configuration[] { new AnnotationConfiguration() {
			@Override
	        public void preConfigure(WebAppContext context) throws Exception {
//	            MultiMap<String> map = new MultiMap<String>();
//	            map.add(WebApplicationInitializer.class.getName(), ServletInitializer.class.getName());
//	            context.setAttribute(CLASS_INHERITANCE_MAP, map);
//	            _classInheritanceHandler = new ClassInheritanceHandler(map);
				
//	            final ClassInheritanceMap map = new ClassInheritanceMap();
//                final ConcurrentHashSet<String> set = new ConcurrentHashSet<>();
//                set.add(ServletInitializer.class.getName());
//                map.put(WebApplicationInitializer.class.getName(), set);
//                context.setAttribute(CLASS_INHERITANCE_MAP, map);
//                _classInheritanceHandler = new ClassInheritanceHandler(map);
				
//	            ConcurrentHashMap<String, ConcurrentHashSet<String>> map = new ConcurrentHashMap<String, ConcurrentHashSet<String>>();
//	            ConcurrentHashSet<String> set = new ConcurrentHashSet<String>();
//	           
//	            set.add(ServletInitializer.class.getName());
//	            map.put(WebApplicationInitializer.class.getName(), set);
//	            
//	            context.setAttribute(CLASS_INHERITANCE_MAP, map);
//	            _classInheritanceHandler = new ClassInheritanceHandler(map);
				
//				ClassInheritanceMap map = new ClassInheritanceMap();
//				ConcurrentHashSet<String> set = new ConcurrentHashSet<String>();
//				set.add(ServletInitializer.class.getName());
//                map.put(WebApplicationInitializer.class.getName(), set);
//                context.setAttribute(CLASS_INHERITANCE_MAP, map);
//                _classInheritanceHandler = new ClassInheritanceHandler(map);
				
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
		*/
	}

	// private ServletContextHandler getServletContextHandler(WebApplicationContext
	// context) throws IOException {
	// ServletContextHandler contextHandler = new ServletContextHandler();
	// contextHandler.setErrorHandler(null);
	// contextHandler.setContextPath("/");
	// contextHandler.addServlet(new ServletHolder(new DispatcherServlet(context)),
	// MAPPING_URL);
	// contextHandler.addEventListener(new ContextLoaderListener(context));
	//// contextHandler.setResourceBase(new
	// ClassPathResource("webapp").getURI().toString());
	// return contextHandler;
	// }
	//
	// private WebApplicationContext getContext() {
	// AnnotationConfigWebApplicationContext context = new
	// AnnotationConfigWebApplicationContext();
	//// context.setConfigLocation(CONFIG_LOCATION);
	//// context.getEnvironment().setDefaultProfiles(DEFAULT_PROFILE);
	// return context;
	// }
}

