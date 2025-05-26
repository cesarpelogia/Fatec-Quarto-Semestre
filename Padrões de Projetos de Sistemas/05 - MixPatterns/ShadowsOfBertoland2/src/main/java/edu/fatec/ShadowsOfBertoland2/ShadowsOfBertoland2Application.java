package edu.fatec.ShadowsOfBertoland2;


import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.fatec.ui.screens.StartScreen;

@SpringBootApplication
public class ShadowsOfBertoland2Application {

	public static void main(String[] args) {
		new StartScreen().setVisible(true);
	}

}
