package site001.dao;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Repository;
import site001.dao.base.BaseDao;
import site001.dao.criteria.UsuarioCriteria;
import site001.model.Usuario;
import site001.service.Security;

@Repository
public class UsuarioDao implements BaseDao<Usuario, UsuarioCriteria> {

    @Override
    public Usuario create(Connection conn, Usuario e) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO usuario (nome, login, email, senha) VALUES(?,?,?,?) RETURNING id");
        try (PreparedStatement ps = conn.prepareStatement(sql.toString())) {
            ps.setString(1, e.getNome());
            ps.setString(2, e.getLogin());
            ps.setString(3, e.getEmail());
            ps.setString(4, e.getSenha());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    e.setId(rs.getLong("id"));
                }
            }
        }
        return e;
    }

    @Override
    public List<Usuario> readByCriteria(Connection conn, Map<UsuarioCriteria, Object> criteria,
            Integer offset, Integer limit) throws SQLException {
        List<Usuario> eList = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM usuario WHERE TRUE");
        if (!criteria.isEmpty()) {
            String login = (String) criteria.get(UsuarioCriteria.LOGIN_EQ);
            if (login != null && !login.isEmpty()) {
                sql.append(" AND login = '").append(login).append("'");
            }
            String senha = (String) criteria.get(UsuarioCriteria.SENHA_EQ);
            if (senha != null && !senha.isEmpty()) {
                sql.append(" AND senha = '").append(senha).append("'");
            }
        }
        if (offset != null) {
            sql.append(" OFFSET ").append(offset);
        }
        if (limit != null) {
            sql.append(" LIMIT ").append(limit);
        }
        sql.append(" ORDER BY nome");

        try (Statement s = conn.createStatement()) {
            try (ResultSet rs = s.executeQuery(sql.toString())) {
                while (rs.next()) {
                    Usuario e = new Usuario();
                    e.setId(rs.getLong("id"));
                    e.setLogin(rs.getString("login"));
                    e.setSenha(rs.getString("senha"));
                    e.setNome(rs.getString("nome"));
                    e.setEmail(rs.getString("email"));
                    eList.add(e);
                }
            }
        }
        return eList;
    }
}
