package project;

import javax.persistence.*;
import java.util.Random;

@Entity
@Table(name = "courses")
public class Courses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "заглавие")
    private String title;
    @Column(name = "продолжительность")
    private double duration;

    private static final String[] titles = new String[] { "Физика", "Химия", "Алгебра", "Сопромат", "Термех", "Биология", "Ин. яз" };
    private static final Random random = new Random();

    public void updateDuration(){
        duration = random.nextDouble(1, 10);
    }

    public void updateTitle(){
        title = titles[random.nextInt(titles.length)];
    }


    public static Courses create(){
        return new Courses(titles[random.nextInt(titles.length)], random.nextDouble(1, 10));
    }

    public Courses(){

    }

    public Courses(int id, String title, double duration) {
        this.id = id;
        this.title = title;
        this.duration = duration;
    }

    public Courses(String title, double duration) {
        this.title = title;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "project.Courses{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", duration=" + duration +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }
}
