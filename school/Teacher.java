package school;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Teacher {
    @Id
    private int id;
    private String name;
    private String subject;

    // Constructors
    public Teacher() {}

    public Teacher(int id, String name, String subject) {
        this.id = id;
        this.name = name;
        this.subject = subject;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Teacher [ID=" + id + ", Name=" + name + ", Subject=" + subject + "]";
    }
}
