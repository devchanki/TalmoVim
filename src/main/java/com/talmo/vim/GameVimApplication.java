package com.talmo.vim;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class GameVimApplication {

   public static void main(String[] args) {
      SpringApplication.run(GameVimApplication.class, args);
   }

}