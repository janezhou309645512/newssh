package com.ls.nssh.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("session")
public class UploadAction extends BaseAction{
	
	
	
	   
	private File file;//文件
    private String fileFileName;//文件名称    
    private String fileContentType; //文件类型   
    private String filename;
    private InputStream inputStream;
	
	public String uploadFile() throws Exception{ 
		   
		//获取需要上传保存文件的文件路径  
        File uploadFile=new File("D:/uploadFile");  
        //判断文件是否上传，如果上传的话将会创建该目录  
        if(!uploadFile.exists()){  
            uploadFile.mkdir(); //创建该目录  
        }  
        FileInputStream input=null;  
        FileOutputStream out=null;
        //第一种文件上传的方法  
       
        try{
        	 //声明文件输入流，为输入流指定文件路径  
            input=new FileInputStream(file);  
           //获取输出流，获取文件的文件地址及名称  
            out=new FileOutputStream(uploadFile + "\\" +fileFileName);  
            byte[] b=new byte[1024];//每次写入的大小  
            int i=0;  
            while((i=input.read(b))>0){  
                out.write(b,0,i);  
            }  
        }catch(Exception e){  
            e.printStackTrace();  
        }finally{  
            input.close();  
            out.close();  
        }  
		
		return  "OK";
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

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}


	
	
	
	

}
