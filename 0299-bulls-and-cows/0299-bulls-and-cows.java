class Solution {
    public String getHint(String secret, String guess) {
        Map<Character, Integer> x = new HashMap<>();
        Map<Character, Integer> y = new HashMap<>();
        int bulls = 0, cows = 0;
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            } else {
                x.merge(secret.charAt(i), 1, Integer::sum);
                y.merge(guess.charAt(i), 1, Integer::sum);
            }
        }
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) != guess.charAt(i)) {
                char g = guess.charAt(i);
                if (y.getOrDefault(g, 0) > 0 && x.getOrDefault(g, 0) > 0) {
                    cows++;
                    y.merge(g, -1, Integer::sum);
                    x.merge(g, -1, Integer::sum);
                }
            }
        }
        return bulls + "A" + cows + "B";
    }
}