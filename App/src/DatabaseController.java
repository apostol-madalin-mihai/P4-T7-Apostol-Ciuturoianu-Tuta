import java.sql.*;
import java.util.List;

public class DatabaseController {
   // Attributes
   private Connection obj_connection = null;
   private Statement obj_statement = null;
   private PreparedStatement obj_prepared_statement = null;
   private ResultSet obj_result_set = null;
   private static long l_exception_counter = 0;
   // Composite Attributes
   private List<Administrator> list_obj_administrator;
   private List<Tenant> list_obj_tenant;
   private List<Apartment> list_obj_apartment;
   private List<AccountApproval> list_obj_approval;
   private List<Contract> list_obj_contract;
   private List<Employee> list_obj_employee;
   private List<Invoice> list_obj_invoice;
   private List<Payment> list_obj_payment;
   private List<Request> list_obj_request;
   private List<WaterConsumption> list_obj_water;
   private List<Register>list_obj_register;
   
   // Constructors
   public DatabaseController(List<Administrator> list_obj_administrator, List<Tenant> list_obj_tenant,
                             List<Apartment>list_obj_apartment, List<AccountApproval>list_obj_approval,
                             List<Contract>list_obj_contract, List<Employee>list_obj_employee,
                             List<Invoice>list_obj_invoice, List<Payment>list_obj_payment, 
                             List<Request>list_obj_request, List<WaterConsumption>list_obj_water,
                             List<Register>list_obj_register) {
      this.list_obj_administrator = list_obj_administrator;
      this.list_obj_tenant = list_obj_tenant;
      this.list_obj_apartment = list_obj_apartment;
      this.list_obj_approval = list_obj_approval;
      this.list_obj_contract = list_obj_contract;
      this.list_obj_employee = list_obj_employee;
      this.list_obj_invoice = list_obj_invoice;
      this.list_obj_payment = list_obj_payment;
      this.list_obj_request = list_obj_request;
      this.list_obj_water = list_obj_water;
      this.list_obj_register = list_obj_register;
   }
   
   // Functionalities
   private void connectDatabase() throws Exception {
      Class.forName("org.mysql.Driver");
      obj_connection = DriverManager.getConnection(DatabaseInfo.MYSQL_DATABASE_SERVER,
            DatabaseInfo.MYSQL_USERNAME, DatabaseInfo.MYSQL_PASSWORD);
   }
   private void readDatabaseAdministrator(String t_sql) throws SQLException {
      try {
         connectDatabase();
         obj_statement = obj_connection.createStatement();
         obj_result_set = obj_statement.executeQuery(t_sql);
         list_obj_administrator.clear();
         
         while(obj_result_set.next()) {
            list_obj_administrator.add(new Administrator(obj_result_set.getInt(DatabaseInfo.ADMINISTRATOR_PRIMARY_KEY),
                  obj_result_set.getString(DatabaseInfo.ADMINISTRATOR_FIRST_NAME),
                  obj_result_set.getString(DatabaseInfo.ADMINISTRATOR_LAST_NAME),
                  obj_result_set.getString(DatabaseInfo.ADMINISTRATOR_PHONE_NUMBER),
                  obj_result_set.getString(DatabaseInfo.ADMINISTRATOR_EMAIL),
                  obj_result_set.getString(DatabaseInfo.ADMINISTRATOR_PASSWORD)));
         }
      } catch(Exception ex) {
         System.out.println(ex);
         System.err.println("SQL Exception:" + l_exception_counter + " " + t_sql);
         l_exception_counter++;
      } finally {
         obj_connection.close();
      }
   }
   private void readDatabaseTenant(String t_sql) throws SQLException {
      try {
         connectDatabase();
         obj_statement = obj_connection.createStatement();
         obj_result_set = obj_statement.executeQuery(t_sql);
         list_obj_tenant.clear();
         
         while(obj_result_set.next()) {
            list_obj_tenant.add(new Tenant(obj_result_set.getInt(DatabaseInfo.TENANT_PRIMARY_KEY),
                  obj_result_set.getString(DatabaseInfo.TENANT_FIRST_NAME),
                  obj_result_set.getString(DatabaseInfo.TENANT_LAST_NAME),
                  obj_result_set.getString(DatabaseInfo.TENANT_PHONE_NUMBER),
                  obj_result_set.getString(DatabaseInfo.TENANT_EMAIL),
                  obj_result_set.getString(DatabaseInfo.TENANT_PASSWORD),
                  obj_result_set.getString(DatabaseInfo.TENANT_SECURITY_QUESTION),
                  obj_result_set.getString(DatabaseInfo.TENANT_SECURITY_ANSWER)));
         }
      } catch (Exception ex) {
         System.out.println(ex);
         System.err.println("SQL Exception:" + l_exception_counter + " " + t_sql);
         l_exception_counter++;
      } finally {
         obj_connection.close();
      }
   }
   
   private void readDatabaseApartment(String t_sql) throws SQLException {
      try {
         connectDatabase();
         obj_statement = obj_connection.createStatement();
         obj_result_set = obj_statement.executeQuery(t_sql);
         list_obj_apartment.clear();
         
         while(obj_result_set.next()) {
            list_obj_apartment.add(new Apartment(obj_result_set.getInt(DatabaseInfo.APARTMENT_PRIMARY_KEY),
                  obj_result_set.getInt(DatabaseInfo.APARTMENT_FOREIGN_KEY),
                  obj_result_set.getString(DatabaseInfo.APARTMENT_HOLDER),
                  obj_result_set.getInt(DatabaseInfo.APARTMENT_NUMBER),
                  obj_result_set.getInt(DatabaseInfo.APARTMENT_FLOOR),
                  obj_result_set.getInt(DatabaseInfo.APARTMENT_NO_ROOMS),
                  obj_result_set.getInt(DatabaseInfo.APARTMENT_NO_PEOPLE),
                  obj_result_set.getInt(DatabaseInfo.APARTMENT_EXPENSE),
                  obj_result_set.getInt(DatabaseInfo.APARTMENT_DEBT),
                  obj_result_set.getInt(DatabaseInfo.APARTMENT_OUTSTANDING_PAYMENT)));
         }
      } catch (Exception ex) {
         System.out.println(ex);
         System.err.println("SQL Exception:" + l_exception_counter + " " + t_sql);
         l_exception_counter++;
      } finally {
         obj_connection.close();
      }
   }
   
