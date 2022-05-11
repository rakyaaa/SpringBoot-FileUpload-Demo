package com.example.jpa.Helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

	//public final String UPLOAD_DIR = "C:\\Users\\rakchoud\\Downloads\\SpringBoot-JPA-DB-Default-CURD-Operations-master\\src\\main\\resources\\static\\images";
	public final String UPLOAD_DIR = new ClassPathResource("static/images").getFile().getAbsolutePath();
	
	public FileUploadHelper() throws IOException {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public boolean uploadFile(MultipartFile file) {
		boolean f=false;
		try {
			
//			//read the file
//			InputStream is = file.getInputStream();
//			byte data[] = new byte[is.available()];
//			is.read(data);
//			//write the file
//			FileOutputStream fos = new FileOutputStream(UPLOAD_DIR+File.separator+file.getOriginalFilename());
//			fos.write(data);
//			fos.close();
//			is.close();
//			f=true;
//			return f;
			
			Files.copy(file.getInputStream(), Paths.get(UPLOAD_DIR+File.separator+file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
			f=true;
			return f;
		} catch (Exception e) {
			return false;
		}
		
	}

}
