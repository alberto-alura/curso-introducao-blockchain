package br.com.ideiasaleatorias.eleicaoonline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class Boot extends SpringBootServletInitializer{

	public static void main(String[] args)  {
		SpringApplication.run(Boot.class, args);
	}
}
