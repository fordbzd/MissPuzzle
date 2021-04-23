package org.misspuzzle.puzzle;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Experiment {

    public void run() {
        JsonObject obj = JsonParser.parseString("{\"abc\":\"123\"}").getAsJsonObject();

        JsonArray list = obj.get("abc").getAsJsonArray();

        for (JsonElement e : list) {
            System.out.print(e.getAsString());
        }

    }

}
