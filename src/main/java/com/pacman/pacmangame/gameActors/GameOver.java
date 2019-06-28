package com.pacman.pacmangame.gameActors;

import com.pacman.pacmangame.gameService.PacmanActor;
import com.pacman.pacmangame.gameService.PacmanGame;

public class GameOver extends PacmanActor {

    public GameOver(PacmanGame game) {
        super(game);
    }

    @Override
    public void init() {
        x = 77;
        y = 160;
        loadFrames("/images/gameover.png");
    }

    @Override
    public void updateGameOver() {
        yield:
        while (true) {
            switch (instructionPointer) {
                case 0:
                    waitTime = System.currentTimeMillis();
                    instructionPointer = 1;
                case 1:
                    if (System.currentTimeMillis() - waitTime < 3000) {
                        break yield;
                    }
                    game.returnToTitle();
                    break yield;
            }
        }
    }

    // broadcast messages

    @Override
    public void stateChanged() {
        visible = false;
        if (game.state == PacmanGame.State.GAME_OVER) {
            visible = true;
            instructionPointer = 0;
        }
    }

}