   private void readDatabaseContract(String t_sql) throws SQLException {
      try {
         connectDatabase();
         obj_statement = obj_connection.createStatement();
         obj_result_set = obj_statement.executeQuery(t_sql);
         list_obj_contract.clear();
         
         while(obj_result_set.next()) {
            list_obj_contract.add(new Contract(obj_result_set.getInt(DatabaseInfo.CONTRACT_PRIMARY_KEY),
                  obj_result_set.getInt(DatabaseInfo.CONTRACT_FOREIGN_KEY),
                  obj_result_set.getString(DatabaseInfo.CONTRACT_COMPANY_NAME),
                  obj_result_set.getString(DatabaseInfo.CONTRACT_COMPANY_OWNER),
                  obj_result_set.getDate(DatabaseInfo.CONTRACT_BEGIN_DATE),
                  obj_result_set.getDate(DatabaseInfo.CONTRACT_END_DATE),
                  obj_result_set.getString(DatabaseInfo.CONTRACT_DETAILS)));
         }
      } catch (Exception ex) {
         System.out.println(ex);
         System.err.println("SQL Exception:" + l_exception_counter + " " + t_sql);
         l_exception_counter++;
      } finally {
         obj_connection.close();
      }
   }
   
   private void readDatabaseEmployee(String t_sql) throws SQLException {
      try {
         connectDatabase();
         obj_statement = obj_connection.createStatement();
         obj_result_set = obj_statement.executeQuery(t_sql);
         list_obj_employee.clear();
         
         while(obj_result_set.next()) {
            list_obj_employee.add(new Employee(obj_result_set.getInt(DatabaseInfo.EMPLOYEE_PRIMARY_KEY),
                  obj_result_set.getInt(DatabaseInfo.EMPLOYEE_FOREIGN_KEY),
                  obj_result_set.getString(DatabaseInfo.EMPLOYEE_FIRST_NAME),
                  obj_result_set.getString(DatabaseInfo.EMPLOYEE_LAST_NAME),
                  obj_result_set.getString(DatabaseInfo.EMPLOYEE_OCCUPATION),
                  obj_result_set.getFloat(DatabaseInfo.EMPLOYEE_SALARY),
                  obj_result_set.getString(DatabaseInfo.EMPLOYEE_EMAIL),
                  obj_result_set.getString(DatabaseInfo.EMPLOYEE_PHONE)));
         }
      } catch (Exception ex) {
         System.out.println(ex);
         System.err.println("SQL Exception:" + l_exception_counter + " " + t_sql);
         l_exception_counter++;
      } finally {
         obj_connection.close();
      }
   }
   
   private void readDatabaseInvoice(String t_sql) throws SQLException {
      try {
         connectDatabase();
         obj_statement = obj_connection.createStatement();
         obj_result_set = obj_statement.executeQuery(t_sql);
         list_obj_invoice.clear();
         
         while(obj_result_set.next()) {
            list_obj_invoice.add(new Invoice(obj_result_set.getInt(DatabaseInfo.INVOICE_PRIMARY_KEY),
                  obj_result_set.getInt(DatabaseInfo.INVOICE_FOREIGN_KEY),
                  obj_result_set.getString(DatabaseInfo.INVOICE_APARTMENT_HOLDER),
                  obj_result_set.getInt(DatabaseInfo.INVOICE_APARTMENT_NUMBER),
                  obj_result_set.getString(DatabaseInfo.INVOICE_COMPANY),
                  obj_result_set.getFloat(DatabaseInfo.INVOICE_AMOUNT),
                  obj_result_set.getDate(DatabaseInfo.INVOICE_DUE_DATE),
                  obj_result_set.getDate(DatabaseInfo.INVOICE_DATE_OF_ISSUE)));
         }
      } catch (Exception ex) {
         System.out.println(ex);
         System.err.println("SQL Exception:" + l_exception_counter + " " + t_sql);
         l_exception_counter++;
      } finally {
         obj_connection.close();
      }
   }
   
   private void readDatabasePayment(String t_sql) throws SQLException {
      try {
         connectDatabase();
         obj_statement = obj_connection.createStatement();
         obj_result_set = obj_statement.executeQuery(t_sql);
         list_obj_payment.clear();
         
         while(obj_result_set.next()) {
            list_obj_payment.add(new Payment(obj_result_set.getInt(DatabaseInfo.PAYMENT_PRIMARY_KEY),
                  obj_result_set.getInt(DatabaseInfo.PAYMENT_FOREIGN_KEY),
                  obj_result_set.getString(DatabaseInfo.PAYMENT_NAME),
                  obj_result_set.getInt(DatabaseInfo.PAYMENT_AMOUNT),
                  obj_result_set.getDate(DatabaseInfo.PAYMENT_DATE)));
         }
      } catch (Exception ex) {
         System.out.println(ex);
         System.err.println("SQL Exception:" + l_exception_counter + " " + t_sql);
         l_exception_counter++;
      } finally {
         obj_connection.close();
      }
   }
   
   private void readDatabaseRegister(String t_sql) throws SQLException {
      try {
         connectDatabase();
         obj_statement = obj_connection.createStatement();
         obj_result_set = obj_statement.executeQuery(t_sql);
         list_obj_register.clear();
         
         while(obj_result_set.next()) {
            list_obj_register.add(new Register(obj_result_set.getInt(DatabaseInfo.REGISTER_PRIMARY_KEY),
                  obj_result_set.getString(DatabaseInfo.REGISTER_FIRST_NAME),
                  obj_result_set.getString(DatabaseInfo.REGISTER_LAST_NAME),
                  obj_result_set.getString(DatabaseInfo.REGISTER_PHONE_NUMBER),
                  obj_result_set.getString(DatabaseInfo.REGISTER_EMAIL),
                  obj_result_set.getString(DatabaseInfo.REGISTER_PASSWORD),
                  obj_result_set.getString(DatabaseInfo.REGISTER_SECURITY_QUESTION),
                  obj_result_set.getString(DatabaseInfo.REGISTER_SECURITY_ANSWER),
                  obj_result_set.getBoolean(DatabaseInfo.REGISTER_IS_APPROVED)));
         }
      } catch (Exception ex) {
         System.out.println(ex);
         System.err.println("SQL Exception:" + l_exception_counter + " " + t_sql);
         l_exception_counter++;
      } finally {
         obj_connection.close();
      }
   }
   
   private void readDatabaseRequest(String t_sql) throws SQLException {
      try {
         connectDatabase();
         obj_statement = obj_connection.createStatement();
         obj_result_set = obj_statement.executeQuery(t_sql);
         list_obj_request.clear();
         
         while(obj_result_set.next()) {
            list_obj_request.add(new Request(obj_result_set.getInt(DatabaseInfo.REQUEST_PRIMARY_KEY),
                  obj_result_set.getInt(DatabaseInfo.REQUEST_FOREIGN_KEY),
                  obj_result_set.getString(DatabaseInfo.REQUEST_APARTMENT_HOLDER),
                  obj_result_set.getInt(DatabaseInfo.REQUEST_APARTMENT_NUMBER),
                  obj_result_set.getString(DatabaseInfo.REQUEST_TYPE),
                  obj_result_set.getDate(DatabaseInfo.REQUEST_DATE),
                  obj_result_set.getString(DatabaseInfo.REQUEST_DETAILS)));
         }
      } catch (Exception ex) {
         System.out.println(ex);
         System.err.println("SQL Exception:" + l_exception_counter + " " + t_sql);
         l_exception_counter++;
      } finally {
         obj_connection.close();
      }
   }
   
