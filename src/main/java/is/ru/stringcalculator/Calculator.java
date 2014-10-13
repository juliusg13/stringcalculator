package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		if(text.equals("")){
			return 0;
		}
		if(text.contains("//")){
			return sum(splitDelims(text));
		}
		else if(text.contains(",")){
			return sum(splitNumbers(text));
		}
		else
			return toInt(text);
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers){
	    return numbers.split("(,)|(\n)");
	}
	private static String[] splitDelims(String text){
		String newText = text.replaceAll("\n", "");
		String delim = text.substring(2, 3);
		String newer = newText.replaceAll(delim, ",");
		String Newest = newer.replaceAll("/", "");
		String returner = Newest.replaceFirst(",", "");

		return (splitNumbers(returner));
	}

 
	private static int sum(String[] numbers){
		int total = 0;
		String Negative = "Negatives are not allowed: ";
		int count = 0;
        	for(String number : numbers){
			if(toInt(number) < 1001)
			{
				total += toInt(number);
			}
			else if(toInt(number) < 0)
			{
				Negative = Negative + "," + toInt(number);
				count++;
			}

		}
		if(count > 0){
			String NewNegative = Negative.replaceFirst(",", "");
			throw new RuntimeException(NewNegative);
		}
		return total;
    }



}
