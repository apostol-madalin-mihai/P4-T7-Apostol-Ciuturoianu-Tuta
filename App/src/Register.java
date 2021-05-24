
public class Register {
   // Attributes
   private int pk_id_register;
   private String l_first_name;
   private String l_last_name;
   private String l_phone_number;
   private String l_email;
   private String l_password;
   private String l_safety_question;
   private String l_safety_answer;
   private boolean l_is_approved;
   
   // Constructors 
   public Register(int pk_id_register, String l_first_name, String l_last_name, String l_phone_number,
                   String l_email, String l_password, String l_safety_question, String l_safety_answer,
                   boolean l_is_approved) {
      this.pk_id_register = pk_id_register;
      this.l_first_name = l_first_name;
      this.l_last_name = l_last_name;
      this.l_phone_number = l_phone_number;
      this.l_email = l_email;
      this.l_password = l_password;
      this.l_safety_question = l_safety_question;
      this.l_safety_answer = l_safety_answer;
      this.l_is_approved = l_is_approved;
   }
   
   // Setters & Getters
   public int getPrimaryKey() {
      return pk_id_register;
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
   public String getSafetyQuestion() {
      return l_safety_question;
   }
   public String getSafetyAnswer() {
      return l_safety_answer;
   }
   public boolean getIsApproved() {
      return l_is_approved;
   }
   
   // Functionalities
}
