package app.controller;

import app.controller.toXml.XmlReader;
import app.controller.toXml.XmlWritter;
import app.model.Pokedex;
import app.model.Pokemon;
import app.model.Trainer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Controller {

    String nombresPokemon[] = {"Dragapult", "Mymikyu", "Talonflame", "Lunala", "Glimora", "Umbreon", "Ceruledge", "Pikachu", "Rayquaza", "Type: Null"};
    double peso[] = {110, 0.7, 24.5, 120, 0.1, 27, 0.5, 6, 206.5, 120.5};
    String misc[] = {"Pokemon dragón", "Pokemon fantasma", "Pokemon fuego", "Pokemon psíquico", "Pokemon hada", "Pokemon siniestro", "Pokemon eléctrico", "Pokemon volador", "Pokemon dragón", "Pokemon normal"};

    PokedexService pokedexService = new PokedexService();
    TrainerService trainerService = new TrainerService();
    PokemonService pokemonService = new PokemonService();
    XmlReader xmlReader = new XmlReader();

    public void crearPokemon(){
        for (int i = 0; i < nombresPokemon.length; i++) {
            Pokedex pokedex = new Pokedex(nombresPokemon[i], peso[i], misc[i]);
            pokedexService.crearPokemon(pokedex);
        }
    }

    public void crearTrainer(){
        Trainer trainer = new Trainer("Red", null);
        Trainer trainer2 = new Trainer("Blue", null);
        trainerService.createTrainer(trainer);
        trainerService.createTrainer(trainer2);
    }

    public void crearEquipos(){
        for (int i = 0; i < 6; i++) {
            pokemonService.addPokemon(new Pokemon(nombresPokemon[i],
                    null,
                    pokedexService.getPokedexId(nombresPokemon[i]),
                    trainerService.getTrainerID("Red")));
        }
        for (int i = 4; i < 10; i++) {
            pokemonService.addPokemon(new Pokemon(nombresPokemon[i],
                    null,
                    pokedexService.getPokedexId(nombresPokemon[i]),
                    trainerService.getTrainerID("Blue")));
        }
    }

    public void updateTrainers(ArrayList<Trainer> trainers){
        for (Trainer trainer : trainers) {
            trainerService.updateTrainer(trainer.getId(), trainer.getNome(), null);
            System.out.println("Trainer " + trainer.getNome() + " creado.");
        }

    }

    public void iniciarApp(){
        //crearPokemon();
        //pokedexService.listarPokemon();
        //pokedexService.modificarPokemon(1, "Mymikyu", 0.8, "Pokemon fantasma");
        //pokedexService.listarPokemon();
        //pokedexService.eliminarTodosPokemon();
        trainerService.deleteAllTrainers();
        crearTrainer();
        //crearEquipos();
        System.out.println("Trainers:");
        trainerService.readTrainer();
        System.out.println("Pokemons:");
        pokedexService.listarPokemon();
        System.out.println("Equipos Pokemon:");
        pokemonService.readPokemon();

        XmlWritter.escribirXML(trainerService.getTrainers());
        trainerService.updateTrainer(trainerService.getTrainerID("Red"), "RedUpdated", null);
        System.out.println("Trainers:");
        trainerService.readTrainer();
        ArrayList<Trainer> trainers = xmlReader.readXML();
        System.out.println("for:");
        for (Trainer trainer : trainers) {
            System.out.println(trainer + "dentro for");
        }
        updateTrainers(trainers);
        System.out.println("Trainers:");
        trainerService.readTrainer();



    }
}
