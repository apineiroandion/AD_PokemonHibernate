package app.controller;

import app.model.Trainer;
import app.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;

public class TrainerService {

    public int getTrainerID(String nome) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Trainer trainer = session.createQuery("from Trainer where nome = :nome", Trainer.class)
                    .setParameter("nome", nome)
                    .uniqueResult();
            if (trainer != null) {
                return trainer.getId();
            } else {
                return -1;
            }
        } catch (Exception e) {
            System.out.println("Error al buscar el trainer: " + e.getMessage());
            return -1;
        }
    }

    public void createTrainer(Trainer trainer) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(trainer);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error al crear trainer: " + e.getMessage());
        }
    }

    public void readTrainer() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.createQuery("from Trainer ", Trainer.class).list().forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Error al listar los trainers: " + e.getMessage());
        }
    }

    public void updateTrainer(int id, String newNome, Date newNacemento) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            Trainer trainer = session.get(Trainer.class, id);
            if (trainer != null) {
                trainer.setNome(newNome);
                trainer.setNacemento(newNacemento);
                session.update(trainer);
                transaction.commit();
            } else {
                System.out.println("Trainer with id " + id + " not found.");
            }
        }
    }

    public void deleteAllTrainers() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.createQuery("DELETE FROM Trainer").executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error al eliminar todos los trainers: " + e.getMessage());
        }
    }
}
