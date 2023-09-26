package org.example;

import org.example.interfaces.Pessoa;

public class PessoaImpl implements Pessoa {
    private final int id;
    private final String nome;

    public PessoaImpl(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public boolean valido() {
        return this.id > 0 && !this.nome.isEmpty();
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}

