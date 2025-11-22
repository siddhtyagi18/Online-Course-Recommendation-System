src/
 ├── model/
 │    ├── Course.java
 │    ├── ProgrammingCourse.java
 │    ├── NonTechnicalCourse.java
 │    ├── TextCourse.java
 │    └── VideoCourse.java
 │
 ├── database/
 │    └── CourseDAO.java
 │
 ├── service/
 │    └── CourseService.java
 │
 ├── threads/
 │    └── CourseLoaderThread.java
 │
 ├── exceptions/
 │    └── CourseNotFoundException.java
 │
 ├── ui/
 │    └── MainGUI.java
 │
 └── Main.java
✅ 1. Course Recommendation
User selects a category (Programming, Data Science, Web Development, etc.)
Recommended courses are displayed in the GUI.

✅ 2. Complete OOP Implementation
Inheritance: All courses extend a base Course class.
Polymorphism: Method overriding for displaying details.
Interfaces: Course categories implemented using interfaces.
Abstraction & Encapsulation: Clean modular code architecture.
Custom Exceptions: Input validation + error handling.

✅ 3. JDBC Database Integration
MySQL database coursedb
Table: courseusers
Fields: id, name, email, interest
DAO classes for DB operations (insert/select)

✅ 4. Multithreading
Background thread:
CourseLoaderThread → Displays loading animation while fetching recommendations.

✅ 5. Modern GUI
Clean Swing GUI (MainGUI.java)
Dropdown category selection
Dynamic result display area
Messages for DB success/failure

Author:-
Siddh Tyagi
B.Tech CSE (Data Science), Galgotias University
