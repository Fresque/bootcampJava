import com.company.MySQL;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;

/**
 * Created by marti on 5/19/2017.
 */
public class MySQLTest {

    @Test
    public void MySQLConnectionTest()throws Exception{

        MySQL sql = MySQL.getInstance();

        MySQLConnectionTest();

        Connection c = sql.getConnection();

        Assert.assertTrue(!c.isClosed());
    }
}
