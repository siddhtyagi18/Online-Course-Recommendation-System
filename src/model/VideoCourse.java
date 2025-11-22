package model;

public class VideoCourse extends Course {
    private String videoQuality;
    private int numberOfVideos;

    public VideoCourse(int courseId, String courseName, String category, String difficulty,
                       double rating, int durationHours, String description,
                       String videoQuality, int numberOfVideos) {
        super(courseId, courseName, category, difficulty, rating, durationHours, description);
        this.videoQuality = videoQuality;
        this.numberOfVideos = numberOfVideos;
    }

    public String getVideoQuality() { return videoQuality; }
    public void setVideoQuality(String videoQuality) { this.videoQuality = videoQuality; }
    public int getNumberOfVideos() { return numberOfVideos; }
    public void setNumberOfVideos(int numberOfVideos) { this.numberOfVideos = numberOfVideos; }
}
