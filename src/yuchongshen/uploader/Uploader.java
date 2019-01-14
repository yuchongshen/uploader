/**
 * 
 */
package yuchongshen.uploader;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
/**
 * 功能:处理上传
 * @author yuchong.shen
 * 2019年1月10日
 * 
 */
@Path("/upload")
@Singleton
public class Uploader {
	@POST
	@Consumes({MediaType.MULTIPART_FORM_DATA})
	public String  uploadFile(@FormDataParam("file") InputStream fileInputStream,
			                  @FormDataParam("file") FormDataContentDisposition fileMetaData,
			                  @FormDataParam("path") String path,
			                  @FormDataParam("file_name") String fileName) throws Exception
	{
		String postfix = fileMetaData.getFileName().substring(fileMetaData.getFileName().lastIndexOf("."));
	    if(fileName==null){
	    	fileName = new String(fileMetaData.getFileName().getBytes("iso8859-1"),"utf-8");
	    }else{
	    	fileName = fileName+postfix;
	    }
	    if(path==null)    path = "";

	    try
	    {
	        int read = 0;
	        byte[] bytes = new byte[1024];
	 
	        OutputStream out = new FileOutputStream(new File(Config.UPLOAD_PATH+File.separatorChar +path+ File.separatorChar+fileName));
	        while ((read = fileInputStream.read(bytes)) != -1)
	        {
	            out.write(bytes, 0, read);
	        }
	        out.flush();
	        out.close();
	    } catch (IOException e)
	    {
	        throw new WebApplicationException();
	    }
	    return "uploaded successfully";
	}
}
