package model;

public class Course {
    private int courseId;
    private String courseName;
    private String category;
    private String difficulty;
    private double rating;
    private int durationHours;
    private String description;

    // ------ Constructor ------
    public Course(int courseId, String courseName, String category, String difficulty,
                  double rating, int durationHours, String description) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.category = category;
        this.difficulty = difficulty;
        this.rating = rating;
        this.durationHours = durationHours;
        this.description = description;
    }

    // ------ Getters ------
    public int getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCategory() {
        return category;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public double getRating() {
        return rating;
    }

    public int getDurationHours() {
        return durationHours;
    }

    public String getDescription() {
        return description;
    }

    // ------ For Polymorphism / Debugging ------
    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", category='" + category + '\'' +
                ", difficulty='" + difficulty + '\'' +
                ", rating=" + rating +
                ", durationHours=" + durationHours +
                ", description='" + description + '\'' +
                '}';
    }
}
