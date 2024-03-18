package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokemonTrainerFactoryTest {
    private IPokemonTrainerFactory iPokemonTrainerFactory;
    private IPokedexFactory iPokedexFactory;

    @Before
    public void setUp() {
        iPokemonTrainerFactory = new PokemonTrainerFactory();
        iPokedexFactory = new PokedexFactory();
//        iPokemonTrainerFactory = mock(IPokemonTrainerFactory.class);
//        IPokedexFactory iPokedexFactory = mock(IPokedexFactory.class);
//        when(iPokemonTrainerFactory.createTrainer("Ange", Team.MYSTIC, iPokedexFactory)).thenReturn(new PokemonTrainer("Ange", Team.MYSTIC, pokedex));
    }

    @Test
    public void testCreateTrainer() throws IOException {
        PokemonTrainer pokemonTrainer = iPokemonTrainerFactory.createTrainer("Ange", Team.MYSTIC, iPokedexFactory);
        assertEquals("Ange", pokemonTrainer.getName());
        assertEquals(Team.MYSTIC, pokemonTrainer.getTeam());
        assertTrue(pokemonTrainer.getPokedex() instanceof IPokedex);
    }
}
