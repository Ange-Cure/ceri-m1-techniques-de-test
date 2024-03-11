package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokemonMetadataProviderTest {
    private IPokemonMetadataProvider metadataProvider;

    @Before
    public void setUp() throws PokedexException {
        metadataProvider = mock(IPokemonMetadataProvider.class);
        when(metadataProvider.getPokemonMetadata(0)).thenReturn(new PokemonMetadata(0, "Bulbizarre", 126, 126, 90));
        when(metadataProvider.getPokemonMetadata(151)).thenThrow(new PokedexException("Pokemon not found"));
    }


    @Test
    public void testGetPokemon() throws PokedexException {
        PokemonMetadata pokemonMetadata = metadataProvider.getPokemonMetadata(0);
        assertEquals("Bulbizarre", pokemonMetadata.getName());
        assertEquals(126, pokemonMetadata.getAttack());
        assertEquals(126, pokemonMetadata.getDefense());
        assertEquals(90, pokemonMetadata.getStamina());
    }

    @Test
    public void testGetPokemonException() {
        try {
            PokemonMetadata pokemonMetadata = metadataProvider.getPokemonMetadata(151);
        } catch (PokedexException e) {
            assertEquals("Pokemon not found", e.getMessage());
        }
    }
}
