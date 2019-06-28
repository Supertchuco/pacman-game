package com.pacman.pacmangame;

import com.pacman.pacmangame.gameInfra.Display;
import com.pacman.pacmangame.gameInfra.Game;
import com.pacman.pacmangame.gameService.PacmanGame;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;

@SpringBootApplication
public class PacmanGameApplication {

/*	public static void main(String[] args) {
		SpringApplication.run(PacmanGameApplication.class, args);
	}*/

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				Game game = new PacmanGame();
				Display view = new Display(game);
				JFrame frame = new JFrame();
				frame.setTitle("Pacman");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.getContentPane().add(view);
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				view.requestFocus();
				view.start();
			}

		});
	}

}
