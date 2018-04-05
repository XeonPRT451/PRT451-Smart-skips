package cdu.xeon.data.db;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.PreparedDelete;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.PreparedUpdate;

import java.security.InvalidParameterException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 3/04/2018.
 */

public interface IBaseDao<T, Integer> {
    public int save(T t) throws SQLException;
    public Dao.CreateOrUpdateStatus saveOrUpdate(T t) throws SQLException;
    public int save(List<T> t) throws SQLException;
    public int delete(T t) throws SQLException;
    public int delete(List<T> list) throws SQLException;
    public int delete(String[] columnNames, Object[] columnValues) throws SQLException, InvalidParameterException;
    public int deleteById(Integer id) throws SQLException;
    public int deleteByIds(List<Integer> ids) throws SQLException;
    public int delete(PreparedDelete<T> preparedDelete) throws SQLException;
    public int update(T t) throws SQLException;
    public int update(PreparedUpdate<T> preparedUpdate) throws SQLException;
    public List<T> queryAll() throws SQLException;
    public List<T> query(PreparedQuery<T> preparedQuery) throws SQLException;
    List<T> query(String columnName, String columnValue) throws SQLException;
    List<T> query(String[] columnNames, Object[] columnValues) throws SQLException;
    List<T> query(Map<String, Object> map) throws SQLException;
    public T queryById(Integer id) throws SQLException;

}
