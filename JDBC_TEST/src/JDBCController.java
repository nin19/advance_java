import java.sql.*;

public class JDBCController {

    String url;
    String username;
    String password;
    Connection conn;

    JDBCController(String url, String username, String password) {
        this.url = url;
        this.password = password;
        this.username = username;

        // Step 1 : Load and register driver
        // Step 2 : Establish connection between java program and database with help of
        // DriverManager
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException se) {
            System.out.println("SQL Exception occured");
            se.printStackTrace();
        }
    }

    void displayEmployees() {
        String sql = "SELECT * FROM Employee";
        try {
            Statement st = conn.createStatement();
            ResultSet res = st.executeQuery(sql);

            while (res.next()) {
                System.out.println(
                        res.getInt(1) + "\t" + res.getString(2) + "\t" + res.getInt(3) + "\t" + res.getString(4));
            }
        } catch (SQLException se) {
            System.out.println("SQL EXCEPTION AT DISPEMP");
        }
    }

    boolean deleteEmployee(int id) {
        String sql = "DELETE FROM Employee WHERE employee_id = ?";
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, id);
            int ret = st.executeUpdate();
            if (ret == 0) {
                return false;
            } else {
                return true;
            }
        } catch (SQLException se) {
            System.out.println("EXCEPTION AT DELETE EMP");
        }

        return true;
    }

    boolean updateEmployee(Employee emp) {
        String sql = "UPDATE Employee SET employee_name = ? , employee_salary = ? , employee_dept = ? WHERE employee_id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, emp.name);
            ps.setInt(2, emp.sal);
            ps.setString(3, emp.dept);
            ps.setInt(4, emp.id);

            int ret = ps.executeUpdate();
            if (ret == 0) {
                return false;
            }
        } catch (SQLException se) {
            System.out.println("EXCEPTION AT UPDATEEMPL");
        }
        return true;
    }

    boolean insertEmployee(Employee emp) {
        String sql = "INSERT INTO Employee (employee_name,employee_salary,employee_dept) VALUES(,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, emp.name);
            ps.setInt(2, emp.sal);
            ps.setString(3, emp.dept);

            int ret = ps.executeUpdate();
            return ret > 0;
        } catch (SQLException se) {
            System.out.println("EXCEPTION AT INSERT");
        }
        return true;
    }

}
