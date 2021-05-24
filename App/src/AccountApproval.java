import java.sql.Timestamp;

public class AccountApproval {
   // Attributes
   private int pk_id_approval_viewer;
   private Timestamp l_date_and_time;
   private int l_apartment_number;
   private String l_details;

   // Constructors
   public AccountApproval(int pk_id_approval_viewer, Timestamp l_date_and_time, int l_apartment_number,
                         String l_details) {
      this.pk_id_approval_viewer = pk_id_approval_viewer;
      this.l_date_and_time = l_date_and_time;
      this.l_apartment_number = l_apartment_number;
      this.l_details = l_details;
   }
   
   // Setters & Getters
   public int getPrimaryKey() {
      return pk_id_approval_viewer;
   }
   public Timestamp getDateAndTime() {
      return l_date_and_time;
   }
   public int getApartmentNumber() {
      return l_apartment_number;
   }
   public String getDetails() {
      return l_details;
   }
   
   // Functionalities
   public void viewDetails() {
      
   }
}
