package fr.univavignon.pokedex.api;

public class PokemonFactory implements IPokemonFactory {
    /**
     * Creates a pokemon instance computing it IVs.
     *
     * @param index Pokemon index.
     * @param cp    Pokemon CP.
     * @param hp    Pokemon HP.
     * @param dust  Required dust for upgrading pokemon.
     * @param candy Required candy for upgrading pokemon.
     * @return Created pokemon instance.
     */
    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) throws PokedexException {
        MetadataProvider metadataProvider = new MetadataProvider();
        PokemonMetadata metadata = metadataProvider.getPokemonMetadata(index);
        double CP_MULTIPLIER = 0.1;
        double HP_MULTIPLIER = 0.1;
        double baseCP = Math.pow(metadata.getAttack(), CP_MULTIPLIER) * Math.pow(metadata.getDefense(), CP_MULTIPLIER) * Math.pow(metadata.getStamina(), CP_MULTIPLIER);
        double baseHP = Math.floor(metadata.getStamina() * HP_MULTIPLIER);

        double ivCP = cp / baseCP;
        double ivHP = hp / baseHP;

        double ivApprox = Math.round((ivCP + ivHP) / 2);

        return new Pokemon(index, metadata.getName(), metadata.getAttack(), metadata.getDefense(), metadata.getStamina(), cp, hp, dust, candy, ivApprox);
    }
}
