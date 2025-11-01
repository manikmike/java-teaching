public class Hand
{
   private Card[] card;
   private int[] faceCount;
   private int[] suitCount;
   
   public Hand(Card[] card)
   {
      int length = card.length;
      this.card = new Card[length];
      for (int i=0; i < length; i++) this.card[i] = card[i];
      faceCount = new int[14];  // element 0 is not used
      for (int i=0; i < 14; i++) faceCount[i] = 0;
      this.countFaces();
      suitCount = new int[4];
      for (int i=0; i < 4; i++) suitCount[i] = 0;      
      this.countSuits();
   }
   
   private void countFaces()
   {
      for (int i=0; i < card.length; i++)
      {
         if (card[i].getFace().equals("Ace"))
            faceCount[1]++;
         else if (card[i].getFace().equals("Deuce"))
            faceCount[2]++;
         else if (card[i].getFace().equals("Three"))
            faceCount[3]++;
         else if (card[i].getFace().equals("Four"))
            faceCount[4]++;
         else if (card[i].getFace().equals("Five"))
            faceCount[5]++;
         else if (card[i].getFace().equals("Six"))
            faceCount[6]++;
         else if (card[i].getFace().equals("Seven"))
            faceCount[7]++;
         else if (card[i].getFace().equals("Eight"))
            faceCount[8]++;
         else if (card[i].getFace().equals("Nine"))
            faceCount[9]++;
         else if (card[i].getFace().equals("Ten"))
            faceCount[10]++;
         else if (card[i].getFace().equals("Jack"))
            faceCount[11]++;
         else if (card[i].getFace().equals("Queen"))
            faceCount[12]++;
         else if (card[i].getFace().equals("King"))
            faceCount[13]++;
      }      
   }
   
   private void countSuits()
   {
      for (int i=0; i < card.length; i++)
      {
         if (card[i].getSuit().equals("Hearts"))
            suitCount[0]++;
         else if (card[i].getSuit().equals("Diamonds"))
            suitCount[1]++;
         else if (card[i].getSuit().equals("Clubs"))
            suitCount[2]++;
         else if (card[i].getSuit().equals("Spades"))
            suitCount[3]++;
      }
   }
   
   public String evaluateHand()
   {
      if (isRoyalFlush())
         return "Royal Flush";
      else if (isStraightFlush())
         return "Straight Flush";
      else if (isFourOfAKind())
         return "Four of a Kind";
      else if (isFullHouse())
         return "Full House";
      else if (isFlush())
         return "Flush";
      else if (isStraight())
         return "Straight";
      else if (isThreeOfAKind())
         return "Three of a Kind";
      else if (isTwoPair())
         return "Two Pair";
      else if (isPair())
         return "Pair";
      else
         return "Nothing";
   }
   
   private boolean isRoyalFlush()
   {
      if (isStraightFlush() &&
          faceCount[10] == 1 && faceCount[1] == 1)
         return true;
      else
         return false;
   }
   
   private boolean isStraightFlush()
   {
      if (isStraight() && isFlush())
         return true;
      else
         return false;
   }

   private boolean isFourOfAKind()
   {
      for (int i=1; i <= 13; i++)
      {
         if (faceCount[i] == 4) return true;
      }
      return false;
   }

   private boolean isFullHouse()
   {
      if (isThreeOfAKind() && isPair())
         return true;
      else
         return false;
   }
   
   private boolean isFlush()
   {
      for (int i=0; i < 4; i++)
      {
         if (suitCount[i] == 5) return true;
      }
      return false;
      
   }
   
   private boolean isStraight()
   {
      for (int i=1; i <= 9; i++)
      {
         if (faceCount[i] == 1 && faceCount[i+1] == 1 && faceCount[i+2] == 1 &&
             faceCount[i+3] == 1 && faceCount[i+4] == 1)
            return true;
      }
      if (faceCount[10] == 1 && faceCount[11] == 1 && faceCount[12] == 1 &&
          faceCount[13] == 1 && faceCount[1] == 1)
         return true;
      else
         return false;
   }

   private boolean isThreeOfAKind()
   {
      for (int i=1; i <= 13; i++)
      {
         if (faceCount[i] == 3) return true;
      }
      return false;
   }

   private boolean isTwoPair()
   {
      int pairCount = 0;
      for (int i=1; i <= 13; i++)
      {
         if (faceCount[i] == 2) pairCount++;
      }
      if (pairCount == 2)
         return true;
      else
         return false;
   }

   private boolean isPair()
   {
      for (int i=1; i <= 13; i++)
      {
         if (faceCount[i] == 2) return true;
      }
      return false;
   }
   
   public void print()
   {
      for (int i=0; i < card.length; i++)
      {
         System.out.println("(" + (i+1) + ") " + card[i]);
      }
   }
}
