package com.talmo.vim.example.util;

import org.json.JSONException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import lombok.Getter;
import lombok.Setter;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;

@SpringBootTest
public class GsonTest {
	private Product product;

    @BeforeEach
    public void setup(){
        product =new  Product("123","Demo Product",123);
    }

    @Test
    public void simpleGsonTest() throws JSONException {
        String expected = "{\n" +
                "\"code\": \"123\",\n" +
                "\"name\": \"Demo Product\",\n" +
                "\"price\": 123\n" +
                "}";

        Gson gson = new GsonBuilder().create();
        String data= gson.toJson(product);

        JSONAssert.assertEquals(expected,data,false);
    }

    @Test
    public void errorGsonTest() throws JSONException {
        String expected = "{\n" +
                "\"code\": \"1233\",\n" +
                "\"name\": \"Demo Product\",\n" +
                "\"price\": 123\n" +
                "}";

        Gson gson = new GsonBuilder().create();
        String data= gson.toJson(product);

        JSONAssert.assertNotEquals(expected,data,false);
    }
    
    @Test
    public void simpleGsonTestByHash() throws JSONException {
    	String expected = "{\"id\":1598266157,\"type\":\"KAKAO\",\"nick\":\"강현제\",\"email\":\"hyunje2316@naver.com\",\"birth\":\"0416\",\"gender\":\"male\"}";
    	
    	HashMap<String, Object> param = new HashMap<>();
    	Gson gson = new Gson();
    	param = (HashMap<String, Object>) gson.fromJson (expected, param.getClass());
    	
    	//assertThat(param.get("id")).isEqualTo(1598266157);
    	assertThat(param.get("type")).isEqualTo("KAKAO");
    	assertThat(param.get("nick")).isEqualTo("강현제");
    	assertThat(param.get("email")).isEqualTo("hyunje2316@naver.com");
    	assertThat(param.get("birth")).isEqualTo("0416");
    	assertThat(param.get("gender")).isEqualTo("male");
    }
    
    
    @Getter @Setter
    private static class Product {
    	String code;
    	String name;
    	int price;
    	public Product(String code, String name, int price) {
    		this.code = code;
    		this.name = name;
    		this.price = price;
    	}
    }
}
