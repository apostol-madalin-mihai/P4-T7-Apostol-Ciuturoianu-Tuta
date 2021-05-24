import java.sql.Date;

public class WaterConsumption {
   // Attributes
   private int pk_id_water_consumption;
   private int fk_id_tenant;
   private String l_name;
   private float l_consumption;
   private Date l_due_date;
   
   // Constructors
   public WaterConsumption(int pk_id_water_consumption, int fk_id_tenant, String l_name,
                           float l_consumption, Date l_due_date) {
      this.pk_id_water_consumption = pk_id_water_consumption;
      this.fk_id_tenant = fk_id_tenant;
      this.l_name = l_name;
      this.l_consumption = l_consumption;
      this.l_due_date = l_due_date;
   }
   
   // Setters & Getters
   public int getPrimaryKey() {
      return pk_id_water_consumption;
   }
   public int getForeignKey() {
      return fk_id_tenant;
   }
   public String getName() {
      return l_name;
   }
   public float getConsumption() {
      return l_consumption;
   }
   public Date getDueDate() {
      return l_due_date;
   }
   
   // Functionalities
   public void displayDetails() {
      
   }
}
