package site001.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site001.dao.UsuarioDao;
import site001.dao.criteria.UsuarioCriteria;
import site001.model.Usuario;
import site001.service.base.BaseService;

@Service
public class UsuarioService implements BaseService<Usuario, UsuarioCriteria> {

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

    @Override
    public List<Usuario> readByCriteria(Map<UsuarioCriteria, Object> criteria,
            Integer offset, Integer limit) {
        List<Usuario> eList = null;
        try (Connection conn = ConnectionManager.getConnection()) {
            criteria.put(UsuarioCriteria.SENHA_EQ, 
                    Security.generateMd5((String) criteria.get(UsuarioCriteria.SENHA_EQ)));
            eList = usuarioDao.readByCriteria(conn, criteria, offset, limit);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return eList;
    }
    
    public Usuario login(Usuario e) {
        Map<UsuarioCriteria, Object> criteria = new HashMap<>();
        criteria.put(UsuarioCriteria.LOGIN_EQ, e.getLogin());
        criteria.put(UsuarioCriteria.SENHA_EQ, e.getSenha());
        List<Usuario> eList = readByCriteria(criteria, null, null);
        if (!eList.isEmpty()) {
            e = eList.get(0);
        }
        return e;
    }
}
