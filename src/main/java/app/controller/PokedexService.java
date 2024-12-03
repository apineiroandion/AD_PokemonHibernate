package app.controller;

import app.model.Pokedex;
import app.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class PokedexService {

    public int getPokedexId(String nome){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Pokedex pokedex = session.createQuery("from Pokedex where nome = :nome", Pokedex.class)
                    .setParameter("nome", nome)
                    .uniqueResult();
            if (pokedex != null) {
                return pokedex.getId();
            }
        } catch (Exception e) {
            System.out.println("Error al obtener el id del pokemon: " + e.getMessage());
        }
        return -1;
    }

    public ArrayList<Pokedex> getPokedex() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return (ArrayList<Pokedex>) session.createQuery("from Pokedex", Pokedex.class).list();
        } catch (Exception e) {
            System.out.println("Error al obtener los pokemons: " + e.getMessage());
        }
        return null;
    }

    public void setPokedex(ArrayList<Pokedex> pokedex) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            pokedex.forEach(session::save);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error al guardar los pokemons: " + e.getMessage());
        }
    }

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
