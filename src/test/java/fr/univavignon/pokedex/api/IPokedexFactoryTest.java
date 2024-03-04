package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class IPokedexFactoryTest {

    private IPokedexFactory pokedexFactory;

    @Before
    public void setUp() {
        pokedexFactory = mock(IPokedexFactory.class);
        when(pokedexFactory.createPokedex(any(IPokemonMetadataProvider.class), any(IPokemonFactory.class))).thenReturn(mock(IPokedex.class));
    }

    @Test
    public void testCreatePokedex() {
        IPokemonMetadataProvider pokemonMetadataProvider = mock(IPokemonMetadataProvider.class);
        IPokemonFactory pokemonFactory = mock(IPokemonFactory.class);

        IPokedex pokedex = pokedexFactory.createPokedex(pokemonMetadataProvider, pokemonFactory);
        // test mais j'ai pas compris quoi
    }

}
