package br.upe.pweb.controleacesso.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import br.upe.pweb.controleacesso.model.Usuario;

@Repository
public interface IUsuarioDao extends CrudRepository<Usuario, Long> {
}
