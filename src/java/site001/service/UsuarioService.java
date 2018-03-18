package site001.service;

import java.sql.Connection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site001.dao.UsuarioDao;
import site001.model.Usuario;
import site001.service.base.BaseService;

@Service
public class UsuarioService implements BaseService<Usuario> {

    @Autowired
    UsuarioDao usuarioDao;

    @Override
    public Usuario create(Usuario e) {
        try (Connection conn = ConnectionManager.getConnection()) {
            e.setSenha(Security.generateMd5(e.getSenha()));
            e = usuarioDao.create(conn, e);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return e;
    }
}
