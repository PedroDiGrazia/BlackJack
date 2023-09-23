import java.util.Scanner;

public class BlackJack {
    public static void main(String[] args) {
        int qtd_players;
        Scanner input = new Scanner(System.in);
        DeckOfCards deck = new DeckOfCards();

        System.out.print("---BLACKJACK---");
        System.out.print("\n\nQTD DE PLAYERS: ");
        qtd_players = input.nextInt();

        for (int i = 1; i <= qtd_players; i++) {
            Player idPlayer = new Player(i);
            idPlayer.imprimeID();
            for (int j = 1; j < qtd_players; j++) {
                Card new_card = deck.dealCard();
                idPlayer.setCard(new_card, i);
                idPlayer.imprimeCards(qtd_players);
            }
        }

        DeckOfCards myDeckOfCards = new DeckOfCards();
        myDeckOfCards.shuffle(); // place Cards in random order
      
      // print all 52 Cards in the order in which they are dealt
      for (int i = 1; i <= 52; i++){
         // deal and display a Card
         System.out.printf("%-19s", myDeckOfCards.dealCard());

		 if (i % 4 == 0) // output a newline after every fourth card
		    System.out.println();
        }
    input.close();
    }
}
