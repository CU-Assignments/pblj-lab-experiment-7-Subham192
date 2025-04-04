CREATE DATABASE EmployeeDB;
USE EmployeeDB;
CREATE TABLE Employee (
EmpID INT PRIMARY KEY
AUTO_INCREMENT, Name VARCHAR(100)
NOT NULL,
Salary DECIMAL(10,2) NOT NULL
);
INSERT INTO Employee (Name, Salary) VALUES
('PRINCE', 50000.00),
('SKY', 60000.00),
('SUKHU', 70000.00);
SELECT * FROM Employee;
IN IDE
package src;
import
java.sql.*;
public class EmployeeDB {
public static void main(String[] args) {
String url = "jdbc:mysql://localhost:3306/EmployeeDB";
String user = "root";
String password =
"50125"; try {
Class.forName("com.mysql.cj.jdbc.Driver");
Connection conn = DriverManager.getConnection(url, user, password);
System.out.println("Connected to MySQL!");
String query = "SELECT * FROM Employee";
Statement stmt =
conn.createStatement(); ResultSet rs =
stmt.executeQuery(query);
System.out.println("Employee Data:");
while (rs.next())
{
int empID = rs.getInt("EmpID");
String name =
rs.getString("Name");
double salary = rs.getDouble("Salary");
   System.out.println(empID + " | " + name + " | $" + salary);
}
rs.close();
stmt.close();
conn.close();
System.out.println("Connection
closed.");
} catch (Exception e) {
e.printStackTrace();
}
}
}

