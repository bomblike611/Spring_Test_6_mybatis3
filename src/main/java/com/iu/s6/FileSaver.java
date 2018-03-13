package com.iu.s6;

import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

public class FileSaver {
	
	
	//3. transfer
		public String save3(MultipartFile f, String filePath)throws Exception{
			String fileName=f.getOriginalFilename();
			//iu_1.jpg
			fileName=fileName.substring(fileName.lastIndexOf("."));
			fileName=UUID.randomUUID().toString()+fileName;
			
			File file = new File(filePath, fileName);
			
			f.transferTo(file);
			
			return fileName;
			
		}
		
		//2.FileCopyUtils
		public String save2(MultipartFile f, String filePath)throws Exception{
			String fileName=f.getOriginalFilename();
			//iu_1.jpg
			fileName=fileName.substring(fileName.lastIndexOf("."));
			fileName=UUID.randomUUID().toString()+fileName;
			
			File file = new File(filePath, fileName);
			
			FileCopyUtils.copy(f.getBytes(), file);
			
			return fileName;
		}
	
	//1. outputStream
	
	public String saver1(MultipartFile f,String filepath) throws Exception{
		String fileName=f.getOriginalFilename();
		fileName=fileName.substring(fileName.lastIndexOf("."));//.확장자만 추출
		fileName=UUID.randomUUID().toString()+fileName;//랜덤한 이름 + .확장자
		byte [] fileDate =f.getBytes();
		File file=new File(filepath, fileName);
		FileOutputStream fo=new FileOutputStream(file);
		fo.write(fileDate);
		
		fo.close();
		return fileName;
	}
	
	
}
