package database;

import model.Course;
import java.sql.*;
import java.util.ArrayList;

public class CourseDAO {

    public boolean addCourse(Course course) {
        String sql = "INSERT INTO courses (name, category, difficulty, rating, duration, description) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, course.getCourseName());
            stmt.setString(2, course.getCategory());
            stmt.setString(3, course.getDifficulty());
            stmt.setDouble(4, course.getRating());
            stmt.setInt(5, course.getDurationHours());
            stmt.setString(6, course.getDescription());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<Course> getAllCourses() {
        ArrayList<Course> courses = new ArrayList<>();
        String sql = "SELECT * FROM courses";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Course c = new Course(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("category"),
                        rs.getString("difficulty"),
                        rs.getDouble("rating"),
                        rs.getInt("duration"),
                        rs.getString("description")
                );
                courses.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }
}
