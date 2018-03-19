package site001.dao.base;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface BaseDao<E, C> {

    public E create(Connection conn, E e) throws SQLException;

    public List<E> readByCriteria(Connection conn, Map<C, Object> criteria, Integer offset, Integer limit) throws SQLException;

}
