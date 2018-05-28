package com.ls.nssh.common;

import java.io.File;


/**
 * 存放上传文件相关的类
 */
public class FileAttr {
	
	
	  private File file;  
	  //文件名称  
	  private String fileFileName;  
	      
	  //文件类型  
	  private String fileContentType;  
	  //注意：文件名称和文件类型的名称前缀必须相同，  

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
