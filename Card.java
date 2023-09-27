public class Card 
{
   private final String face; // face of card ("Ace", "Deuce", ...)
   private final String suit; // suit of card ("Hearts", "Diamonds", ...)

   // two-argument constructor initializes card's face and suit
   public Card(String face, String suit)
   {
      this.face = face;
      this.suit = suit; 
   } 

   // return String representation of Card
   public String toString() 
   { 
      return face + " de " + suit;
   } 

   // sets card value
   /*public int handValue(Card card)
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
   }*/

   public String getFace()
   {
      return face;
   }
   
} // end class Card
