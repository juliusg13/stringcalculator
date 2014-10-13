package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		if(text.equals("")){
			return 0;
		}
		if(text.contains("//")){
//			splitDelims(text);
			String newtext = text.replaceAll("\n", "");

			String delim = text.substring(2, 3);

			String Newer = newtext.replaceAll(delim, ",");

			String Newest = Newer.replaceAll("/", "");

			String returner = Newest.replaceFirst(",", "");

			return sum(splitNumbers(returner));
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
//	private static String[] splitDelims(string text){
//		String delim = text.substring(2);
//		text.replaceAll(delim, ",");
//		text = text.substring(3, text.length());
//		return Text;
//	}

 
    private static int sum(String[] numbers){
 	    int total = 0;
        for(String number : numbers){
		    total += toInt(number);
		}
		return total;
    }



}
