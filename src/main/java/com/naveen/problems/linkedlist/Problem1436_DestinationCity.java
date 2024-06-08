package com.naveen.problems.linkedlist;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem1436_DestinationCity {

    public String destCity(List<List<String>> paths) {
        Set<String> startNodes = new HashSet<>();
        for (List<String> path : paths) startNodes.add(path.get(0));
        for (List<String> path : paths)
            if (!startNodes.contains(path.get(1)))
                return path.get(1);
        return "";

    }
}
