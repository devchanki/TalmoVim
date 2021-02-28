package com.talmo.vim.example.controller;

import com.talmo.vim.common.ResponseDto;
import com.talmo.vim.common.ResponseStatus;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("example/api/")
public class ExampleApiController {
    @GetMapping("common-response-map")
    public Map<String, Object> commomResponseMap() {
        Map<String, Object> response = new LinkedHashMap<>();

        response.put("status", ResponseStatus.SUCCESS);
        response.put("message", "This is common response to Map");

        response.put("data", createExampleData());
        return response;
    }

    @GetMapping("common-response-dto")
    public ResponseDto commomResponseDto() {
        return ResponseDto.builder()
                .status(ResponseStatus.SUCCESS)
                .message("This is common response to Dto")
                .data(createExampleData())
                .build();
    }

    @AllArgsConstructor
    static class SomeObject  {
        int integera;
        double deciaml;
        String msg ;
    }

    private Map<String, Object> createExampleData (){
        Map<String, Object> data = new LinkedHashMap<>();
        data.put("desc" , "data can anything");

        List<String> list = new LinkedList<>();
        list.add("like"); list.add("lists");
        data.put("example1" , list);

        data.put("example2", new SomeObject(10, 3.141234, "or object"));
        data.put("can-use-null", null);
        return data;
    }
}
