import java.util.Scanner;

public class BlackJack 
{
    public static void main(String[] args)
    {
        int num_players, i, j;
        Scanner input = new Scanner(System.in);
        DeckOfCards deck = new DeckOfCards();

        // limpa a tela
        System.out.print("\033c");

        System.out.print("---BLACKJACK---");
        System.out.print("\n\nNUMERO DE JOGADORES: ");
        num_players = input.nextInt();
        System.out.print("\033c");

        // criacao do vetor de jogadores
        Player[] players = new Player[num_players];     
        Dealer dealer = new Dealer();
        for (i = 0; i < num_players; i++)
        {
            players[i] = new Player(i);
        }

        // cria e embaralha o deck
        DeckOfCards myDeckOfCards = new DeckOfCards();
        myDeckOfCards.shuffle(); // place Cards in random order

        // distribuicao das cartas
        for (i = 0; i < 2; i++) 
        {
            System.out.printf("-=-CARTA %d-=-\n", i + 1);
            for (j = 0; j < num_players; j++) 
            {   
                Card new_card = myDeckOfCards.dealCard();

                players[j].printID();
                players[j].setCard(new_card, i);
                players[j].printCards();
                players[j].hand_value = players[j].handValue(new_card);
                System.out.printf("VALOR DA MAO: %d\n", players[j].hand_value);
                if(players[j].hand_value == 21)
                {
                    System.out.printf("\nBLACKJACK - JOGADOR %d VENCEU!\n", j + 1);
                }
            }

            Card new_card = myDeckOfCards.dealCard();
            dealer.printID();
            dealer.setCard(new_card, i);
            dealer.printCardsStart();
            dealer.hand_value = dealer.handValue(new_card)
            limpaTela();
        }

        for(j = 0; j < num_players; j++)
        {
            int hit = 1;
            i = 2;
            if(j != 0)
                limpaTela();

            while(hit == 1)
            {   
                if(players[j].hand_value < 21)
                {
                    players[j].printID();
                    players[j].printCards();
                    System.out.printf("VALOR DA MAO: %d\n", players[j].hand_value);
                    System.out.printf("\n [1] COMPRAR\n [2] FICAR\n ESCOLHA: ");
                    hit = input.nextInt();
                    
                    if(hit == 1)
                    {
                        Card new_card = myDeckOfCards.dealCard();
                        players[j].setCard(new_card, i);
                        players[j].hand_value = players[j].handValue(new_card);
                        
                        for(int k = 0; k <= i; k++)
                        {   
                            if(players[j].hand_value > 21 && players[j].getHand()[k].getFace() == "As")
                            {
                                players[j].hand_value = players[j].handValue(players[j].getHand()[k]);
                            }
                        }

                        System.out.printf("\n%s\n", new_card);
                        System.out.printf("VALOR DA MAO: %d\n", players[j].hand_value);

                        if(players[j].hand_value > 21)
                        {
                            System.out.printf("\nJOGADOR %d ESTOUROU!", j + 1);
                            hit = 0;
                        }
                        limpaTela();
                        i++;
                    }
                }
                else
                {
                    hit = 0;
                }
            }
        }

        System.out.print("\033c");
        dealer.printID();
        dealer.printCardsEnd();
        System.out.printf("\nVALOR DA MAO: %d\n", dealer.hand_value);
        limpaTela();

        i = 2;
        while(dealer.hand_value <= 15)
        {
            dealer.printID();
            Card new_card = myDeckOfCards.dealCard();
            dealer.setCard(new_card, i);
            dealer.printCardsEnd();
            dealer.hand_value = dealer.handValue(new_card);
            System.out.printf("\nVALOR DA MAO: %d", dealer.hand_value);

            if(dealer.hand_value > 21)
            {
                System.out.printf("\nDEALER ESTOUROU!");
            }
            else if(dealer.hand_value > 15)
            {
                System.out.printf("\nVALOR DA MAO FINAL: %d\n", dealer.hand_value);
            }
            limpaTela();
            i++;
        }

        for(i = 0; i < num_players; i++)
        {
            if(players[i].hand_value > 21 || players[i].hand_value <= dealer.hand_value)
            {
                System.out.printf("\nJOGADOR %d PERDEU! - MAO FINAL: %d\n", i + 1, players[i].hand_value);
            }
            else
            {
                System.out.printf("\nJOGADOR %d GANHOU! - MAO FINAL: %d\n", i + 1, players[i].hand_value);
            }
        }
        System.out.printf("\nDEALER - MAO FINAL: %d\n", dealer.hand_value);

        limpaTela();
        System.out.print("JOGO ENCERRADO!\n\n");
        input.close();
    }

    public static void limpaTela()
    {
        Scanner input = new Scanner(System.in);
        System.out.printf("\n-=-PRESSIONE <ENTER> PARA CONTINUAR-=-\n");
        input.nextLine();
        System.out.print("\033c");
    }
}
