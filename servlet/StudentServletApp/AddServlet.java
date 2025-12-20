import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class AddServlet extends HttpServlet {

private static final String DB_URL =
"jdbc:mysql://localhost:3306/online_courses?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

private static final String DB_USER = "student";
private static final String DB_PASS = "student123";

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String category = request.getParameter("category");
        String difficulty = request.getParameter("difficulty");
        String ratingStr = request.getParameter("rating");
        String durationStr = request.getParameter("duration");
        String description = request.getParameter("description");

        // ---------- VALIDATION ----------
        if (name == null || category == null || difficulty == null ||
            ratingStr == null || durationStr == null ||
            name.isEmpty() || category.isEmpty() || difficulty.isEmpty()) {

            out.println("<h3>Error: All fields are required</h3>");
            return;
        }

        double rating;
        int duration;

        try {
            rating = Double.parseDouble(ratingStr);
            duration = Integer.parseInt(durationStr);
        } catch (NumberFormatException e) {
            out.println("<h3>Error: Invalid number format</h3>");
            return;
        }

        if (rating < 0 || rating > 5) {
            out.println("<h3>Error: Rating must be between 0 and 5</h3>");
            return;
        }

        if (duration <= 0) {
            out.println("<h3>Error: Duration must be greater than 0</h3>");
            return;
        }

        // ---------- JDBC ----------
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {

            String sql = "INSERT INTO courses (name, category, difficulty, rating, duration, description) " +
                         "VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, category);
            ps.setString(3, difficulty);
            ps.setDouble(4, rating);
            ps.setInt(5, duration);
            ps.setString(6, description);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                out.println("<h2>Course added successfully</h2>");
            } else {
                out.println("<h3>Failed to add course</h3>");
            }

        } catch (SQLException e) {
            out.println("<h3>Database Error:</h3>");
            out.println(e.getMessage());
        }
    }
}
