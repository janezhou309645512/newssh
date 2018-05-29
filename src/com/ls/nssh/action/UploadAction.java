package com.ls.nssh.action;

import java.io.File;

import org.apache.commons.io.FileUtils;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("session")
public class UploadAction extends BaseAction{
	
	
	
	   
	private File file;//文件
    private String fileFileName;//文件名称    
    private String fileContentType; //文件类型   
   
   
    private  String message;
	
	public String uploadFile(){ 
		try{  
		//获取需要上传保存文件的文件路径  
        File uploadFile=new File("D:/uploadFile");  
        //判断文件是否上传，如果上传的话将会创建该目录  
        if(!uploadFile.exists()){  
            uploadFile.mkdir(); //创建该目录  
        }  
        // 实现文件上传，也就是做了一个方法调用～
        FileUtils.copyFile(file,new File(uploadFile,fileFileName));
          message="OK";
        	
        }catch (Exception e) {
        	message="NO";
		}
        
        
       
		return  "jsonData";
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	

	

	
	
	
	

}
