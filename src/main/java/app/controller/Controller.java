package app.controller;

import app.model.Pokedex;

import java.util.ArrayList;

public class Controller {

    String nombresPokemon[] = {"Dragapult", "Mymikyu", "Talonflame", "Lunala", "Glimora", "Umbreon", "Ceruledge", "Pikachu", "Rayquaza", "Type: Null"};
    double peso[] = {110, 0.7, 24.5, 120, 0.1, 27, 0.5, 6, 206.5, 120.5};
    String misc[] = {"Pokemon dragón", "Pokemon fantasma", "Pokemon fuego", "Pokemon psíquico", "Pokemon hada", "Pokemon siniestro", "Pokemon eléctrico", "Pokemon volador", "Pokemon dragón", "Pokemon normal"};

    PokemonService pokemonService = new PokemonService();

    public void crearPokemon(){
        for (int i = 0; i < nombresPokemon.length; i++) {
            Pokedex pokemon = new Pokedex(nombresPokemon[i], peso[i], misc[i]);
            pokemonService.crearPokemon(pokemon);
        }
    }

    public void iniciarApp(){
        crearPokemon();
        pokemonService.listarPokemon();
        pokemonService.modificarPokemon(1, "Mymikyu", 0.8, "Pokemon fantasma");
        pokemonService.listarPokemon();
        pokemonService.eliminarTodosPokemon();
        pokemonService.listarPokemon();



    }
}
