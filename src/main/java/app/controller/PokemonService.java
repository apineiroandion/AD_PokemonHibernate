package app.controller;

import app.model.Pokedex;
import app.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PokemonService {
    public void crearPokemon(Pokedex pokedex) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(pokedex);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error al crear el pokemon: " + e.getMessage());
        }
    }

    public void listarPokemon() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.createQuery("from Pokedex ", Pokedex.class).list().forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Error al listar los pokemons: " + e.getMessage());
        }

    }

    public void eliminarTodosPokemon() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.createQuery("DELETE FROM Pokedex").executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error al eliminar todos los pokemons: " + e.getMessage());
        }
    }

    public void modificarPokemon(int id, String nuevoNombre, double nuevoPeso, String nuevaMisc) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Pokedex pokemon = session.get(Pokedex.class, id);
            if (pokemon != null) {
                pokemon.setNome(nuevoNombre);
                pokemon.setPeso(nuevoPeso);
                pokemon.setMisc(nuevaMisc);
                session.update(pokemon);
                transaction.commit();
            } else {
                System.out.println("Pokemon con id " + id + " no encontrado.");
            }
        } catch (Exception e) {
            System.out.println("Error al modificar el pokemon: " + e.getMessage());
        }
    }
}