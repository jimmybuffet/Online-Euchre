import java.util.Scanner;
/*
 * @author Hal M. Hattis
 * 
 * @course TSP CS3141 
 * 
 * @class "EuchreGame" - Euchre headclass
 */
public class EuchreGame {
	
	//class variables
	//boolean to control the game state
	Boolean gameOver= false;
	//Table to initialize teams and players
	Table table= new Table();
	Scanner in = new Scanner(System.in);
	
	/*
	 * This method will handle shuffling and dealing
	 * the deck to start each hand
	 */
	public void dealDeck(){
		table.deck.shuffle();
		table.deck.deal();
		table.players[0].hand= table.deck.hand1;
		table.players[1].hand= table.deck.hand2;
		table.players[2].hand= table.deck.hand3;
		table.players[3].hand= table.deck.hand4;
		table.topOfDiscard= table.deck.discard[0];
	}
	
	public char makeSuit(int suit){
		char trumpSuit = 'X';
		if(suit == 1){
			trumpSuit= 'H';
		}
		if(suit == 2){
			trumpSuit= 'D';
		}
		if(suit == 3){
			trumpSuit= 'S';
		}
		if(suit == 4){
			trumpSuit= 'C';
		}
		return trumpSuit;
	}
	
	//in progress, have to add auto increment of dealer/player and actually pick up card
	public void trumpRound(){
		System.out.println("Player 1, do you want to set this card to trump: " + table.topOfDiscard.face + table.topOfDiscard.suit + "?");
		int trumpCalled= in.nextInt();
		
		if(trumpCalled == 1){
			table.setTrump(table.topOfDiscard.suit);
			System.out.println("Dealer, you must pick this card up: " +table.topOfDiscard.face + table.topOfDiscard.suit);
			System.out.println("What card will you choose to discard from your hand?");
			table.players[0].showHand();
			int cardToDrop= in.nextInt()-1;
			table.players[0].pickUpTrump(cardToDrop, table.topOfDiscard);
			
			return;
		}
		
		System.out.println("Player 2, do you want to set this card to trump: " + table.topOfDiscard.face + table.topOfDiscard.suit + "?");
		trumpCalled= in.nextInt();
		
		if(trumpCalled == 1){
			table.setTrump(table.topOfDiscard.suit);
			System.out.println("Dealer, you must pick this card up: " +table.topOfDiscard.face + table.topOfDiscard.suit);
			System.out.println("What card will you choose to discard from your hand?");
			table.players[0].showHand();
			int cardToDrop= in.nextInt()-1;
			table.players[0].pickUpTrump(cardToDrop, table.topOfDiscard);
			
			return;
		}
		
		System.out.println("Player 3, do you want to set this card to trump: " + table.topOfDiscard.face + table.topOfDiscard.suit + "?");
		trumpCalled= in.nextInt();
		
		if(trumpCalled == 1){
			table.setTrump(table.topOfDiscard.suit);
			System.out.println("Dealer, you must pick this card up: " +table.topOfDiscard.face + table.topOfDiscard.suit);
			System.out.println("What card will you choose to discard from your hand?");
			table.players[0].showHand();
			int cardToDrop= in.nextInt()-1;
			table.players[0].pickUpTrump(cardToDrop, table.topOfDiscard);
			
			return;
		}
		
		System.out.println("Player 4, do you want to set this card to trump: " + table.topOfDiscard.face + table.topOfDiscard.suit + "?");
		trumpCalled= in.nextInt();
		
		if(trumpCalled == 1){
			table.setTrump(table.topOfDiscard.suit);
			System.out.println("Dealer, you must pick this card up: " +table.topOfDiscard.face + table.topOfDiscard.suit);
			System.out.println("What card will you choose to discard from your hand?");
			table.players[0].showHand();
			int cardToDrop= in.nextInt()-1;
			table.players[0].pickUpTrump(cardToDrop, table.topOfDiscard);
			
			return;
		}
		
		System.out.println("Player 1, do you want to set trump? ");
		trumpCalled= in.nextInt();
		
		if(trumpCalled == 1){
			System.out.println("What suit would you like to call it?");
			System.out.println("1=H, 2=D, 3=S, 4=C");
			int trumpSuit = in.nextInt();
			char trumpSuitChar = makeSuit(trumpSuit);
			
			table.setTrump(trumpSuitChar);
			return;
		}
		
		System.out.println("Player 2, do you want to set trump? ");
		trumpCalled= in.nextInt();
		
		if(trumpCalled == 1){
			System.out.println("What suit would you like to call it?");
			System.out.println("1=H, 2=D, 3=S, 4=C");
			int trumpSuit = in.nextInt();
			char trumpSuitChar = makeSuit(trumpSuit);
			
			table.setTrump(trumpSuitChar);
			return;
		}
		
		System.out.println("Player 3, do you want to set trump? ");
		trumpCalled= in.nextInt();
		
		if(trumpCalled == 1){
			System.out.println("What suit would you like to call it?");
			System.out.println("1=H, 2=D, 3=S, 4=C");
			int trumpSuit = in.nextInt();
			char trumpSuitChar = makeSuit(trumpSuit);
			
			table.setTrump(trumpSuitChar);
			return;
		}
		
		System.out.println("Player 4, you must set trump");
		System.out.println("What suit would you like to call it?");
		System.out.println("1=H, 2=D, 3=S, 4=C");
		int trumpSuit = in.nextInt();
		char trumpSuitChar = makeSuit(trumpSuit);
		table.setTrump(trumpSuitChar);
	}
	
