package com.ls.nssh.action;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.ls.nssh.util.CodeUtil;
/**
 * 用于下载的
 * @author jane.zhou1
 *
 */

@Controller
@Scope("session")
public class DownLoadAction extends BaseAction{
	    private String downPath;        // 下载时的文件名
	    private String contentType;     // 保存文件类型
	    private String filename;        // 保存时的文件名
		public String getDownPath() {
			return downPath;
		}
		
		public String getContentType() {
			return contentType;
		}
		public void setContentType(String contentType) {
			this.contentType = contentType;
		}
		public String getFilename() {
			return filename;
		}
		public void setFilename(String filename) {
			this.filename = filename;
		}
		
		
		 public void setDownPath(String downPath) {
		        try {
		            // 解决下载时候的中文文件乱码问题
		            downPath = new String(downPath.getBytes("ISO-8859-1"),"UTF-8");
		        }catch (UnsupportedEncodingException e){
		            e.printStackTrace();
		        }
		        this.downPath = downPath;
		    }
		   /*
		    *下载用的Action返回一个InputString实例，该方法对应Action配置
		    *里面的result的inputName参数，值为inputString
		    *
		    */

		   public InputStream getInputString(){
		       return ServletActionContext.getServletContext().getResourceAsStream(downPath);
		   }
		public String downloadFile(){
			  // 下载保存时的文件名和被下载的文件名一样
		       filename = downPath;
		       // 下载的文件路径，请在webapps目录下创建images
		       downPath = "images/" + downPath;
		       // 保存文件的类型

		       contentType = "application/x-msdownload";

		       /*
		        *对下载的文件名按照UTF-8进行编码，解决下载窗口中的中文乱码问题
		        * 其中,MyUtil是自己定义的一个类
		        */

		       filename = CodeUtil.toUTF8String(filename);
		       
		       return SUCCESS;
			
			
		}
		   
		   
	
	

}
