package edu.qs.spring_data_jpa_demo.file_handling;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.http.HttpHeaders;
import java.util.Optional;

import org.apache.tomcat.util.http.parser.HttpHeaderParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileController {
	
	
	@Autowired
	FileRepository fRepo;

	@PostMapping("/file")
	public ResponseEntity<String> filedata(@RequestParam MultipartFile file){
		
		String name = file.getOriginalFilename();
		Long size = file.getSize();
		String content = file.getContentType();
		
		String data = name + ", "+ size + ", "+ content;
		
		return new ResponseEntity<String>(data, HttpStatus.OK);
	}
	
	
	// upload in the src/main/resources/static/images
	@PostMapping("/file_folder")
	public ResponseEntity<String> fileUploadInFolder(@RequestParam MultipartFile file){
		if(FileUtility.fileUploadInFolder(file)) {
			return new ResponseEntity<String>("file uploaded", HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("file failed to uploaded", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	// upload in database
	@PostMapping("/file_db")
	public ResponseEntity<String> fileUploadInDb(@RequestParam MultipartFile file) {
		try {
			
			Files f1 = new Files(file.getOriginalFilename(), file.getSize(), file.getContentType(), file.getBytes());
			Files newFile = fRepo.save(f1);
			if(newFile.getId() != null) {
				return new ResponseEntity<String>("file uploaded", HttpStatus.OK);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ResponseEntity<String>("file failed to uploaded", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	// just to see the data or file
	@GetMapping("/image/show/{id}")
	public ResponseEntity<byte[]> displayImageById(@PathVariable int id){
		
		
		Optional<Files> opt = fRepo.findById(id);
		
		if(opt.isPresent()) {
			
			Files f = opt.get();
			
			org.springframework.http.HttpHeaders hh = new org.springframework.http.HttpHeaders();
			
			hh.setContentType(MediaType.parseMediaType(f.getContentType()));
			hh.set("Content-disposition", "inline");
			
			return new ResponseEntity<byte[]>(f.getData(),hh, HttpStatus.OK);
		}
		return new ResponseEntity<byte[]>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	//to download the data or file
	@GetMapping("/image/download/{id}")
	public ResponseEntity<byte[]> downloadImageById(@PathVariable int id){
		
		
		Optional<Files> opt = fRepo.findById(id);
		
		if(opt.isPresent()) {
			
			Files f = opt.get();
			
			org.springframework.http.HttpHeaders hh = new org.springframework.http.HttpHeaders();
			
			hh.setContentType(MediaType.parseMediaType(f.getContentType()));
			hh.setContentDisposition(ContentDisposition.attachment().filename("abcd.png").build());
			
			return new ResponseEntity<byte[]>(f.getData(),hh, HttpStatus.OK);
		}
		return new ResponseEntity<byte[]>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
