package main.java.company;

import java.util.ArrayList;
import java.util.List;

public class Game {

    public int calculateScore(String scorecard) {
        int score = 0;
        List<Roll> rollList = fillRollList(scorecard);

        for (int i = 0; i < rollList.size(); i++) {
            Roll currentRoll = rollList.get(i);
            switch (currentRoll.getRollType()) {
                case SPARE:
                    score += currentRoll.getValue() + rollList.get(i + 1).getValue();
                    break;
                case STRIKE:
                    score += currentRoll.getValue() + rollList.get(i + 1).getValue() + rollList.get(i + 2).getValue();
                    break;
                default:
                    score += currentRoll.getValue();
            }
            
            //Checking for Bonus Rolls
            if (
                    (currentRoll.getRollType() == RollType.STRIKE && i >= rollList.size() - 3) ||
                    (currentRoll.getRollType() == RollType.SPARE && i >= rollList.size() - 2)
            ) {
                return score;
            }
        }
        return score;
    }

    private List<Roll> fillRollList(String scorecard) {
        List<Roll> rollList = new ArrayList<>();
        for (int i = 0; i < scorecard.length(); i++) {
            char c = scorecard.charAt(i);
            switch (c) {
                case '/':
                    rollList.add(new Roll(10 - rollList.get(i - 1).getValue(), RollType.SPARE));
                    break;
                case 'x':
                    rollList.add(new Roll(10, RollType.STRIKE));
                    break;
                case '-':
                    rollList.add(new Roll(0, RollType.VALUE));
                    break;
                default:
                    rollList.add(new Roll(Character.getNumericValue(c), RollType.VALUE));
                    break;
            }
        }
        return rollList;
    }
}
