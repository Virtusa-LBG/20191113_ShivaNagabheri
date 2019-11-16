import java.util.HashMap;

public class NumberToWordConvertor {

	private static HashMap<Integer,String> numberInName = new HashMap<>();

	public NumberToWordConvertor(){
		numberInName.put(0,"");
		numberInName.put(1,"one");
		numberInName.put(2,"two");
		numberInName.put(3,"three");
		numberInName.put(4,"four");
		numberInName.put(5,"five");
		numberInName.put(6,"six");
		numberInName.put(7,"seven");
		numberInName.put(8,"eight");
		numberInName.put(9,"nine");

		numberInName.put(10,"ten");
		numberInName.put(20,"twenty");
		numberInName.put(30,"thirty");
		numberInName.put(40,"forty");
		numberInName.put(50,"fifty");
		numberInName.put(60,"sixty");
		numberInName.put(70,"seventy");
		numberInName.put(80,"eighty");
		numberInName.put(90,"ninty");	
		
		numberInName.put(11, "eleven");
		numberInName.put(12, "twelve");
		numberInName.put(13, "thirteen");
		numberInName.put(14, "forteen");
		numberInName.put(15, "fiteen");
		numberInName.put(16, "sixteen");
		numberInName.put(17, "seventeen");
		numberInName.put(18, "eighteen");
		numberInName.put(19, "ninteen");		
	}

	public String convertToName(Integer number) {
		StringBuilder numberInWords = new StringBuilder();		
		int count = 0, subcount = 0;			
		String multipleOfTens = multipleofTens(number);
		if(multipleOfTens != null)
			return multipleOfTens;
		while(number%10 > 0 || number == 10) {
			String temp = numberInWords.toString();
			if(count == 3) {
				if(subcount == 1)		
					temp ="million "+temp;
				else
					temp ="thousand "+temp;
				count = 0;
				subcount++;
			}
			count++;
			int modValue = number%10;
			number = number/10;
			switch(count) {
				case 1:		
					 numberInWords = new StringBuilder(numberInName.get(modValue));
					break;
				case 2:
					numberInWords = new StringBuilder(numberInName.get(modValue*10));
					break;
				case 3:
					numberInWords = new StringBuilder(numberInName.get(modValue)).append(" hundred and");
			}
			numberInWords = numberInWords.append(" ").append(temp);		
			multipleOfTens = multipleofTens(number*10);
			if(multipleOfTens != null)
				return multipleOfTens +" and "+ numberInWords;
		}		
		return numberInWords.toString();
	}
	
	public String convertNumberToName(Integer number) {
		return findAndReplaceTens(convertToName(number));		
	}
	
	public String findAndReplaceTens(String value) {
		return value.replace("ten one", "eleven").replace("ten two", "twelve").replace("ten three", "thirteen")
				.replace("ten four", "forteen").replace("ten five", "fifteen").replace("ten six", "sixteen")
				.replace("ten seven", "seventeen").replace("ten eight", "eighteen").replace("ten nine", "ninteen");
	}
	
	public String multipleofTens(Integer number) {
		if(number == 0)
			return null;
		if(number%100000000 == 0)
			return numberInName.get(number/100000000)+" hundred million";
		if(number%10000000 == 0)
			return numberInName.get(number/10000000)+" hundred million";
		if(number%1000000 == 0)
			return numberInName.get(number/1000000)+" million";
		if(number%100000 == 0)
			return numberInName.get(number/100000)+" hundred thousand";
		if(number%10000 == 0)
			return numberInName.get(number/10000)+" hundred thousand";
		if(number%1000 == 0)
			return numberInName.get(number/1000)+" thousand";
		if(number%100 == 0)
			return numberInName.get(number/100)+" hundred";
		return null;
	}
	
	public static void main(String[] args) {
		NumberToWordConvertor numberToWordConvertor = new NumberToWordConvertor();
		System.out.println(numberToWordConvertor.convertNumberToName(1583));
		System.out.println(numberToWordConvertor.convertNumberToName(56945781));
		System.out.println(numberToWordConvertor.convertNumberToName(999999999));
		System.out.println(numberToWordConvertor.convertNumberToName(1005));
		System.out.println(numberToWordConvertor.convertNumberToName(100000));
		System.out.println(numberToWordConvertor.convertNumberToName(11));
	}
}
