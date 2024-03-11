package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokemonFactoryTest {
    private IPokemonFactory iPokemonFactory;

    @Before
    public void setUp() {
        iPokemonFactory = mock(IPokemonFactory.class);
        when(iPokemonFactory.createPokemon(0, 613, 64, 4000, 4))
                .thenReturn(new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56));
    }

    @Test
    public void testCreatePokemon() {
        Pokemon pokemon = iPokemonFactory.createPokemon(0, 613, 64, 4000, 4);
        assertEquals("Bulbizarre", pokemon.getName());
        assertEquals(0, pokemon.getIndex());
        assertEquals(126, pokemon.getAttack());
        assertEquals(126, pokemon.getDefense());
        assertEquals(90, pokemon.getStamina());
        assertEquals(613, pokemon.getCp());
        assertEquals(64, pokemon.getHp());
        assertEquals(4000, pokemon.getDust());
        assertEquals(4, pokemon.getCandy());
        assertEquals(56.0, pokemon.getIv(), 0);
    }
}
