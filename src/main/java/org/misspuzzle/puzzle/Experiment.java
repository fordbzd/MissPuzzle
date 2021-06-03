package org.misspuzzle.puzzle;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Experiment {

    public void run() {
        List<String> list = new ArrayList<>();
        list.add("vol1");
        list.add("vol2");

        Map<String, List<String>> map = new HashMap<>();
        map.put("vol", list);

        String s = new Gson().toJson(map);



    }
}
