package br.upe.pweb.base.exception;

import java.time.LocalDateTime;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ControleAcessoExceptionDetalhe {

  private Integer status;
  private String mensagem;
  private String detalhe;
  private LocalDateTime ocorrencia;

}
