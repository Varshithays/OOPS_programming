import java.util.*;

class University{
    String uname;
    Map<String,Course2> courses;

    public University(String uname, Map<String, Course2> courses) {
        this.uname = uname;
        this.courses = courses;
    }
}

class Course2 {
    String code;
    String name;
    String instructor;
    Set<String> snames;

    public Course2(String code, String name, String instructor, Set<String> snames) {
        this.code = code;
        this.name = name;
        this.instructor = instructor;
        this.snames = snames;
    }
}

class Serviessol {

    // Method to get courses taught by a specific instructor
    public void getCoursesByInstructor(List<Course2> cl2, String input1) {
        boolean found = false;
        for (Course2 course : cl2) {
            if (course.instructor.equalsIgnoreCase(input1)) {
                found = true;
                System.out.println("Course Name: " + course.name);
                for (String student : course.snames) {
                    System.out.println("Student: " + student);
                }
            }
        }
        if (!found) {
            System.out.println("No courses found for instructor: " + input1);
        }
    }

    // Method to get students enrolled in a specific course by its code
    public void getStudentsEnrolledInCourse(List<Course2> cl2, String input2) {
        boolean found = false;
        for (Course2 course : cl2) {
            if (course.code.equalsIgnoreCase(input2)) {
                found = true;
                System.out.println("Students enrolled in " + course.name + ":");
                for (String student : course.snames) {
                    System.out.println(student);
                }
            }
        }
        if (!found) {
            System.out.println("No students found for course code: " + input2);
        }
    }

    // Method to get the number of students enrolled in each course
    public void getCoursesWithStudentCount(List<Course2> cl2) {
        if (cl2.isEmpty()) {
            System.out.println("No courses available.");
            return;
        }
        System.out.println("Courses with student count:");
        for (Course2 course : cl2) {
            System.out.println("Course: " + course.name + ", Students Enrolled: " + course.snames.size());
        }
    }
}

public class Practice4_ai {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Taking input from user
        System.out.println("Enter number of courses:");
        int numCourses = in.nextInt();
        in.nextLine();  // consume the newline after number input

        // List to hold courses
        List<Course2> coursesList = new java.util.ArrayList<>();

        // Get courses information from the user
        for (int i = 0; i < numCourses; i++) {
            System.out.println("Enter details for course " + (i + 1) + ":");

            System.out.print("Enter course code: ");
            String code = in.nextLine();

            System.out.print("Enter course name: ");
            String name = in.nextLine();

            System.out.print("Enter instructor name: ");
            String instructor = in.nextLine();

            System.out.print("Enter number of students in this course: ");
            int numStudents = in.nextInt();
            in.nextLine();  // consume newline

            Set<String> studentNames = new HashSet<>();
            for (int j = 0; j < numStudents; j++) {
                System.out.print("Enter student name: ");
                String studentName = in.nextLine();
                studentNames.add(studentName);
            }

            Course2 course = new Course2(code, name, instructor, studentNames);
            coursesList.add(course);
        }

        // Using the Serviessol class to interact with courses
        Serviessol service = new Serviessol();

        // Get courses by instructor
        System.out.print("Enter instructor name to search courses: ");
        String instructorInput = in.nextLine();
        service.getCoursesByInstructor(coursesList, instructorInput);

        // Get students enrolled in a course by course code
        System.out.print("Enter course code to get enrolled students: ");
        String courseCodeInput = in.nextLine();
        service.getStudentsEnrolledInCourse(coursesList, courseCodeInput);

        // Get courses with student count
        service.getCoursesWithStudentCount(coursesList);
    }
}
