package site001.service.base;

import java.util.List;
import java.util.Map;

public interface BaseService<E, C> {

    public E create(E e);

    public E readById(Long id);

    public List<E> readByCriteria(Map<C, Object> criteria, Integer offset, Integer limit);

    public boolean update(E e);

}