   private void readDatabaseWaterConsumption(String t_sql) throws SQLException {
      try {
         connectDatabase();
         obj_statement = obj_connection.createStatement();
         obj_result_set = obj_statement.executeQuery(t_sql);
         list_obj_water.clear();
         
         while(obj_result_set.next()) {
            list_obj_water.add(new WaterConsumption(obj_result_set.getInt(DatabaseInfo.WATER_CONSUMPTION_PRIMARY_KEY),
                  obj_result_set.getInt(DatabaseInfo.WATER_CONSUMPTION_FOREIGN_KEY),
                  obj_result_set.getString(DatabaseInfo.WATER_CONSUMPTION_HOLDER_NAME),
                  obj_result_set.getFloat(DatabaseInfo.WATER_CONSUMPTION_CONSUMPTION),
                  obj_result_set.getDate(DatabaseInfo.WATER_CONSUMPTION_DUE_DATE)));
         }
      } catch (Exception ex) {
         System.out.println(ex);
         System.err.println("SQL Exception:" + l_exception_counter + " " + t_sql);
         l_exception_counter++;
      } finally {
         obj_connection.close();
      }
   }
   
   private void readDatabaseApproval(String t_sql) throws SQLException {
      try {
         connectDatabase();
         obj_statement = obj_connection.createStatement();
         obj_result_set = obj_statement.executeQuery(t_sql);
         list_obj_approval.clear();
         
         while(obj_result_set.next()) {
            list_obj_approval.add(new AccountApproval(obj_result_set.getInt(DatabaseInfo.ACCOUNT_PRIMARY_KEY),
                  obj_result_set.getTimestamp(DatabaseInfo.ACCOUNT_APPROVAL_DATE_AND_TIME),
                  obj_result_set.getInt(DatabaseInfo.ACCOUNT_APPROVAL_APARTMENT_NUMBER),
                  obj_result_set.getString(DatabaseInfo.ACCOUNT_DETAILS)));
         }
      } catch (Exception ex) {
         System.out.println(ex);
         System.err.println("SQL Exception:" + l_exception_counter + " " + t_sql);
         l_exception_counter++;
      } finally {
         obj_connection.close();
      }
   }
   
   public void readAllAdministrator() {
      try {
         readDatabaseAdministrator("SELECT * FROM " + DatabaseInfo.ADMINISTRATOR_TABLE_NAME);
      } catch (SQLException ex) {
         System.out.println(ex);
         ex.printStackTrace();
      }
   }
   
   public void readAllTenant() {
      try {
         readDatabaseTenant("SELECT * FROM " + DatabaseInfo.TENANT_TABLE_NAME);
      } catch (SQLException ex) {
         System.out.println(ex);
         ex.printStackTrace();
      }
   }
   
   public void readAllApartment() {
      try {
         readDatabaseApartment("SELECT * FROM " + DatabaseInfo.APARTMENT_TABLE_NAME);
      } catch (SQLException ex) {
         System.out.println(ex);
         ex.printStackTrace();
      }
   }
   
   public void readAllContract() {
      try {
         readDatabaseContract("SELECT * FROM " + DatabaseInfo.CONTRACT_TABLE_NAME);
      } catch (SQLException ex) {
         System.out.println(ex);
         ex.printStackTrace();
      }
   }
   
   public void readAllEmployee() {
      try {
         readDatabaseEmployee("SELECT * FROM " + DatabaseInfo.EMPLOYEE_TABLE_NAME);
      } catch (SQLException ex) {
         System.out.println(ex);
         ex.printStackTrace();
      }
   }
   
   public void readAllInvoice() {
      try {
         readDatabaseInvoice("SELECT * FROM " + DatabaseInfo.INVOICE_TABLE_NAME);
      } catch (SQLException ex) {
         System.out.println(ex);
         ex.printStackTrace();
      }
   }
   
   public void readAllPayment() {
      try {
         readDatabasePayment("SELECT * FROM " + DatabaseInfo.PAYMENT_TABLE_NAME);
      } catch (SQLException ex) {
         System.out.println(ex);
         ex.printStackTrace();
      }
   }
   
   public void readAllRegister() {
      try {
         readDatabaseRegister("SELECT * FROM " + DatabaseInfo.REGISTER_TABLE_NAME);
      } catch (SQLException ex) {
         System.out.println(ex);
         ex.printStackTrace();
      }
   }
   
   public void readAllRequest() {
      try {
         readDatabaseRequest("SELECT * FROM " + DatabaseInfo.REQUEST_TABLE_NAME);
      } catch (SQLException ex) {
         System.out.println(ex);
         ex.printStackTrace();
      }
   }
   
   public void readAllWaterConsumption() {
      try {
         readDatabaseWaterConsumption("SELECT * FROM " + DatabaseInfo.WATER_CONSUMPTION_TABLE_NAME);
      } catch (SQLException ex) {
         System.out.println(ex);
         ex.printStackTrace();
      }
   }
   
   public void readAllApproval() {
      try {
         readDatabaseApproval("SELECT * FROM " + DatabaseInfo.ACCOUNT_APPROVAL_TABLE_NAME);
      } catch (SQLException ex) {
         System.out.println(ex);
         ex.printStackTrace();
      }
   }
   
   public <Type> void searchAdministrator(final String COLUMN_NAME, Type t_searched_data) {
      String temp_sql = "SELECT * FROM " + DatabaseInfo.ADMINISTRATOR_TABLE_NAME +  " WHERE " + 
                        COLUMN_NAME + " LIKE  '%" + t_searched_data + "%'";
      System.out.println(temp_sql);
      try {
         connectDatabase();
         obj_statement = obj_connection.createStatement();
         obj_result_set = obj_statement.executeQuery(temp_sql);
         list_obj_administrator.clear();
         
         while(obj_result_set.next()) {
            list_obj_administrator.add(new Administrator(obj_result_set.getInt(DatabaseInfo.ADMINISTRATOR_PRIMARY_KEY),
                  obj_result_set.getString(DatabaseInfo.ADMINISTRATOR_FIRST_NAME),
                  obj_result_set.getString(DatabaseInfo.ADMINISTRATOR_LAST_NAME),
                  obj_result_set.getString(DatabaseInfo.ADMINISTRATOR_PHONE_NUMBER),
                  obj_result_set.getString(DatabaseInfo.ADMINISTRATOR_EMAIL),
                  obj_result_set.getString(DatabaseInfo.ADMINISTRATOR_PASSWORD)));
         }
      } catch (Exception ex) {
         System.out.println(ex);
         ex.printStackTrace();
      } finally {
         // SEARCH DONE
      }
   }
   
