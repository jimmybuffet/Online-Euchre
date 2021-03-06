/*
 * @author Hal M. Hattis
 * 
 * @course TSP CS3141 
 * 
 * @class "Card" - Euchre component
 * 
 * @Subclass to Deck
 */
public class Card {

	//class variables
	char suit;			//Heart= 'H', Diamond= 'D', Spade= 'S', Club= 'C'
	char face;			//face is what the card will appear as. (J,Q,K, etc...)
	int value;			//Value of card, used in trick determination
	
	//blank constructor for card
	public Card(){}
	
	//constructor for card
	public Card(char suit, int value, char face){
		this.suit= suit;
		this.value= value;
		this.face= face;
	}
	
	/*
	 * Method to determine if card is trump
	 * Not a class var. by teams request
	 * @param trumpSuit: The suit that is trump of the table
	 * @return boolean: true if card is trump, flase if not
	 */
	public boolean isTrump(char trumpSuit){
		//return whether or not the card is of trump suit
		if(this.suit == trumpSuit){ 
			return true;
		}
		
		else{ 
			return false; 
		}
	}//end of isTrump method
	
}//EOC

