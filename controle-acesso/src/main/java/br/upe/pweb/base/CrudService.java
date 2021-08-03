package br.upe.pweb.base;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface CrudService<T extends Entidade<T>, ID> {

  <Dao extends CrudRepository<T, ID>> Dao getDao();

  default T incluir(T entidade) {
    final T salva = getDao().save(entidade);
    return salva;
  }

  default T alterar(T entidade) {
    final T salva = getDao().save(entidade);
    return salva;
  }

  default void excluir(ID id) {
    getDao().deleteById(id);
  }

  default Iterable<T> listar() {
    return getDao().findAll();
  }

  default Optional<T> procurar(ID id) {
    return getDao().findById(id);
  }

}
