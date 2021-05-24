import java.sql.Date;

public class Invoice {
   // Attributes
   private int pk_id_invoice;
   private int fk_id_tenant;
   private String l_holder_name; 
   private int l_apartment_number; 
   private String l_company_name;
   private float l_amount;
   private Date l_date_of_issue;
   private Date l_due_date;
   
   // Constructors
   public Invoice(int pk_id_invoice, int fk_id_tenant, String l_holder_name, int l_apartment_number,
                  String l_company_name, float l_amount, Date l_date_of_issue, Date l_due_date) {
      this.pk_id_invoice = pk_id_invoice;
      this.fk_id_tenant = fk_id_tenant;
      this.l_holder_name = l_holder_name;
      this.l_apartment_number = l_apartment_number;
      this.l_company_name = l_company_name;
      this.l_amount = l_amount;
      this.l_date_of_issue = l_date_of_issue;
      this.l_due_date = l_due_date;
   }
   
   // Setters & Getters
   public int getPrimaryKey() {
      return pk_id_invoice;
   }
   public int getForeignKey() {
      return fk_id_tenant;
   }
   public String getHolderName() {
      return l_holder_name;
   }
   public int getApartmentNumber() {
      return l_apartment_number;
   }
   public String getCompanyName() {
      return l_company_name;
   }
   public float getAmount() {
      return l_amount;
   }
   public Date getDateOfIssue() {
      return l_date_of_issue;
   }
   public Date getDueDate() {
      return l_due_date;
   }
   
   // Functionalities
   public void displayDetails() {
      
   }
}