   public <Type> void searchTenant(final String COLUMN_NAME, Type t_searched_data) {
      String temp_sql = "SELECT * FROM " + DatabaseInfo.TENANT_TABLE_NAME + " WHERE " + 
                        COLUMN_NAME + " LIKE '%" + t_searched_data + "%'";
      System.out.println(temp_sql);
      try {
         connectDatabase();
         obj_statement = obj_connection.createStatement();
         obj_result_set = obj_statement.executeQuery(temp_sql);
         list_obj_tenant.clear();
         
         while(obj_result_set.next()) {
            list_obj_tenant.add(new Tenant(obj_result_set.getInt(DatabaseInfo.TENANT_PRIMARY_KEY),
                  obj_result_set.getString(DatabaseInfo.TENANT_FIRST_NAME),
                  obj_result_set.getString(DatabaseInfo.TENANT_LAST_NAME),
                  obj_result_set.getString(DatabaseInfo.TENANT_PHONE_NUMBER),
                  obj_result_set.getString(DatabaseInfo.TENANT_EMAIL),
                  obj_result_set.getString(DatabaseInfo.TENANT_PASSWORD),
                  obj_result_set.getString(DatabaseInfo.TENANT_SECURITY_QUESTION),
                  obj_result_set.getString(DatabaseInfo.TENANT_SECURITY_ANSWER)));
         }  
      } catch (Exception ex) {
         System.out.println(ex);
         ex.printStackTrace();
      } finally {
         // SEARCH DONE
      }
   }
   
   public <Type> void searchApartment(final String COLUMN_NAME, Type t_searched_data) {
      String temp_sql = "SELECT * FROM " + DatabaseInfo.APARTMENT_TABLE_NAME + " WHERE " + 
                        COLUMN_NAME + " LIKE '%" + t_searched_data + "%'";
      System.out.println(temp_sql);
      try {
         connectDatabase();
         obj_statement = obj_connection.createStatement();
         obj_result_set = obj_statement.executeQuery(temp_sql);
         list_obj_apartment.clear();
         
         while(obj_result_set.next()) {
            list_obj_apartment.add(new Apartment(obj_result_set.getInt(DatabaseInfo.APARTMENT_PRIMARY_KEY),
                  obj_result_set.getInt(DatabaseInfo.APARTMENT_FOREIGN_KEY),
                  obj_result_set.getString(DatabaseInfo.APARTMENT_HOLDER),
                  obj_result_set.getInt(DatabaseInfo.APARTMENT_NUMBER),
                  obj_result_set.getInt(DatabaseInfo.APARTMENT_FLOOR),
                  obj_result_set.getInt(DatabaseInfo.APARTMENT_NO_ROOMS),
                  obj_result_set.getInt(DatabaseInfo.APARTMENT_NO_PEOPLE),
                  obj_result_set.getInt(DatabaseInfo.APARTMENT_EXPENSE),
                  obj_result_set.getInt(DatabaseInfo.APARTMENT_DEBT),
                  obj_result_set.getInt(DatabaseInfo.APARTMENT_OUTSTANDING_PAYMENT)));
         }
      } catch (Exception ex) {
         System.out.println(ex);
         ex.printStackTrace();
      } finally {
         // SEARCH DONE
      }
   }
   
   public <Type> void searchRegister(final String COLUMN_NAME, Type t_searched_data) {
      String temp_sql = "SELECT * FROM " + DatabaseInfo.REGISTER_TABLE_NAME + " WHERE " + 
                         COLUMN_NAME + " LIKE '%" + t_searched_data + "%'";
      System.out.println(temp_sql);
      try {
         connectDatabase();
         obj_statement = obj_connection.createStatement();
         obj_result_set = obj_statement.executeQuery(temp_sql);
         list_obj_register.clear();
         
         while(obj_result_set.next()) {
            list_obj_register.add(new Register(obj_result_set.getInt(DatabaseInfo.REGISTER_PRIMARY_KEY),
                  obj_result_set.getString(DatabaseInfo.REGISTER_FIRST_NAME),
                  obj_result_set.getString(DatabaseInfo.REGISTER_LAST_NAME),
                  obj_result_set.getString(DatabaseInfo.REGISTER_PHONE_NUMBER),
                  obj_result_set.getString(DatabaseInfo.REGISTER_EMAIL),
                  obj_result_set.getString(DatabaseInfo.REGISTER_PASSWORD),
                  obj_result_set.getString(DatabaseInfo.REGISTER_SECURITY_QUESTION),
                  obj_result_set.getString(DatabaseInfo.REGISTER_SECURITY_ANSWER),
                  obj_result_set.getBoolean(DatabaseInfo.REGISTER_IS_APPROVED)));
         }
      } catch (Exception ex) {
         System.out.println(ex);
         ex.printStackTrace();
      } finally {
         // SEARCH DONE
      }
   }
   
   public <Type> void searchWaterConsumption(final String COLUMN_NAME, Type t_searched_data) {
      String temp_sql = "SELECT * FROM " + DatabaseInfo.WATER_CONSUMPTION_TABLE_NAME + " WHERE " + 
            COLUMN_NAME + " LIKE '%" + t_searched_data + "%'";
      System.out.println(temp_sql);
      try {
         connectDatabase();
         obj_statement = obj_connection.createStatement();
         obj_result_set = obj_statement.executeQuery(temp_sql);
         list_obj_water.clear();
         
         while(obj_result_set.next()) {
            list_obj_water.add(new WaterConsumption(obj_result_set.getInt(DatabaseInfo.WATER_CONSUMPTION_PRIMARY_KEY),
                  obj_result_set.getInt(DatabaseInfo.WATER_CONSUMPTION_FOREIGN_KEY),
                  obj_result_set.getString(DatabaseInfo.WATER_CONSUMPTION_HOLDER_NAME),
                  obj_result_set.getFloat(DatabaseInfo.WATER_CONSUMPTION_CONSUMPTION),
                  obj_result_set.getDate(DatabaseInfo.WATER_CONSUMPTION_DUE_DATE)));
         } 
      } catch (Exception ex) {
         System.out.println(ex);
         ex.printStackTrace();
      } finally {
         // SEARCH DONE
      }
   }
   
