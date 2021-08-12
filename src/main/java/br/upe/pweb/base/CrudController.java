package br.upe.pweb.base;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
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
import io.swagger.annotations.ApiOperation;

public interface CrudController<T extends Entidade<T>, ID> {

  <Service extends CrudService<T, ID>> Service getService();

  @PostMapping("/{modelo}")
  default public EntityModel<T> incluir(@Valid @RequestBody T entidade,
      @PathVariable String modelo) {

    T salvo = getService().incluir(entidade);

    String tratado = modelo + "s";

    return EntityModel.of(salvo.add(linkTo(methodOn(this.getClass()).listar(tratado))
        .withRel("Lista de " + StringUtils.capitalize(this.getTipo()))));
  }


  @PutMapping("/{modelo}/{id}")
  default public EntityModel<T> alterar(@Valid @RequestBody T entidade,
      @PathVariable String modelo) {

    T alterado = getService().alterar(entidade);

    String tratado = modelo + "s";

    return EntityModel.of(alterado.add(linkTo(methodOn(this.getClass()).listar(tratado))
        .withRel("Lista de " + StringUtils.capitalize(this.getTipo()))));
  }

  @DeleteMapping("/{modelo}/{id}")
  default public void excluir(@PathVariable ID id) {
    getService().excluir(id);
  }

  @GetMapping("/{modelos}")
  @ApiOperation(value = "Retorna uma lista de ...")
  default public CollectionModel<EntityModel<T>> listar(@PathVariable String modelos) {

    String tratado = modelos.substring(0, modelos.length() - 1);

    final List<EntityModel<T>> entidades = ((List<T>) getService().listar()).stream()
        .map(usuario -> EntityModel.of(
            usuario.add(linkTo(methodOn(this.getClass()).procurar((Long) usuario.getId(), tratado))
                .withSelfRel())))
        .collect(Collectors.toList());

    return CollectionModel.of(entidades);
  }

  @SuppressWarnings("unchecked")
  @GetMapping("/{modelo}/{id}")
  default public EntityModel<T> procurar(@PathVariable Long id, @PathVariable String modelo) {
    String tratado = modelo + "s";

    T usuario = this.getService().procurar((ID) id);

    return EntityModel.of(usuario.add(
        linkTo(methodOn(this.getClass()).listar(tratado)).withRel("Lista de " + this.getTipo())));
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
