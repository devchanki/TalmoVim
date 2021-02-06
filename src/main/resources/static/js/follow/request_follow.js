/* 
* follow 요청에 대한 함수들 모아둠 
* var BASE_URL 필요!
*/

/*팔로우 팔로이 단일 대상 확인*/
function requestChkFollow(user_id, opponent_id){
	var followResponseData=null;
	var requestMap={
		user_id : user_id,
		type : 'one',
		opponent_id : opponent_id
	};
	$.ajax({
		url: BASE_URL+'/follow/one',
		headers: {
                'X-CSRF-TOKEN': $('meta[name="csrf-token"]').attr('content')
            },
		type:'POST',
		dataType:'JSON',
		data: JSON.stringify(requestMap),
		contentType:'application/json',
		cache:false,
		async:false,
		success:function(data){
			if(data.status=='success'){
				var followResponseData=data;
			}
		}
	});
	return followResponseData;
}

/*팔로우 카운트 초기화*/
function requestInitMyFollow(user_id){
	var followResponseData=null;
	var requestMap={
		user_id:user_id
	};
	$.ajax({
		url: BASE_URL+'/follow/my',
		headers: {
                'X-CSRF-TOKEN': $('meta[name="csrf-token"]').attr('content')
            },
		type:'POST',
		dataType:'JSON',
		data: JSON.stringify(requestMap),
		contentType:'application/json',
		cache:false,
		async:false,
		success:function(data){
			if(data.status=='success'){
				var followResponseData=data;
			}
		}
	});
	return followResponseData;
}

/*팔로워 리스트 초기화 (모두 가져오기)*/
function requestInitMyFollowerList(user_id){
	var followResponseData=null;
	var requestMap={
		user_id : user_id,
		type : 'default'
	};
	$.ajax({
		url: BASE_URL+'/follow/follower',
		headers: {
                'X-CSRF-TOKEN': $('meta[name="csrf-token"]').attr('content')
            },
		type:'POST',
		dataType:'JSON',
		data: JSON.stringify(requestMap),
		contentType:'application/json',
		cache:false,
		async:false,
		success:function(data){
			if(data.status=='success'){
				var followResponseData=data;
			}
		}
	});
	return followResponseData;
}

/*팔로워 리스트 초기화 (요청 갯수 정해주는 것)*/
function requestInitMyFollowerList(user_id, row_cnt){
	requestMoreMyFollowerList(user_id, row_cnt, 1);
}

/*팔로워 리스트 추가 요청 */
function requestMoreMyFollowerList(user_id, row_cnt, from_row){
	var followResponseData=null;
	var requestMap={
		user_id : user_id,
		type : 'list',
		row_cnt : row_cnt,
		from_row : from_row
	};
	$.ajax({
		url: BASE_URL+'/follow/follower',
		headers: {
                'X-CSRF-TOKEN': $('meta[name="csrf-token"]').attr('content')
            },
		type:'POST',
		dataType:'JSON',
		data: JSON.stringify(requestMap),
		contentType:'application/json',
		cache:false,
		async:false,
		success:function(data){
			if(data.status=='success'){
				var followResponseData=data;
			}
		}
	});
	return followResponseData;
}

/*팔로이 리스트 초기화 (모두 가져오기)*/
function requestInitMyFolloweeList(user_id){
	var followResponseData=null;
	var requestMap={
		user_id : user_id,
		type : 'default'
	};
	$.ajax({
		url: BASE_URL+'/follow/followee',
		headers: {
                'X-CSRF-TOKEN': $('meta[name="csrf-token"]').attr('content')
            },
		type:'POST',
		dataType:'JSON',
		data: JSON.stringify(requestMap),
		contentType:'application/json',
		cache:false,
		async:false,
		success:function(data){
			if(data.status=='success'){
				var followResponseData=data;
			}
		}
	});
	return followResponseData;
}

/*팔로이 리스트 초기화 (요청 갯수 정해주는 것)*/
function requestInitMyFolloweeList(user_id, row_cnt){
	requestMoreMyFolloweeList(user_id, row_cnt, 1);
}

/*팔로이 리스트 추가 요청 */
function requestMoreMyFolloweeList(user_id, row_cnt, from_row){
	var followResponseData=null;
	var requestMap={
		user_id : user_id,
		type : 'list',
		row_cnt : row_cnt,
		from_row : from_row
	};
	$.ajax({
		url: BASE_URL+'/follow/followee',
		headers: {
                'X-CSRF-TOKEN': $('meta[name="csrf-token"]').attr('content')
            },
		type:'POST',
		dataType:'JSON',
		data: JSON.stringify(requestMap),
		contentType:'application/json',
		cache:false,
		async:false,
		success:function(data){
			if(data.status=='success'){
				var followResponseData=data;
			}
		}
	});
	return followResponseData;
}

/*팔로워 제거*/
function deleteFollower(user_id, opponent_id){
	var followResponseData=null;
	var requestMap={
		user_id : user_id,
		opponent_id : opponent_id
	};
	$.ajax({
		url: BASE_URL+'/follow/follower',
		headers: {
                'X-CSRF-TOKEN': $('meta[name="csrf-token"]').attr('content')
            },
		type:'DELETE',
		dataType:'JSON',
		data: JSON.stringify(requestMap),
		contentType:'application/json',
		cache:false,
		async:false,
		success:function(data){
			if(data.status=='success'){
				var followResponseData=data;
			}
		}
	});
	return followResponseData;
}

/*팔로이 제거*/
function deleteFollowee(user_id, opponent_id){
	var followResponseData=null;
	var requestMap={
		user_id : user_id,
		opponent_id : opponent_id
	};
	$.ajax({
		url: BASE_URL+'/follow/followee',
		headers: {
                'X-CSRF-TOKEN': $('meta[name="csrf-token"]').attr('content')
            },
		type:'DELETE',
		dataType:'JSON',
		data: JSON.stringify(requestMap),
		contentType:'application/json',
		cache:false,
		async:false,
		success:function(data){
			if(data.status=='success'){
				var followResponseData=data;
			}
		}
	});
	return followResponseData;
}

/*팔로우 하기(팔로이 추가) */
function addFollowee(user_id, opponent_id){
	var followResponseData=null;
	var requestMap={
		user_id : user_id,
		opponent_id : opponent_id
	};
	$.ajax({
		url: BASE_URL+'/follow/followee',
		headers: {
                'X-CSRF-TOKEN': $('meta[name="csrf-token"]').attr('content')
            },
		type:'PUT',
		dataType:'JSON',
		data: JSON.stringify(requestMap),
		contentType:'application/json',
		cache:false,
		async:false,
		success:function(data){
			if(data.status=='success'){
				var followResponseData=data;
			}
		}
	});
	return followResponseData;
}