import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class Transaction extends JFrame
{

    TextField t1,t2,t3,t4;
    Label l1,l2,l3,l4;
      Connection conn;
      int tno;
      int accno;
      int tdate,amt,balance;


    Transaction()
    {

		 setLayout(null);


			   l1=new Label("Acc_no");
			   l1.setBounds(10,10,80,30);
			   add(l1);

			  t1= new TextField();
			  t1.setBounds(110,10,100,30);
			  add(t1);

			  l2=new Label("tran_date");
			  l2.setBounds(10,50,80,30);
			  add(l2);

			  t2= new TextField();
		          t2.setBounds(110,50,140,30);
			  add(t2);

			  l3=new Label("tran_type");
			  l3.setBounds(10,90,80,30);
			  add(l3);

			  t3= new TextField();
			  t3.setBounds(110,90,180,30);
			  add(t3);

			  l4=new Label("updated_balance");
			  l4.setBounds(10,130,80,30);
			  add(l4);

			  t4= new TextField();
			  t4.setBounds(110,130,140,30);
	          add(t4);

	            }


	            int SearchRecord(int accno) throws SQLException
	            {
						   String sql="Select * from Account where Account_no="+accno;
						   Statement statement=conn.createStatement();
						   ResultSet result = statement.executeQuery(sql);
					int count=0;
					//can use field name or ordinal position

					while(result.next())
					{
						int balance=result.getInt("Balance");
						  }
                        return(balance);
					  }

					  void Deposite(int accno,int amt) throws SQLException
					  {
						  int balance=SearchRecord(accno);
						   balance+=amt;
						  ModifyRecord(balance);
						  InsertRecord(accno,tno,tdate,amt);
						  System.out.print("amount sucessfully deposited");
					  }

				  void ModifyRecord(int Balance) throws SQLException
						{

								  String sql="Update Transaction set balance=? where Account_no=?";

                                         PreparedStatement statement = conn.prepareStatement(sql);
										 statement.setInt(1, balance );
										  int rowsUpdated = statement.executeUpdate();
										  if(rowsUpdated > 0)
										  {
											  System.out.println("The current Balance is");

										  }
				                       }

								   void Withdraw(int accno,int amt) throws SQLException
									{
										  int balance=SearchRecord(accno);
										  balance-=amt;
										  ModifyRecord(balance);
										  InsertRecord(accno,tno,tdate,amt);
										  if(balance>amt)
										  System.out.print("amount sucessfully withdrawn");

										 else if(balance<amt)
										  {
									          System.out.print("Insufficient Balance");
				                        }
									}

						 void InsertRecord(int accno,int tno,int tdate,int amt) throws  SQLException
								 {


									 String sql="Insert INTO Book(Account_no,trans_id,trans_date,amount) values (?,?,?,?)";
									 System.out.println(accno+tno+tdate+amt);
									 PreparedStatement statement = conn.prepareStatement(sql);
									 statement.setInt(1, accno);
									 statement.setInt(2, tno);
									 statement.setInt(3, tdate);
									 statement.setInt(4, amt);

									 int rowsInserted = statement.executeUpdate();
									 if(rowsInserted >0)
									 {
										 System.out.println("A new user has inserted sucessfully!");
									 }
								 }





			  public static void main(String args[])
			  {
				 Transaction T= new Transaction();
				 T.setVisible(true);
				 T.setSize(500,700);
				 }

	 }