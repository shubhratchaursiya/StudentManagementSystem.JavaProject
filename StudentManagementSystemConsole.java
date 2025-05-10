import java.util.*;
class Student {
    private String name, rollNo, branch, gender, parentName, studentContact, parentContact, address;
    public Student(String name, String rollNo, String branch, String gender,
                   String parentName, String studentContact, String parentContact, String address) {
        this.name = name;
        this.rollNo = rollNo;
        this.branch = branch;
        this.gender = gender;
        this.parentName = parentName;
        this.studentContact = studentContact;
        this.parentContact = parentContact;
        this.address = address;
    }
    public String getName() { return name; }
    public String getRollNo() { return rollNo; }
    public String getBranch() { return branch; }
    public String getGender() { return gender; }
    public String getParentName() { return parentName; }
    public String getStudentContact() { return studentContact; }
    public String getParentContact() { return parentContact; }
    public String getAddress() { return address; }
    public void display(int index) {
        System.out.println("\n🔹 Student #" + index);
        System.out.println("📛 Name            : " + name);
        System.out.println("🆔 Roll No         : " + rollNo);
        System.out.println("🏫 Branch          : " + branch);
        System.out.println("⚧ Gender          : " + gender);
        System.out.println("👨‍👩 Parent's Name : " + parentName);
        System.out.println("📱 Student Contact : " + studentContact);
        System.out.println("📞 Parent Contact  : " + parentContact);
        System.out.println("🏠 Address         : " + address);
    }
}
public class StudentManagementSystemConsole {
    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<Student> studentList = new ArrayList<>();
    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== Student Management System By Shubhrat Chaursiya =====");
            System.out.println("1. Add Student");
            System.out.println("2. Show All Students");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1 -> addStudent();
                case 2 -> showStudents();
                case 3 -> {
                    System.out.println("👋 Exiting... Goodbye!");
                    System.exit(0);
                }
                default -> System.out.println("❌ Invalid option. Try again!");
            }
        }
    }
    private static void addStudent() {
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Roll No: ");
        String roll = sc.nextLine();
        System.out.print("Branch: ");
        String branch = sc.nextLine();
        System.out.print("Gender: ");
        String gender = sc.nextLine();
        System.out.print("Parent's Name: ");
        String parentName = sc.nextLine();
        System.out.print("Student Contact No: ");
        String studentContact = sc.nextLine();
        System.out.print("Parent Contact No: ");
        String parentContact = sc.nextLine();
        System.out.print("Permanent Address: ");
        String address = sc.nextLine();
        if (name.isEmpty() || roll.isEmpty() || branch.isEmpty() || gender.isEmpty() ||
            parentName.isEmpty() || studentContact.isEmpty() || parentContact.isEmpty() || address.isEmpty()) {
            System.out.println("❗ All fields are required!");
            return;
        }
        Student s = new Student(name, roll, branch, gender, parentName, studentContact, parentContact, address);
        studentList.add(s);
        System.out.println("✅ Student added successfully!");
    }
    private static void showStudents() {
        if (studentList.isEmpty()) {
            System.out.println("📭 No student records available.");
            return;
        }
        studentList.sort(Comparator.comparing(Student::getName));
        int count = 1;
        for (Student s : studentList) {
            s.display(count++);
        }
    }
}