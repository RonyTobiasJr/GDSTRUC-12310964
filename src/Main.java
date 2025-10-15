import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        ArrayStack playerDeck = new ArrayStack(30);
        ArrayStack playerHand = new ArrayStack(30);
        ArrayStack discardPile = new ArrayStack(30);

        for (int i = 1; i <= 30; i++) {
            playerDeck.push(new Card("Card " + i));
        }

        System.out.println("============== CARD GAME! ==============");
        System.out.println("You have a deck of 30 cards.\n");

        System.out.print("Press ENTER to begin...");
        input.nextLine();

        int turn = 1;

        while (!playerDeck.isEmpty()) {
            System.out.println("\n================ TURN " + turn + " ================");

            int commandType = random.nextInt(3);
            int x = random.nextInt(5) + 1;

            switch (commandType) {
                case 0:
                    System.out.println("Command: Draw " + x + " card(s)");
                    for (int i = 0; i < x; i++) {
                        Card drawn = playerDeck.pop();
                        if (drawn != null) {
                            playerHand.push(drawn);
                        } else {
                            System.out.println("No more cards to draw!");
                            break;
                        }
                    }
                    break;

                case 1:
                    System.out.println("Command: Discard " + x + " card(s)");
                    for (int i = 0; i < x; i++) {
                        Card discarded = playerHand.pop();
                        if (discarded != null) {
                            discardPile.push(discarded);
                        } else {
                            System.out.println("You have no cards to discard!");
                            break;
                        }
                    }
                    break;

                case 2:
                    System.out.println("Command: Take " + x + " card(s) from discard pile");
                    for (int i = 0; i < x; i++) {
                        Card recovered = discardPile.pop();
                        if (recovered != null) {
                            playerHand.push(recovered);
                        } else {
                            System.out.println("Discard pile is empty!");
                            break;
                        }
                    }
                    break;
            }

            System.out.print("\nYour Hand: ");
            playerHand.printStack();
            System.out.println("\nRemaining card(s) in Deck: " + playerDeck.size());
            System.out.println("Discarded card pile: " + discardPile.size());

            if (!playerDeck.isEmpty()) {
                System.out.print("\nPress ENTER for next turn...");
                while (input.hasNextLine()) {  // clean up buffer properly
                    String line = input.nextLine();
                    if (line.isEmpty()) break;
                }
            }

            turn++;
        }

        System.out.println("\n==================== GAME OVER!!!!! ====================");
        System.out.println("Your Deck is empty!");
    }
}



