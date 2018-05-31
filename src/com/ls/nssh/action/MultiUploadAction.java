package com.ls.nssh.action;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * 多文件上传的示例
 * @author jane.zhou1
 *
 */
@Controller
@Scope("session")
public class MultiUploadAction extends BaseAction{
	
	
	    private List<File> upload;
	    private List<String> uploadContentType;
	    private List<String> uploadFileName;
	    private String message;

	    public List<File> getUpload() {
	        return upload;
	    }

	    public void setUpload(List<File> upload) {
	        this.upload = upload;
	    }

	    public List<String> getUploadContentType() {
	        return uploadContentType;
	    }

	    public void setUploadContentType(List<String> uploadContentType) {
	        this.uploadContentType = uploadContentType;
	    }

	    public List<String> getUploadFileName() {
	        return uploadFileName;
	    }

	    public void setUploadFileName(List<String> uploadFileName) {
	        this.uploadFileName = uploadFileName;
	    }

	    
	    public String multiUploadFile(){
	    	try{
	    		   //文件保存路径
	         
	        File file = new File("D:/webfile/MultiUploadFile");
	        //不存在则创建
	        if(!file.exists()){
	            file.mkdir();
	        }
	        
	        //循环将文件上传到指定路径
	        for(int i = 0; i< upload.size(); i++){
	            FileUtils.copyFile(upload.get(i), new File(file,uploadFileName.get(i)));
	        }
	        
	        
	        message="OK";
	    	}catch (Exception e) {
	    		
			message="NO";	
			}
	        return "jsonData";
	    }

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}
	
	
	

}