   public <Type> void searchRequest(final String COLUMN_NAME, Type t_searched_data) {
      String temp_sql = "SELECT * FROM " + DatabaseInfo.REQUEST_TABLE_NAME + " WHERE " + 
                        COLUMN_NAME + " LIKE '%" + t_searched_data + "%'";
      System.out.println(temp_sql);
      try {
         connectDatabase();
         obj_statement = obj_connection.createStatement();
         obj_result_set = obj_statement.executeQuery(temp_sql);
         list_obj_request.clear();
         
         while(obj_result_set.next()) {
            list_obj_request.add(new Request(obj_result_set.getInt(DatabaseInfo.REQUEST_PRIMARY_KEY),
                  obj_result_set.getInt(DatabaseInfo.REQUEST_FOREIGN_KEY),
                  obj_result_set.getString(DatabaseInfo.REQUEST_APARTMENT_HOLDER),
                  obj_result_set.getInt(DatabaseInfo.REQUEST_APARTMENT_NUMBER),
                  obj_result_set.getString(DatabaseInfo.REQUEST_TYPE),
                  obj_result_set.getDate(DatabaseInfo.REQUEST_DATE),
                  obj_result_set.getString(DatabaseInfo.REQUEST_DETAILS)));
         }    
      } catch (Exception ex) {
         System.out.println(ex);
         ex.printStackTrace();
      } finally {
         // SEARCH DONE
      }
   }
   
   public <Type> void searchEmployee(final String COLUMN_NAME, Type t_searched_data) {
      String temp_sql = "SELECT * FROM " + DatabaseInfo.EMPLOYEE_TABLE_NAME + " WHERE " + 
                        COLUMN_NAME + " LIKE '%" + t_searched_data + "%'";
      System.out.println(temp_sql);
      try {
         connectDatabase();
         obj_statement = obj_connection.createStatement();
         obj_result_set = obj_statement.executeQuery(temp_sql);
         list_obj_employee.clear();
         
         while(obj_result_set.next()) {
            list_obj_employee.add(new Employee(obj_result_set.getInt(DatabaseInfo.EMPLOYEE_PRIMARY_KEY),
                  obj_result_set.getInt(DatabaseInfo.EMPLOYEE_FOREIGN_KEY),
                  obj_result_set.getString(DatabaseInfo.EMPLOYEE_FIRST_NAME),
                  obj_result_set.getString(DatabaseInfo.EMPLOYEE_LAST_NAME),
                  obj_result_set.getString(DatabaseInfo.EMPLOYEE_OCCUPATION),
                  obj_result_set.getFloat(DatabaseInfo.EMPLOYEE_SALARY),
                  obj_result_set.getString(DatabaseInfo.EMPLOYEE_EMAIL),
                  obj_result_set.getString(DatabaseInfo.EMPLOYEE_PHONE)));
         }         
      } catch (Exception ex) {
         System.out.println(ex);
         ex.printStackTrace();
      } finally {
         // SEARCH DONE
      }
   }
   
   public <Type> void searchInvoice(final String COLUMN_NAME, Type t_searched_data) {
      String temp_sql = "SELECT * FROM " + DatabaseInfo.INVOICE_TABLE_NAME + " WHERE " + 
                        COLUMN_NAME + " LIKE '%" + t_searched_data + "%'";
      System.out.println(temp_sql);
      try {
         connectDatabase();
         obj_statement = obj_connection.createStatement();
         obj_result_set = obj_statement.executeQuery(temp_sql);
         list_obj_invoice.clear();
         
         while(obj_result_set.next()) {
            list_obj_invoice.add(new Invoice(obj_result_set.getInt(DatabaseInfo.INVOICE_PRIMARY_KEY),
                  obj_result_set.getInt(DatabaseInfo.INVOICE_FOREIGN_KEY),
                  obj_result_set.getString(DatabaseInfo.INVOICE_APARTMENT_HOLDER),
                  obj_result_set.getInt(DatabaseInfo.INVOICE_APARTMENT_NUMBER),
                  obj_result_set.getString(DatabaseInfo.INVOICE_COMPANY),
                  obj_result_set.getFloat(DatabaseInfo.INVOICE_AMOUNT),
                  obj_result_set.getDate(DatabaseInfo.INVOICE_DUE_DATE),
                  obj_result_set.getDate(DatabaseInfo.INVOICE_DATE_OF_ISSUE)));
         }
      } catch (Exception ex) {
         System.out.println(ex);
         ex.printStackTrace();
      } finally {
         // SEARCH DONE
      }
   }
   
   public <Type> void searchPayment(final String COLUMN_NAME, Type t_searched_data) {
      String temp_sql = "SELECT * FROM " + DatabaseInfo.PAYMENT_TABLE_NAME + " WHERE " + 
                        COLUMN_NAME + " LIKE '%" + t_searched_data + "%'";
      System.out.println(temp_sql);
      try {
         connectDatabase();
         obj_statement = obj_connection.createStatement();
         obj_result_set = obj_statement.executeQuery(temp_sql);
         list_obj_payment.clear();
         
         while(obj_result_set.next()) {
            list_obj_payment.add(new Payment(obj_result_set.getInt(DatabaseInfo.PAYMENT_PRIMARY_KEY),
                  obj_result_set.getInt(DatabaseInfo.PAYMENT_FOREIGN_KEY),
                  obj_result_set.getString(DatabaseInfo.PAYMENT_NAME),
                  obj_result_set.getInt(DatabaseInfo.PAYMENT_AMOUNT),
                  obj_result_set.getDate(DatabaseInfo.PAYMENT_DATE)));
         }        
      } catch (Exception ex) {
         System.out.println(ex);
         ex.printStackTrace();
      } finally {
         // SEARCH DONE
      }
   }
   
   public <Type> void searchContract(final String COLUMN_NAME, Type t_searched_data) {
      String temp_sql = "SELECT * FROM " + DatabaseInfo.CONTRACT_TABLE_NAME + " WHERE " + 
                        COLUMN_NAME + " LIKE '%" + t_searched_data + "%'";
      System.out.println(temp_sql);
      try {
         connectDatabase();
         obj_statement = obj_connection.createStatement();
         obj_result_set = obj_statement.executeQuery(temp_sql);
         list_obj_contract.clear();
         
         while(obj_result_set.next()) {
            list_obj_contract.add(new Contract(obj_result_set.getInt(DatabaseInfo.CONTRACT_PRIMARY_KEY),
                  obj_result_set.getInt(DatabaseInfo.CONTRACT_FOREIGN_KEY),
                  obj_result_set.getString(DatabaseInfo.CONTRACT_COMPANY_NAME),
                  obj_result_set.getString(DatabaseInfo.CONTRACT_COMPANY_OWNER),
                  obj_result_set.getDate(DatabaseInfo.CONTRACT_BEGIN_DATE),
                  obj_result_set.getDate(DatabaseInfo.CONTRACT_END_DATE),
                  obj_result_set.getString(DatabaseInfo.CONTRACT_DETAILS)));
         }
      } catch (Exception ex) {
         System.out.println(ex);
         ex.printStackTrace();
      } finally {
         // SEARCH DONE
      }
   }
   
