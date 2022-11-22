public class Employee {
    private String FullName;
    private String EmployeeID;
    private String EmailAddress;

    Employee(String FullName, String EmployeeID, String EmailAddress){
      this.FullName = FullName;
      this.EmployeeID = EmployeeID;
      this.EmailAddress = EmailAddress;
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

}
