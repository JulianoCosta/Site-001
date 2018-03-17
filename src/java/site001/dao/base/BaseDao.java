package site001.dao.base;

import java.sql.Connection;
import java.sql.SQLException;

public interface BaseDao<E> {

    public E create(Connection conn, E e) throws SQLException;

}
