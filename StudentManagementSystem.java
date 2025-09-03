import java.util.ArrayList;
import java.util.Scanner;

class Student {
    int id;
    String name;
    int age;

    Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}

public class StudentManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        while (true) {
            System.out.println("\n=== 🎓 Student Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Remove Student");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // clear buffer
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    students.add(new Student(id, name, age));
                    System.out.println("✅ Student Added Successfully!");
                    break;

                case 2:
                    if (students.isEmpty()) {
                        System.out.println("⚠️ No students found!");
                    } else {
                        System.out.println("\n📋 Student List:");
                        for (Student s : students) {
                            System.out.println("ID: " + s.id + " | Name: " + s.name + " | Age: " + s.age);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Student ID to remove: ");
                    int removeId = sc.nextInt();
                    boolean removed = false;
                    for (int i = 0; i < students.size(); i++) {
                        if (students.get(i).id == removeId) {
                            students.remove(i);
                            removed = true;
                            System.out.println("🗑 Student Removed Successfully!");
                            break;
                        }
                    }
                    if (!removed) {
                        System.out.println("❌ Student not found!");
                    }
                    break;

                case 4:
                    System.out.println("👋 Exiting... Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("⚠️ Invalid choice. Try again!");
            }
        }
    }
}
