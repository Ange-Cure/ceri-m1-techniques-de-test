package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokemonTrainerFactoryTest {
    private IPokemonTrainerFactory iPokemonTrainerFactory;
    private IPokedex pokedex;

    @Before
    public void setUp() {
        iPokemonTrainerFactory = mock(IPokemonTrainerFactory.class);
        IPokedexFactory iPokedexFactory = mock(IPokedexFactory.class);
        when(iPokemonTrainerFactory.createTrainer("Ange", Team.MYSTIC, iPokedexFactory)).thenReturn(new PokemonTrainer("Ange", Team.MYSTIC, pokedex));

    }

    @Test
    public void testCreateTrainer() {

        PokemonTrainer pokemonTrainer = new PokemonTrainer("Ange", Team.MYSTIC, pokedex);
        assertEquals("Ange", pokemonTrainer.getName());
        assertEquals(Team.MYSTIC, pokemonTrainer.getTeam());
    }
}
