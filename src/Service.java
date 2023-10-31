import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;

public class Service {
    public void viewTable (Statement stmt, String schema){
        try {
            ResultSet rs=stmt.executeQuery("SELECT * FROM " + schema);
            while(rs.next())
                System.out.println(rs.getInt(1)+" "+rs.getString(2)+
                        " "+rs.getString(3)+ " "+rs.getString(4));
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    public void insertData (Statement stmt, String schema, String data){
        try {
            System.out.println("INSERT INTO " + schema + " VALUES (" + data + ");");
            int rs=stmt.executeUpdate("INSERT INTO " + schema + " VALUES (" + data + ");");
            if (rs > 0) {
                System.out.println("Query OK, 1 row affected ");
            }
            else{
                System.out.println("ERROR");
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public void deleteData (Statement stmt, String schema, Integer id){
        try {
            String column="";
            if(Objects.equals(schema, "Book")){
                column = "bookid";
            } else if (Objects.equals(schema, "Customer")) {
                column = "custid";
            } else {
                throw new RuntimeException("No schema");
            }
            int rs=stmt.executeUpdate("DELETE FROM " + schema + " WHERE " + column + "=" +id);
            if (rs > 0) {
                System.out.println("Query OK, 1 row affected ");
            }
            else{
                System.out.println("ERROR");
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public void searchData(Statement stmt, String schema,String column, String searchData){
        try {
            ResultSet rs=stmt.executeQuery("SELECT * FROM " + schema + " WHERE "+ column + "=" + "\"" + searchData + "\"");
            while(rs.next())
                System.out.println(rs.getInt(1)+" "+rs.getString(2)+
                        " "+rs.getString(3)+ " "+rs.getString(4));
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
