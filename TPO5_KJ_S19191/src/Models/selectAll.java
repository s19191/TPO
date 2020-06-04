package Models;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class selectAll {

    DataSource dataSource;

    public selectAll() throws ServletException {
        try {
            Context init = new InitialContext();
            Context contx = (Context) init.lookup("java:comp/env");
            dataSource = (DataSource) contx.lookup("jdbc/ksidb");
        } catch (NamingException exc) {
            throw new ServletException(
                    "Nie mogę uzyskać źródła java:comp/env/jdbc/ksidb", exc);
        }
    }

    public Object find(String find) {
        Connection con = null;
        try {
            synchronized (dataSource) {
                con = dataSource.getConnection();
            }
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from pozycje");
            List<String> books = new ArrayList<>();
            while (rs.next())  {
                String tytul = rs.getString("tytul");
                float cena  = rs.getFloat("cena");
                books.add(tytul + " - cena: " + cena);
            }
            return books;
        } catch (Exception exc)  {
            return exc;
        }
    }
}
