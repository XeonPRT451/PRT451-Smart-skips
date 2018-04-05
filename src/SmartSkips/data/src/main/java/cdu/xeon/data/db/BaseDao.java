package cdu.xeon.data.db;

import android.content.Context;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.PreparedDelete;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.PreparedUpdate;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.support.DatabaseConnection;

import java.security.InvalidParameterException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 3/04/2018.
 */

public abstract class BaseDao<T, Integer> implements IBaseDao<T, Integer> {

    protected DatabaseHelper mDatabaseHelper;


    protected Context mContext;


    public BaseDao(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("Context can't be null!");

        }
        mContext = context.getApplicationContext();

        mDatabaseHelper = DatabaseHelper.getHelper(mContext);

    }

    /**
     *
     *
     * @return Dao
     * @throws SQLException SQLException
     */
    public abstract Dao<T, Integer> getDao() throws SQLException;

    /**
     *
     *
     * @param t
     * @return
     * @throws SQLException SQLException
     */

    public int save(T t) throws SQLException {
        Dao<T, Integer> dao = getDao();

        DatabaseConnection databaseConnection = null;
        try {
            databaseConnection = dao.startThreadConnection();
            dao.setAutoCommit(databaseConnection, false);
            int save = dao.create(t);
            dao.commit(databaseConnection);
            return save;
        } catch (SQLException e) {
            dao.rollBack(databaseConnection);
            e.printStackTrace();
        } finally {
            dao.endThreadConnection(databaseConnection);
        }
        return 0;
    }

    /**
     *
     * @param t
     * @return Dao.CreateOrUpdateStatus
     * @throws SQLException SQLException
     */
    public Dao.CreateOrUpdateStatus saveOrUpdate(T t) throws SQLException {
        Dao<T, Integer> dao = getDao();
        DatabaseConnection databaseConnection = null;
        try {
            databaseConnection = dao.startThreadConnection();
            dao.setAutoCommit(databaseConnection, false);
            Dao.CreateOrUpdateStatus orUpdate = dao.createOrUpdate(t);
            dao.commit(databaseConnection);
            return orUpdate;
        } catch (SQLException e) {
            dao.rollBack(databaseConnection);
            e.printStackTrace();
        } finally {
            dao.endThreadConnection(databaseConnection);
        }
        return null;
    }

    /**
     *
     * @param t
     * @return
     * @throws SQLException SQLException
     */
    public int save(List<T> t) throws SQLException {
        Dao<T, Integer> dao = getDao();
        DatabaseConnection databaseConnection = null;
        try {
            databaseConnection = dao.startThreadConnection();
            dao.setAutoCommit(databaseConnection, false);
            for (T item : t) {
                dao.create(item);
            }
            dao.commit(databaseConnection);
            return t.size();
        } catch (SQLException e) {
            dao.rollBack(databaseConnection);
            e.printStackTrace();
        } finally {
            dao.endThreadConnection(databaseConnection);
        }
        return 0;
    }

    /**
     *
     *
     * @param t
     * @return
     * @throws SQLException SQLException
     */
    public int delete(T t) throws SQLException {
        Dao<T, Integer> dao = getDao();
        DatabaseConnection databaseConnection = null;
        try {
            databaseConnection = dao.startThreadConnection();
            dao.setAutoCommit(databaseConnection, false);
            int delete = dao.delete(t);
            dao.commit(databaseConnection);
            return delete;
        } catch (SQLException e) {
            dao.rollBack(databaseConnection);
            e.printStackTrace();
        } finally {
            dao.endThreadConnection(databaseConnection);
        }
        return 0;
    }

    /**
     *
     *
     * @param list
     * @return
     * @throws SQLException SQLException
     */
    public int delete(List<T> list) throws SQLException {
        Dao<T, Integer> dao = getDao();
        DatabaseConnection databaseConnection = null;
        try {
            databaseConnection = dao.startThreadConnection();
            dao.setAutoCommit(databaseConnection, false);
            int delete = dao.delete(list);
            dao.commit(databaseConnection);
            return delete;
        } catch (SQLException e) {
            dao.rollBack(databaseConnection);
            e.printStackTrace();
        } finally {
            dao.endThreadConnection(databaseConnection);
        }
        return 0;
    }

    /**
     *
     *
     * @param columnNames
     * @param columnValues
     * @return
     * @throws SQLException              SQLException
     * @throws InvalidParameterException InvalidParameterException
     */
    public int delete(String[] columnNames, Object[] columnValues) throws SQLException, InvalidParameterException {
        List<T> list = query(columnNames, columnValues);
        if (null != list && !list.isEmpty()) {
            Dao<T, Integer> dao = getDao();
            DatabaseConnection databaseConnection = null;
            try {
                databaseConnection = dao.startThreadConnection();
                dao.setAutoCommit(databaseConnection, false);
                int delete = dao.delete(list);
                dao.commit(databaseConnection);
                return delete;
            } catch (SQLException e) {
                dao.rollBack(databaseConnection);
                e.printStackTrace();
            } finally {
                dao.endThreadConnection(databaseConnection);
            }
        }
        return 0;
    }

    /**
     *
     *
     * @param id
     * @return
     * @throws SQLException SQLException
     */
    public int deleteById(Integer id) throws SQLException {
        Dao<T, Integer> dao = getDao();
        DatabaseConnection databaseConnection = null;
        try {
            databaseConnection = dao.startThreadConnection();
            dao.setAutoCommit(databaseConnection, false);
            int delete = dao.deleteById(id);
            dao.commit(databaseConnection);
            return delete;
        } catch (SQLException e) {
            dao.rollBack(databaseConnection);
            e.printStackTrace();
        } finally {
            dao.endThreadConnection(databaseConnection);
        }
        return 0;
    }

    /**
     *
     * @param ids
     * @return
     * @throws SQLException SQLException
     */
    public int deleteByIds(List<Integer> ids) throws SQLException {
        Dao<T, Integer> dao = getDao();

        DatabaseConnection databaseConnection = null;
        try {
            databaseConnection = dao.startThreadConnection();
            dao.setAutoCommit(databaseConnection, false);
            int delete = dao.deleteIds(ids);
            dao.commit(databaseConnection);
            return delete;
        } catch (SQLException e) {
            dao.rollBack(databaseConnection);
            e.printStackTrace();
        } finally {
            dao.endThreadConnection(databaseConnection);
        }
        return 0;
    }
    /**
     *
     *
     * @param preparedDelete PreparedDelete
     * @return
     * @throws SQLException SQLException
     */
    public int delete(PreparedDelete<T> preparedDelete) throws SQLException {
        Dao<T, Integer> dao = getDao();
        DatabaseConnection databaseConnection = null;
        try {
            databaseConnection = dao.startThreadConnection();
            dao.setAutoCommit(databaseConnection, false);
            int delete = dao.delete(preparedDelete);
            dao.commit(databaseConnection);
            return delete;
        } catch (SQLException e) {
            dao.rollBack(databaseConnection);
            e.printStackTrace();
        } finally {
            dao.endThreadConnection(databaseConnection);
        }
        return 0;
    }

    /**
     *
     *
     * @param t
     * @return
     * @throws SQLException SQLException
     */
    public int update(T t) throws SQLException {
        Dao<T, Integer> dao = getDao();
        DatabaseConnection databaseConnection = null;
        try {
            databaseConnection = dao.startThreadConnection();
            dao.setAutoCommit(databaseConnection, false);
            int update = dao.update(t);
            dao.commit(databaseConnection);
            return update;
        } catch (SQLException e) {
            dao.rollBack(databaseConnection);
            e.printStackTrace();
        } finally {
            dao.endThreadConnection(databaseConnection);
        }
        return 0;
    }

    /**
     *
     * @param preparedUpdate PreparedUpdate
     * @return
     * @throws SQLException SQLException
     */
    public int update(PreparedUpdate<T> preparedUpdate) throws SQLException {
        Dao<T, Integer> dao = getDao();
        DatabaseConnection databaseConnection = null;
        try {
            databaseConnection = dao.startThreadConnection();
            dao.setAutoCommit(databaseConnection, false);
            int update = dao.update(preparedUpdate);
            dao.commit(databaseConnection);
            return update;
        } catch (SQLException e) {
            dao.rollBack(databaseConnection);
            e.printStackTrace();
        } finally {
            dao.endThreadConnection(databaseConnection);
        }
        return 0;
    }
    /**
     *
     *
     * @return
     * @throws SQLException SQLException
     */
    public List<T> queryAll() throws SQLException {
        Dao<T, Integer> dao = getDao();
        DatabaseConnection databaseConnection = null;
        try {
            databaseConnection = dao.startThreadConnection();
            dao.setAutoCommit(databaseConnection, false);
            List<T> query = dao.queryForAll();
            dao.commit(databaseConnection);
            return query;
        } catch (SQLException e) {
            dao.rollBack(databaseConnection);
            e.printStackTrace();
        } finally {
            dao.endThreadConnection(databaseConnection);
        }
        return null;
    }

    /**
     *
     *
     * @param preparedQuery PreparedQuery
     * @return
     * @throws SQLException SQLException
     */
    public List<T> query(PreparedQuery<T> preparedQuery) throws SQLException {
        Dao<T, Integer> dao = getDao();
        DatabaseConnection databaseConnection = null;
        try {
            databaseConnection = dao.startThreadConnection();
            dao.setAutoCommit(databaseConnection, false);
            List<T> query = dao.query(preparedQuery);
            dao.commit(databaseConnection);
            return query;
        } catch (SQLException e) {
            dao.rollBack(databaseConnection);
            e.printStackTrace();
        } finally {
            dao.endThreadConnection(databaseConnection);
        }
        return null;
    }

    /**
     *
     *
     * @param columnName
     * @param columnValue
     * @return
     * @throws SQLException SQLException
     */
    public List<T> query(String columnName, String columnValue) throws SQLException {
        QueryBuilder<T, Integer> queryBuilder = getDao().queryBuilder();
        queryBuilder.where().eq(columnName, columnValue);
        PreparedQuery<T> preparedQuery = queryBuilder.prepare();
        Dao<T, Integer> dao = getDao();
        DatabaseConnection databaseConnection = null;
        try {
            databaseConnection = dao.startThreadConnection();
            dao.setAutoCommit(databaseConnection, false);
            List<T> query = dao.query(preparedQuery);
            //also can use dao.queryForEq(columnName,columnValue);
            dao.commit(databaseConnection);
            return query;
        } catch (SQLException e) {
            dao.rollBack(databaseConnection);
            e.printStackTrace();
        } finally {
            dao.endThreadConnection(databaseConnection);
        }
        return null;
    }

    /**
     *
     *
     * @param columnNames
     * @param columnValues
     * @return
     * @throws SQLException SQLException
     */
    public List<T> query(String[] columnNames, Object[] columnValues) throws SQLException {
        if (columnNames.length != columnValues.length) {
            throw new InvalidParameterException("params size is not equal");
        }
        QueryBuilder<T, Integer> queryBuilder = getDao().queryBuilder();
        Where<T, Integer> wheres = queryBuilder.where();
        for (int i = 0; i < columnNames.length; i++) {
            if (i==0){
                wheres.eq(columnNames[i], columnValues[i]);
            }else{
                wheres.and().eq(columnNames[i], columnValues[i]);
            }

        }
        PreparedQuery<T> preparedQuery = queryBuilder.prepare();

        Dao<T, Integer> dao = getDao();
        DatabaseConnection databaseConnection = null;
        try {
            databaseConnection = dao.startThreadConnection();
            dao.setAutoCommit(databaseConnection, false);
            List<T> query = dao.query(preparedQuery);
            dao.commit(databaseConnection);
            return query;
        } catch (SQLException e) {
            dao.rollBack(databaseConnection);
            e.printStackTrace();
        } finally {
            dao.endThreadConnection(databaseConnection);
        }
        return null;
    }

    /**
     *
     *
     * @param map
     * @return
     * @throws SQLException SQLException
     */
    public List<T> query(Map<String, Object> map) throws SQLException {
        QueryBuilder<T, Integer> queryBuilder = getDao().queryBuilder();
        if (!map.isEmpty()) {
            Where<T, Integer> wheres = queryBuilder.where();
            Iterator<Map.Entry<String, Object>> iterator = map.entrySet().iterator();
            String key = null;
            Object value = null;
            for (int i = 0; iterator.hasNext(); i++) {
                Map.Entry<String, Object> next = iterator.next();
                key = next.getKey();
                value = next.getValue();
                if (i == 0) {
                    wheres.eq(key, value);
                } else {
                    wheres.and().eq(key, value);
                }
            }
        }
        PreparedQuery<T> preparedQuery = queryBuilder.prepare();
        Dao<T, Integer> dao = getDao();
        DatabaseConnection databaseConnection = null;
        try {
            databaseConnection = dao.startThreadConnection();
            dao.setAutoCommit(databaseConnection, false);
            List<T> query = dao.query(preparedQuery);
            dao.commit(databaseConnection);
            return query;
        } catch (SQLException e) {
            dao.rollBack(databaseConnection);
            e.printStackTrace();
        } finally {
            dao.endThreadConnection(databaseConnection);
        }
        return null;
    }

    /**
     *
     *
     * @param id
     * @return
     * @throws SQLException SQLException
     */
    public T queryById(Integer id) throws SQLException {
        Dao<T, Integer> dao = getDao();
        DatabaseConnection databaseConnection = null;
        try {
            databaseConnection = dao.startThreadConnection();
            dao.setAutoCommit(databaseConnection, false);
            T t = dao.queryForId(id);
            dao.commit(databaseConnection);
            return t;
        } catch (SQLException e) {
            dao.rollBack(databaseConnection);
            e.printStackTrace();
        } finally {
            dao.endThreadConnection(databaseConnection);
        }
        return null;
    }

    /**
     *
     *
     * @return
     * @throws SQLException SQLException
     */
    public boolean isTableExists() throws SQLException {
        return getDao().isTableExists();
    }


    /**
     *
     *
     * @return
     * @throws SQLException SQLException
     */
    public long count() throws SQLException {
        Dao<T, Integer> dao = getDao();
        DatabaseConnection databaseConnection = null;
        try {
            databaseConnection = dao.startThreadConnection();
            dao.setAutoCommit(databaseConnection, false);
            long count = dao.countOf();
            dao.commit(databaseConnection);
            return count;
        } catch (SQLException e) {
            dao.rollBack(databaseConnection);
            e.printStackTrace();
        } finally {
            dao.endThreadConnection(databaseConnection);
        }
        return 0;
    }

    /**
     *
     *
     * @param preparedQuery
     * @return
     * @throws SQLException SQLException
     */
    public long count(PreparedQuery<T> preparedQuery) throws SQLException {
        Dao<T, Integer> dao = getDao();
        DatabaseConnection databaseConnection = null;
        try {
            databaseConnection = dao.startThreadConnection();
            dao.setAutoCommit(databaseConnection, false);

            long count = dao.countOf(preparedQuery);
            dao.commit(databaseConnection);
            return count;
        } catch (SQLException e) {
            dao.rollBack(databaseConnection);
            e.printStackTrace();
        } finally {
            dao.endThreadConnection(databaseConnection);
        }
        return 0;
    }
}
