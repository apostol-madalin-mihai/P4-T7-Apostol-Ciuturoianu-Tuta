
public class Employee {
   // Attributes
   private int pk_id_employee;
   private int fk_id_aba;
   private String l_first_name;
   private String l_last_name;
   private String l_occupation;
   private float l_salary;
   private String l_email;
   private String l_phone;
   
   // Constructors
   public Employee(int pk_id_employee, int fk_id_aba, String l_first_name, String l_last_name,
                   String l_occupation, float l_salary, String l_email, String l_phone) {
      this.pk_id_employee = pk_id_employee;
      this.fk_id_aba = fk_id_aba;
      this.l_first_name = l_first_name;
      this.l_last_name = l_last_name;
      this.l_occupation = l_occupation;
      this.l_salary = l_salary;
      this.l_email = l_email;
      this.l_phone = l_phone;
   }
   
   // Setters & Getters
   public int getPrimaryKey() {
      return pk_id_employee;
   }
   public int getForeignKey() {
      return fk_id_aba;
   }
   public String getFirstName() {
      return l_first_name;
   }
   public String getLastName() {
      return l_last_name;
   }
   public String getOccupation() {
      return l_occupation;
   }
   public float getSalary() {
      return l_salary;
   }
   public String getEmail() {
      return l_email;
   }
   public String getPhone() {
      return l_phone;
   }
   
   // Functionalities
   public void viewDetails() {
      
   }
}
