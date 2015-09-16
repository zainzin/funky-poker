package poker;

public class Deck {

	private Card[] cards;

	public Deck() {
		cards = new Card[52];
		int count = 0;
		for (int suit = 0; suit < 4; suit++) {
			for (int cardsVal = 1; cardsVal <= 13; cardsVal++) {
				cards[count] = new Card(cardsVal, suit);
				count++;
			}
		}
	}
	public Deck(Deck other) {
		cards = new Card[other.cards.length];
		for (int i = 0; i < other.cards.length; i++) {
			cards[i] = other.cards[i];	
		}
	}

	public Card getCardAt(int position) {
		return cards[position];
	}

	public int getNumCards() {
		return cards.length;
	}

	/* hint: odd and even */
	public void shuffle() {
		Card [] newArrayCards = new Card[cards.length];
		int position = (cards.length/2);
		int firstPosition = 0;
		for (int i = 0; i < cards.length; i++) {
			if((i == 0) || i%2 == 0){
				newArrayCards[i] = cards[position++];
			}
			else{
				newArrayCards[i] = cards[firstPosition++];
			}
		}
			cards = newArrayCards;
	}

	public void cut(int position) {
		Card[] newCutCards = new Card[cards.length];
		int cut = 0;
		for (int i = 0; i < newCutCards.length - position; i++) {
			newCutCards[i] = cards[i + position];
		}
		for (int i = newCutCards.length - position; i < newCutCards.length; i++) {
			newCutCards[i] = cards[cut++];
		}
		cards = newCutCards;
	}

	public Card[] deal(int numCards) {
		int size = this.getNumCards();
		Card[] remove = new Card[numCards];
		Card[] smaller = new Card[size - numCards];
		for (int i = 0; i < numCards; i++) {
			remove[i] = this.getCardAt(i);
		}
		for (int i = 0; i < size - numCards; i++) {
			smaller[i] = this.getCardAt(i + numCards);
		}
		cards = smaller;
		return remove;
	}
 
}
