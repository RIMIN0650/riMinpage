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
		
		// 첨부파일이 없는 경우 아래 코드가 실행되지 않도록 null을 return

		
		
	
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
		
	
		// 파일 삭제 기능
		// 컴퓨터 안에 저장된 경로를 만들어내기 
		public static boolean removeFile(String filePath) {
			// 파일이 없음 > 삭제할 대상이 없음 > return null
			
			if(filePath == null) {
				return false;
			}
			
			// 삭제 대상 파일 경로
			// 컴퓨터 파일 경로
			
			String fullFilePath = FILE_UPLOAD_PATH + filePath.replace("/images", "");
			
			// 경로를 관리하는 자바 객체가 있음
			// 경로 관리하는 자바 객체 하나 만들기
			Path path = Paths.get(fullFilePath); 
			
			// 파일 삭제시 확인 > 파일 존재하는지
			// 파일이 존재하는지 확인하기
			if(Files.exists(path)) {
				// 있다면 삭제해주기
				try {
					Files.delete(path);
				} catch (IOException e) {
					e.printStackTrace();
					return false; // 파일 삭제 과정에서 문제가 있었다는 것을 알려줌
				}
			}
			
			// 디렉토리 삭제
			Path dirPath = path.getParent(); // 상위폴더
			
			if(Files.exists(dirPath)) {
				try {
					Files.delete(dirPath);
				} catch (IOException e) {
					e.printStackTrace();
					return false;
				}
			}
			
			return true; // 성공적으로 삭제 된 경우

		}
	
	}

	
	
