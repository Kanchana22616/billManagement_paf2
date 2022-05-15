package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.addBill;
import model.deleteBill;
import model.updateBill;
import model.viewBill;
import utill.dbConnection;

public class BillDao {
	
	public static String addBillDetails(String getUserId, String getBillId,
			String getDate, String getArrears, String getAmount, String getTotalPayble, String getEmpId) {

		

		Connection con = dbConnection.connect();

		try {

			PreparedStatement ps1 = con.prepareStatement("select billId from bill where billId=?");
			ps1.setString(1, getBillId);
			ResultSet rrs = ps1.executeQuery();

			if (rrs.next()) {
				return "Already Exist";
			} else {
				
				
				
				
				PreparedStatement ps = con.prepareStatement("insert into bill values(?,?,?,?,?,?,?)");
				ps.setString(1, getUserId);
				ps.setString(2, getBillId);
				ps.setString(3, getDate);
				ps.setString(4, getArrears);
				ps.setString(5, getAmount);
				ps.setString(6, getTotalPayble);
				ps.setString(7, getEmpId);

				int i = ps.executeUpdate();

				if (i > 0) {
					return "Insert Succsessfully";
				} else {
					return "Insert Failed";
				}

			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		} finally {
			try {
				con.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return "fail";

	}
	
	public static boolean checkBillID(updateBill updateBillBean) {

		Connection con = dbConnection.connect();

		try {

			PreparedStatement ps = con.prepareStatement("select * from bill where billId=? ");
			ps.setNString(1, updateBillBean.getBillId());
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}

	}

	public static boolean updateBillDetails(String getNewdate, String getNewarrears, String getNewamount, String getNewtotalPayble, String getBillId) {

		Connection con = dbConnection.connect();

		try {

			PreparedStatement ps = con.prepareStatement("update bill set date=? , arrears=? , amount=? , totalPayble=? where billId=?");
			ps.setNString(1, getNewdate);
			ps.setNString(2, getNewarrears);
			ps.setNString(3, getNewamount);
			ps.setNString(4, getNewtotalPayble);
			ps.setNString(5, getBillId);
			int i = ps.executeUpdate();

			if (i > 0) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}

	}
	


	public static boolean deleteBillDetails(String getBillId) {

		Connection con = dbConnection.connect();

		try {

			PreparedStatement ps = con.prepareStatement("DELETE FROM bill WHERE billId=?");
			ps.setNString(1, getBillId);
			int i = ps.executeUpdate();

			if (i > 0) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}

	}
	
	public static String viewallBillDao() {

		String output = "";

		try {

		Connection con = dbConnection.connect();


		if (con == null) {
			return "Error while connecting to the database for reading.";

		}

		// Prepare the html table to be displayed
		output = "<table border='1'><tr>"
				+ "<th>User ID</th>"
				+ "<th>Bill ID</th>"
				+ "<th>Date</th>"
				+ "<th>Arrears</th>"
				+ "<th>Amount</th>"
				+ "<th>Total Payble</th>"
				+ "<th>Emp Name</th>"
				+ " </tr>";

		String query = "select * from bill";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);

		while (rs.next()) {
			String userId = rs.getString(1);
			String billId = rs.getString(2);
			String date = rs.getString(3);
			Float arrears = rs.getFloat(4);
			Float amount = rs.getFloat(5);
			Float totalPayble = rs.getFloat(6);
			String empName = rs.getString(7);

			// Add into the html table
			output += "<tr><td>" + userId + "</td>";
			output += "<td>" + billId + "</td>";
			output += "<td>" + date + "</td>";
			output += "<td>" + arrears + "</td>";
			output += "<td>" + amount + "</td>";
			output += "<td>" + totalPayble + "</td>";
			output += "<td>" + empName + "</td>";
	}
		con.close();

		// Complete the html table
		output += "</table>";

	} catch (Exception e) {
		output = "Error while reading the items.";
		System.err.println(e.getMessage());
	}
	return output;

}
	
	public static String viewBillDetails(viewBill rs) {

		String output = "";
		Connection con = dbConnection.connect();

		try {
			
			output = "<table border='1'><tr>"
					+ "<th>User ID</th>"
					+ "<th>Bill ID</th>"
					+ "<th>Date</th>"
					+ "<th>Arrears</th>"
					+ "<th>Amount</th>"
					+ "<th>Total Payble</th>"
					+ "<th>Emp Name</th>"
					+ " </tr>";


			PreparedStatement ps1 = con.prepareStatement("select b.userId, b.billId, b.date, b.arrears, b.amount, b.totalPayble, e.EmpName from bill b, employees e where e.EmpID = b.EmpID and b.billId = ? ");
			ps1.setString(1, rs.getBillId());
			ResultSet rrs = ps1.executeQuery();

			if (rrs.next()) {

											
				String userId = rrs.getString(1);
				String billId = rrs.getString(2);
				String date = rrs.getString(3);
				Float arrears = rrs.getFloat(4);
				Float amount = rrs.getFloat(5);
				Float totalPayble = rrs.getFloat(6);
				String empName = rrs.getString(7);
				
				output += "<tr><td>" + userId + "</td>";
				output += "<td>" + billId + "</td>";
				output += "<td>" + date + "</td>";
				output += "<td>" + arrears + "</td>";
				output += "<td>" + amount + "</td>";
				output += "<td>" + totalPayble + "</td>";
				output += "<td>" + empName + "</td>";


				output += "</table>";
				return "" + output;

			} else {

				return "failed";

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return "fail";

	}

	
	

}
