package br.upe.pweb.controleacesso.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import br.upe.pweb.base.Entidade;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class Usuario extends Entidade<Usuario> {

  private static final long serialVersionUID = 284223519940704044L;

  @Column(name = "perfil_acesso")
  @Enumerated(value = EnumType.STRING)
  private PerfilAcesso perfilAcesso;
  private String nome;
  private String email;
  private String senha;
  private Boolean bloqueado;

}
