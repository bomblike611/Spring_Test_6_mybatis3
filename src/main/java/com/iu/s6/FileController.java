package com.iu.s6;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class FileController {
	
	
	@RequestMapping(value="/fileUpload", method=RequestMethod.POST)
	public void fileTest2(MultipartFile[] f1,HttpSession session) throws Exception{
		//Service class로 session, file들을 넘겨줌
		String filepath=session.getServletContext().getRealPath("resources/upload");
		File file=new File(filepath);

		if(!file.exists()){
			file.mkdirs();
		}
		FileSaver fileSaver=new FileSaver();
		
		for(MultipartFile f:f1){
			String s=fileSaver.saver1(f, filepath);
			System.out.println(s);
		}
	}
	
	
	@RequestMapping(value="/fileUpload4", method=RequestMethod.POST)
	public void fileTest2(MultipartHttpServletRequest request) throws Exception{
		List<MultipartFile> ar=request.getFiles("f1");
		for(MultipartFile f:ar){
			System.out.println(f.getOriginalFilename());
		}
	}
	
	
	@RequestMapping(value="/fileUpload1", method=RequestMethod.POST)
	public void fileTest(FileDTO fileDTO) throws Exception{
		System.out.println(fileDTO.getF1().getOriginalFilename());
		System.out.println(fileDTO.getF2().getOriginalFilename());
	}
	@RequestMapping(value="/fileUpload2", method=RequestMethod.POST)
	public void fileTest(MultipartFile f1,MultipartFile f2) throws Exception{
		System.out.println(f1.getName());
		System.out.println(f1.getOriginalFilename());
		System.out.println(f2.getName());
		System.out.println(f2.getOriginalFilename());
	}
	
	@RequestMapping(value="/fileUpload3", method=RequestMethod.POST)
	public void fileTest(MultipartHttpServletRequest request) throws Exception{
		request.getSession().getServletContext().getRealPath("");
		Iterator<String> it=request.getFileNames();
		while(it.hasNext()){
			MultipartFile f=request.getFile(it.next());
		}
		
	}
	
}
