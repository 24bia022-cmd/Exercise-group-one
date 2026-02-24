
/**
 * Write a description of class Person here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Person
{
    private String name;
    private String address;
    
    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String toString() {
        return "Person[name=" + name + ", address=" + address + "]";
    }
}
class Student extends Person {
    private String program;
    private int year;
    private double fee;

    public Student(String name, String address, String program, int year, double fee) {
        super(name, address);
        this.program = program;
        this.year = year;
        this.fee = fee;
    }

    public String getProgram() {
        return program;
    }

    public int getYear() {
        return year;
    }

    public double getFee() {
        return fee;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public String toString() {
        return "Student[" + super.toString() +
               ", program=" + program +
               ", year=" + year +
               ", fee=" + fee + "]";
    }
}
class Staff extends Person {
    private String department;
    private double salary;
    
    public Staff(String name, String address, String department, double salary) {
        super(name, address); 
        this.department = department;
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String toString() {
        return "Staff[" + super.toString() +
               ", department=" + department +
               ", salary=" + salary + "]";
    }
}
class Lab2_PersonStudentStaff {
    public static void main(String[] args) {

        Person p1 = new Person("Ali", "Zanzibar");
        Student s1 = new Student("Amina", "Dar es Salaam", "Computer Science", 2, 1500000);
        Staff st1 = new Staff("John", "Arusha", "ICT", 2000000);

        System.out.println(p1);
        System.out.println(s1);
        System.out.println(st1);

        Person[] people = new Person[3];
        people[0] = p1;
        people[1] = s1;
        people[2] = st1;

        int studentCount = 0;
        int staffCount = 0;

        for (Person person : people) {
            if (person instanceof Student) {
                studentCount++;
            }
            if (person instanceof Staff) {
                staffCount++;
            }
        }

        System.out.println("Number of Students: " + studentCount);
        System.out.println("Number of Staff: " + staffCount);
    }
}


