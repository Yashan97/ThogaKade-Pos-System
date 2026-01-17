package utill;
import dbConnection.DBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CRUDUtill {
    public static ResultSet executeQuery(String sql , Object ... args) throws SQLException {
        PreparedStatement psTm = DBConnection.getInstance()
                .getConnection()
                .prepareStatement(sql);

        for (int i = 0; i < args.length; i++) {
            psTm.setObject(i + 1, args[i]);
        }
        return psTm.executeQuery();
    }
    public static int executeUpdate(String sql, Object ... args) throws SQLException {
        PreparedStatement psTm = DBConnection.getInstance().getConnection().prepareStatement(sql);
        for (int i = 0; i < args.length; i++) {
            psTm.setObject(i + 1, args[i]);
        }
        return psTm.executeUpdate();
    }
}
