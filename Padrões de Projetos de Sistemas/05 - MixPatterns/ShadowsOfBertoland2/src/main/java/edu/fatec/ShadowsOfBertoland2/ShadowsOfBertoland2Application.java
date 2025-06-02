package edu.fatec.ShadowsOfBertoland2;


import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.fatec.ShadowsOfBertoland2.observer.ScreenController;

@SpringBootApplication
public class ShadowsOfBertoland2Application {

	public static void main(String[] args) {
		ScreenController controller = new ScreenController();
    	controller.initialize();
	}

}
