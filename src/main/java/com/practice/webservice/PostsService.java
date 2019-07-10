package com.practice.webservice;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practice.webservice.domain.posts.PostsRepository;
import com.practice.webservice.dto.posts.PostsSaveRequestDto;
import com.practice.webservice.dto.PostsMainResponseDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PostsService {
	
    private PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto dto){
        return postsRepository.save(dto.toEntity()).getId();
    }
    
    @Transactional(readOnly = true)
    public List<PostsMainResponseDto> findAllDesc() {
        return postsRepository.findAllDesc()
                .map(PostsMainResponseDto::new)
                .collect(Collectors.toList());
    }
    //repository 결과로 넘어온 Posts의 Stream을 map을 통해
    //PostsMainResponseDto로 변환 -> List로 반환하는 메소드
}
