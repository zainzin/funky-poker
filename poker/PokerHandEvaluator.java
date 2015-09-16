package poker;

public class PokerHandEvaluator {
	//YOUR IMPLEMENTATION HERE
	//Any helpers must be private.
	
	public static boolean hasPair(Card[] cards) {
		int counter = pairCounter(cards);
		if(counter >= 1){
			return true;
			}
		else
			{
			return false;
		}
	}
	public static boolean hasRainbow(Card[] cards) {
		int[] suitEvaluator= suitEvaluator(cards);
		boolean val = false;
		int counter = 0;
		
		for(int i = 0; i < 4; i++){
			if(suitEvaluator[i] == 1){
				counter++;
			}
		}
			if(counter == 3){
				val = true;
			}
			return val;
		}
	public static boolean hasTwoPair(Card[] cards) {
		int counter = pairCounter(cards);
		boolean val = false;
			if (counter >= 2){
				if(!hasFourOfAKind(cards)){
					val=true;
				}
		}
		return val;
	}
	public static boolean hasThreeOfAKind(Card[] cards) {
		boolean val = false;
		int[] evaluator = evaluation(cards); 
		for(int i = 0;i < 13;i++){
			if(evaluator[i] >= 3){
				val=true;
			}
		}
		return val;
		}
	public static boolean hasOddStraight(Card [] cards) {	
		int[] eva = evalForStraights(cards);
		
		if(eva[0]%2==1 && eva[1]%2==1 && eva[2]%2==1 && eva[3]%2==1	&& eva[4]%2==1){
			int minimumOdd=minimum(eva);
			if(minimumOdd==1 || minimumOdd==3 || minimumOdd==5 ){
				eva=sort(eva);
				boolean state = true;

		if(minimumOdd==1){
		if(!(eva[1]==3)){state = false;
		}
		if(!(eva[2]==5)){state = false;
		}
		if(!(eva[3]==7)){state = false;
		}
		if(!(eva[4]==9)){state = false;
		}
		return state;
		}
		else if(minimumOdd==3){//set of cards must be:3,5,7,9,11

		if(!(eva[1]==5)){state = false;
		}
		if(!(eva[2]==7)){state = false;
		}
		if(!(eva[3]==9)){state = false;
		}
		if(!(eva[4]==11)){state = false;
		}
		return state;
		}
		else if(minimumOdd==5){
		if(!(eva[1]==7)){state = false;}

		if(!(eva[2]==9)){state = false;}

		if(!(eva[3]==11)){state = false;}

		if(!(eva[4]==13)){state = false;}
		return state;
		}
		return false;
		}
			else{

				return false;
		}
		}
			else
			{
		return false;
		}
	}
	public static boolean hasEvenStraight(Card [] cards) {	
		int[] eva = evalForStraights(cards);
		for(int index=0;index<eva.length;index++){
			if(eva[index]==1){
				eva[index]=14;
			}
		}
			if(eva[0]%2==0
					&&eva[1]%2==0
					&&eva[2]%2==0
					&&eva[3]%2==0
					&&eva[4]%2==0){
		int minimumEven= minimum(eva);
			if( minimumEven==2 || minimumEven==4 || minimumEven==6 ){ 
				eva=sort(eva);
				boolean state = true;
		if(minimumEven==2){
		if(!(eva[1]==4)){state=false;}
		if(!(eva[2]==6)){state=false;}
		if(!(eva[3]==8)){state=false;}
		if(!(eva[4]==10)){state=false;}
		return state;
		}else if(minimumEven==4){
		if(!(eva[1]==6)){state=false;}
		if(!(eva[2]==8)){state=false;}
		if(!(eva[3]==10)){state=false;}
		if(!(eva[4]==12)){state=false;}
		return state;
		}
		else if(minimumEven==6){
		if(!(eva[1]==8)){state=false;}
		if(!(eva[2]==10)){state=false;}
		if(!(eva[3]==12)){state=false;}
		if(!(eva[4]==14)){state=false;}
		return state;
		}
		return false;
		}
			else
		{
		return false;
		}
		}
			else
		{
		return false;
		}
}	
	public static boolean hasFlush(Card[] cards) {
		boolean statement = false;
		int[] suitEvaluator= evaluation(cards);
		for(int i = 0; i < 4; i++){
			if(suitEvaluator[i]>=5){
		statement = true;
			}
		}
		return statement;
	}
	public static boolean hasFullHouse(Card[] cards) {
			boolean threePair=false,pair=false,val=false;
			int[] evaluator= evaluation(cards);
			for(int index=0; index<13; index++){
				if(evaluator[index]==3){
					threePair=true;
				}
				if(evaluator[index]==2){
					pair=true;
				}
			}
			if (pair&&threePair){
				val= true;
			}
			return val;
			}
	public static boolean hasFourOfAKind(Card[] cards) {
		boolean val = false;
		int [] evaluator= evaluation(cards);
		for(int i = 0; i < 13; i++){
			if(evaluator[i] == 4){
				val=true;
			}
		}
		return val;
		}
	public static boolean hasStraightRainbow(Card[] cards) {
		boolean val = false;
			if((hasOddStraight(cards) || hasEvenStraight(cards)) && hasRainbow(cards)){
				val = true;
			}
		return val;
		}
	public static boolean hasStraightFlush(Card[] cards) {
		boolean val = false;
			if ((hasOddStraight(cards) || hasEvenStraight(cards)) && hasFlush(cards)){
				val = true;
			}
		return val;
		}
	private static int[] evaluation(Card[] cards){
		int[] value = new int[13];
		for(int i = 0; i < cards.length;i++){
			int Avalue=cards[i].getValue();
			value[Avalue-1]++;
		}
		return value;
		} 
	private static int[] suitEvaluator(Card[] cards){
		int[] suitEvaluator = new int[4];
		for(int i = 0; i < cards.length; i++){
			int suit=cards[i].getSuit(); 
			suitEvaluator[suit]++;
		}
		return suitEvaluator; 
		} 
	private static int pairCounter(Card[] cards){
		int[] evaluator = evaluation(cards);
		int counter = 0;
		
		for(int i = 0; i < 13; i++){
			if(evaluator[i] >= 2){
			counter++;
		}
	}
		return counter;
		}
	private static int[] evalForStraights(Card[] cards){
		int[] eval= new int[cards.length];
		
		for(int i = 0; i < cards.length; i++){
			eval[i]=cards[i].getValue();
		}
		return eval;
		}
	private static int minimum(int[] set){
		int minimum=14;
		for(int i = 0; i < set.length; i++){
			if(set[i]<minimum){
				minimum=set[i];
			}
		}
		return minimum;
	}
		private static int[] sort(int[] set){
		int index; 
		boolean statement = true;
		int var;
		
		while(statement){
		statement= false;
			for(index = 0; index < set.length-1;index++){
				if (set[index] > set[index+1]){
					var = set[index];
					set[index]= set[index+1];
					set[index+1]= var;
		statement = true;
				}
			}
		} 
		return set;
		}
	}


