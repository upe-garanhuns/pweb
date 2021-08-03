package br.upe.pweb.base;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import org.springframework.hateoas.RepresentationModel;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
public abstract class Entidade<T extends Entidade<T>> extends RepresentationModel<T>
    implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  @Getter
  private Long id;

  @Getter
  @Setter
  private LocalDateTime dataInclusao;
  @Getter
  @Setter
  private LocalDateTime dataUltimaAlteracao;

}
