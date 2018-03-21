package site001.service;

import java.sql.Connection;
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
    public Usuario readById(Long id) {
        Usuario e = null;
        try (Connection conn = ConnectionManager.getConnection()) {
            e = usuarioDao.readById(conn, id);
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
            if (criteria != null) {
                criteria.put(UsuarioCriteria.SENHA_EQ,
                        Security.generateMd5((String) criteria.get(UsuarioCriteria.SENHA_EQ)));
            }
            eList = usuarioDao.readByCriteria(conn, criteria, offset, limit);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return eList;
    }

    @Override
    public boolean update(Usuario e) {
        boolean resultado = false;
        try (Connection conn = ConnectionManager.getConnection()) {
            e.setSenha(Security.generateMd5(e.getSenha()));
            resultado = usuarioDao.update(conn, e);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return resultado;
    }

    @Override
    public boolean delete(Long id) {
        boolean resultado = false;
        try (Connection conn = ConnectionManager.getConnection()) {
            resultado = usuarioDao.delete(conn, id);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return resultado;
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
