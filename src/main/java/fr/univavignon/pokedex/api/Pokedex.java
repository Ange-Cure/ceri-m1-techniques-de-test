package fr.univavignon.pokedex.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Pokedex implements IPokedex{
    private List<Pokemon> pokemonList;
    MetadataProvider metadataProvider;
    PokemonFactory pokemonFactory;

    public Pokedex(MetadataProvider metadataProvider, PokemonFactory pokemonFactory) {
        pokemonList = new ArrayList<>();
        this.metadataProvider = metadataProvider;
        this.pokemonFactory = pokemonFactory;
    }

    public int size() {
        return pokemonList.size();
    }

    public int addPokemon(Pokemon pokemon) {
        pokemonList.add(pokemon);
        return pokemonList.size()-1;
    }

    public Pokemon getPokemon(int id) throws PokedexException {
        return pokemonList.get(id);
    }

    public List<Pokemon> getPokemons() {
        return pokemonList;
    }

    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        List<Pokemon> copyPokemonList = pokemonList;
        copyPokemonList.sort(order);
        return copyPokemonList;
    }

    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) throws PokedexException, IOException {
        return pokemonFactory.createPokemon(index, cp, hp, dust, candy);
    }

    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        return metadataProvider.getPokemonMetadata(index);
    }
}
