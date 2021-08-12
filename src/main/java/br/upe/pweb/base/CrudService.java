package br.upe.pweb.base;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import org.springframework.data.repository.CrudRepository;
import org.springframework.util.StringUtils;
import br.upe.pweb.base.exception.ControleAcessoException;
import br.upe.pweb.base.exception.RecursoNaoEncontradoException;

public interface CrudService<T extends Entidade<T>, ID> {

  <Dao extends CrudRepository<T, ID>> Dao getDao();

  default T incluir(T entidade) {

    if (entidade == null) {
      throw new ControleAcessoException(StringUtils.capitalize(getTipo()) + " não informado.");
    }

    return getDao().save(entidade);
  }

  default T alterar(T entidade) {
    if (entidade == null) {
      throw new ControleAcessoException(StringUtils.capitalize(getTipo()) + " não informado.");
    }

    return getDao().save(entidade);
  }

  default void excluir(ID id) {

    if (id == null) {
      throw new ControleAcessoException(
          "Identificador do " + StringUtils.capitalize(getTipo()) + " não informado.");
    }

    getDao().deleteById(id);
  }

  default Iterable<T> listar() {
    return getDao().findAll();
  }

  default T procurar(ID id) {
    return getDao().findById(id).orElseThrow(() -> new RecursoNaoEncontradoException(
        StringUtils.capitalize(this.getTipo()) + " não encontrado"));
  }

  @SuppressWarnings("rawtypes")
  default public String getTipo() {
    String tipo = "";

    Class iClasse = ((Class)getClass().getInterfaces()[0]);
    Type[] genericTypes =  iClasse.getGenericInterfaces();
    tipo = ((Class)((ParameterizedType) genericTypes[0]).getActualTypeArguments()[0]).getSimpleName().toLowerCase();

    return tipo;
  }
}
