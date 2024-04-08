package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IPokemonMetadataProviderTest {
    private IPokemonMetadataProvider metadataProvider;

    @Before
    public void setUp() {
//        metadataProvider = mock(IPokemonMetadataProvider.class);
//        when(metadataProvider.getPokemonMetadata(0)).thenReturn(new PokemonMetadata(0, "Bulbasaur", 118, 111, 128));
//        when(metadataProvider.getPokemonMetadata(151)).thenThrow(new PokedexException("Pokemon not found"));
        metadataProvider = new MetadataProvider();
    }


    @Test
    public void testGetPokemon() throws PokedexException {
        PokemonMetadata pokemonMetadata = metadataProvider.getPokemonMetadata(1);
        assertEquals("Bulbasaur", pokemonMetadata.getName());
        assertEquals(118, pokemonMetadata.getAttack());
        assertEquals(111, pokemonMetadata.getDefense());
        assertEquals(128, pokemonMetadata.getStamina());
    }

    @Test
    public void testGetPokemonException() {
        try {
            PokemonMetadata pokemonMetadata = metadataProvider.getPokemonMetadata(152);
        } catch (PokedexException e) {
            assertEquals("Pokemon not found", e.getMessage());
        }
    }
}
