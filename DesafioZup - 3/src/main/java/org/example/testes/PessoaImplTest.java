package org.example.testes;

import org.example.PessoaImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.example.interfaces.Pessoa;


public class PessoaImplTest {

    @Test
    public void testPessoaValida() {
        PessoaImpl pessoa = new PessoaImpl(1, "Fulano");
        assertTrue(pessoa.valido());
    }

    @Test
    public void testPessoaIdNegativo() {
        PessoaImpl pessoa = new PessoaImpl(-1, "Beltrano");
        assertFalse(pessoa.valido());
    }

    @Test
    public void testPessoaNomeVazio() {
        PessoaImpl pessoa = new PessoaImpl(2, "");
        assertFalse(pessoa.valido());
    }
}