package app.controller.serializer;

import app.model.Pokedex;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Serializar {
    public static void serializePokedex(ArrayList<Pokedex> pokedex, String ruta) {
        try {
            FileOutputStream fileOut = new FileOutputStream(ruta);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(pokedex);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in " + ruta);
        } catch (IOException i) {
            System.out.println("Error al serializar " + i.getMessage());
        }
    }
}
