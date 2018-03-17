package site001.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.stereotype.Repository;
import site001.dao.base.BaseDao;
import site001.model.Usuario;

@Repository
public class UsuarioDao implements BaseDao<Usuario> {

    @Override
    public Usuario create(Connection conn, Usuario e) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append(" INSERT INTO usuario (nome, login, email, senha) VALUES(?,?,?,?) RETURNING id");
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
}
