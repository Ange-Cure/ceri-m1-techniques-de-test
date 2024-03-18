package fr.univavignon.pokedex.api;

public class PokedexFactory implements IPokedexFactory {
    public IPokedex createPokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
        Pokedex pokedex = new Pokedex((MetadataProvider) metadataProvider, (PokemonFactory) pokemonFactory);
        return pokedex;
    }
}
