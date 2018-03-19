package site001.service.base;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface BaseService<E, C> {

    public E create(E e);

    public List<E> readByCriteria(Map<C, Object> criteria, Integer offset, Integer limit);

}
