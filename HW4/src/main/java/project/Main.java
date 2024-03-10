package project;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Main {
    /**
     * Задание
     * =======
     * Создайте базу данных (например, SchoolDB).
     * В этой базе данных создайте таблицу project.Courses с полями id (ключ), title, и duration.
     * Настройте Hibernate для работы с вашей базой данных.
     * Создайте Java-класс Course, соответствующий таблице project.Courses, с необходимыми аннотациями Hibernate.
     * Используя Hibernate, напишите код для вставки, чтения, обновления и удаления данных в таблице project.Courses.
     * Убедитесь, что каждая операция выполняется в отдельной транзакции.
     */
    public static void main(String[] args) {


        try(SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Courses.class)
                .buildSessionFactory()){

            // Создание сессии
            Session session = sessionFactory.getCurrentSession();

            // Начало транзакции
            session.beginTransaction();

            // Создание объекта
            Courses courses = Courses.create();
            session.save(courses);

            System.out.println("Object courses save successfully");

            // Чтение объекта из базы данных
            Courses retrievedCourses = session.get(Courses.class, courses.getId());

            System.out.println("Object courses retrieved successfully");
//            System.out.println("Retrieved courses object: " + retrievedCourses);

            // Обновление объекта
            retrievedCourses.updateTitle();

            retrievedCourses.updateDuration();

            session.update(retrievedCourses);
            System.out.println("Object courses update successfully");


            session.delete(courses);
            System.out.println("Object courses delete successfully");


            session.getTransaction().commit();

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


}

