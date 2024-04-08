package fr.univavignon.pokedex.api;

import org.json.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;

public class MetadataProvider implements IPokemonMetadataProvider {
    private final Map<Integer, PokemonMetadata> metadataMap;

    public MetadataProvider() {
        this.metadataMap = new HashMap<>();
        try {
            String jsonContent = new String(Files.readAllBytes(Paths.get("PokemonData.json")));
            JSONArray jsonArray = new JSONArray(jsonContent);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                int index = jsonObject.getInt("id");
                String name = jsonObject.getString("name");
                int attack = jsonObject.getInt("attack");
                int defense = jsonObject.getInt("defense");
                int stamina = jsonObject.getInt("stamina");
                PokemonMetadata metadata = new PokemonMetadata(index, name, attack, defense, stamina);
                metadataMap.put(index, metadata);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        PokemonMetadata metadata = metadataMap.get(index);
        if (metadata == null) {
            throw new PokedexException("Pokemon not found");
        }
        return metadata;
    }
}
