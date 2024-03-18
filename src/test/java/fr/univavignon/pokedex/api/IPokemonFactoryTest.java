package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokemonFactoryTest {
    private IPokemonFactory iPokemonFactory;

    @Before
    public void setUp() {
        iPokemonFactory = new PokemonFactory();
//        iPokemonFactory = mock(IPokemonFactory.class);
//        when(iPokemonFactory.createPokemon(0, 613, 64, 4000, 4))
//                .thenReturn(new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56));
    }

    @Test
    public void testCreatePokemon() throws PokedexException, IOException {
        Pokemon pokemon = iPokemonFactory.createPokemon(1, 613, 64, 4000, 4);
        assertEquals("Bulbasaur", pokemon.getName());
        assertEquals(1, pokemon.getIndex());
        assertEquals(118, pokemon.getAttack());
        assertEquals(111, pokemon.getDefense());
        assertEquals(128, pokemon.getStamina());
        assertEquals(613, pokemon.getCp());
        assertEquals(64, pokemon.getHp());
        assertEquals(4000, pokemon.getDust());
        assertEquals(4, pokemon.getCandy());
        assertEquals(76.0, pokemon.getIv(), 0);
    }
}
