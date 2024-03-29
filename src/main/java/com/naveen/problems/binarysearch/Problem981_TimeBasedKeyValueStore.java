package com.naveen.problems.binarysearch;

import java.util.*;

/*
* https://leetcode.com/problems/time-based-key-value-store/
* Design a time-based key-value data structure that can store multiple values for the same key at different time stamps
* and retrieve the key's value at a certain timestamp.

Implement the TimeMap class:

TimeMap() Initializes the object of the data structure.
void set(String key, String value, int timestamp) Stores the key key with the value value at the given time timestamp.
String get(String key, int timestamp) Returns a value such that set was called previously,
* with timestamp_prev <= timestamp. If there are multiple such values,
* it returns the value associated with the largest timestamp_prev. If there are no values, it returns "".
* Input
["TimeMap", "set", "get", "get", "set", "get", "get"]
[[], ["foo", "bar", 1], ["foo", 1], ["foo", 3], ["foo", "bar2", 4], ["foo", 4], ["foo", 5]]
Output
[null, null, "bar", "bar", null, "bar2", "bar2"]

Explanation
TimeMap timeMap = new TimeMap();
timeMap.set("foo", "bar", 1);  // store the key "foo" and value "bar" along with timestamp = 1.
timeMap.get("foo", 1);         // return "bar"
timeMap.get("foo", 3);         // return "bar", since there is no value corresponding to foo at timestamp 3 and
* timestamp 2, then the only value is at timestamp 1 is "bar".
timeMap.set("foo", "bar2", 4); // store the key "foo" and value "bar2" along with timestamp = 4.
timeMap.get("foo", 4);         // return "bar2"
timeMap.get("foo", 5);         // return "bar2"
* */
public class Problem981_TimeBasedKeyValueStore {
    static class TimeMap {
        Map<String, List<Entry>> map = new HashMap<>();
        public TimeMap() {}

        public void set(String key, String value, int timestamp) {
            Entry e = new Entry(key, value, timestamp);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(e);
        }

        public String get(String key, int timestamp) {
            List<Entry> list = map.getOrDefault(key, Collections.EMPTY_LIST);
            if (list.size() == 0 || list.get(0).timestamp > timestamp) return "";
            int l = 0, r = list.size() - 1;
            while (l <= r) {
                int m = (l + r)/2;
                int mtimestamp = list.get(m).timestamp;
                if (mtimestamp == timestamp) return list.get(m).value;
                else if (mtimestamp > timestamp) r = m - 1;
                else l = m + 1;
            }
            return list.get(r).value;
        }

        private static class Entry {
            int timestamp;
            String key;
            String value;
            public Entry(String key, String value, int timestamp) {
                this.timestamp = timestamp;
                this.key = key;
                this.value = value;
            }
        }
    }

}
