package service;

import database.CourseDAO;
import model.Course;
import java.util.ArrayList;

public class CourseService {
    private CourseDAO dao;

    public CourseService() {
        dao = new CourseDAO();
    }

    public boolean addCourse(Course c) {
        return dao.addCourse(c);
    }

    public ArrayList<Course> getAllCourses() {
        return dao.getAllCourses();
    }

    public ArrayList<Course> recommendCourses(String category, String difficulty) {
        ArrayList<Course> recommended = new ArrayList<>();
        for (Course c : dao.getAllCourses()) {
            if (c.getCategory().equalsIgnoreCase(category) &&
                c.getDifficulty().equalsIgnoreCase(difficulty)) {
                recommended.add(c);
            }
        }
        return recommended;
    }
}
