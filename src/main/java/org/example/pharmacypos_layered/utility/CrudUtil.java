package org.example.pharmacypos_layered.utility;

import org.example.pharmacypos_layered.db.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CrudUtil {

    public static <T>T execute(String query, Object...object) throws SQLException, ClassNotFoundException {

        // get Connection
        Connection connection = DbConnection.getConnection();

        // Set Connection to PreparedStatement
        PreparedStatement ps = connection.prepareStatement(query);

        // Set Values to Parameters
        for (int i = 0; i < object.length; i++) {
            ps.setObject(i + 1, object[i]);
        }

        // Check Query
        if (query.startsWith("SELECT") || query.startsWith("select")) {
            return (T) ps.executeQuery();
        }else {
            return (T) (Boolean) (0 < ps.executeUpdate());
        }
    }
}
