package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokedexTest {

    private IPokedex pokedex;
    private Pokemon pokemon1;
    private Pokemon pokemon2;

    @Before
    public void setUp() throws PokedexException {
        pokedex = mock(IPokedex.class);
        pokemon1 = new Pokemon(0,"Bulbizarre",126,126,90,613,64,4000, 4, 56);
        pokemon2 = new Pokemon(133,"Aquali",186,168,260,2729,202,5000,4,100);

        when(pokedex.size()).thenReturn(0);
        when(pokedex.addPokemon(pokemon1)).thenReturn(0);
        when(pokedex.addPokemon(pokemon2)).thenReturn(1);
        when(pokedex.getPokemon(0)).thenReturn(pokemon1);
        when(pokedex.getPokemon(1)).thenReturn(pokemon2);
        when(pokedex.getPokemon(151)).thenThrow(new PokedexException("Invalid ID"));

    }

    @Test
    public void testSize() {
        assertEquals(0, pokedex.size());
    }

    @Test
    public void testAddPokemonAndGetPokemon() throws PokedexException {
        assertEquals(0, pokedex.addPokemon(pokemon1));
        assertEquals(1, pokedex.addPokemon(pokemon2));
        assertEquals(pokemon1, pokedex.getPokemon(0));
        assertEquals(pokemon2, pokedex.getPokemon(1));
    }

    @Test
    public void testGetPokemonWithInvalidId() {
        try {
            pokedex.getPokemon(151);
        } catch (PokedexException e) {
            assertEquals("Invalid ID", e.getMessage());
        }
    }
}
