package edu.qs.spring_data_jpa_demo.file_handling;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.web.multipart.MultipartFile;

public class FileUtility {

	static String path = "C:\\Users\\Neha\\OneDrive\\Desktop\\Advance java\\SpringBoot\\spring_data_jpa_demo\\src\\main\\resources\\static\\images";
	
	public static boolean fileUploadInFolder(MultipartFile file) {
		byte[] img = null;
		
		try {
			InputStream is = file.getInputStream();
			
			img = new byte[is.available()]; // whether the file is availableor not
			is.read(img);
			is.close();
			 
			FileOutputStream fos = new FileOutputStream(path + File.separator + file.getOriginalFilename()); //File.separator for the \\ slaces
			fos.write(img);
			fos.flush();
			fos.close();
			
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
}
