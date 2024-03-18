package fr.univavignon.pokedex.api;

public class PokemonTrainerFactory implements IPokemonTrainerFactory {
    public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory) {
        MetadataProvider metadataProvider = new MetadataProvider();
        PokemonFactory pokemonFactory = new PokemonFactory();
        return new PokemonTrainer(name, team, pokedexFactory.createPokedex(metadataProvider, pokemonFactory));
    }
}
