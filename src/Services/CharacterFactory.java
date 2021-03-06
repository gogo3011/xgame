package Services;

import Entities.Ability;
import Entities.GameCharacter;
import Entities.Stats;
import Utils.Helpers.FileHelper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class CharacterFactory {
    public static GameCharacter[] createCharFromResources(){
        ArrayList<GameCharacter> characters = new ArrayList<>();
        FileHelper.scanForJsonFiles("src/main/resources/Characters")
                .forEach((el) -> characters.add(createCharFromJSON(el)));
        GameCharacter[] arr = new GameCharacter[characters.size()];
        characters.toArray(arr);
        return arr;
    }

    public static GameCharacter createCharFromJSON(String path) {
        JSONObject jsonObject = FileHelper.getJsonContents(path);
        Stats stats = createStats(jsonObject);
        Ability[] abilities = createAbilityArray(jsonObject);
        return new GameCharacter((String) jsonObject.get("name"), stats, abilities);
    }

    private static Ability[] createAbilityArray(JSONObject jsonObject) {
        JSONArray jsonArray = (JSONArray) jsonObject.get("abilities");
        Ability[] abilities = new Ability[jsonArray.size()];
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject object = (JSONObject) jsonArray.get(i);
            abilities[i] = new Ability(
                    (String) object.get("name"),
                    (String) object.get("description"),
                    ((Long) object.get("physicalMulti")).doubleValue(),
                    ((Long) object.get("magicalMulti")).doubleValue(),
                    ((Long) object.get("manaCost")).doubleValue()
            );
        }
        return abilities;
    }

    private static Stats createStats(JSONObject jsonObject) {
        return new Stats(((Long) jsonObject.get("maxHealth")).doubleValue(),
                ((Long) jsonObject.get("maxMana")).doubleValue(),
                ((Long) jsonObject.get("strength")).doubleValue(),
                ((Long) jsonObject.get("intelligence")).doubleValue(),
                ((Long) jsonObject.get("armor")).doubleValue(),
                ((Long) jsonObject.get("resistance")).doubleValue()
        );
    }
}
