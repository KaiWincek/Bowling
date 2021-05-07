package main.java.company;

public class Game {

    public int calculateScore(String scorecard){
        String [][] rolls = new String[21][2];
        int score = 0;
        int numberOfRolls = 0;

        initiateRollArray(rolls);
        fillRollArray(scorecard, rolls);
        replaceStrikeAndZeroesWithValues(rolls);
        replaceSparesWithValues(rolls);

        for (int i = 0; i < scorecard.length(); i++){
            numberOfRolls++;
            score += Integer.parseInt(rolls[i][0]);
            if (rolls[i][0].equals("10") && rolls[i][1].equals("1") && numberOfRolls < scorecard.length()-2){
                score += (Integer.parseInt(rolls[i+1][0]) + Integer.parseInt(rolls[i+2][0]));
            }
            if (rolls[i][1].equals("2") && numberOfRolls == scorecard.length()-1){
                score -= Integer.parseInt(rolls[i+1][0]);
            }
        }

        return score;
    }

    private void replaceSparesWithValues(String[][] rolls) {
        for (int i = 0; i < rolls.length; i++){
            if (rolls[i][0].equals("/")){
                int scoreOfSpare = (10 - Integer.parseInt(rolls[i-1][0]) + Integer.parseInt(rolls[i+1][0]));
                rolls[i][0] = rolls[i][0].replace("/", Integer.toString(scoreOfSpare));
                rolls[i][1] = rolls[i][1].replace("0", "2");
            }
        }
    }

    private void replaceStrikeAndZeroesWithValues(String[][] rolls) {
        for (int i = 0; i < rolls.length; i++){
            if (rolls[i][0].equals("x")){
                rolls[i][0] = rolls[i][0].replace("x", "10");
                rolls[i][1] = rolls[i][1].replace("0", "1");
            } else if (rolls[i][0].equals("-")){
                rolls[i][0] = rolls[i][0].replace("-", "0");
            }
        }
    }

    private String[][] fillRollArray(String scorecard, String[][] rolls) {
        for (int i = 0; i < scorecard.length(); i++){
            rolls[i][0] = rolls[i][0].concat(scorecard.charAt(i) + "");
        }
        return rolls;
    }

    private String[][] initiateRollArray(String[][] rolls) {
        for (int i = 0; i < rolls.length; i++){
            rolls[i][0] = "";
            rolls[i][1] = "0";
        }
        return rolls;
    }
}