   public <Type> void searchAccountApproval(final String COLUMN_NAME, Type t_searched_data) {
      String temp_sql = "SELECT * FROM " + DatabaseInfo.ACCOUNT_APPROVAL_TABLE_NAME + " WHERE " + 
                        COLUMN_NAME + " LIKE '%" + t_searched_data + "%'";
      System.out.println(temp_sql);
      try {
         connectDatabase();
         obj_statement = obj_connection.createStatement();
         obj_result_set = obj_statement.executeQuery(temp_sql);
         list_obj_approval.clear();
         
         while(obj_result_set.next()) {
            list_obj_approval.add(new AccountApproval(obj_result_set.getInt(DatabaseInfo.ACCOUNT_PRIMARY_KEY),
                  obj_result_set.getTimestamp(DatabaseInfo.ACCOUNT_APPROVAL_DATE_AND_TIME),
                  obj_result_set.getInt(DatabaseInfo.ACCOUNT_APPROVAL_APARTMENT_NUMBER),
                  obj_result_set.getString(DatabaseInfo.ACCOUNT_DETAILS)));
         }
      } catch (Exception ex) {
         System.out.println(ex);
         ex.printStackTrace();
      } finally {
         // SEARCH DONE
      }
   }
     
   public void addDatabaseAdministrator(Administrator t_administrator) throws SQLException {
      String temp_sql = "INSERT INTO " + DatabaseInfo.ADMINISTRATOR_TABLE_NAME
            + " (" + DatabaseInfo.ADMINISTRATOR_PRIMARY_KEY +" , " + DatabaseInfo.ADMINISTRATOR_FIRST_NAME + ", "
            + DatabaseInfo.ADMINISTRATOR_LAST_NAME + ", " + DatabaseInfo.ADMINISTRATOR_PHONE_NUMBER + ", "
            + DatabaseInfo.ADMINISTRATOR_EMAIL +", " + DatabaseInfo.ADMINISTRATOR_PASSWORD + ") " 
            + "VALUES (?, ?, ?, ?, ?, ?)";
      
      if(t_administrator == null) {
         System.out.println("Administrator is null...");
         return;
      }
      
      try {
         connectDatabase();
         obj_prepared_statement = obj_connection.prepareStatement(temp_sql);
         obj_prepared_statement.setInt(1, t_administrator.getPrimaryKey());
         obj_prepared_statement.setString(2, t_administrator.getFirstName());
         obj_prepared_statement.setString(3, t_administrator.getLastName());
         obj_prepared_statement.setString(4, t_administrator.getPhoneNumber());
         obj_prepared_statement.setString(5, t_administrator.getEmail());
         obj_prepared_statement.setString(6, t_administrator.getPassword()); 
         obj_prepared_statement.executeUpdate();
         list_obj_administrator.add(t_administrator);
      } catch (Exception ex) {
         System.out.println(ex);
         ex.printStackTrace();
      } finally {
         obj_connection.close();
         obj_prepared_statement.close();
      }
   }
   
   public void addDatabaseTenant(Tenant t_tenant) throws SQLException {
      String temp_sql = "INSERT INTO " + DatabaseInfo.TENANT_TABLE_NAME
            + " (" + DatabaseInfo.TENANT_PRIMARY_KEY +" , " + DatabaseInfo.TENANT_FIRST_NAME + ", "
            + DatabaseInfo.TENANT_LAST_NAME + ", " + DatabaseInfo.TENANT_PHONE_NUMBER + ", "
            + DatabaseInfo.TENANT_EMAIL + ", " + DatabaseInfo.TENANT_PASSWORD + ", "
            + DatabaseInfo.TENANT_SECURITY_QUESTION + ", " + DatabaseInfo.TENANT_SECURITY_ANSWER + ") " 
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
      
      if(t_tenant == null) {
         System.out.println("Tenant is null...");
         return;
      }
      
      try {
         connectDatabase();
         obj_prepared_statement = obj_connection.prepareStatement(temp_sql);
         obj_prepared_statement.setInt(1, t_tenant.getPrimaryKey());
         obj_prepared_statement.setString(2, t_tenant.getFirstName());
         obj_prepared_statement.setString(3, t_tenant.getLastName());
         obj_prepared_statement.setString(4, t_tenant.getPhoneNumber());
         obj_prepared_statement.setString(5, t_tenant.getEmail());
         obj_prepared_statement.setString(6, t_tenant.getPassword());  
         obj_prepared_statement.setString(7, t_tenant.getSecurityQuestion());
         obj_prepared_statement.setString(8, t_tenant.getSecurityAnswer());
         obj_prepared_statement.executeUpdate();
         list_obj_tenant.add(t_tenant);
      } catch (Exception ex) {
         System.out.println(ex);
         ex.printStackTrace();
      } finally {
         obj_connection.close();
         obj_prepared_statement.close();
      }
   }
   
   public void addDatabaseApartment(Apartment t_apartment) throws SQLException {
      String temp_sql = "INSERT INTO " + DatabaseInfo.APARTMENT_TABLE_NAME
            + " (" + DatabaseInfo.APARTMENT_PRIMARY_KEY +" , " + DatabaseInfo.APARTMENT_FOREIGN_KEY + ", "
            + DatabaseInfo.APARTMENT_HOLDER + ", " + DatabaseInfo.APARTMENT_NUMBER + ", "
            + DatabaseInfo.APARTMENT_FLOOR + ", " + DatabaseInfo.APARTMENT_NO_ROOMS + ", "
            + DatabaseInfo.APARTMENT_NO_PEOPLE + ", " + DatabaseInfo.APARTMENT_EXPENSE + ", " 
            + DatabaseInfo.APARTMENT_DEBT + ", " + DatabaseInfo.APARTMENT_OUTSTANDING_PAYMENT + ") " 
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ? , ?)";
      
      if(t_apartment == null) {
         System.out.println("Apartment is null...");
         return;
      }
      
