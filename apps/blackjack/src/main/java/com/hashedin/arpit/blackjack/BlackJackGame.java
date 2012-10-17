package com.hashedin.arpit.blackjack;
import java.util.*;
/**
 * 
 * @author arpit
 *
 */
class Cards{
	/**Map<Integer,Integer>cardsSelection=new HashMap<Integer,Integer>();*/
	//List<HashMap<Integer,Integer>> selection=new StackList<HashMap<Integer,Integer>>();
	public Face cardvalue;
	public Suit suitvalue;
	
	public enum Face{
		Ace(1),Two(2),Three(3),Four(4),Five(5),Six(6),Seven(7),Eight(8),Nine(9),Ten(10),King(10),Queen(10),Jack(10);
	
		private final int value;
		Face(int value){this.value=value;}
		public int getValue(){return value;}
	}
	public enum Suit{
		Club(0),Spade(1),Diamond(2),Heart(3);
		private final int value;
		Suit(int value){this.value=value;}
		public int getValue(){return value;}
	}
	public Cards(){}
	
	public Cards(Face c,Suit s)
	{
	    this.cardvalue=c;
	    this.suitvalue=s;
		//System.out.println(suitvalue);
		//System.out.println(cardvalue);
	}
   	
}


interface Dealer{
	//public void Shuffle();
	
	public void deck();
	public void selection();
	
}
interface ScoreCard{
	public void dealerscore();
	public void playerscore();
	public void winner();
}

class Game extends Cards implements Dealer {
	Scanner scan=new Scanner(System.in);
	Stack<Cards> cardstack= new Stack<Cards>();
	private Face c;
	private Suit s;
	public void deck() {
      for(Face c:Face.values()){
    	  for(Suit s:Suit.values()){
    		  Cards assign=new Cards(c,s);
    		  cardstack.add(assign);
    	  }
      }
	}
	
	public void shuffle(){
		Collections.shuffle(cardstack);
	
	}
	
	public void selection(){
		Cards assign=new Cards();
		Score score=new Score();
		shuffle();
		score.dealerscore(cardstack.pop());
		score.dealerscore(cardstack.pop());
		assign=cardstack.pop();
		System.out.println("Player Card:"+assign.cardvalue);
		score.playerscore(cardstack.pop());
		System.out.println("Would like to Hit enter H or Stand enter S");
		String input= scan.next();
    	while(input.equalsIgnoreCase("h")){
    		//Run the Method of Giving Card
    		
    		
    		//player.selection();
    		score.playerscore(cardstack.pop());
    		assign=cardstack.pop();
    		
    		System.out.println("Player Card:"+assign.cardvalue);
    		
    		System.out.println("Would like to Hit enter H or Stand enter S");
    		input=scan.next();
    	}
    	if(input.equalsIgnoreCase("s")){
    		//Check who win either Dealer or Person
    		score.winner();
    	}
	}

	
	
}

class Score implements ScoreCard{
   private int delearpoint;
   private int playerpoint;
	public void playerscore(Cards card){
		playerpoint+=card.cardvalue.getValue();
		
	}
  // public int cardnumber;
   //super.shuffle();
	public void dealerscore(Cards card) {
		// TODO Auto-generated method stub
		delearpoint+=card.cardvalue.getValue();
	}
	
  public void winner(){
	  if(delearpoint<=21 && delearpoint>playerpoint)
	  {
		  System.out.println("DelearsWin");
	  }
	  else if (delearpoint == playerpoint)
	  {
		  System.out.println("Match Tie");
	  }
	  else
	  {
		  
		  System.out.println("PlayerWin");
	  }
  }
public void dealerscore() {
	// TODO Auto-generated method stub
	
}
public void playerscore() {
	// TODO Auto-generated method stub
	
}
	  
  

}


public class BlackJackGame {
    
	public static void main(String args[]) {
		Scanner scan=new Scanner(System.in);        //Declaring to take input from user 
		//Cards cards=new Cards();
		Game game=new Game();
		//Player player=new Player();
		System.out.println("Welcome to BlackJackGame");
		System.out.println("--------------------------");
		
			System.out.println("Press B for Bet and Q for Quit");
			String input = scan.next();
	        if(input.equalsIgnoreCase("b")){
	        	//Intilaize Method of Betting
	            game.deck();
	            game.selection();
	        	
	        }
	        else
	        	System.exit(0);
		
		
	}
}
