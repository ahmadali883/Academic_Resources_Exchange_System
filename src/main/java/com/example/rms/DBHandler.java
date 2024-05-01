package com.example.rms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


//import BusinessLayer.Booking;
//import BusinessLayer.Registration;
//import BusinessLayer.Station;
//import BusinessLayer.Train;
//import BusinessLayer.admin;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;



public class DBHandler {

    // JDBC URL, username, and password of MySQL server
    private static final String URL = "jdbc:mysql://localhost:3306/Resource_management_system";
    private static final String USER = "root";
    private static final String PASSWORD = "1216";

    // JDBC variables for opening, closing, and managing connection
    private static Connection connection;
    private static PreparedStatement preparedStatement;
    private static ResultSet resultSet;

    private static DBHandler instance = null;

    private DBHandler() {
    }

    public static synchronized DBHandler getInstance() {
        if (instance == null) {
            instance = new DBHandler();
        }
        return instance;
    }


        public static boolean isValidEmail(String email) {
        // Regular expression to match the given email format
        String regex = "[ipkfIPKF]\\d{6}@nu\\.edu\\.pk";

        // Compile the regular expression
        Pattern pattern = Pattern.compile(regex);

        // Match the email address with the pattern
        Matcher matcher = pattern.matcher(email);

        // Return true if the email matches the pattern, false otherwise
        return matcher.matches();
    }
        // Function to insert user data into the database
        public static void insertUser(String name, String phoneNumber, String emailAddress, String password) {
                try {
                    // Open a connection
                    connection = DriverManager.getConnection(URL, USER, PASSWORD);

                    // SQL query to insert user data
                    String sql = "INSERT INTO users (name, phone_number, email_address, password) VALUES (?, ?, ?, ?)";

                    // Create a prepared statement
                    preparedStatement = connection.prepareStatement(sql);

                    // Set parameters for the prepared statement
                    preparedStatement.setString(1, name);
                    preparedStatement.setString(2, phoneNumber);
                    preparedStatement.setString(3, emailAddress);
                    preparedStatement.setString(4, password);

                    // Execute the query
                    preparedStatement.executeUpdate();

                    System.out.println("User data inserted successfully!");
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    // Close the prepared statement and connection
                    try {
                        if (preparedStatement != null)
                            preparedStatement.close();
                        if (connection != null)
                            connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

        }




    // Function to check if user exists with specific email address and password
    public static boolean checkUser(String emailAddress, String password) {
        boolean userExists = false;
        try {
            // Open a connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // SQL query to check if user exists
            String sql = "SELECT COUNT(*) FROM users WHERE email_address = ? AND password = ?";

            // Create a prepared statement
            preparedStatement = connection.prepareStatement(sql);

            // Set parameters for the prepared statement
            preparedStatement.setString(1, emailAddress);
            preparedStatement.setString(2, password);

            // Execute the query
            resultSet = preparedStatement.executeQuery();

            // Check if any rows returned
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                if (count > 0) {
                    userExists = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the result set, prepared statement, and connection
            try {
                if (resultSet != null)
                    resultSet.close();
                if (preparedStatement != null)
                    preparedStatement.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return userExists;
    }


}
//public class DBHandler{
//
//	private static DBHandler instance = null;
//	private DBHandler()
//	{}
//
//	public static synchronized DBHandler getInstance()
//	{
//		if(instance == null)
//		{
//			instance = new DBHandler();
//		}
//		return instance;
//	}
//
//
//
//
//
//
//
//	public Boolean BookingConfirmed(String cnic, String nameofTrain, String arrival, String destination, int no_of_Seats) throws ClassNotFoundException, SQLException
//	{
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Resource_management_system", "root", "1216");
//
//		PreparedStatement ps = con.prepareStatement("select * from customer where customer.cnic='"+cnic+"';");
//		ResultSet rs = ps.executeQuery();
//
//		while(rs.next())
//		{
//			 cnic = rs.getString("cnic");
//
//			if(!cnic.contentEquals(cnic))
//			{
//				String Errors = "Cannot book the ticket due to invalid or registered cnic";
//				Alert errorAlert = new Alert(AlertType.ERROR);
//				errorAlert.setTitle("Booking Unsuccessful");
//				errorAlert.setContentText(Errors);
//				errorAlert.show();
//				return false;
//			}
//		}
//
//		PreparedStatement ps1 = con.prepareStatement("select * from train where train.NameOfTrain='"+nameofTrain+"'AND train.arrival='"+arrival+"' AND train.destination='"
//		+destination+"';");
//
//		ResultSet rs1 = ps1.executeQuery();
////
////		while(rs1.next())
////		{
////			String train_Name = rs1.getString("NameOfTr");
////			String train_arrival = rs1.getString("arrival");
////			String train_destination = rs1.getNString("destination");
////
////			if(!(train_Name.contentEquals(nameofTrain)) && (train_arrival.contentEquals(arrival)) && (train_destination.contentEquals(destination)))
////			{
////				String Errors = "Train does not exist! Please enter correct Train Name";
////				Alert errorAlert = new Alert(AlertType.ERROR);
////				errorAlert.setTitle("Booking Unsuccessful");
////				errorAlert.setContentText(Errors);
////				errorAlert.show();
////				return false;
////			}
//
////			if(!train_arrival.contentEquals(arrival))
////			{
////				String Errors = "This specific train does not go from the entered Place!";
////				Alert errorAlert = new Alert(AlertType.ERROR);
////				errorAlert.setTitle("Booking Unsuccessful");
////				errorAlert.setContentText(Errors);
////				errorAlert.show();
////				return false;
////			}
////
////			if(!train_destination.contentEquals(destination))
////			{
////				String Errors = "This specific train does not go to the entered Place!";
////				Alert errorAlert = new Alert(AlertType.ERROR);
////				errorAlert.setTitle("Booking Unsuccessful");
////				errorAlert.setContentText(Errors);
////				errorAlert.show();
////				return false;
////			}
////		}
//
//		PreparedStatement pstmt = con.prepareStatement("INSERT INTO booking VALUES (?,?,?,?,?);");
//		pstmt.setString(1, cnic);
//		pstmt.setString(2, nameofTrain);
//		pstmt.setString(3, arrival);
//		pstmt.setString(4, destination);
//		pstmt.setInt(5, no_of_Seats);
//		pstmt.executeUpdate();
//
//
//		int fare = no_of_Seats*1000;
//
//		String fare_amount = "Calculated fare is "+ fare;
//		Alert alert = new Alert(Alert.AlertType.INFORMATION);
//        alert.setTitle("Fare Amount");
//        alert.setContentText(fare_amount);
//        alert.show();
//
//		System.out.print("Calculated cost is ");
//		System.out.println(fare);
//
//		Booking bookTicket = new Booking(cnic,nameofTrain,arrival,destination,no_of_Seats);
//
//		return true;
//
//	}
//
//	public Boolean ValidateCustomerForCancelBooking(String cnic) throws SQLException, ClassNotFoundException{
//		Class.forName("com.mysql.cj.jdbc.Driver");
//
//		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Resource_management_system", "root", "1216");
//
//		PreparedStatement ps = con.prepareStatement("select * from  booking where booking.cnic='"+cnic+"';");
//		ResultSet rs = ps.executeQuery();
//
//		while(rs.next())
//		{
//			 cnic = rs.getString("cnic");
//
//			if(!cnic.contentEquals(cnic))
//			{
//				String Errors = "No ticket has been booked on the entered cnic";
//				Alert errorAlert = new Alert(AlertType.ERROR);
//				errorAlert.setTitle("Booking Unsuccessful");
//				errorAlert.setContentText(Errors);
//				errorAlert.show();
//				return false;
//			}
//		}
//
////		PreparedStatement ps1 = con.prepareStatement("DELETE FROM booking where booking.cnic='"+cnic+"';");
//		Statement st = con.createStatement();
//		int rs1 = st.executeUpdate("DELETE FROM booking where booking.cnic='"+cnic+"';");
//
//
//		return true;
//	}
//
//
//
//
//	public Boolean addTrainConfirmed(String nameofTrain, String arrival, String destination) throws ClassNotFoundException, SQLException
//	{
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Resource_management_system", "root", "1216");
//
//		PreparedStatement ps = con.prepareStatement("select * from train where train.NameOfTrain ='"+nameofTrain+"';");
//		ResultSet rs = ps.executeQuery();
//
//		while(rs.next())
//		{
//			String train_name = rs.getString("NameOfTrain");
//
//			if(nameofTrain.contentEquals(train_name))
//			{
//				String Errors = "Cannot add the train due to invalid or already used train name";
//				Alert errorAlert = new Alert(AlertType.ERROR);
//				errorAlert.setTitle("add Train Unsuccessful");
//				errorAlert.setContentText(Errors);
//				errorAlert.show();
//				return false;
//			}
//		}
//
//		PreparedStatement ps1 = con.prepareStatement("Insert into train Values(?,?,?)");
//		ps1.setString(1, nameofTrain);
//		ps1.setString(2, arrival);
//		ps1.setString(3, destination);
//		ps1.executeUpdate();
//
//
//		Train addTrain = new Train(nameofTrain,arrival,destination);
//
//		return true;
//	}
//
//	public ResultSet BookingCnicExists(String updateBooking_Cnic) throws ClassNotFoundException, SQLException {
//		// TODO Auto-generated method stub
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Resource_management_system", "root", "1216");
//		Statement ps = con.createStatement();
//		ResultSet rs = ps.executeQuery("select * from booking where booking.cnic ='"+updateBooking_Cnic+"';");
//		return rs;
//	}
//
//	public void updateBooking(String updateBooking_Cnic,String updateBooking_TrainName, String updateBooking_arrival,
//			String updateBooking_destination, int updateBooking_noOfSeats) throws ClassNotFoundException, SQLException {
//		// TODO Auto-generated method stub
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Resource_management_system", "root", "1216");
//
//		String query = "update booking set trainName='"+updateBooking_TrainName+"',arrival='"+updateBooking_arrival+"',dest='"
//				+updateBooking_destination+"',numbOfSeats='"+updateBooking_noOfSeats+"' where cnic='"+updateBooking_Cnic+"';";
//
//		Statement st = con.createStatement();
//		int rs = st.executeUpdate(query);
//	}
//
//	public boolean validateTrainDeletion(String deleteTrain_Name) throws SQLException, ClassNotFoundException {
//
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Resource_management_system", "root", "1216");
//
//		PreparedStatement ps = con.prepareStatement("select * from  train where train.NameOfTrain='"+deleteTrain_Name+"';");
//		ResultSet rs = ps.executeQuery();
//
//		while(rs.next())
//		{
//			String train_Name_del = rs.getString("NameOfTrain");
//
//			if(!train_Name_del.contentEquals(deleteTrain_Name))
//			{
//				String Errors = "Train does not Exist";
//				Alert errorAlert = new Alert(AlertType.ERROR);
//				errorAlert.setTitle("Train Not Found");
//				errorAlert.setContentText(Errors);
//				errorAlert.show();
//				return false;
//			}
//		}
////		PreparedStatement ps1 = con.prepareStatement("DELETE FROM booking where booking.cnic='"+cnic+"';");
//		Statement st = con.createStatement();
//		int rs1 = st.executeUpdate("DELETE FROM train where train.NameOfTrain='"+deleteTrain_Name+"';");
//		return true;
//	}
//
//	public void train_UpdateValidate(String updateTrain_TrainName, String updateTrain_arrival, String updateTrain_dest) throws SQLException, ClassNotFoundException {
//
//		// TODO Auto-generated method stub
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Resource_management_system", "root", "1216");
//
//		String query = "update train set NameOfTrain='"+updateTrain_TrainName+"',arrival='"+updateTrain_arrival+"', destination='"
//				+updateTrain_dest+"';";
//
//		Statement st = con.createStatement();
//		int rs = st.executeUpdate(query);
//
//	}
//
//	public void addTrainStation(String stationName) throws SQLException, ClassNotFoundException {
//		// TODO Auto-generated method stub
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Resource_management_system", "root", "1216");
//		Station st = new Station(stationName);
//	}
//
//
//}