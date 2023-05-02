package com.spring.datajpa.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

public class ImageDao {
	
	@Autowired
	ImageRespository imageRespository;
	
	public void insertImage() throws IOException {
		
		Image image=new Image();
		image.setName("img.JPG");
				
		File file=new File("path");
		byte[] data=new byte[(int) file.length()];
		
		FileInputStream fileIinputStream= new FileInputStream(file);
		fileIinputStream.read(data);		
		image.setData(data);
		imageRespository.save(image);
		fileIinputStream.close();
		
	}
public void readImage() throws IOException {
	
	  Image image=imageRespository.findById(1).get();
	  File file=new File("path"+image.getName());
	  FileOutputStream fos= new FileOutputStream(file);
	  fos.write(image.getData());
	  fos.close();
	  
	  
	}

}
