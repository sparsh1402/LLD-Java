package org.lld.behavioralPattern.strategyPattern.puzzleGame;
interface DifficultyLevelStrategy{
    void modifyGameRules();
}

class EasyLevel implements DifficultyLevelStrategy {
    @Override
    public void modifyGameRules() {
        // Modify game rules for easy level
        System.out.println("Game rules for easy level: Time limit increased, scoring simplified.");
    }
}

class MediumLevel implements DifficultyLevelStrategy {
    @Override
    public void modifyGameRules() {
        // Modify game rules for medium level
        System.out.println("Game rules for medium level: Standard time limit and scoring.");
    }
}

class HardLevel implements DifficultyLevelStrategy {
    @Override
    public void modifyGameRules() {
        // Modify game rules for hard level
        System.out.println("Game rules for hard level: Time limit reduced, complex scoring.");
    }
}

class Game {
    private DifficultyLevelStrategy difficultyLevelStrategy;

    public Game(DifficultyLevelStrategy difficultyLevelStrategy) {
        this.difficultyLevelStrategy = difficultyLevelStrategy;
    }

    public void setDifficultyLevel(DifficultyLevelStrategy difficultyLevelStrategy) {
        this.difficultyLevelStrategy = difficultyLevelStrategy;
    }

    public void startGame() {
        difficultyLevelStrategy.modifyGameRules();
        // Other game logic
    }
}
public class client {
    public static void main(String[] args) {
        Game game = new Game(new EasyLevel());

        game.startGame();  // Start game with easy difficulty

        game.setDifficultyLevel(new MediumLevel());
        game.startGame();  // Switch to medium difficulty

        game.setDifficultyLevel(new HardLevel());
        game.startGame();  // Play on hard difficulty
    }
}
