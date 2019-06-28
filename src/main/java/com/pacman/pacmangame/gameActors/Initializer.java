package com.pacman.pacmangame.gameActors;

import com.pacman.pacmangame.gameService.PacmanActor;
import com.pacman.pacmangame.gameService.PacmanGame;

public class Initializer extends PacmanActor {

    public Initializer(PacmanGame game) {
        super(game);
    }

    @Override
    public void updateInitializing() {
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
                    instructionPointer = 2;
                case 2:
                    game.setState(PacmanGame.State.OL_PRESENTS);
                    break yield;
            }
        }
    }

}
