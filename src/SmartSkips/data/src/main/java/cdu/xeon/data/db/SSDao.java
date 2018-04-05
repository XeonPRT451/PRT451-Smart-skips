package cdu.xeon.data.db;

import android.content.Context;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class SSDao<T, Integer> extends BaseDao<T, Integer> {

    private Class<T> clazz;
    private Map<Class<T>,Dao<T,Integer>> mDaoMap=new HashMap<Class<T>,Dao<T,Integer>>();

    public SSDao(Context context, Class<T> clazz) {
        super(context);
        this.clazz=clazz;
    }

    @Override
    public Dao<T, Integer> getDao() throws SQLException {
        Dao<T,Integer> dao=mDaoMap.get(clazz);
        if (null==dao){
            dao=mDatabaseHelper.getDao(clazz);
            mDaoMap.put(clazz,dao);
        }
        return dao;
    }

}
