package br.upe.pweb.controleacesso.controle;

public class UsuarioNaoEncontradoException extends RuntimeException {
  private static final long serialVersionUID = 2595107180259623460L;

  UsuarioNaoEncontradoException(Long id) {
    super("Não foi possível encontrar usuário: " + id);
  }
}
