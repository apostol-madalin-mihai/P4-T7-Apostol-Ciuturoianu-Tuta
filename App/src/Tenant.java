
public class Tenant {
   // Main Attributes
   private int pk_id_tenant;
   private String l_first_name;
   private String l_last_name;
   private String l_phone_number;
   private String l_email;
   private String l_password;
   private String l_security_question;
   private String l_security_answer;
   
   // Constructors
   public Tenant(int pk_id_tenant, String l_first_name, String l_last_name, String l_phone_number,
                 String l_email, String l_password, String l_security_question, String l_security_answer) {
      this.pk_id_tenant = pk_id_tenant;
      this.l_first_name = l_first_name;
      this.l_last_name = l_last_name;
      this.l_phone_number = l_phone_number;
      this.l_email = l_email;
      this.l_password = l_password;
      this.l_security_question = l_security_question;
      this.l_security_answer = l_security_answer;
   }
   
   // Setters & Getters
   public int getPrimaryKey() {
      return pk_id_tenant;
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
   public String getSecurityQuestion() {
      return l_security_question;
   }
   public String getSecurityAnswer() {
      return l_security_answer;
   }

   // Functionalities
   public void logIn() {
      
   }
   public void logOut() {
      
   }
   public void changePassword() {
      
   }
   public void addPayment() {
      
   }
   public void addWaterConsumption() {
      
   }
   public void numberOfPeople() {
      
   }
   public void addRequest() {
      
   }
   public void editAppartment() {
      
   }
   public void viewInvoices() {
      
   }
   public void viewDetails() {
      // Apartment details
      // Payment details
      // Tenant details
   }
}
