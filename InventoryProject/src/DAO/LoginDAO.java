package DAO;
import java.sql.*;
import ConnectionManager.ConnectionManager;

public class LoginDAO {

   public boolean validate(Model.Login Login) throws ClassNotFoundException, SQLException
   {
  String username=Login.getUsername();
  String Password=Login.getPassword();
 
   ConnectionManager conm=new ConnectionManager();
   Connection con=conm.establishConnection();
   //statement class
   Statement st=con.createStatement();
   //resultset class
   ResultSet rt=st.executeQuery("select * from login");
   while(rt.next())
   {
  if(username.equals(rt.getString("username"))&&Password.equals(rt.getString("Password")))
  {
  conm.closeConnection();

  return true;
  }
   }
  conm.closeConnection();
  return false;
  }
}
