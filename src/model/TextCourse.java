package model;

public class TextCourse extends Course {
    private String contentFormat;

    public TextCourse(int courseId, String courseName, String category, String difficulty,
                      double rating, int durationHours, String description, String contentFormat) {
        super(courseId, courseName, category, difficulty, rating, durationHours, description);
        this.contentFormat = contentFormat;
    }

    public String getContentFormat() { return contentFormat; }
    public void setContentFormat(String contentFormat) { this.contentFormat = contentFormat; }
}