	public void runTrick(){
		//use player turn, use dealer, use read ints, use play card
		
		//play all the cards for the trick
		System.out.println("Player 1, play a card from this hand: (1-5 are the cards)");
		table.players[0].showHand();
		int card1 = in.nextInt()-1;
		
		
		while( card1 < 0 || card1 > 4|| table.players[0].hand[card1] == null){
			System.out.println("Invalid card, try again... (There arent that many cards in your hand)");
			card1= in.nextInt()-1;
		}
		
		table.tableCards[0]= table.players[0].playCard(card1);
		
		
		System.out.println("Player 2, play a card from this hand: (1-5 are the cards)");
		table.players[1].showHand();
		int card2 = in.nextInt()-1;
		
		while( card2 < 0 || card2 > 4|| table.players[1].hand[card2] == null){
			System.out.println("Invalid card, try again... (There arent that many cards in your hand)");
			card2= in.nextInt()-1;
		}
		
		table.tableCards[1]= table.players[1].playCard(card2);
		
		System.out.println("Player 3, play a card from this hand: (1-5 are the cards)");
		table.players[2].showHand();
		int card3 = in.nextInt()-1;
		
		while( card3 < 0 || card3 > 4|| table.players[2].hand[card3] == null){
			System.out.println("Invalid card, try again... (There arent that many cards in your hand)");
			card3= in.nextInt()-1;
		}
		
		table.tableCards[2]= table.players[2].playCard(card3);
		
		System.out.println("Player 4, play a card from this hand: (1-5 are the cards");
		table.players[3].showHand();
		int card4 = in.nextInt()-1;
		
		while( card4 < 0 || card4 > 4|| table.players[3].hand[card4] == null){
			System.out.println("Invalid card, try again... (There arent that many cards in your hand)");
			card4= in.nextInt()-1;
		}
		
		table.tableCards[3]= table.players[3].playCard(card4);
		
		//evaluate cards played
		int playerOfCard=0;

		int maxCardPos= table.evalCards();
		playerOfCard= maxCardPos;
		
		System.out.println("Player " + (playerOfCard+1) +  " wins the trick!");
		
		table.players[playerOfCard].tricks+=1;
		
		if(playerOfCard==0 || playerOfCard==2){
			table.team1.tricks+=1;
		}
		if(playerOfCard==1 || playerOfCard==3){
			table.team2.tricks+=1;
		}
		
	}
	
	public void runHand(){
		dealDeck();
		
		trumpRound();
		
		for(int i=0; i<5; i+=1){
			runTrick();
		}
		
		if(table.team1.getTricks()>2){
			table.team1.teamScored(1);
			System.out.println("Team 1 scored!");
			System.out.println("Player 1 earned " + table.players[0].tricks + " tricks, and Player 3 earned " + table.players[2].tricks + " tricks.");
			table.players[0].clearTricks();
			table.players[2].clearTricks();
			System.out.println("The Score of the game is: Team 1 has " + table.team1.score + " point(s) and Team 2 has " + table.team2.score + " point(s).");
			System.out.println();
		}
		else{
			table.team2.teamScored(1);
			System.out.println("Team 2 scored!");
			System.out.println("Player 2 earned " + table.players[1].tricks + " tricks, and Player 4 earned " + table.players[3].tricks + " tricks.");
			table.players[0].clearTricks();
			table.players[2].clearTricks();
			System.out.println("The Score of the game is: Team 1 has " + table.team1.score + " point(s) and Team 2 has " + table.team2.score + " point(s).");
			System.out.println();
		}
		
	}
	
	public void runGame(){
		while(table.team1.getScore()<10 && table.team2.getScore()<10){
			runHand();
		}
		
		if(table.team1.winner == true){
			System.out.println("Team 1 Won the Game");
		}
		
		else{
			System.out.println("Team 2 Won the Game");
		}
	}
	
	
	
	public static void main(String[] args) {
		EuchreGame game= new EuchreGame();
		game.runGame();
	}
	
}//EOC
