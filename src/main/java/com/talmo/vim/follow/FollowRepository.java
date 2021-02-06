package com.talmo.vim.follow;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Repository
@Mapper
public interface FollowRepository {
	
	//팔로워 수
	List<Integer> selectFollowerCnt(Map request);
	
	//팔로워 리스트
	List<Map> selectFollowerList(Map request);
	
	//팔로이 수
	List<Integer> selectFolloweeCnt(Map request);
	
	//팔로이 리스트
	List<Map> selectFolloweeList(Map request);
	
	//
	int insertFollowee(Map request);
	
	//
	int deleteFollower(Map request);
	
	//
	int deleteFollowee(Map request);

}
