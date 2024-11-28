package app.controller;

import app.model.Pokedex;
import app.model.Pokemon;
import app.model.Trainer;
import app.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;

public class PokemonService {
    public void addPokemon(Pokemon pokemon) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(pokemon);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error al añadir el pokemon al entrenador: " + e.getMessage());

        }
    }

    public void readPokemon() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.createQuery("from Pokemon ", Pokemon.class).list().forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Error al listar los pokemons: " + e.getMessage());
        }
    }

    public void updatePokemon(int id, String newNome, Date newNacemento, int newPokedexentry, int newAdestrador) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            Pokemon pokemon = session.get(Pokemon.class, id);
            if (pokemon != null) {
                pokemon.setNome(newNome);
                pokemon.setNacemento(newNacemento);
                pokemon.setPokedexentry(newPokedexentry);
                pokemon.setAdestrador(newAdestrador);
                session.update(pokemon);
                transaction.commit();
            } else {
                System.out.println("Pokemon con id " + id + " no encontrado.");
            }
        }

    }

    public void deletePokemon() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.createQuery("DELETE FROM Pokemon").executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error al eliminar todos los pokemons: " + e.getMessage());
        }
    }

}
