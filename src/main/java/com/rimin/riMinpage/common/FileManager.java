package com.rimin.riMinpage.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.multipart.MultipartFile;

public class FileManager {
	
	// 파일을 저장할 위치 선언해주기
	public static final String FILE_UPLOAD_PATH = "D:\\rimin\\springProject\\upload\\riminPage";
		
	
	public static String saveFile(int userId, MultipartFile file) {
		// 저장된 파일을 접근하기 위한 url 경로 (문자열) 리턴
		
	
		String directoryName = "/" + userId + "_" + System.currentTimeMillis();
		
		// 폴더 생성 
		
				String directoryPath = FILE_UPLOAD_PATH + directoryName;
				File directory = new File(directoryPath);
				
				
				
				if(!directory.mkdir()) {
					//디렉터리 생성 실패
					return null;
				}
				
				// 파일 저장
				String filePath = directoryPath + "/" + file.getOriginalFilename();
				
				
				try {
					byte[] bytes = file.getBytes();
					Path path = Paths.get(filePath);
					Files.write(path, bytes);
				} catch (IOException e) {
					
					e.printStackTrace();
					// 파일 저장 실패
					return null;
				}
			
				
				// 클라이언트에서 접근 가능한 경로 - 데이터베이스에 저장
				// 클라이언트에서 접근 가능한 경로 리턴
				
				// 파일 경로 : D:\\rimin\\springProject\\memo\\upload/2_564855854354/test.png
				// url 경로 규칙 : /images/2_564855854354/test.png
				
				return "/images" + directoryName + "/" + file.getOriginalFilename();
				
				
			}
		
		
	}

	
	
