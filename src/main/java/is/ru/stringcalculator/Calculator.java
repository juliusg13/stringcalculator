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
		
		String text1 = "";

		if(text.contains("[")){
			int count = 0;
			for(int i = 0; i < text.length(); i++)
				{
					if(text.substring(i, i+1).equals("["))
					{
						count++;;
					}
				}

			for(int k = 0; k < count; k++)
			{
				int indexx = text.indexOf("[");
				int dindex = text.indexOf("]");
				String delim = "";

				String Tdelim = text.substring(indexx + 1, dindex);


				for(int i = 0; i < Tdelim.length(); i++)
				{
					delim = delim + "\\" + Tdelim.substring(i, i+1);
				}

				text = text.substring(dindex+1, text.length());

				text = text.replaceAll("\n", ",");

				text = text.replaceAll(delim, ",");
				if(k == 0)
				{
					text = text.replaceFirst(",", "");
				}


			}

		return splitNumbers(text);
		}
		else {
			String delim = text.substring(2, 3);
			text1 = text;
			String newText = text1.replaceFirst("\n", "");
			String newer = newText.replaceAll(delim, ",");
			String Newest = newer.replaceAll("/", "");
			String returner = Newest.replaceFirst(",", "");

			return (splitNumbers(returner));
			}
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
