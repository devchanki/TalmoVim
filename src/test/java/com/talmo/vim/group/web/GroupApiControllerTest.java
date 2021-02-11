package com.talmo.vim.group.web;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;
import java.util.Map;

import com.talmo.vim.common.ResponseStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.google.gson.Gson;
import com.talmo.vim.group.GroupRepository;
import com.talmo.vim.group.util.GroupVO;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GroupApiControllerTest {

	@LocalServerPort
	int port;
		
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	private MockMvc mvc;
	
	@Autowired
	private GroupRepository repo;
	
	@BeforeEach
	public void setUp() {
		mvc = MockMvcBuilders
				.webAppContextSetup(webApplicationContext)
				.build();
	}
	
	@Test
	public void post_new() throws Exception {
		String name = "testTeamName";
		String desc = "this is testTeam dese";
		Map<String, Object> postMap = new HashMap<>();
		postMap.put("name", name);
		postMap.put("desc", desc);
		
		String url = "http://localhost:" + port + "/group/api/new";
		
		//when
		MvcResult mvcRst = mvc.perform( 
				post(url)
				.contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(postMap))
				)
		.andExpect(status().isOk())
		.andReturn();
		
		Gson gson = new Gson();
		
		Map<String, Object> rstMap = (Map<String, Object>) gson.fromJson(mvcRst.getResponse().getContentAsString(), Map.class);
		
		assertThat(rstMap.get("status")).isEqualTo(ResponseStatus.NOT_IMPLEMENTED.toString());
		assertThat(rstMap.get("message")).isNotNull();
		
		Map<String, Object> data = (Map<String, Object>) rstMap.get("data");
		long teamId = (long) data.get("team_id");
		
		assertThat(teamId).isNotEqualTo(-1L);
		GroupVO vo = repo.selectGroup(teamId);
		
		assertThat(vo.getGroupName()).isEqualTo(name);
		assertThat(vo.getGroupDesc()).isEqualTo(desc);
		
		repo.deleteGroup(teamId);
	}

}
