package Services;

import Entities.Ability;
import Entities.GameCharacter;
import Entities.Stats;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.nio.file.Files;
import java.nio.file.Paths;

public class CharacterFactory {
    public CharacterFactory(){
    }

    public GameCharacter createCharFromJSON(String path){
        String json = "";
        try {
            json = Files.readString(Paths.get(path));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = null;
        try {
            jsonObject = (JSONObject) parser.parse(json);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        Stats stats = createStats(jsonObject);
        Ability[] abilities = createAbilityArray(jsonObject);
        return new GameCharacter((String) jsonObject.get("name"), stats, abilities);
    }

    private Ability[] createAbilityArray(JSONObject jsonObject) {
        JSONArray jsonArray = (JSONArray)jsonObject.get("abilities");
        Ability[] abilities = new Ability[jsonArray.size()];
        for (int i = 0; i < jsonArray.size(); i++) {
            abilities[i] = (Ability) jsonArray.get(i);
        }
        return abilities;
    }

    private Stats createStats(JSONObject jsonObject) {
        return new Stats((double)jsonObject.get("maxHealth"),
                (double)jsonObject.get("maxMana"), (double)jsonObject.get("strength"), (double)jsonObject.get("intelligence"),
                (double)jsonObject.get("armor"), (double)jsonObject.get("resistance"));
    }
}
