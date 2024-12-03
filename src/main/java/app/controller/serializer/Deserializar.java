package app.controller.serializer;

import app.model.Pokedex;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Deserializar {
    public static Pokedex deserializePokedex(String ruta) {
        try {
            FileInputStream fileIn = new FileInputStream(ruta);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Pokedex pokedex = (Pokedex) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Deserialized data is saved in " + ruta);
            return pokedex;
        } catch (IOException i) {
            System.out.println("Error al deserializar " + i.getMessage());
            return null;
        } catch (ClassNotFoundException c) {
            System.out.println("Pokedex class not found " + c.getMessage());
            return null;
        }
    }

    public static ArrayList<Pokedex> deserializePokedexList(String ruta) {
        try {
            FileInputStream fileIn = new FileInputStream(ruta);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            ArrayList<Pokedex> pokedex = (ArrayList<Pokedex>) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Deserialized data is saved in " + ruta);
            return pokedex;
        } catch (IOException i) {
            System.out.println("Error al deserializar " + i.getMessage());
            return null;
        } catch (ClassNotFoundException c) {
            System.out.println("Pokedex class not found " + c.getMessage());
            return null;
        }
    }
}
