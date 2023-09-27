public class Player 
{
    public int id;
    private Card card;
    private Card[] hand = new Card[10];
    int hand_value = 0;

    public Player(int id)
    {
        this.id = id;
    }

    public void setCard(Card card, int hand_pos)
    {
        this.hand[hand_pos] = card;
    }

    public int handValue(Card card)
    {
        String view_face = card.getFace();
        switch(view_face)
        {
            case "As":
                if(hand_value < 11)
                    hand_value = hand_value + 11;
                else
                    hand_value = hand_value + 1;
                break;
            case "Dois":
                hand_value = hand_value + 2;
                break;
            case "Tres":
                hand_value = hand_value + 3;
                break;
            case "Quatro":
                hand_value = hand_value + 4;
                break;
            case "Cinco":
                hand_value = hand_value + 5;
                break;
            case "Seis":
                hand_value = hand_value + 6;
                break;
            case "Sete":
                hand_value = hand_value + 7;
                break;
            case "Oito":
                hand_value = hand_value + 8;
                break;
            case "Nove":
                hand_value = hand_value + 9;
                break;
            default:
                hand_value = hand_value + 10;
        }

        return hand_value;
    }

    public void printID()
    {
        System.out.printf("\nJOGADOR %d\n----------\n", this.id + 1);
    }

    public void printCards()
    {
        for (int i = 0; i < 2; i++) 
        {
            if(this.hand[i] != null)
            System.out.printf("%s\n",this.hand[i]);   
        }
    }
}
