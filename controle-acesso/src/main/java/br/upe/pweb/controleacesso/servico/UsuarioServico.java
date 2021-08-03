package br.upe.pweb.controleacesso.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.upe.pweb.controleacesso.dao.IUsuarioDao;

@Service
public class UsuarioServico implements IUsuarioServico {

  @Autowired
  private IUsuarioDao dao;

  @SuppressWarnings("unchecked")
  @Override
  public IUsuarioDao getDao() {
    return dao;
  }

}
