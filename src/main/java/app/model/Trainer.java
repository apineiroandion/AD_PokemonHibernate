package app.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Trainer {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private int id;
    @Column (name = "nome")
    private String nome;
    @Column (name = "nacemento")
    private Date nacemento;


    public Trainer() {
    }

    public Trainer(String nome, Date nacemento) {
        this.nome = nome;
        this.nacemento = nacemento;
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

    public void setNacementoText(String nacemento) {
        this.nacemento = null;
    }

    @Override
    public String toString() {
        return "Adestrador{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", nacemento=" + nacemento +
                '}';
    }
}

