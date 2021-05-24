
public interface DatabaseInfo {
   // Interface for parameters to connect to MySQL database
   public static final String MYSQL_USERNAME = "root";
   public static final String MYSQL_PASSWORD = "root";
   public static final String MYSQL_DATABASE_SERVER = "jdbc:mysql://localhost:3306/database";
   public static final String MYSQL_DATABASE_NAME = "database";  
   
   // MySql tables & tuplets for queries:
      // Tenant
      public static final String TENANT_TABLE_NAME = "Tenant";
      public static final String TENANT_PRIMARY_KEY = "id_tenant";
      public static final String TENANT_FIRST_NAME = "first_name";
      public static final String TENANT_LAST_NAME = "last_name";
      public static final String TENANT_PHONE_NUMBER = "phone_number";
      public static final String TENANT_EMAIL = "email";
      public static final String TENANT_PASSWORD = "password";
      public static final String TENANT_SECURITY_QUESTION = "safety_question";
      public static final String TENANT_SECURITY_ANSWER = "safety_answer";
      // Administrator   
      public static final String ADMINISTRATOR_TABLE_NAME = "Administrator";
      public static final String ADMINISTRATOR_PRIMARY_KEY = "id_aba";
      public static final String ADMINISTRATOR_FIRST_NAME = "first_name";
      public static final String ADMINISTRATOR_LAST_NAME = "last_name";
      public static final String ADMINISTRATOR_PHONE_NUMBER = "phone_number";
      public static final String ADMINISTRATOR_EMAIL = "email";
      public static final String ADMINISTRATOR_PASSWORD = "password";
      // Apartment
      public static final String APARTMENT_TABLE_NAME = "Apartment";
      public static final String APARTMENT_PRIMARY_KEY = "id_apartment";
      public static final String APARTMENT_FOREIGN_KEY = "id_tenant";
      public static final String APARTMENT_HOLDER = "holder";
      public static final String APARTMENT_NUMBER = "apt_number";
      public static final String APARTMENT_FLOOR = "storey";
      public static final String APARTMENT_NO_ROOMS = "no_of_rooms";
      public static final String APARTMENT_NO_PEOPLE = "no_of_people";
      public static final String APARTMENT_EXPENSE = "expense";
      public static final String APARTMENT_DEBT = "debt";
      public static final String APARTMENT_OUTSTANDING_PAYMENT = "outstanding_payment";
      // Register 
      public static final String REGISTER_TABLE_NAME = "Register";
      public static final String REGISTER_PRIMARY_KEY = "id_register";
      public static final String REGISTER_FIRST_NAME = "first_name";
      public static final String REGISTER_LAST_NAME = "last_name";
      public static final String REGISTER_PHONE_NUMBER = "phone_number";
      public static final String REGISTER_EMAIL = "email";
      public static final String REGISTER_PASSWORD = "password";
      public static final String REGISTER_SECURITY_QUESTION = "safety_question";
      public static final String REGISTER_SECURITY_ANSWER = "safety_answer";
      public static final String REGISTER_IS_APPROVED = "is_approved";
      // Water Consumption
      public static final String WATER_CONSUMPTION_TABLE_NAME = "Water_Consumption";
      public static final String WATER_CONSUMPTION_PRIMARY_KEY = "id_water_consumption";
      public static final String WATER_CONSUMPTION_FOREIGN_KEY = "id_tenant";
      public static final String WATER_CONSUMPTION_HOLDER_NAME = "holder_name";
      public static final String WATER_CONSUMPTION_CONSUMPTION = "consumption";
      public static final String WATER_CONSUMPTION_DUE_DATE = "due_date";
      // Request 
      public static final String REQUEST_TABLE_NAME = "Request";
      public static final String REQUEST_PRIMARY_KEY = "id_request";
      public static final String REQUEST_FOREIGN_KEY = "id_tenant";
      public static final String REQUEST_APARTMENT_HOLDER = "holder";
      public static final String REQUEST_APARTMENT_NUMBER = "apt_number";
      public static final String REQUEST_TYPE = "archetype";
      public static final String REQUEST_DATE = "upload_date";
      public static final String REQUEST_DETAILS = "details";
      // Employee
      public static final String EMPLOYEE_TABLE_NAME = "Employee";
      public static final String EMPLOYEE_PRIMARY_KEY = "id_employee";
      public static final String EMPLOYEE_FOREIGN_KEY = "id_aba";
      public static final String EMPLOYEE_FIRST_NAME = "first_name";
      public static final String EMPLOYEE_LAST_NAME = "last_name";
      public static final String EMPLOYEE_OCCUPATION = "occupation";
      public static final String EMPLOYEE_SALARY = "salary";
      public static final String EMPLOYEE_EMAIL = "email";
      public static final String EMPLOYEE_PHONE = "phone";
      // Invoice 
      public static final String INVOICE_TABLE_NAME = "Invoice";
      public static final String INVOICE_PRIMARY_KEY = "id_invoice";
      public static final String INVOICE_FOREIGN_KEY = "id_tenant";
      public static final String INVOICE_APARTMENT_HOLDER = "holder";
      public static final String INVOICE_APARTMENT_NUMBER = "apt_number";
      public static final String INVOICE_COMPANY = "company";
      public static final String INVOICE_AMOUNT = "amount";
      public static final String INVOICE_DUE_DATE = "due_date";
      public static final String INVOICE_DATE_OF_ISSUE ="date_of_issue";
      // Payment 
      public static final String PAYMENT_TABLE_NAME = "Payment";
      public static final String PAYMENT_PRIMARY_KEY = "id_payment";
      public static final String PAYMENT_FOREIGN_KEY = "id_tenant";
      public static final String PAYMENT_NAME = "name";
      public static final String PAYMENT_AMOUNT = "amount";
      public static final String PAYMENT_DATE = "date_of";
      // Contract
      public static final String CONTRACT_TABLE_NAME = "Contract";
      public static final String CONTRACT_PRIMARY_KEY = "id_contract";
      public static final String CONTRACT_FOREIGN_KEY = "id_aba";
      public static final String CONTRACT_COMPANY_NAME = "company_name";
      public static final String CONTRACT_COMPANY_OWNER = "company_owner";
      public static final String CONTRACT_BEGIN_DATE = "begin_date";
      public static final String CONTRACT_END_DATE = "end_date";
      public static final String CONTRACT_DETAILS = "details";
      // Account Approval Request
      public static final String ACCOUNT_APPROVAL_TABLE_NAME = "Account_Aproval_Request";
      public static final String ACCOUNT_PRIMARY_KEY = "id_account_approval";
      public static final String ACCOUNT_APPROVAL_DATE_AND_TIME = "date_and_time";
      public static final String ACCOUNT_APPROVAL_APARTMENT_NUMBER = "apartment_number";
      public static final String ACCOUNT_DETAILS = "details";
}
