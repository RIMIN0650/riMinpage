package com.rimin.riMinpage.post.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.rimin.riMinpage.common.FileManager;
import com.rimin.riMinpage.post.domain.Post;
import com.rimin.riMinpage.post.dto.PostDetail;
import com.rimin.riMinpage.post.repository.PostRepository;
import com.rimin.riMinpage.user.domain.User;
import com.rimin.riMinpage.user.service.UserService;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private UserService userService;
	
	
	
	public Post addPost(int userId, String contents, MultipartFile file) {
		// 로그인 성공시 id 멤버변수가 세션에 저장됨
		
		String filePath = FileManager.saveFile(userId, file);
		
		
		// 전달된 값을 저장할 엔티티 클래스
		Post post = Post.builder()
						.userId(userId)
						// 멤버변수 이름 , 저장할 값
						.contents(contents)
						.imagePath(filePath)
						.build();
		
		return postRepository.save(post);
	}
	
	//타임라인은 최신이 위로 올라와야함 등록 내림차순으로 조회된 결과 돌려주는 기능
	public List<PostDetail> getPostList(){
		List<Post> postList = postRepository.findAllByOrderByIdDesc();
			
		List<PostDetail> postDetailList = new ArrayList<>(); 
			
		//조회된 결과를 그대로 리턴하는게 아니라 필요한 정보를 처리하고 나서 return
		
		//post정보랑 로그인 사용자 정보를 담은 객체를 생성
		for(Post post:postList) {
			//포스트에서 사용할 user와 관련된 기능이 있다면 userService 로 
			int userId = post.getUserId();
			User user = userService.getUserById(userId);
			
			
			PostDetail postDetail =  PostDetail.builder()//builder:멤버변수에 값을 채움
										.postId(post.getId())
										.userId(userId)
										.userLoginId(user.getLoginId())
										.contents(post.getContents())
										.imagePath(post.getImagePath())
										.build();
			// postdetail안에 들어있던 객체가 postDetailList안에 저장됨
			postDetailList.add(postDetail);
		}
		// 게시글 하나를 위한 postdetailList완성됨
		return postDetailList;
	}
}
