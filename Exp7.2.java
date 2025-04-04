CREATE DATABASE ProductDB;
USE ProductDB;
CREATE TABLE Product (
ProductID INT AUTO_INCREMENT PRIMARY KEY,
ProductName VARCHAR(100) NOT NULL,
Price DECIMAL(10,2) NOT NULL,
Quantity INT NOT NULL
);
IN IDE:
import java.sql.*;
import
java.util.Scanner;
public class CRUDOperations {
public static void main(String[] args) {
Scanner scanner = new
Scanner(System.in);
while (true) {
System.out.println("\n===== Product Management System =====");
System.out.println("1. Insert Product");
System.out.println("2. Read Products");
System.out.println("3. Update Product");
System.out.println("4. Delete Product");
System.out.println("5. Exit");
System.out.print("Choose an option: ");
int choice = scanner.nextInt();
scanner.nextLine();
switch
(choice) {
case 1:
      insertProduct(scanner);
break;
case 2:
readProducts();
break;
case 3:
updateProduct(scanner);
break;
case 4:
deleteProduct(scanner);
break;
case 5:
System.out.println("Exiting...");
scanner.close();
ret
urn;
defau
lt:
System.out.println("Invalid choice! Try again.");
}
}
}
private static void insertProduct(Scanner scanner) {
try (Connection conn = DBConnection.getConnection()) {
System.out.print("Enter Product Name: ");
String name = scanner.nextLine();
System.out.print("Enter Price: ");
double price =
scanner.nextDouble();
System.out.print("Enter Quantity:
"); int quantity = scanner.nextInt();
scanner.nextLine();
String sql = "INSERT INTO Product (ProductName, Price, Quantity)
VALUES (?, ?, ?)";
PreparedStatement pstmt = conn.prepareStatement(sql);
pstmt.setString(1, name);
pstmt.setDouble(2,
price); pstmt.setInt(3,
quantity);
int rowsInserted = pstmt.executeUpdate();
System.out.println(rowsInserted + " product(s) added successfully.");
} catch (Exception e) {
e.printStackTrace();
}
}
private static void readProducts() {
   try (Connection conn = DBConnection.getConnection();
Statement stmt = conn.createStatement()) {
String sql = "SELECT * FROM
Product"; ResultSet rs =
stmt.executeQuery(sql);
System.out.println("\nProduct List:");
while (rs.next()) {
System.out.println(rs.getInt("ProductID") + " | " +
rs.getString("ProductName") + " | $" +
rs.getDouble("Price") + " | " +
rs.getInt("Quantity"));
}
} catch (Exception e) {
e.printStackTrace();
}
}
private static void updateProduct(Scanner scanner) {
try (Connection conn = DBConnection.getConnection()) {
System.out.print("Enter Product ID to update: ");
int productId = scanner.nextInt();
scanner.nextLine();
System.out.print("Enter new Price: ");
double newPrice =
scanner.nextDouble();
System.out.print("Enter new Quantity:
"); int newQuantity =
scanner.nextInt(); scanner.nextLine();
String sql = "UPDATE Product SET Price = ?, Quantity = ? WHERE
ProductID = ?";
PreparedStatement pstmt = conn.prepareStatement(sql);
pstmt.setDouble(1, newPrice);
pstmt.setInt(2,
newQuantity);
pstmt.setInt(3,
productId);
int rowsUpdated = pstmt.executeUpdate();
System.out.println(rowsUpdated + " product(s) updated
successfully.");
} catch (Exception e)
{
   e.printStackTrace();
}
}
private static void deleteProduct(Scanner scanner) {
try (Connection conn = DBConnection.getConnection()) {
System.out.print("Enter Product ID to delete: ");
int productId =
scanner.nextInt();
scanner.nextLine();
String sql = "DELETE FROM Product WHERE ProductID = ?";
PreparedStatement pstmt = conn.prepareStatement(sql);
pstmt.setInt(1, productId);
int rowsDeleted = pstmt.executeUpdate();
System.out.println(rowsDeleted + " product(s) deleted successfully.");
} catch (Exception e) {
e.printStackTrace();
}
}
}
