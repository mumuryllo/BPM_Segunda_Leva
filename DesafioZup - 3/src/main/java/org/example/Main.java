package org.example;
import org.example.exceptions.PessoaInvalidaException;
public class Main {

    public static void main(String[] args) {
        Turma turma = Turma.getInstancia();

        PessoaImpl pessoa1 = new PessoaImpl(1, "Fulano");
        PessoaImpl pessoa2 = new PessoaImpl(2, "Beltrano");
        PessoaImpl pessoa3 = new PessoaImpl(3, "Ciclano");

        try {
            turma.adicionarPessoa(pessoa1);
            turma.adicionarPessoa(pessoa2);
            turma.adicionarPessoa(pessoa3);
        } catch (PessoaInvalidaException e) {
            System.out.println("Erro ao adicionar pessoa na turma: " + e.getMessage());
        }
        System.out.println(turma.buscarPessoaPorId(1));
        System.out.println("Número de pessoas na turma: " + turma.getPessoas().size());
        System.out.println(turma.listarTodasPessoas());
        turma.removerPessoaPorId(3);
        System.out.println(turma.listarTodasPessoas());
        turma.removerTodasPessoas();
        System.out.println("Número de pessoas na turma: " + turma.getPessoas().size());
    }
}