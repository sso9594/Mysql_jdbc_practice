import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://192.168.56.101:4567/madang","root","1234");
            Statement stmt=con.createStatement();
            Service service = new Service();
            Scanner scanner = new Scanner(System.in);
            while (true){
                System.out.println("=========================================================");
                System.out.println("원하는 모드를 선택하세요\ninsert\ndelete\nview\nsearch\nexit");
                System.out.println("=========================================================");
                String input = scanner.nextLine();
                if(Objects.equals(input, "insert")){
                    System.out.println("정보를 입력하세요.(스키마)");
                    String schema = scanner.nextLine();
                    System.out.println("정보를 입력하세요.(데이터)");
                    String data = scanner.nextLine();
                    service.insertData(stmt, schema, data);
                }
                else if(Objects.equals(input, "delete")){
                    System.out.println("정보를 입력하세요.(스키마)");
                    String schema = scanner.nextLine();
                    System.out.println("정보를 입력하세요.(삭제하고싶은 id)");
                    int id = scanner.nextInt();
                    service.deleteData(stmt, schema, id);
                }
                else if(Objects.equals(input, "view")){
                    System.out.println("정보를 입력하세요.(스키마)");
                    String schema = scanner.nextLine();
                    service.viewTable(stmt, schema);
                }
                else if(Objects.equals(input, "search")){
                    System.out.println("정보를 입력하세요.(스키마)");
                    String schema = scanner.nextLine();
                    System.out.println("정보를 입력하세요.(Column)");
                    String column = scanner.nextLine();
                    System.out.println("정보를 입력하세요.(searchData)");
                    String searchData = scanner.nextLine();
                    service.searchData(stmt, schema, column, searchData);
                }
                else if(Objects.equals(input, "exit")){
                    System.out.println("Bye");
                    break;
                }
                else{
                    System.out.println("Try again");
                    continue;
                }
            }
            con.close();
        }catch(Exception e){ System.out.println(e);}
    }
}