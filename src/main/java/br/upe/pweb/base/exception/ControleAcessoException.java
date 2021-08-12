package br.upe.pweb.base.exception;

public class ControleAcessoException extends RuntimeException {
  
  private static final long serialVersionUID = 2595107180259623433L;

  ControleAcessoException() {
    super();
  }
  
  public ControleAcessoException(String msg) {
    super(msg);
  }
  
  public ControleAcessoException(String msg, Throwable ex) {
    super(msg, ex);
  }
  
  public ControleAcessoException(Throwable ex) {
    super(ex);
  }
}
