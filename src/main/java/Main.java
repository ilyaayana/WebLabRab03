
import managers.CourseManager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class Main {

    static CourseManager courseManager;
    static Scanner scanner;


    public static void main(String[] args){
        courseManager = new CourseManager();
        scanner = new Scanner(System.in);
        int choice = 0;
        do {
            printMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            String courseName,studentName;
            switch (choice) {
                case 1:
                    handlePrintNumberOfStudentsCourse();
                    break;
                case 2:
                    handlePrintTeachersWithMultipleCourses();
                    break;
                case 3:
                    handlePrintStudentsGrades();
                    break;
                case 4:
                    handleOpenNewCourse();
                    break;
                case 5:
                    handlePrintAllCoursesInfo();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 0);
    }

    private static void handlePrintNumberOfStudentsCourse() {
        System.out.print("Enter the course name: ");
        String courseName = scanner.nextLine();
        courseManager.printNumberOfStudentsCourse(courseName);
    }

    private static void handlePrintTeachersWithMultipleCourses() {
        courseManager.printTeachersWithMultipleCourses();
    }

    private static void handlePrintStudentsGrades() {
        System.out.print("Enter the student name: ");
        String studentName = scanner.nextLine();
        courseManager.printStudentsGrades(studentName);
    }

    private static void handleOpenNewCourse() {
        System.out.print("Enter the course name: ");
        String courseName = scanner.nextLine();
        System.out.print("Enter teacher name: ");
        String teacherName = scanner.nextLine();
        System.out.print("Enter the start date (yyyy-MM-dd): ");
        String startDateStr = scanner.nextLine();

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date startDate = dateFormat.parse(startDateStr);
            courseManager.openNewCourse(courseName, teacherName, startDate);
            System.out.println("New course opened successfully.");
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please try again.");
        }
    }

    private static void handlePrintAllCoursesInfo() {
        courseManager.printAllCoursesInfo();
    }

    private static void printMenu() {
        System.out.println("\nThe options are:");
        System.out.println("1. Count students on a course");
        System.out.println("2. List teachers with multiple courses");
        System.out.println("3. Get student grades");
        System.out.println("4. Open a new course");
        System.out.println("5. List all courses");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }
}