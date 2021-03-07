package com.talmo.vim.group.web;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.JsonElement;
import com.talmo.vim.common.ResponseDto;
import com.talmo.vim.common.ResponseStatus;
import com.talmo.vim.group.Group;
import com.talmo.vim.group.GroupRepository;
import com.talmo.vim.group.dto.GroupDto;
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

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

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
	@Transactional
	public void newGroup() throws Exception {
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

			ResponseDto response = gson.fromJson(mvcRst.getResponse().getContentAsString(), ResponseDto.class);

			assertThat(response.getStatus()).isEqualTo(ResponseStatus.SUCCESS);
			assertThat(response.getMessage()).isNotNull();

			GroupDto.Response dto = gson.fromJson(gson.toJsonTree(response.getData()) , GroupDto.Response.class);
			Long teamId = dto.getGroupId();

			assertThat(teamId).isNotEqualTo(-1L);
			Group group = repo.findById(teamId).orElseThrow(EntityNotFoundException::new);

			assertThat(group.getName()).isEqualTo(name);
			assertThat(group.getName()).isEqualTo(dto.getGroupName());

			assertThat(group.getDesc()).isEqualTo(desc);
			assertThat(group.getDesc()).isEqualTo(dto.getGroupDesc());

			repo.delete(group);
	}

}
