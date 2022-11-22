
public class Main{
    public static void main(String args[]){  
        BookManager bm = new BookManager("Naol", "1314", "EmailAddress");
        Cashier ch = new Cashier("Bisrat", "2344", "EmailAddresjjs");
        // bm.addNewBook("Three life", "NBA", 1234 ,6, 1994, "Biography", "Mega", 1, 100.00); 
        // bm.removeBook(1260440230);
        // bm.addExistingBook(1260440230);
        // bm.removeBook(1234);
        ch.viewPrice(9780385);
    }  
}
