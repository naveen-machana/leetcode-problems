package com.naveen.problems.heaps;

import java.util.*;

public class Problem2353_FoodRatings {
    
    static class FoodRatings {
        Map<String, SortedSet<Entry>> cuisinesFoods = new HashMap<>();
        Map<String, String> foodCuisines = new HashMap<>();
        Map<String, Integer> foodRatings = new HashMap<>();

        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            for (int i = 0; i < cuisines.length; i++) {
                cuisinesFoods.computeIfAbsent(cuisines[i], k -> new TreeSet<>()).add(new Entry(foods[i], ratings[i]));
                foodCuisines.put(foods[i], cuisines[i]);
                foodRatings.put(foods[i], ratings[i]);
            }
        }

        public void changeRating(String food, int newRating) {
            String cuisine = foodCuisines.get(food);
            int rating = foodRatings.get(food);
            SortedSet<Entry> sortedSet = cuisinesFoods.get(cuisine);
            sortedSet.remove(new Entry(food, rating));
            sortedSet.add(new Entry(food, newRating));
            foodRatings.put(food, newRating);
        }

        public String highestRated(String cuisine) {
            return cuisinesFoods.get(cuisine).first().food;
        }

        class Entry implements Comparable<Entry> {
            private String food;
            private int rating;
            public Entry(String food, int rating) {
                this.food = food;
                this.rating = rating;
            }
            public int compareTo(Entry o) {
                if (rating != o.rating) {
                    return Integer.compare(o.rating, rating);
                }
                else {
                    return food.compareTo(o.food);
                }
            }

            @Override
            public boolean equals(Object o) {
                if (o == null) return false;
                Entry other = (Entry)o;
                return other.food.equals(food) && other.rating == rating;
            }

            @Override
            public int hashCode() {
                int hashCode = 0;
                hashCode = 31 * hashCode +  food.hashCode();
                hashCode = 31 * hashCode + rating;
                return hashCode;
            }
            @Override
            public String toString() {
                return "[" + food + ", " + rating + "]";
            }
        }
    }

}
