package app.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Pokemon {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private int id;
    @Column (name = "nome")
    private String nome;
    @Column (name = "nacemento")
    private Date nacemento;
    @Column (name = "pokedexentry")
    private int pokedexentry;
    @Column (name = "adestrador")
    private int adestrador;

    public Pokemon() {
    }

    public Pokemon(int id, String nome, Date nacemento, int pokedexentry, int adestrador) {
        this.id = id;
        this.nome = nome;
        this.nacemento = nacemento;
        this.pokedexentry = pokedexentry;
        this.adestrador = adestrador;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getNacemento() {
        return nacemento;
    }

    public void setNacemento(Date nacemento) {
        this.nacemento = nacemento;
    }

    public int getPokedexentry() {
        return pokedexentry;
    }

    public void setPokedexentry(int pokedexentry) {
        this.pokedexentry = pokedexentry;
    }

    public int getAdestrador() {
        return adestrador;
    }

    public void setAdestrador(int adestrador) {
        this.adestrador = adestrador;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", nacemento=" + nacemento +
                ", pokedexentry=" + pokedexentry +
                ", adestrador=" + adestrador +
                '}';
    }
}

