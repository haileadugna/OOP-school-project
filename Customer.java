public class Customer {
   public static Book[] requestBookByName(String BookName){
    return SearchSystem.searchBookByName(BookName);
  }
  public static Book[] requestBookByAuthor(String AuthorName){
    return SearchSystem.searchBookByAuthor(AuthorName);
  }
  public static int chooseBook(int RollNumber){
    
  }
  public static BookLocation showLocation(){
    
  }
}
