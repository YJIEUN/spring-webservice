package com.practice.webservice.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice.webservice.PostsService;
import com.practice.webservice.dto.posts.PostsSaveRequestDto;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor		//모든 필드를 인자값으로 하는 생성자를 생성해줌
public class WebRestController {

	private PostsService postsService;
	
	/* '@AllArgsConstructor'이 이 역할을 대신해줌
	 public WebRestController(PostsRepository postsRepository) {
       this.postsRepository = postsRepository;
    }*/
	
	@GetMapping("/hello")
	public String hello() {
		return "HelloWorld";
	}
	
	@PostMapping("/posts")
	public Long savePosts(@RequestBody PostsSaveRequestDto dto) {
		return postsService.save(dto);
	}
}
