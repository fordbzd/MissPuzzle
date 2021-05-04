package org.misspuzzle.puzzle;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Experiment {

    public void run() {
        JsonObject obj = JsonParser.parseString("{\"abc\":123}").getAsJsonObject();

        int result = obj.get("abc").getAsInt();

        System.out.println(result);

    }
}
