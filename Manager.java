
public class Manager extends Employee {
    private String FullName;
    private String EmployeeID;
    private String EmailAddress;

    Manager(String FullName, String EmployeeID, String EmailAddress){
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
    public void generateReport(){
        
    }
}
