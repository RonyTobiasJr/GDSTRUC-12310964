import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        ArrayQueue playerQueue = new ArrayQueue(100);
        int playerId = 1;
        int gamesCreated = 0;
        int turn = 1;

        System.out.println("============ MATCHMAKING INGAME ============");
        System.out.println("Press ENTER to start matchmaking...");
        input.nextLine();

        while (gamesCreated < 10) {
            System.out.println("\n================== TURN " + turn + " ==================");

            int newPlayers = random.nextInt(7) + 1;
            System.out.println(newPlayers + " new player(s) in queue");

            for (int i = 0; i < newPlayers; i++) {
                Player newPlayer = new Player(playerId, "Player" + playerId);
                playerQueue.enqueue(newPlayer);
                playerId++;
            }

            System.out.println("Current players in queue: " + playerQueue.size());

            if (playerQueue.size() >= 5) {
                System.out.println("\nGame " + (gamesCreated + 1) + " started with:");
                for (int i = 0; i < 5; i++) {
                    Player matched = playerQueue.dequeue();
                    System.out.println(matched);
                }
                gamesCreated++;
            } else {
                System.out.println("Need more players to start.");
            }

            System.out.println("Players waiting in queue: " + playerQueue.size());

            if (gamesCreated < 10) {
                System.out.print("\nPress ENTER for the next turn");
                while (input.hasNextLine()) {
                    String line = input.nextLine();
                    if (line.isEmpty()) break;
                }
            }

            turn++;
        }

        System.out.println("\nThere are now 10 games live right now");
        System.out.println("Done");
    }
}

