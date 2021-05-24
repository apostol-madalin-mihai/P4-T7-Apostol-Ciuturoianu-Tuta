import java.util.List;
import javax.swing.table.AbstractTableModel;

public class AdministratorTableModel extends AbstractTableModel {
   // Attributes
   private List<Administrator>obj_administrator_list;
   private String[] obj_col_names; // = { TO DO MUST MUST MUST
   
   // Constructors
   public AdministratorTableModel(List<Administrator>obj_administrator_list) {
      this.obj_administrator_list = obj_administrator_list;
   }
   
   // Functionalities
   @Override
   public String getColumnName(int column) {
      return obj_col_names[column];
   }
   
   @Override 
   public int getColumnCount() {
      return obj_col_names.length;
   }
   
   @Override
   public int getRowCount() {
      return obj_administrator_list.size();
   }
   
   @Override
   public Object getValueAt(int t_row, int t_col) {
      if((t_row < 0) || (t_row >= obj_administrator_list.size())) {
         return null;
      }
      Administrator obj_administrator = obj_administrator_list.get(t_row);
      switch(t_col) {
         case 0: return obj_administrator.getPrimaryKey();
         case 1: return obj_administrator.getFirstName();
         case 2: return obj_administrator.getLastName();
         case 3: return obj_administrator.getPhoneNumber();
         case 4: return obj_administrator.getEmail();
         case 5: return obj_administrator.getPassword();
         default: return null;
      }
   }
}
