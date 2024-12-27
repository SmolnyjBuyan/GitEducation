package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class DataBase {
    private SessionFactory sessionFactory;

    public DataBase() {
        sessionFactory = setUp();
    }

    private static SessionFactory setUp() {
        // A SessionFactory is set up once for an application!
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        try {
            return new MetadataSources(registry)
                    .buildMetadata()
                    .buildSessionFactory();
        }
        catch (Exception e) {
            // The registry would be destroyed by the SessionFactory, but we
            // had trouble building the SessionFactory so destroy it manually.
            System.out.println(e.getMessage());
            StandardServiceRegistryBuilder.destroy(registry);
            return null;
        }
    }

    public void create(Course course) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(course);
            session.getTransaction().commit();
        }
    }

    public List<Course> getCourses() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("SELECT c FROM Course c", Course.class).list();
        }
    }

    public Course getCourseById(long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Course.class, id);
        }
    }

    public void update(Course course) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(course);
            session.getTransaction().commit();
        }
    }

    public void remove(Course course) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.remove(course);
            session.getTransaction().commit();
        } catch (IllegalArgumentException e) {
            System.out.println("Null object to delete");
        }
    }

}
