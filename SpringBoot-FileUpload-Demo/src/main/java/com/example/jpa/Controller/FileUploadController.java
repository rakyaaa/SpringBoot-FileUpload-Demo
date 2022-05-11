package com.example.jpa.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.jpa.Helper.FileUploadHelper;

@RestController
public class FileUploadController {
	
	@Autowired
	FileUploadHelper fileUploadHelper;

	@PostMapping("/fileDetails")
	public ResponseEntity<String> fileDetails(@RequestParam("file") MultipartFile file ){
		String name = file.getOriginalFilename();
		long size = file.getSize();
		String type = file.getContentType();
		return ResponseEntity.ok("FileName is : " + name + "\nFile Size is : " + size + "\nFile Type is : "+type);
	}
	
	@PostMapping("/uploadFile")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file ){
		
		try {
			
			boolean f = fileUploadHelper.uploadFile(file);
			//String name = file.getOriginalFilename();
			if(f) {
				//return ResponseEntity.ok("FileName is : " + name + " is uploaded Successfully");
				return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/images/").path(file.getOriginalFilename()).toUriString());
			}else {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
		}
	}
}
