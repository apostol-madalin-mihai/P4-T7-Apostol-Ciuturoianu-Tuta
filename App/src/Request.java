import java.sql.Date;

public class Request {
   // Attributes
   private int pk_id_request;
   private int fk_id_tenant;
   private String l_owner;
   private int l_apartment_number;
   private String l_type;
   private Date l_date;
   private String l_details;

   // Constructors
   public Request(int pk_id_request, int fk_id_tenant, String l_owner, int l_apartment_number,
                  String l_type, Date l_date, String l_details) {
      this.pk_id_request = pk_id_request;
      this.fk_id_tenant = fk_id_tenant;
      this.l_apartment_number = l_apartment_number;
      this.l_owner = l_owner;
      this.l_type = l_type;
      this.l_date = l_date;
      this.l_details = l_details;
   }
   
   // Setters & Getters
   public int getPrimaryKey() {
      return pk_id_request;
   }
   public int getForeignKey() {
      return fk_id_tenant;
   }
   public int getApartmentNumber() {
      return l_apartment_number;
   }
   public String getOwner() {
      return l_owner;
   }
   public String getType() {
      return l_type;
   }
   public Date getDate() {
      return l_date;
   }
   public String getDetails() {
      return l_details;
   }
   
   // Functionalities
   
}
