package com.rimin.riMinpage.post.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.rimin.riMinpage.comment.dto.CommentDetail;
import com.rimin.riMinpage.comment.service.CommentService;
import com.rimin.riMinpage.common.FileManager;
import com.rimin.riMinpage.like.service.LikeService;
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
	
	@Autowired
	private CommentService commentService;
	
	// 좋아요 개수 세기 위한 기능 불러오기
	@Autowired
	private LikeService likeService;
	
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
	public List<PostDetail> getPostList(int loginUserId){
		List<Post> postList = postRepository.findAllByOrderByIdDesc();
			
		List<PostDetail> postDetailList = new ArrayList<>(); 
			
		//조회된 결과를 그대로 리턴하는게 아니라 필요한 정보를 처리하고 나서 return
		
		//post정보랑 로그인 사용자 정보를 담은 객체를 생성
		for(Post post:postList) {
			//포스트에서 사용할 user와 관련된 기능이 있다면 userService 로 
			int userId = post.getUserId();
			
			User user = userService.getUserById(userId);
			
			// 좋아요 개수 조회 
			// like 테이블에 있는 postId = post 테이블의 id(pk)
			int likeCount = likeService.getLikeCount(post.getId());
			// 로그인한 사용자가 좋아요 했는지 여부 조회
			// > like 입장에서는 특정 사용자가 특정 게시물에 좋아요를 눌렀는지 알려주는 기능
			// 로그인한 사용자를 얻어와서 인자로 넣어줘야함 > loginUserId
			// 누가 : 로그인한 사용자의 userId가 전달되어야 하므로
			// 서비스가 직접 얻어낼 수 없으니까
			// 컨트롤러에서 얻어낼 수 있도록 파라미터 추가
			boolean isLike = likeService.isLike(loginUserId, post.getId());
			
			//댓글 목록 조회
			// commentService & commentRepository
			List<CommentDetail> commentList = commentService.getCommentList(post.getId());
			
			PostDetail postDetail =  PostDetail.builder()//builder:멤버변수에 값을 채움
										.postId(post.getId())
										.userId(userId)
										.userLoginId(user.getLoginId())
										.contents(post.getContents())
										.imagePath(post.getImagePath())
										.likeCount(likeCount)
										.commentList(commentList)
										.isLike(isLike)// 로그인한 사용자가 눌렀는지 안 눌렀는지
										.build();
			// postdetail안에 들어있던 객체가 postDetailList안에 저장됨
			postDetailList.add(postDetail);
		}
		// 게시글 하나를 위한 postdetailList완성됨
		return postDetailList;
	}
	
	// 게시글 삭제 
	public Post deletePost(int id) {
		// 대상이 되는 게시글 정보 얻어오고
		// 확인 후 그 정보 삭제해주기
		// 게시글의 id 만 가져오면 되므로
		
		Optional<Post> optionalPost = postRepository.findById(id);
		Post post = optionalPost.orElse(null); // null인 경우 예외처리 해주기

		
		if(post != null) {
			
			// 좋아요와 댓글 삭제 > 좋아요와 댓글 service 에서 그 기능 만들기
			// 특정한 게시물과 연관된 좋아요와 댓글 정보 > postId 
			
			// 게시글 좋아요 데이터 삭제
			likeService.deleteLikeByPostId(id); // 안에 id 가 삭제 대상의 id 이기 때문에 그냥 쓰면 됨
			
			// 게시글 댓글 데이터 삭제
			commentService.deleteCommentByPostId(id); // 안에 id 가 삭제 대상의 id 이기 때문에 그냥 쓰면 됨
			
			
			// 연결된 이미지도 삭제해줘야함
			FileManager.removeFile(post.getImagePath());
			
			postRepository.delete(post);// 게시물 삭제
		}
		return post;
	}

	
}
