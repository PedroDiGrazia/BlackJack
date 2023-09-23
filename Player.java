public class Player 
{
    private final int id;
    private Card card;
    private Card[] hand = new Card[10];

    public Player(int id){
        this.id = id;
    }

    public void setCard(Card card, int handPos){
        this.hand[handPos] = card;
    }

    public void imprimeID(){
        System.out.printf("\nPlayer %d\n",this.id);
    }

    public void imprimeCards(int qtd_players){
        for (int i = 1; i < qtd_players; i++) {
            System.out.printf("%s\n",this.hand[i]);   
        }
    }
}
