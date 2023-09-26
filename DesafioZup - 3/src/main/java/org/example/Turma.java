package org.example;

import org.example.exceptions.PessoaInvalidaException;

import java.util.ArrayList;
import java.util.List;

// Tentando aplicar o padrão de criação de Design Patterns Singleton
public class Turma {
    private static Turma instanciaUnica = null;
    private final List<PessoaImpl> pessoas = new ArrayList<>();

    private Turma() {
    }

    public static Turma getInstancia() {
        if (instanciaUnica == null) {
            instanciaUnica = new Turma();
        }
        return instanciaUnica;
    }

    public List<PessoaImpl> getPessoas() {
        return pessoas;
    }

    public void adicionarPessoa(PessoaImpl pessoa) throws PessoaInvalidaException {
        if (!pessoa.valido()) {
            throw new PessoaInvalidaException("Objeto pessoa inválido");
        } else if (pessoas.stream().anyMatch(it -> it.getId() == pessoa.getId())) {
            throw new PessoaInvalidaException("Objeto pessoa já está atribuído à turma");
        } else {
            pessoas.add(pessoa);
        }
    }

    public void removerPessoaPorId(int id) {
        pessoas.removeIf(pessoa -> pessoa.getId() == id);
    }


    public PessoaImpl buscarPessoaPorId(int id) {
        return pessoas.stream()
                .filter(pessoa -> pessoa.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<PessoaImpl> listarTodasPessoas() {
        return new ArrayList<>(pessoas);
    }

    public void removerTodasPessoas() {
        pessoas.clear();
    }
}