package cdu.xeon.data.db;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import cdu.xeon.data.bean.Driver;
import cdu.xeon.data.bean.Landfill;
import cdu.xeon.data.bean.Operator;
import cdu.xeon.data.bean.Skip;


/**
 * Created by Administrator on 3/04/2018.
 */

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {
    private static final String TABLE_NAME = "xeon-smartskips.db";

            private DatabaseHelper(Context context)
   {
               super(context, TABLE_NAME, null, 1);
            }

           @Override
    public void onCreate(SQLiteDatabase database,
            ConnectionSource connectionSource)
    {
               try
                {
                        TableUtils.createTable(connectionSource, Skip.class);
                       TableUtils.createTable(connectionSource, Driver.class);
                        TableUtils.createTable(connectionSource, Operator.class);
                    TableUtils.createTable(connectionSource, Landfill.class);
                    } catch (SQLException e)
                {
                       e.printStackTrace();
                  }
            }

            @Override
  public void onUpgrade(SQLiteDatabase database,
            ConnectionSource connectionSource, int oldVersion, int newVersion)
   {
                try
                {
                        TableUtils.dropTable(connectionSource, Skip.class, true);
                        TableUtils.dropTable(connectionSource, Driver.class, true);
                        TableUtils.dropTable(connectionSource, Operator.class, true);
                    TableUtils.dropTable(connectionSource, Landfill.class, true);
                       onCreate(database, connectionSource);
                   } catch (SQLException e)
                {
                        e.printStackTrace();
                    }
            }

            private static DatabaseHelper instance;

            /**
     * singleton
      *
     * @param context
      * @return
      */
            public static synchronized DatabaseHelper getHelper(Context context)
    {

               if (instance == null)
                    {
                        synchronized (DatabaseHelper.class)
                        {
                              if (instance == null)
                                        instance = new DatabaseHelper(context);
                            }
                    }

                return instance;
           }



}
