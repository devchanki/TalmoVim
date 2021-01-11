package com.talmo.vim.follow;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


public interface FollowRepository {	
	
	//팔로워 수
	List<Integer> selectFollowerCnt(Map request);
	//팔로워 리스트
	List<Map> selectFollowerList(Map request);
	
	//팔로이 수
	List<Integer> selectFollweeCnt(Map request);
	//팔로이 리스트
	List<Map> selectFollweeList(Map request);
	
	//
	int insertFollower(Map request);
	
	//
	int deleteFollower(Map request);
	
	//
	int deleteFollowee(Map request);
}
