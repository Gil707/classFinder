import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Finder {

    private Comparator<String> compareClasses = (a, b) -> ((a.contains(".") ? a.substring(a.lastIndexOf(".") + 1) : a).compareTo(b));

    private boolean isAnyUpperCase(String s) {

        return !s.equals(s.toLowerCase());

    }

    private String findUpperCases(String s) {

        StringBuilder upperChars = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (Character.isUpperCase(s.charAt(i))) {
                upperChars.append(s.charAt(i));
            }
        }

        return upperChars.toString();
    }

    private boolean compareBtwUpperCases(String source, String pattern) {

        boolean flag = true;

        if (!pattern.contains("*")) {

            ArrayList<Integer> indexes = new ArrayList<>();

            for (int i = 0; i < pattern.length(); i++) {
                if (Character.isUpperCase(pattern.charAt(i))) {
                    indexes.add(i);
                }
            }

            for (int i = 0; i < indexes.size(); i++) {
                flag = source.contains(pattern.substring(indexes.get(0), indexes.get(1)));
            }

        }

        return flag;
    }


    private boolean compareByFirstLetters(String source, String pattern) {

        if (isAnyUpperCase(pattern)) {
            if (Character.isUpperCase(pattern.charAt(0)) && compareBtwUpperCases(source, pattern)) {
                if (pattern.charAt(pattern.length() - 1) == ' ') {
                    return findUpperCases(source).equals(findUpperCases(pattern));
                } else return findUpperCases(source).contains(findUpperCases(pattern));
            }
        } else {
            return findUpperCases(source).toLowerCase().equals(pattern);
        }

        return false;
    }

    private boolean compareByWildcard(String source, String pattern) {

        if (pattern.contains("*")) {
            String[] parts = pattern.split(Pattern.quote("*"));

            return source.startsWith(parts[0]) && source.endsWith(parts[1]);
        }

        return false;
    }


    public List<String> fileContainsClass(String fileName, String className) throws IOException {

        return Files
                .lines(Paths.get(fileName))
                .filter(e -> e.contains(className)
                        || (compareByFirstLetters(e, className))
                        || (compareByWildcard(e, className)))
                .map(String::trim)
                .sorted(compareClasses)
                .collect(Collectors.toList());
    }

}