      try {
         connectDatabase();
         obj_prepared_statement = obj_connection.prepareStatement(temp_sql);
         obj_prepared_statement.setInt(1, t_apartment.getPrimaryKey());
         obj_prepared_statement.setInt(2, t_apartment.getForeignKey());
         obj_prepared_statement.setString(3, t_apartment.getOwner());
         obj_prepared_statement.setInt(4, t_apartment.getApartmentNumber());
         obj_prepared_statement.setInt(5, t_apartment.getFloor());
         obj_prepared_statement.setInt(6, t_apartment.getNoOfPeople());
         obj_prepared_statement.setInt(7, t_apartment.getExpense());  
         obj_prepared_statement.setInt(8, t_apartment.getDebt());
         obj_prepared_statement.setInt(9, t_apartment.getOutstandingPayment());
         obj_prepared_statement.executeUpdate();
         list_obj_apartment.add(t_apartment);
      } catch (Exception ex) {
         System.out.println(ex);
         ex.printStackTrace();
      } finally {
         obj_connection.close();
         obj_prepared_statement.close();
      }
   }
   
   public void addDatabaseApproval(AccountApproval t_account_approval) throws SQLException {
      String temp_sql = "INSERT INTO " + DatabaseInfo.ACCOUNT_APPROVAL_TABLE_NAME
            + " (" + DatabaseInfo.ACCOUNT_PRIMARY_KEY +" , " 
            + DatabaseInfo.ACCOUNT_APPROVAL_DATE_AND_TIME + ", "
            + DatabaseInfo.ACCOUNT_APPROVAL_APARTMENT_NUMBER + ", " 
            + DatabaseInfo.ACCOUNT_DETAILS + ") "
            + "VALUES (?, ?, ?, ?)";
      
      if(t_account_approval == null) {
         System.out.println("Account Approval is null...");
         return;
      }
      
      try {
         connectDatabase();
         obj_prepared_statement = obj_connection.prepareStatement(temp_sql);
         obj_prepared_statement.setInt(1, t_account_approval.getPrimaryKey());
         obj_prepared_statement.setTimestamp(2, t_account_approval.getDateAndTime());
         obj_prepared_statement.setInt(3, t_account_approval.getApartmentNumber());
         obj_prepared_statement.setString(4, t_account_approval.getDetails());
         obj_prepared_statement.executeUpdate();
         list_obj_approval.add(t_account_approval);
      } catch (Exception ex) {
         System.out.println(ex);
         ex.printStackTrace();
      } finally {
         obj_connection.close();
         obj_prepared_statement.close();
      }
   }
   
   public void addDatabaseRegister(Register t_register) throws SQLException {
      String temp_sql = "INSERT INTO " + DatabaseInfo.REGISTER_TABLE_NAME
            + " (" + DatabaseInfo.REGISTER_PRIMARY_KEY +" , " 
            + DatabaseInfo.REGISTER_FIRST_NAME + ", "
            + DatabaseInfo.REGISTER_LAST_NAME + ", " 
            + DatabaseInfo.REGISTER_PHONE_NUMBER + ", "
            + DatabaseInfo.REGISTER_EMAIL + ", "
            + DatabaseInfo.REGISTER_PASSWORD + ", "
            + DatabaseInfo.REGISTER_SECURITY_QUESTION + ", "
            + DatabaseInfo.REGISTER_SECURITY_ANSWER + ", "
            + DatabaseInfo.REGISTER_IS_APPROVED + ") "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
      
      if(t_register == null) {
         System.out.println("Register is null...");
         return;
      }
      
      try {
         connectDatabase();
         obj_prepared_statement = obj_connection.prepareStatement(temp_sql);
         obj_prepared_statement.setInt(1, t_register.getPrimaryKey());
         obj_prepared_statement.setString(2, t_register.getFirstName());
         obj_prepared_statement.setString(3, t_register.getLastName());
         obj_prepared_statement.setString(4, t_register.getPhoneNumber());
         obj_prepared_statement.setString(5, t_register.getEmail());
         obj_prepared_statement.setString(6, t_register.getPassword());
         obj_prepared_statement.setString(7, t_register.getSafetyQuestion());
         obj_prepared_statement.setString(8, t_register.getSafetyAnswer());
         obj_prepared_statement.setBoolean(9, t_register.getIsApproved());
         obj_prepared_statement.executeUpdate();
         list_obj_register.add(t_register);
      } catch (Exception ex) {
         System.out.println(ex);
         ex.printStackTrace();
      } finally {
         obj_connection.close();
         obj_prepared_statement.close();
      }
   }
   
   public void addDatabaseWaterConsumption(WaterConsumption t_water_consumption) throws SQLException {
      String temp_sql = "INSERT INTO " + DatabaseInfo.WATER_CONSUMPTION_TABLE_NAME
            + " (" + DatabaseInfo.WATER_CONSUMPTION_PRIMARY_KEY +" , " 
            + DatabaseInfo.WATER_CONSUMPTION_FOREIGN_KEY + ", "
            + DatabaseInfo.WATER_CONSUMPTION_HOLDER_NAME + ", " 
            + DatabaseInfo.WATER_CONSUMPTION_CONSUMPTION + ", "
            + DatabaseInfo.WATER_CONSUMPTION_DUE_DATE + ") "
            + "VALUES (?, ?, ?, ?, ?)";
      
      if(t_water_consumption == null) {
         System.out.println("Water Consumption is null...");
         return;
      }
      
      try {
         connectDatabase();
         obj_prepared_statement = obj_connection.prepareStatement(temp_sql);
         obj_prepared_statement.setInt(1, t_water_consumption.getPrimaryKey());
         obj_prepared_statement.setInt(2, t_water_consumption.getForeignKey());
         obj_prepared_statement.setString(3,t_water_consumption.getName());
         obj_prepared_statement.setFloat(4, t_water_consumption.getConsumption());
         obj_prepared_statement.setDate(5, t_water_consumption.getDueDate());
         obj_prepared_statement.executeUpdate();
         list_obj_water.add(t_water_consumption);
      } catch (Exception ex) {
         System.out.println(ex);
         ex.printStackTrace();
      } finally {
         obj_connection.close();
         obj_prepared_statement.close();
      }
   }
   
   public void addDatabaseRequest(Request t_request) throws SQLException {
      String temp_sql = "INSERT INTO " + DatabaseInfo.REQUEST_TABLE_NAME
            + " (" + DatabaseInfo.REQUEST_PRIMARY_KEY +" , " 
            + DatabaseInfo.REQUEST_FOREIGN_KEY + ", "
            + DatabaseInfo.REQUEST_APARTMENT_HOLDER + ", " 
            + DatabaseInfo.REQUEST_APARTMENT_NUMBER + ", "
            + DatabaseInfo.REQUEST_TYPE + ", " + DatabaseInfo.REQUEST_DATE + ", "
            + DatabaseInfo.REQUEST_DETAILS + ") "
            + "VALUES (?, ?, ?, ?, ?, ?, ?)";
      
      if(t_request == null) {
         System.out.println("Request is null...");
         return;
      }
      
      try {
         connectDatabase();
         obj_prepared_statement = obj_connection.prepareStatement(temp_sql);
         obj_prepared_statement.setInt(1, t_request.getPrimaryKey());
         obj_prepared_statement.setInt(2, t_request.getForeignKey());
         obj_prepared_statement.setString(3, t_request.getOwner());
         obj_prepared_statement.setInt(4, t_request.getApartmentNumber());
         obj_prepared_statement.setString(5, t_request.getType());
         obj_prepared_statement.setDate(6, t_request.getDate());
         obj_prepared_statement.setString(7, t_request.getDetails());
         obj_prepared_statement.executeUpdate();
         list_obj_request.add(t_request);
      } catch (Exception ex) {
         System.out.println(ex);
         ex.printStackTrace();
      } finally {
         obj_connection.close();
         obj_prepared_statement.close();
      }
   }
   
   public void addDatabaseEmployee(Employee t_employee) throws SQLException {
      String temp_sql = "INSERT INTO " + DatabaseInfo.EMPLOYEE_TABLE_NAME
            + " (" + DatabaseInfo.EMPLOYEE_PRIMARY_KEY +" , " 
            + DatabaseInfo.EMPLOYEE_FOREIGN_KEY + ", "
            + DatabaseInfo.EMPLOYEE_FIRST_NAME + ", " 
            + DatabaseInfo.EMPLOYEE_LAST_NAME + ", "
            + DatabaseInfo.EMPLOYEE_OCCUPATION + ", " 
            + DatabaseInfo.EMPLOYEE_SALARY + ", "
            + DatabaseInfo.EMPLOYEE_EMAIL + ", "
            + DatabaseInfo.EMPLOYEE_PHONE + ") "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
      
      if(t_employee == null) {
         System.out.println("Employee is null...");
         return;
      }
      
      try {
         connectDatabase();
         obj_prepared_statement = obj_connection.prepareStatement(temp_sql);
         obj_prepared_statement.setInt(1, t_employee.getPrimaryKey());
         obj_prepared_statement.setInt(2, t_employee.getForeignKey());
         obj_prepared_statement.setString(3, t_employee.getFirstName());
         obj_prepared_statement.setString(4, t_employee.getLastName());
         obj_prepared_statement.setString(5, t_employee.getOccupation());
         obj_prepared_statement.setFloat(6, t_employee.getSalary());
         obj_prepared_statement.setString(7, t_employee.getEmail());
         obj_prepared_statement.setString(8, t_employee.getPhone());
         obj_prepared_statement.executeUpdate();
         list_obj_employee.add(t_employee);
      } catch (Exception ex) {
         System.out.println(ex);
         ex.printStackTrace();
      } finally {
         obj_connection.close();
         obj_prepared_statement.close();
      }
   }
   
   public void addDatabaseContract(Contract t_contract) throws SQLException {
      String temp_sql = "INSERT INTO " + DatabaseInfo.CONTRACT_TABLE_NAME
            + " (" + DatabaseInfo.CONTRACT_PRIMARY_KEY +" , " 
            + DatabaseInfo.CONTRACT_FOREIGN_KEY + ", "
            + DatabaseInfo.CONTRACT_COMPANY_NAME + ", " 
            + DatabaseInfo.CONTRACT_COMPANY_OWNER + ", "
            + DatabaseInfo.CONTRACT_BEGIN_DATE + ", " 
            + DatabaseInfo.CONTRACT_END_DATE + ", "
            + DatabaseInfo.CONTRACT_DETAILS + ") "
            + "VALUES (?, ?, ?, ?, ?, ?, ?)";
      
      if(t_contract == null) {
         System.out.println("Contract is null...");
         return;
      }
      
      try {
         connectDatabase();
         obj_prepared_statement = obj_connection.prepareStatement(temp_sql);
         obj_prepared_statement.setInt(1, t_contract.getPrimaryKey());
         obj_prepared_statement.setInt(2, t_contract.getForeignKey());
         obj_prepared_statement.setString(3, t_contract.getCompanyName());
         obj_prepared_statement.setString(4, t_contract.getCompanyOwner());
         obj_prepared_statement.setDate(5, t_contract.getBeginDate());
         obj_prepared_statement.setDate(6, t_contract.getEndDate());
         obj_prepared_statement.setString(7, t_contract.getDetails());
         obj_prepared_statement.executeUpdate();
         list_obj_contract.add(t_contract);
      } catch (Exception ex) {
         System.out.println(ex);
         ex.printStackTrace();
      } finally {
         obj_connection.close();
         obj_prepared_statement.close();
      }
   }
   
   public void addDatabaseInvoice(Invoice t_invoice) throws SQLException {
      String temp_sql = "INSERT INTO " + DatabaseInfo.INVOICE_TABLE_NAME
            + " (" + DatabaseInfo.INVOICE_PRIMARY_KEY +" , " 
            + DatabaseInfo.INVOICE_FOREIGN_KEY + ", "
            + DatabaseInfo.INVOICE_APARTMENT_HOLDER + ", " 
            + DatabaseInfo.INVOICE_APARTMENT_NUMBER + ", "
            + DatabaseInfo.INVOICE_COMPANY + ", " 
            + DatabaseInfo.INVOICE_AMOUNT + ", "
            + DatabaseInfo.INVOICE_DUE_DATE + ", " 
            + DatabaseInfo.INVOICE_DATE_OF_ISSUE + ") "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
      
      if(t_invoice == null) {
         System.out.println("Invoice is null...");
         return;
      }
      
      try {
         connectDatabase();
         obj_prepared_statement = obj_connection.prepareStatement(temp_sql);
         obj_prepared_statement.setInt(1, t_invoice.getPrimaryKey());
         obj_prepared_statement.setInt(2, t_invoice.getForeignKey());
         obj_prepared_statement.setString(3, t_invoice.getHolderName());
         obj_prepared_statement.setInt(4, t_invoice.getApartmentNumber());
         obj_prepared_statement.setString(5, t_invoice.getCompanyName());
         obj_prepared_statement.setFloat(6, t_invoice.getAmount());
         obj_prepared_statement.setDate(7, t_invoice.getDateOfIssue());
         obj_prepared_statement.setDate(8, t_invoice.getDueDate());
         obj_prepared_statement.executeUpdate();
         list_obj_invoice.add(t_invoice);
      } catch (Exception ex) {
         System.out.println(ex);
         ex.printStackTrace();
      } finally {
         obj_connection.close();
         obj_prepared_statement.close();
      }
   }  
   
   public void addDatabasePayment(Payment t_payment) throws SQLException {
      String temp_sql = "INSERT INTO " + DatabaseInfo.PAYMENT_TABLE_NAME
            + " (" + DatabaseInfo.PAYMENT_PRIMARY_KEY +" , " 
            + DatabaseInfo.PAYMENT_FOREIGN_KEY + ", "
            + DatabaseInfo.PAYMENT_NAME + ", " 
            + DatabaseInfo.PAYMENT_AMOUNT + ", "
            + DatabaseInfo.PAYMENT_DATE + ") "
            + "VALUES (?, ?, ?, ?, ?)";
      
      if(t_payment == null) {
         System.out.println("Payment is null...");
         return;
      }
      
      try {
         connectDatabase();
         obj_prepared_statement = obj_connection.prepareStatement(temp_sql);
         obj_prepared_statement.setInt(1, t_payment.getPrimaryKey());
         obj_prepared_statement.setInt(2, t_payment.getForeignKey());
         obj_prepared_statement.setString(3, t_payment.getName());
         obj_prepared_statement.setInt(4, t_payment.getPaymentAmount());
         obj_prepared_statement.setDate(5, t_payment.getPaymentDate());
         obj_prepared_statement.executeUpdate();
         list_obj_payment.add(t_payment);
      } catch (Exception ex) {
         System.out.println(ex);
         ex.printStackTrace();
      } finally {
         obj_connection.close();
         obj_prepared_statement.close();
      }
   }  
}
