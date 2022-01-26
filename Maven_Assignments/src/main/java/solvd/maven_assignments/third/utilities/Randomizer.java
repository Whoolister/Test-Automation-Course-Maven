package utilities;

public class Randomizer {
    public static String randomizeString(int length) {
        StringBuilder result = new StringBuilder(length);

        String characters = "ABCDEFGHIJKLMNOPQRSTUVXYZabcdefghijklmnopqrstuvxyz";

        for (int index = 0; index < length; index++) {
            int position = (int) (characters.length() * Math.random());

            result.append(characters.charAt(position));
        }

        return result.toString();
    }
}
