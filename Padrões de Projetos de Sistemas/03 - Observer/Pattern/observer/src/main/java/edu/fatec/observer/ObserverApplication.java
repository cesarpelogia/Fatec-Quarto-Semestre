package edu.fatec.observer;

import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.fatec.observer.game.Enemy;
import edu.fatec.observer.observer.PlayerSubject;

@SpringBootApplication
public class ObserverApplication {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(ObserverApplication.class, args);

		Scanner scanner = new Scanner(System.in);

		System.out.println("Pressione Enter para iniciar o jogo...");
		scanner.nextLine();
		System.out.println("Bem-vindo ao Shadows of Bertoland!");
		Thread.sleep(3000);
		System.out.println("Você é um heroi perdido em um mundo repleto de perigos.");
		Thread.sleep(3000);
		System.out.println("Para sobreviver, você deverá demonstar coragem e habilidade.");
		Thread.sleep(3000);
		System.out.println("Nessa terra inóspita, você encontrará monstros e criaturas mágicas.");
		Thread.sleep(3000);
		System.out.println("E estará completamente sozinho...");
		Thread.sleep(3000);
		System.out.println("\n");
		System.out.println("Digite o seu nome para começar:");
		String playerName = scanner.nextLine();

		PlayerSubject player = new PlayerSubject(playerName, 100, 100, new ArrayList<>());
		System.out.println("\n");
		Enemy enemy = new Enemy("Monstro", 100, player);
		player.addObserver(enemy);

		System.out.println("Bem-vindo ao jogo, " + playerName + "!");
		Thread.sleep(2000);
		System.out.println("Enquanto você vagava por uma floresta densa e sombria,");
		Thread.sleep(2000);
		System.out.println("você se deparou com um lago que refletia a luz da lua.");
		Thread.sleep(2000);
		System.out.println("Você se aproximou do lago e viu seu reflexo.");
		Thread.sleep(2000);
		System.out.println("Mas, de repente, uma sombra surgiu atrás de você.");
		Thread.sleep(2000);
		System.out.println( playerName + ", cuidado! Um " + enemy.getName() + " apareceu pronto para atacar!");
		System.out.println("-------------------------");

		System.out.println("Você tem " + player.getLife() + " de vida e " + player.getMana() + " de mana.");
		System.out.println("O " + enemy.getName() + " tem " + enemy.getLife() + " de vida.");
		System.out.println("-------------------------");

		while (true) {
			System.out.println("Escolha uma ação: " + "\n" +
					"1. ataque" + "\n" +
					"2. cura" + "\n" +
					"3. sair");
			System.out.println("\n" + "Digite o número da ação desejada:");
			String action = scanner.nextLine();
		
			switch (action) {
				case "1":
					player.performAction("ataque");
					break;
				case "2":
					player.performAction("cura");
					break;
				case "3":
					System.out.println("Saindo do jogo. Até a próxima!");
					scanner.close();
					System.exit(0);
					break;
				default:
					System.out.println("Ação inválida! Escolha apenas 1 (ataque), 2 (cura) ou 3 (sair).");
			}
		}
	}
}
