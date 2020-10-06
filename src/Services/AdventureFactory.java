package Services;

import Entities.*;
import Utils.Helpers.AdventureStepType;
import Utils.Helpers.FileHelper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public class AdventureFactory {
    public static AdventureBase createAdventureBaseFromJSON(String path) {
        JSONObject jsonObject = FileHelper.getJsonContents(path);
        AdventureStep[] steps = createAdventureStepsArray(jsonObject);
        return new AdventureBase((String) jsonObject.get("name"), (String) jsonObject.get("author"),
                steps);
    }

    private static AdventureStep[] createAdventureStepsArray(JSONObject jsonObject){
        JSONArray jsonArray = (JSONArray) jsonObject.get("steps");
        AdventureStep[] steps = new AdventureStep[jsonArray.size()];
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject object = (JSONObject) jsonArray.get(i);
            AdventureStepType type = AdventureStepType.valueOf(
                    ((String)object.get("type")).toUpperCase());
            steps[i] = new AdventureStep(type, (String)object.get("text"));
        }
        return steps;
    }

    public static AdventureBase[] createAdventureBasesFromResources() {
        ArrayList<AdventureBase> bases = new ArrayList<>();
        FileHelper.scanForJsonFiles("src/main/resources/Adventures")
                .forEach((el) -> bases.add(createAdventureBaseFromJSON(el)));
        AdventureBase[] arr = new AdventureBase[bases.size()];
        bases.toArray(arr);
        return arr;
    }
}
