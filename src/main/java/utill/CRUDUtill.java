package utill;
import dbConnection.DBConnection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CRUDUtill {
    public static <T>T executeQuery(String sql , Object ... args) throws SQLException {
        PreparedStatement psTm = DBConnection.getInstance().getConnection().prepareStatement(sql);
        for (int i = 0; i <args.length; i++) {
            psTm.setObject((i+1),args[i]);
        }
        if (sql.startsWith("SELECT")||sql.startsWith("select")){
           return (T)psTm.executeQuery();
        }
        return (T)(Boolean)(psTm.executeUpdate()>0);
    }
    public static <X>X executeUpdate(String sql, Object ... args) throws SQLException {
        PreparedStatement psTm = DBConnection.getInstance().getConnection().prepareStatement(sql);
        for (int i = 0; i < args.length; i++) {
            psTm.setObject(i + 1, args[i]);
        }
        return (X)(Boolean)(psTm.executeUpdate()>0);
    }
}
