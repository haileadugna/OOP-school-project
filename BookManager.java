
import java.sql.*;

public class BookManager extends Employee {
  private String FullName;
  private String EmployeeID;
  private String EmailAddress;

  BookManager(String FullName, String EmployeeID, String EmailAddress) {
    super(FullName, EmployeeID, EmailAddress);
  }

  public void setFullName(String FullName) {
    this.FullName = FullName;
  }

  public String getFullName() {
    return FullName;
  }

  public void setEmployeeID(String EmployeeID) {
    this.EmployeeID = EmployeeID;
  }

  public String getEmployeeID() {
    return EmployeeID;
  }

  public void setEmailAddress(String EmailAddress) {
    this.EmailAddress = EmailAddress;
  }

  public String getEmailAddress() {
    return EmailAddress;
  }

  public void addNewBook(String BookName, String AuthorName, int ISBN, int Edition, int YearOfPublication, 
  String Genre, String Publisher, int CurrentNumberOfBook, double Price){

    Book abook = new Book(BookName, AuthorName, ISBN, Edition, YearOfPublication, Genre, Publisher, CurrentNumberOfBook, Price);
    try{
      String myDriver = "com.mysql.cj.jdbc.Driver";
      String myUrl = "jdbc:mysql://localhost:3306/Alpha_Book_Store";
      Class.forName(myDriver);
      Connection conn = DriverManager.getConnection(myUrl, "root", "");

      String sql = " insert into book" + " values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

      PreparedStatement preparedStmt = conn.prepareStatement(sql);
      preparedStmt.setString (1, abook.getBookName());
      preparedStmt.setString (2, abook.getAuthorName());
      preparedStmt.setInt    (3, abook.getISBN());
      preparedStmt.setInt    (4, abook.getEdition());
      preparedStmt.setInt    (5, abook.getYearOfPublication());
      preparedStmt.setString (6, abook.getGenre());
      preparedStmt.setString (7, abook.getPublisher());
      preparedStmt.setInt    (8, abook.getCurrentNumberOfBook());
      preparedStmt.setDouble (9, abook.getPrice());

      preparedStmt.execute();

      conn.close();
      }
      catch (Exception e) {
        System.err.println("Got an exception!");
        // printStackTrace method 
        // prints line numbers + call stack
        e.printStackTrace();
        // Prints what exception has been thrown 
        System.out.println(e); 
        }
  }

  public void addExistingBook(int ISBN){
    try{
      String myDriver = "com.mysql.cj.jdbc.Driver";
      String myUrl = "jdbc:mysql://localhost:3306/Alpha_Book_Store";
      Class.forName(myDriver);
      Connection conn = DriverManager.getConnection(myUrl, "root", "");

      String sql1 = "update book set CurrentNumberOfBook = CurrentNumberOfBook + 1 where ISBN = " + ISBN;
      PreparedStatement stmt = conn.prepareStatement(sql1);
      stmt.execute();

      conn.close();
    }

    catch (Exception e) {
        System.err.println("Got an exception!");
        e.printStackTrace();
        System.out.println(e); 
    }
    
  }

  public void removeBook(int ISBN){
    try{
      String myDriver = "com.mysql.cj.jdbc.Driver";
      String myUrl = "jdbc:mysql://localhost:3306/Alpha_Book_Store";
      Class.forName(myDriver);
      Connection conn = DriverManager.getConnection(myUrl, "root", "");

      String sql1 = "select * from book where ISBN = " + ISBN;
      Statement stmt = conn.createStatement();  
      ResultSet rs = stmt.executeQuery(sql1);

      while(rs.next()) {  
        int curnum = rs.getInt(8);

        if (curnum == 1){
          String sql2 = "delete from book where ISBN = " + ISBN;
          PreparedStatement stmt2 = conn.prepareStatement(sql2);
          stmt2.execute();

          removeBookLocation(ISBN);
         
        }
        else if(curnum > 1){
          String sql3 = "update book set CurrentNumberOfBook = CurrentNumberOfBook - 1 where ISBN = " + ISBN;
          PreparedStatement stmt2 = conn.prepareStatement(sql3);
          stmt2.execute();
        }
      }

      conn.close();
    }

    catch (Exception e) {
        System.err.println("Got an exception!");
        e.printStackTrace();
        System.out.println(e); 
    }
    
   }

  // public void addBookLocation(){

  // }
  public void removeBookLocation(int ISBN){
    try{
      String myDriver = "com.mysql.cj.jdbc.Driver";
      String myUrl = "jdbc:mysql://localhost:3306/Alpha_Book_Store";
      Class.forName(myDriver);
      Connection conn = DriverManager.getConnection(myUrl, "root", "");

      String sql1 = "delete from booklocation where ISBN = " + ISBN;
      PreparedStatement stmt = conn.prepareStatement(sql1);
      stmt.execute();

      conn.close();
    }

    catch (Exception e) {
        System.err.println("Got an exception!");
        e.printStackTrace();
        System.out.println(e); 
    }
  }
}

