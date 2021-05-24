
public class Administrator {
   // Attributes
   private int pk_l_id_aba;
   private String l_first_name;
   private String l_last_name;
   private String l_phone_number;
   private String l_email;
   private String l_password;
   
   // Constructors
   public Administrator(int pk_l_id_aba, String l_first_name, String l_last_name, String l_phone_number,
                        String l_email, String l_password) {
      this.pk_l_id_aba = pk_l_id_aba;
      this.l_first_name = l_first_name;
      this.l_last_name = l_last_name;
      this.l_phone_number = l_phone_number;
      this.l_email = l_email;
      this.l_password = l_password;
   }
   
   // Setters & Getters
   public int getPrimaryKey() {
      return pk_l_id_aba;
   }
   public String getFirstName() {
      return l_first_name;
   }
   public String getLastName() {
      return l_last_name;
   }
   public String getPhoneNumber() {
      return l_phone_number;
   }
   public String getEmail() {
      return l_email;
   }
   public String getPassword() {
      return l_password;
   }
   
   // Functionalities
   public void logIn() {
      
   }
   public void logOut() {
      
   }
   public void changePassword() {
      
   }
   public void addEmployees() {
      
   }
   public void editEmployees() {
      
   }
   public void addContract() {
      
   }
   public void editContract() {
      
   }
   public void viewDetails() {
      
   }
   public void viewRequests() {
      
   }
   public void seeDebt() {
      
   }
   public void viewOutstandingPayments() {
      
   }
}
