/**
 * 
 */
package yuchongshen.uploader;
import org.glassfish.jersey.servlet.ServletContainer;
import javax.ws.rs.Path;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.servlets.CrossOriginFilter;
/**
 * @author vellhe@tencent.com
 * @date 2017/7/7
 * @description 提供REST接口
 */
@Path("/")
public class RestInterface {
	private void start(int port) throws Exception {
		
		
		ServletHolder servletHolder = new ServletHolder(ServletContainer.class);
		servletHolder.setInitParameter("jersey.config.server.provider.packages","com.gbd");
		servletHolder.setInitParameter("jersey.config.server.provider.classnames","org.glassfish.jersey.media.multipart.MultiPartFeature");
		
 		ServletContextHandler servletContextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
 		servletContextHandler.addServlet(servletHolder, "/*");
		
		FilterHolder filterHolder = new FilterHolder(CrossOriginFilter.class);
		filterHolder.setInitParameter("allowedOrigins", "*");
		filterHolder.setInitParameter("allowedMethods", "GET, POST");
		servletContextHandler.addFilter(filterHolder, "/*", null);
		
		Server server = new Server(Config.PORT);
		server.setHandler(servletContextHandler);
		server.start();
		
		System.out.println("******************************************************************");
		System.out.println("server has startup,port:"+Config.PORT);
		System.out.println("server has startup,upload path:"+Config.UPLOAD_PATH);
		System.out.println("******************************************************************");


	}
 
	public void stop() throws Exception {
	}
 
	public static void main(String[] args) throws Exception {
		int portIndex=0,uploadPathIndex=0;
		for(int i=0;i<args.length;i++){
			if(args[i].equals("-uploadpath")) uploadPathIndex=i+1;
			if(args[i].equals("-port"))       portIndex=i+1;
		}
		if(uploadPathIndex>0) Config.UPLOAD_PATH = args[uploadPathIndex];
		if(portIndex>0)       Config.PORT        = Integer.parseInt(args[portIndex]);

		RestInterface server = new RestInterface();
		server.start(Config.PORT);
	}
}

