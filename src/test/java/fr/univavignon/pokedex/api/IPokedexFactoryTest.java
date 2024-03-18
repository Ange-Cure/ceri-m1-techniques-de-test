package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class IPokedexFactoryTest {

    private IPokedexFactory pokedexFactory;
    private MetadataProvider metadataProvider;
    private PokemonFactory pokemonFactory;
    @Before
    public void setUp() {
        metadataProvider = new MetadataProvider();
        pokemonFactory = new PokemonFactory();
        pokedexFactory = new PokedexFactory();
//        pokedexFactory = mock(IPokedexFactory.class);
//        when(pokedexFactory.createPokedex(any(IPokemonMetadataProvider.class), any(IPokemonFactory.class))).thenReturn(mock(IPokedex.class));

    }

    @Test
    public void testCreatePokedex() {
        IPokedex pokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);
        assertTrue(pokedex instanceof IPokedex);
        assertNotNull(pokedex);
    }
}
