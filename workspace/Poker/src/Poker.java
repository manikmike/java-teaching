public class Poker
{
   private DeckOfCards deck;
   public int[] count = new int[10];
   
   public static void main(String[] args)
   {
      Poker game = new Poker();
      game.deck = new DeckOfCards();
      for (int i=1; i <= 2598960; i++)
      {
         String result = game.play();
         game.countResults(result);
      }
      game.displayResults();
  }
   
   public String play()
   {
      for (int i=0; i < 3; i++) this.deck.shuffle();
      
      Card[] cards = new Card[5];
      for (int i=0; i < 5; i++)
      {
         cards[i] = this.deck.dealCard();
      }
      
      Hand hand = new Hand(cards);
      //hand.print();
      String result = hand.evaluateHand();
      //System.out.println(result);
      return result;
   }
   
   public void countResults(String result)
   {
      if (result.equals("Royal Flush"))
         count[0]++;
      else if (result.equals("Straight Flush"))
         count[1]++;
      else if (result.equals("Four of a Kind"))
         count[2]++;
      else if (result.equals("Full House"))
         count[3]++;
      else if (result.equals("Flush"))
         count[4]++;
      else if (result.equals("Straight"))
         count[5]++;
      else if (result.equals("Three of a Kind"))
         count[6]++;
      else if (result.equals("Two Pair"))
         count[7]++;
      else if (result.equals("Pair"))
         count[8]++;
      else // if (result.equals("Nothing"))
         count[9]++;
   }
   
   public void displayResults()
   {
      String[] result = {"Royal Flush", "Straight Flush", "Four of a Kind",
         "Full House", "Flush", "Straight", "Three of a Kind", "Two Pair",
         "Pair", "Nothing"};
      for (int i=0; i < count.length; i++)
      {
         System.out.printf("%-17s %7d\n",result[i],count[i]);
      }
   }
}
