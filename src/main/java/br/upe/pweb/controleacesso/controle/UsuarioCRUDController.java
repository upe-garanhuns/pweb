package br.upe.pweb.controleacesso.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.upe.pweb.base.CrudController;
import br.upe.pweb.controleacesso.model.Usuario;
import br.upe.pweb.controleacesso.servico.IUsuarioServico;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/crudapi")
@Slf4j
public class UsuarioCRUDController implements CrudController<Usuario, Long> {

  @Autowired
  private IUsuarioServico servico;

  @SuppressWarnings("unchecked")
  public IUsuarioServico getService() {
    return this.servico;
  }
  
}
