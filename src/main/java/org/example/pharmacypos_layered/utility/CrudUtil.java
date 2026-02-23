package org.example.pharmacypos_layered.utility;

import org.example.pharmacypos_layered.db.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CrudUtil {
    public static <T>T execute(String query, Object ...object) throws SQLException, ClassNotFoundException {
        // get Connection
        Connection conn = DbConnection.getInstance().getConnection();

        // set to Connection and Query
        // create Prepared Statement
        PreparedStatement ps = conn.prepareStatement(query);

        // set Values to Parameters
        for (int i = 1; i < object.length; i++) {
            ps.setObject(i, object[i]);
        }

        // query start word test
        if (query.startsWith("SELECT") || query.startsWith("select")) {
            return (T) ps.executeQuery();
        }else{
            return (T)(Boolean) (ps.executeUpdate() > 0);
        }
    }
}
