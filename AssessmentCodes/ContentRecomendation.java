package AssessmentCodes;

import java.util.*;

public class ContentRecomendation {
    public static void main(String[] args) {
        List<String> matchedCategories = Arrays.asList("Code", "Food");
        List<Integer> matchedCategoryRelevance = Arrays.asList(200, 188);
        List<String> availableVideoTitles = Arrays.asList("APIs", "Pasta", "MUL", "Tips", "Bread", "Workout");
        List<String> availableVideoCategories = Arrays.asList("Code", "Food", "Code", "Health", "Food", "Sports");

        List<String> recommendations = getRecommendations(
                matchedCategories, matchedCategoryRelevance, availableVideoTitles, availableVideoCategories);
        System.out.println(recommendations);
    }

    public static List<String> getRecommendations(List<String> matchedCategories,
            List<Integer> matchedCategoryRelevance,
            List<String> availableVideoTitles,
            List<String> availableVideoCategories) {

        Map<String, Integer> relevanceMap = new HashMap<>();
        for (int i = 0; i < matchedCategories.size(); i++) {
            relevanceMap.put(matchedCategories.get(i), matchedCategoryRelevance.get(i));
        }
        int n = availableVideoTitles.size();
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, (i1, i2) -> {
            String cat1 = availableVideoCategories.get(i1);
            String cat2 = availableVideoCategories.get(i2);
            String title1 = availableVideoTitles.get(i1);
            String title2 = availableVideoTitles.get(i2);

            boolean isWatched1 = relevanceMap.containsKey(cat1);
            boolean isWatched2 = relevanceMap.containsKey(cat2);

            if (isWatched1 != isWatched2) {
                return isWatched1 ? -1 : 1;
            }
            if (isWatched1) {
                // Rule B: If both are watched, sort by decreasing relevance
                int rel1 = relevanceMap.get(cat1);
                int rel2 = relevanceMap.get(cat2);
                if (rel1 != rel2) {
                    return Integer.compare(rel2, rel1);
                }
            } else {
                // Rule C: If both are unwatched, sort alphabetically by category name
                if (!cat1.equals(cat2)) {
                    return cat1.compareTo(cat2);
                }
            }

            // Rule D: Within the same category, sort alphabetically by title
            return title1.compareTo(title2);
        });
        List<String> result = new ArrayList<>();
        for (int i : indices) {
            result.add(availableVideoTitles.get(i));
        }

        return result;
    }
}
