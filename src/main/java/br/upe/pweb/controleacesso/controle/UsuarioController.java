package br.upe.pweb.controleacesso.controle;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.upe.pweb.controleacesso.model.Usuario;
import br.upe.pweb.controleacesso.servico.IUsuarioServico;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@Slf4j
public class UsuarioController {

  @Autowired
  private IUsuarioServico servico;

  @PostMapping("/usuario")
  public EntityModel<Usuario> incluir(@Valid @RequestBody Usuario usuario) {
    log.info("Solicitada criação de usuário: {}", usuario);

    Usuario salvo = servico.incluir(usuario);

    return EntityModel.of(
        salvo.add(linkTo(methodOn(UsuarioController.class).listar()).withRel("Lista de Usuarios")));
  }

  @PutMapping("/usuario/{id}")
  public EntityModel<Usuario> alterar(@Valid @RequestBody Usuario entidade) {
    Usuario usuario = servico.alterar(entidade);

    return EntityModel.of(usuario
        .add(linkTo(methodOn(UsuarioController.class).listar()).withRel("Lista de Usuarios")));
  }

  @DeleteMapping("/usuario/{id}")
  public void excluir(@PathVariable Long id) {
    servico.excluir(id);
  }

  @GetMapping("/usuarios")
  public CollectionModel<EntityModel<Usuario>> listar() {

    final List<EntityModel<Usuario>> usuarios = ((List<Usuario>) servico.listar()).stream()
        .map(usuario -> EntityModel.of(usuario.add(
            linkTo(methodOn(UsuarioController.class).procurar(usuario.getId())).withSelfRel())))
        .collect(Collectors.toList());

    return CollectionModel.of(usuarios,
        linkTo(methodOn(UsuarioController.class).listar()).withSelfRel());
  }

  @GetMapping("/usuario/{id}")
  public EntityModel<Usuario> procurar(@PathVariable Long id) {
    Usuario usuario = servico.procurar(id)
        .add(linkTo(methodOn(UsuarioController.class).listar()).withRel("Lista de Usuarios"));

    return EntityModel.of(usuario);
  }

}
