package com.talmo.vim;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@MapperScan(basePackageClasses = GameVimApplication.class)
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class, JacksonAutoConfiguration.class })
public class GameVimApplication {

   public static void main(String[] args) {
      SpringApplication.run(GameVimApplication.class, args);
   }

}