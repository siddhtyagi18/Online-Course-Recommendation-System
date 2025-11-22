📚 Online Course Recommendation System

A Java-based project implementing OOPs, Collections, JDBC, DAO Pattern, Swing GUI, and Multithreading for recommending courses based on user preferences.

🚀 Features
✅ Object-Oriented Programming

Inheritance (Course → ProgrammingCourse / NonTechnicalCourse)

Polymorphism (Course reference, subclass objects)

Encapsulation (private fields + getters)

Exception Handling (custom exception)

✅ Collections & Generics

ArrayList<Course> used for storing and displaying courses

Generic DAO & Service layers

✅ Multithreading

Background loading using a custom thread: CourseLoaderThread

✅ Database (JDBC + MySQL)

DBConnection.java for MySQL connectivity

CourseDAO.java performs CRUD operations

Uses PreparedStatement, ResultSet, DAO design pattern

✅ Swing-Based GUI

Add a new course

View all courses

Get recommended courses

Smooth UI interaction

🗂️ Project Structure
Online-Course-Recommendation-System/
│
├── src/
│   ├── model/
│   │   ├── Course.java
│   │   ├── ProgrammingCourse.java
│   │   ├── NonTechnicalCourse.java
│   │
│   ├── service/
│   │   └── CourseService.java
│   │
│   ├── database/
│   │   ├── CourseDAO.java
│   │   └── DBConnection.java
│   │
│   ├── exceptions/
│   │   └── InvalidInputException.java
│   │
│   ├── threads/
│   │   └── CourseLoaderThread.java
│   │
│   ├── ui/
│       └── MainGUI.java
│
├── lib/ (JDBC driver)
│
├── bin/ (compiled classes)
│
└── README.md

🛢️ Database Setup (MySQL)

Create database:

CREATE DATABASE online_courses;


Create table:

CREATE TABLE courses (
    id INT PRIMARY KEY,
    name VARCHAR(255),
    category VARCHAR(100),
    difficulty VARCHAR(50),
    rating DOUBLE,
    duration INT,
    description TEXT
);

⚙️ How to Compile & Run
Compile
javac -d bin -cp "bin;lib/*" src\**\*.java

Run
cd bin
java ui.MainGUI

🧵 Multithreading Example

CourseLoaderThread runs during recommendations:

for (int i = 1; i <= 5; i++) {
    System.out.println("Loading recommended courses... " + i);
    Thread.sleep(500);
}
