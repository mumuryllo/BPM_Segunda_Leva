package org.example.testes;

import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import org.example.Turma;
import org.example.PessoaImpl;
import org.example.exceptions.PessoaInvalidaException;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TurmaTest {
    private Turma turma;

    @BeforeEach
    public void setUp() {
        turma = Turma.getInstancia();
        turma.removerTodasPessoas();
    }

    @Test
    public void testAdicionarPessoaValida() throws PessoaInvalidaException {
        PessoaImpl pessoa = new PessoaImpl(1, "Nome ");
        turma.adicionarPessoa(pessoa);
        assertEquals(1, turma.getPessoas().size());
    }

    @Test
    public void testAdicionarPessoaInvalida() {
        PessoaImpl pessoa = new PessoaImpl(-1, null);
        assertThrows(PessoaInvalidaException.class, () -> turma.adicionarPessoa(pessoa));
    }
    @Test
    public void testAdicionarPessoaDuplicada() throws PessoaInvalidaException {
        PessoaImpl pessoa1 = new PessoaImpl(1, "Nome 1");
        PessoaImpl pessoa2 = new PessoaImpl(2, "Nome 2");
        turma.adicionarPessoa(pessoa1);
        assertThrows(PessoaInvalidaException.class, () -> turma.adicionarPessoa(pessoa1));
        assertDoesNotThrow(() -> turma.adicionarPessoa(pessoa2));
    }

    @Test
    public void testRemoverTodasPessoas() throws PessoaInvalidaException {
        PessoaImpl pessoa1 = new PessoaImpl(1, "Nome 1");
        PessoaImpl pessoa2 = new PessoaImpl(2, "Nome 2");
        turma.adicionarPessoa(pessoa1);
        turma.adicionarPessoa(pessoa2);
        turma.removerTodasPessoas();
        assertEquals(0, turma.getPessoas().size());
    }


    @Test
    public void testRemoverPessoaPorId() throws PessoaInvalidaException {
        PessoaImpl pessoa1 = new PessoaImpl(1, "Nome 1");
        PessoaImpl pessoa2 = new PessoaImpl(2, "Nome 2");
        turma.adicionarPessoa(pessoa1);
        turma.adicionarPessoa(pessoa2);
        turma.removerPessoaPorId(1);

        assertNull(turma.buscarPessoaPorId(1));
        assertNotNull(turma.buscarPessoaPorId(2));
    }

    @Test
    public void testBuscarPessoaPorId() throws PessoaInvalidaException {
        PessoaImpl pessoa1 = new PessoaImpl(1, "Nome 1");
        PessoaImpl pessoa2 = new PessoaImpl(2, "Nome 2");
        turma.adicionarPessoa(pessoa1);
        turma.adicionarPessoa(pessoa2);

        PessoaImpl pessoaEncontrada = turma.buscarPessoaPorId(1);
        assertNotNull(pessoaEncontrada);
        assertEquals(1, pessoaEncontrada.getId());
        assertEquals("Nome 1", pessoaEncontrada.getNome());

        PessoaImpl pessoaNaoEncontrada = turma.buscarPessoaPorId(3);
        assertNull(pessoaNaoEncontrada);
    }

    @Test
    public void testListarTodasPessoas() throws PessoaInvalidaException {
        PessoaImpl pessoa1 = new PessoaImpl(1, "Nome 1");
        PessoaImpl pessoa2 = new PessoaImpl(2, "Nome 2");
        turma.adicionarPessoa(pessoa1);
        turma.adicionarPessoa(pessoa2);

        List<PessoaImpl> pessoas = turma.listarTodasPessoas();
        assertEquals(2, pessoas.size());
        assertTrue(pessoas.contains(pessoa1));
        assertTrue(pessoas.contains(pessoa2));
    }
}