import java.sql.Date;

public class Payment {
   // Attributes
   private int pk_id_payment;
   private int fk_id_tenant;
   private String l_name;
   private int l_payment_amount;
   private Date l_payment_date;
   
   // Constructors
   public Payment(int pk_id_payment, int fk_id_tenant, String l_name, int l_payment_amount, 
                  Date l_payment_date) {
      this.pk_id_payment = pk_id_payment;
      this.fk_id_tenant = fk_id_tenant;
      this.l_name = l_name;
      this.l_payment_amount = l_payment_amount;
      this.l_payment_date = l_payment_date;
   }

   // Setters & Getters
   public int getPrimaryKey() {
      return pk_id_payment;
   }
   public int getForeignKey() {
      return fk_id_tenant;
   }
   public String getName() {
      return l_name;
   }
   public Date getPaymentDate() {
      return l_payment_date;
   }
   public int getPaymentAmount() {
      return l_payment_amount;
   }
   
   // Functionalities
   public void displayDetails() {
      
   }
}
