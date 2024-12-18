package school;

import javax.persistence.*;
import java.util.List;

public class SchoolApp {
    private static final String PERSISTENCE_UNIT_NAME = "school";
    private static EntityManagerFactory factory;

    public static void main(String[] args) {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        SchoolApp app = new SchoolApp();

        // Create Students, Teachers, and Courses
        app.createStudent(1, "Alice Johnson", 20);
        app.createTeacher(1, "Mr. Smith", "Mathematics");
        app.createCourse(1, "Calculus", 4);

        // Read all records
        app.readAllStudents();
        app.readAllTeachers();
        app.readAllCourses();

        // Update records
        app.updateStudent(1, "Alice Cooper", 21);
        app.updateTeacher(1, "Mr. John Smith", "Physics");
        app.updateCourse(1, "Advanced Calculus", 5);

        // Delete records
        app.deleteStudent(1);
        app.deleteTeacher(1);
        app.deleteCourse(1);
    }

    // Create a new Student
    public void createStudent(int id, String name, int age) {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Student student = new Student(id, name, age);
        em.persist(student);

        em.getTransaction().commit();
        em.close();
        System.out.println("Student created: " + student);
    }

    // Create a new Teacher
    public void createTeacher(int id, String name, String subject) {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Teacher teacher = new Teacher(id, name, subject);
        em.persist(teacher);

        em.getTransaction().commit();
        em.close();
        System.out.println("Teacher created: " + teacher);
    }

    // Create a new Course
    public void createCourse(int id, String title, int creditHours) {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Course course = new Course(id, title, creditHours);
        em.persist(course);

        em.getTransaction().commit();
        em.close();
        System.out.println("Course created: " + course);
    }

    // Read all Students
    public void readAllStudents() {
        EntityManager em = factory.createEntityManager();
        TypedQuery<Student> query = em.createQuery("SELECT s FROM Student s", Student.class);
        List<Student> students = query.getResultList();

        System.out.println("All Students:");
        for (Student s : students) {
            System.out.println(s);
        }

        em.close();
    }

    // Read all Teachers
    public void readAllTeachers() {
        EntityManager em = factory.createEntityManager();
        TypedQuery<Teacher> query = em.createQuery("SELECT t FROM Teacher t", Teacher.class);
        List<Teacher> teachers = query.getResultList();

        System.out.println("All Teachers:");
        for (Teacher t : teachers) {
            System.out.println(t);
        }

        em.close();
    }

    // Read all Courses
    public void readAllCourses() {
        EntityManager em = factory.createEntityManager();
        TypedQuery<Course> query = em.createQuery("SELECT c FROM Course c", Course.class);
        List<Course> courses = query.getResultList();

        System.out.println("All Courses:");
        for (Course c : courses) {
            System.out.println(c);
        }

        em.close();
    }

    // Update a Student
    public void updateStudent(int id, String newName, int newAge) {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Student student = em.find(Student.class, id);
        if (student != null) {
            student.setName(newName);
            student.setAge(newAge);
            em.merge(student);
            System.out.println("Student updated: " + student);
        }

        em.getTransaction().commit();
        em.close();
    }

    // Update a Teacher
    public void updateTeacher(int id, String newName, String newSubject) {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Teacher teacher = em.find(Teacher.class, id);
        if (teacher != null) {
            teacher.setName(newName);
            teacher.setSubject(newSubject);
            em.merge(teacher);
            System.out.println("Teacher updated: " + teacher);
        }

        em.getTransaction().commit();
        em.close();
    }

    // Update a Course
    public void updateCourse(int id, String newTitle, int newCreditHours) {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Course course = em.find(Course.class, id);
        if (course != null) {
            course.setTitle(newTitle);
            course.setCreditHours(newCreditHours);
            em.merge(course);
            System.out.println("Course updated: " + course);
        }

        em.getTransaction().commit();
        em.close();
    }

    // Delete a Student by ID
    public void deleteStudent(int id) {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Student student = em.find(Student.class, id);
        if (student != null) {
            em.remove(student);
            System.out.println("Student with ID " + id + " deleted.");
        }

        em.getTransaction().commit();
        em.close();
    }

    // Delete a Teacher by ID
    public void deleteTeacher(int id) {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Teacher teacher = em.find(Teacher.class, id);
        if (teacher != null) {
            em.remove(teacher);
            System.out.println("Teacher with ID " + id + " deleted.");
        }

        em.getTransaction().commit();
        em.close();
    }

    // Delete a Course by ID
    public void deleteCourse(int id) {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Course course = em.find(Course.class, id
