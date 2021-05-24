
public class Apartment {
   // Attributes
   private int pk_id_apartment;
   private int fk_id_tenant;
   private String l_owner;
   private int l_apartment_number;
   private int l_floor;
   private int l_no_of_rooms;
   private int l_no_of_people;
   private int l_expense;
   private int l_debt;
   private int l_outstanding_payment;
   
   // Constructors
   public Apartment(int pk_id_apartment, int fk_id_tenant, String l_owner, int l_apartment_number,
                    int l_floor, int l_no_of_rooms, int l_no_of_people, int l_expense, int l_debt, int l_outstanding_payment) {
      this.pk_id_apartment = pk_id_apartment;
      this.fk_id_tenant = fk_id_tenant;
      this.l_owner = l_owner;
      this.l_apartment_number = l_apartment_number;
      this.l_floor = l_floor;
      this.l_no_of_rooms = l_no_of_rooms;
      this.l_no_of_people= l_no_of_people;
      this.l_debt = l_debt;
      this.l_outstanding_payment = l_outstanding_payment;
   }
 
   // Setters & Getters
   public int getPrimaryKey() {
      return pk_id_apartment;
   }
   public int getForeignKey() {
      return fk_id_tenant;
   }
   public String getOwner() {
      return l_owner;
   }
   public int getApartmentNumber() {
      return l_apartment_number;
   }
   public int getFloor() {
      return l_floor;
   }
   public int getNoOfPeople() {
      return l_no_of_people;
   }
   public int getNoOfRooms() {
      return l_no_of_rooms;
   }
   public int getExpense() {
      return l_expense;
   }
   public int getDebt() {
      return l_debt;
   }
   public int getOutstandingPayment() {
      return l_outstanding_payment;
   }
}
