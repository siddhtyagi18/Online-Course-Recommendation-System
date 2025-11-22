package ui;

import model.Course;
import service.CourseService;
import threads.CourseLoaderThread;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainGUI {

    private CourseService service;

    public MainGUI() {
        service = new CourseService();
        createUI();
    }

    private void createUI() {
        JFrame frame = new JFrame("Online Course Recommendation System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1, 10, 10));

        JButton addBtn = new JButton("Add Course");
        JButton viewBtn = new JButton("View All Courses");
        JButton recBtn = new JButton("Get Recommendations");
        JButton exitBtn = new JButton("Exit");

        addBtn.addActionListener(e -> openAddCourseDialog());
        viewBtn.addActionListener(e -> viewCourses());
        recBtn.addActionListener(e -> getRecommendations());
        exitBtn.addActionListener(e -> System.exit(0));

        panel.add(addBtn);
        panel.add(viewBtn);
        panel.add(recBtn);
        panel.add(exitBtn);

        frame.add(panel);
        frame.setVisible(true);
    }

    // *********************************************
    //            ADD COURSE POPUP
    // *********************************************
    private void openAddCourseDialog() {
        JDialog dialog = new JDialog();
        dialog.setTitle("Add New Course");
        dialog.setSize(400, 400);
        dialog.setLayout(new GridLayout(7, 2, 5, 5));
        dialog.setLocationRelativeTo(null);

        JTextField nameField = new JTextField();
        JTextField categoryField = new JTextField();
        JTextField difficultyField = new JTextField();
        JTextField ratingField = new JTextField();
        JTextField durationField = new JTextField();
        JTextField descField = new JTextField();

        dialog.add(new JLabel("Course Name:"));
        dialog.add(nameField);

        dialog.add(new JLabel("Category:"));
        dialog.add(categoryField);

        dialog.add(new JLabel("Difficulty:"));
        dialog.add(difficultyField);

        dialog.add(new JLabel("Rating:"));
        dialog.add(ratingField);

        dialog.add(new JLabel("Duration Hours:"));
        dialog.add(durationField);

        dialog.add(new JLabel("Description:"));
        dialog.add(descField);

        JButton saveBtn = new JButton("Save");
        saveBtn.addActionListener(e -> {
            try {
                int id = (int) (Math.random() * 10000);
                double rating = Double.parseDouble(ratingField.getText());
                int duration = Integer.parseInt(durationField.getText());

                Course c = new Course(
                        id,
                        nameField.getText(),
                        categoryField.getText(),
                        difficultyField.getText(),
                        rating,
                        duration,
                        descField.getText()
                );

                boolean saved = service.addCourse(c);

                if (saved) {
                    JOptionPane.showMessageDialog(dialog, "Course Added Successfully!");
                    dialog.dispose();
                } else {
                    JOptionPane.showMessageDialog(dialog, "Failed to add course.");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(dialog, "Error: " + ex.getMessage());
            }
        });

        dialog.add(saveBtn);
        dialog.setVisible(true);
    }

    // *********************************************
    //       VIEW ALL COURSES POPUP
    // *********************************************
    private void viewCourses() {
        ArrayList<Course> list = service.getAllCourses();

        if (list.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No courses found.");
            return;
        }

        StringBuilder sb = new StringBuilder();

        for (Course c : list) {
            sb.append("ID: ").append(c.getCourseId())
              .append("\nName: ").append(c.getCourseName())
              .append("\nCategory: ").append(c.getCategory())
              .append("\nDifficulty: ").append(c.getDifficulty())
              .append("\nRating: ").append(c.getRating())
              .append("\nDuration: ").append(c.getDurationHours())
              .append("\nDescription: ").append(c.getDescription())
              .append("\n--------------------------\n");
        }

        JTextArea area = new JTextArea(sb.toString());
        area.setEditable(false);
        JScrollPane pane = new JScrollPane(area);

        JOptionPane.showMessageDialog(null, pane, "All Courses", JOptionPane.INFORMATION_MESSAGE);
    }

    // *********************************************
    //         GET RECOMMENDATIONS
    // *********************************************
    private void getRecommendations() {
        JTextField categoryField = new JTextField();
        JTextField difficultyField = new JTextField();

        Object[] fields = {
                "Category:", categoryField,
                "Difficulty:", difficultyField
        };

        int option = JOptionPane.showConfirmDialog(null, fields, "Course Recommendation", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {

            CourseLoaderThread loader = new CourseLoaderThread();
            loader.start(); // show loading in console

            ArrayList<Course> rec = service.recommendCourses(
                    categoryField.getText(),
                    difficultyField.getText()
            );

            if (rec.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No matching courses found.");
                return;
            }

            StringBuilder sb = new StringBuilder();
            sb.append("Recommended Courses:\n\n");

            for (Course c : rec) {
                sb.append(c.getCourseName())
                        .append("  (Rating: ").append(c.getRating())
                        .append(")\n");
            }

            JOptionPane.showMessageDialog(null, sb.toString());
        }
    }

    public static void main(String[] args) {
        new MainGUI();
    }
}
