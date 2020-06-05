import java.io.*;
import javax.naming.*;
import java.sql.*;
import javax.sql.*;

public class DbAccessAllBooks extends CommandImplAllBooks implements Serializable {

    private DataSource dataSource;

    public void init() {
        try {
            Context init = new InitialContext();
            Context jndiCtx = (Context) init.lookup("java:comp/env");
            String dbName = (String) getParameter("dbName");
            dataSource = (DataSource) jndiCtx.lookup(dbName);
        } catch (NamingException exc) {
            setStatusCode(1);
        }
    }

    public void execute() {
        clearResult();
        setStatusCode(0);
        Connection con = null;
        try {
            synchronized(this) {
                con = dataSource.getConnection();
            }
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from pozycje");
            ResultSetMetaData rsmd = rs.getMetaData();
            int cols = rsmd.getColumnCount();
            while (rs.next())  {
                String wynik = "";
                for (int i=1; i<=cols; i++)
                    wynik += rs.getObject(i) + " ";
                addResult(wynik);
            }
            rs.close();
            stmt.close();
        } catch (SQLException exc) {
            setStatusCode(2);
            throw new DbAccessException("Błąd w dostępie do bazy lub w SQL", exc);
        } finally {
            try {
                con.close();
            } catch (Exception exc) {}
        }
    }
}