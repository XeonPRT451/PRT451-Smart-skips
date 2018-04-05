package cdu.xeon.data;
import android.app.Application;
import android.content.Context;
import android.test.AndroidTestCase;
import android.test.ApplicationTestCase;
import android.test.mock.MockContext;
import android.util.Log;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.SQLException;

import cdu.xeon.data.bean.Driver;
import cdu.xeon.data.bean.Landfill;
import cdu.xeon.data.bean.Operator;
import cdu.xeon.data.bean.Skip;
import cdu.xeon.data.db.BaseDao;
import cdu.xeon.data.db.SSDao;

import static org.junit.Assert.*;



public class TestSSDao extends AndroidTestCase
{
    private BaseDao<Skip,Integer> skipDao;
    private BaseDao<Driver,Integer> driverDao;
    private BaseDao<Operator,Integer> operatorDao;
    private BaseDao<Landfill,Integer> landfillDao;
    private Context context;




    @BeforeClass
    protected void setUp() throws Exception {

        super.setUp();
        context=new MockContext();
        skipDao=new SSDao<>(context,Skip.class);
       driverDao=new SSDao<>(context,Driver.class);
        operatorDao=new SSDao<>(context,Operator.class);
        landfillDao=new SSDao<>(context,Landfill.class);

    }
    @Test
    public void testAddSkip() throws SQLException {
        Skip skip=new Skip();
        skip.setName("skip1");
        skip.setLocation("sdgsfgfs");
        skip.setCapacity(0.7);
        skip.setCurrentCapacity(0.4);
        skipDao.save(skip);

    }
    @Test
    public void testQuerySkipById() throws SQLException {
        Skip skip = skipDao.queryById(1);
        assertEquals(1,skip.getId());
        Log.e("TAG",skip+"1");
    }
    @Test
    public void testDeleteSkipById() throws SQLException {

        skipDao.deleteById(1);
    }




}
