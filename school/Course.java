package school;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Course {
    @Id
    private int id;
    private String title;
    private int creditHours;

    // Constructors
    public Course() {}

    public Course(int id, String title, int creditHours) {
        this.id = id;
        this.title = title;
        this.creditHours = creditHours;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public void setCreditHours(int creditHours) {
        this.creditHours = creditHours;
    }

    @Override
    public String toString() {
        return "Course [ID=" + id + ", Title=" + title + ", Credit Hours=" + creditHours + "]";
    }
}
