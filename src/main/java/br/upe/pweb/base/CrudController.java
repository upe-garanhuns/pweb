package br.upe.pweb.base;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

public interface CrudController<T extends Entidade<T>, ID> {

  <Service extends CrudService<T, ID>> Service getService();

  @PostMapping("/{modelo}")
  default public EntityModel<T> incluir(@Valid @RequestBody T entidade,
      @RequestHeader @GenericController String modelo) {
    T salvo = getService().incluir(entidade);

    return EntityModel.of(salvo.add(linkTo(methodOn(this.getClass()).listar(modelo))
        .withRel("Lista de " + StringUtils.capitalize(this.getTipo()))));
  }


  @PutMapping("/{modelo}/{id}")
  default public EntityModel<T> alterar(@Valid @RequestBody T entidade,
      @RequestHeader @GenericController String modelo) {

    T alterado = getService().alterar(entidade);

    return EntityModel.of(alterado.add(linkTo(methodOn(this.getClass()).listar(modelo))
        .withRel("Lista de " + StringUtils.capitalize(this.getTipo()))));
  }

  @DeleteMapping("/{modelo}/{id}")
  default public void excluir(@PathVariable ID id) {
    getService().excluir(id);
  }

  @SuppressWarnings("unchecked")
  @GetMapping("/{modelo}s")
  default public CollectionModel<EntityModel<T>> listar(
      @RequestHeader @GenericController String modelo) {

    final List<EntityModel<T>> usuarios = ((List<T>) getService().listar()).stream()
        .map(usuario -> EntityModel.of(usuario.add(
            linkTo(methodOn(this.getClass()).procurar(usuario.getId(), modelo)).withSelfRel())))
        .collect(Collectors.toList());

    return CollectionModel.of(usuarios);
  }

  @GetMapping("/{modelo}/{id}")
  default public EntityModel<T> procurar(@PathVariable Long id,
      @RequestHeader @GenericController String modelo) {
    Optional<T> usuario = getService().procurar((ID) id);

    usuario.get().add(
        linkTo(methodOn(this.getClass()).listar(modelo)).withRel("Lista de " + this.getTipo()));

    return EntityModel.of(usuario.get());
  }

  @SuppressWarnings("rawtypes")
  default public String getTipo() {
    String tipo = "";

    for (Type genericInterface : getClass().getGenericInterfaces()) {
      if (genericInterface instanceof ParameterizedType) {
        Type[] genericTypes = ((ParameterizedType) genericInterface).getActualTypeArguments();
        tipo = ((Class) genericTypes[0]).getSimpleName().toLowerCase();
      }
    }

    return tipo;
  }
}
