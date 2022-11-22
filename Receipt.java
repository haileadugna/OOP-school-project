import java.time.LocalDate;

public class Receipt {
    private String ReceiptID;
    private Book PurchasedBook;
    private LocalDate PurchaseDate;
  
    Receipt(String ReceiptID, Book PurchasedBook, LocalDate PurchaseDate){
      this.ReceiptID = ReceiptID;
      this.PurchasedBook = PurchasedBook;
      this.PurchaseDate = PurchaseDate;
    }
    public void setReceiptID(String ReceiptID){
      this.ReceiptID = ReceiptID;
    }
    public String getReceiptID(){
      return ReceiptID;
    }
    public void setPurchasedBook(Book PurchasedBook){
      this.PurchasedBook = PurchasedBook;
    }
    public Book getPurchasedBook(){
      return PurchasedBook;
    }
    public void setPurchaseDate(LocalDate PurchaseDate){
      this.PurchaseDate = PurchaseDate;
    }
    public LocalDate getPurchaseDate(){
      return PurchaseDate;
    }
}