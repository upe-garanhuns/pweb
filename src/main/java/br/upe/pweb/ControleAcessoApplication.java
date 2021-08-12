package br.upe.pweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan("br.upe.pweb")
public class ControleAcessoApplication {

  public static void main(String[] args) {
    SpringApplication.run(ControleAcessoApplication.class, args);
  }

}
