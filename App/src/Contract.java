import java.sql.Date;

public class Contract {
   // Attributes
   private int pk_id_contract;
   private int fk_id_aba;
   private String l_company_name;
   private String l_company_owner;
   private Date l_begin_date;
   private Date l_end_date;
   private String l_details;
   
   // Constructors
   public Contract(int pk_id_contract, int fk_id_aba, String l_company_name, String l_company_owner,
                   Date l_begin_date, Date l_end_date, String l_details) {
      this.pk_id_contract = pk_id_contract;
      this.fk_id_aba = fk_id_aba;
      this.l_company_name = l_company_name;
      this.l_company_owner = l_company_owner;
      this.l_begin_date = l_begin_date;
      this.l_end_date = l_end_date;
      this.l_details = l_details;
   }
 
   // Setters & Getters
   public int getPrimaryKey() {
      return pk_id_contract;
   }
   public int getForeignKey() {
      return fk_id_aba;
   }
   public String getCompanyName() {
      return l_company_name;
   }
   public String getCompanyOwner() {
      return l_company_owner;
   }
   public Date getBeginDate() {
      return l_begin_date;
   }
   public Date getEndDate() {
      return l_end_date;
   }
   public String getDetails() {
      return l_details;
   }
   
   // Functionalities
   public void viewDetails() {
      
   }
}
