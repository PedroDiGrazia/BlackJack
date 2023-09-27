import java.util.Scanner;

public class BlackJack 
{
    public static void main(String[] args)
    {
        int num_players;
        Scanner input = new Scanner(System.in);
        DeckOfCards deck = new DeckOfCards();

        System.out.print("---BLACKJACK---");
        System.out.print("\n\nNUMERO DE JOGADORES: ");
        num_players = input.nextInt();

        Player[] players = new Player[num_players];     // Create an array to store players
        Dealer dealer = new Dealer();

        for (int i = 0; i < num_players; i++)
        {
            players[i] = new Player(i);
        }

        DeckOfCards myDeckOfCards = new DeckOfCards();
        myDeckOfCards.shuffle(); // place Cards in random order

        for (int i = 0; i < 2; i++) 
        {
            System.out.printf("\n\n=-=RODADA %d=-=\n", i+1);
            for (int j = 0; j < num_players; j++) 
            {   
                Card new_card = myDeckOfCards.dealCard();

                players[j].printID();
                players[j].setCard(new_card, i);
                players[j].printCards();
                players[j].hand_value = players[j].handValue(new_card);
                System.out.printf("\nVALOR DA MAO: %d\n", players[j].hand_value);
            }

            Card new_card = deck.dealCard();

            dealer.printID();
            dealer.setCard(new_card, i);
            dealer.printCardsStart();
            dealer.hand_value = dealer.handValue(new_card);
            //System.out.printf("\nVALOR DA MAO: %d", dealer.hand_value);
        }

        System.out.print("\n\n");
        input.close();
    }
}
