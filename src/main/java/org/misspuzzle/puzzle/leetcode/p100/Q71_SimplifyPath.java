package org.misspuzzle.puzzle.leetcode.p100;

import java.util.ArrayList;
import java.util.List;

public class Q71_SimplifyPath {
    public String simplifyPath(String path) {
        String[] paths = path.split("/");

        List<String> folders = new ArrayList<>();

        for (String p : paths) {
            if (p.equalsIgnoreCase("..")) {
                if (folders.size() > 0) {
                    folders.remove(folders.size() - 1);
                }
            } else if (p.equalsIgnoreCase(".") || p.equalsIgnoreCase("")) {
                continue;
            } else {
                folders.add(p);
            }
        }

        return "/" + String.join("/", folders);
    }
}
