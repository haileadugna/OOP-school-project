import java.sql.*;

public class Cashier extends Employee {
    private String FullName;
    private String EmployeeID;
    private String EmailAddress;

    Cashier(String FullName, String EmployeeID, String EmailAddress){
      super(FullName, EmployeeID, EmailAddress);
    }
    public void setFullName(String FullName){
      this.FullName = FullName;
    }
    public String getFullName(){
      return FullName;
    }
    public void setEmployeeID(String EmployeeID){
      this.EmployeeID = EmployeeID;
    }
    public String getEmployeeID(){
      return EmployeeID;
    }
    public void setEmailAddress(String EmailAddress){
      this.EmailAddress = EmailAddress;
    }
    public String getEmailAddress(){
      return EmailAddress;
    }

    public void viewPrice(int ISBN){
        try{
            String myDriver = "com.mysql.cj.jdbc.Driver";
            String myUrl = "jdbc:mysql://localhost:3306/Alpha_Book_Store";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "");

            String sql1 = "select * from book where ISBN = " + ISBN;
            Statement stmt = conn.createStatement();  
            ResultSet rs = stmt.executeQuery(sql1);

            while(rs.next()) {  
                double price = rs.getInt(9);
                System.out.println("The Price of this book is: " + price);
            }

            conn.close();   
        }

        catch (Exception e) {
            System.err.println("Got an exception!");
            e.printStackTrace();
            System.out.println(e); 
        }
        
    }  

    public void createReceipt(){
        
    }
}