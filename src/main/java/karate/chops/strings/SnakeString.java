package karate.chops.strings;

public class SnakeString {
	public static void main(String...strings) {
		String snake = getSnakeString("Hello World!");
		System.out.println(snake);
	}

	private static String getSnakeString(String input) {
		// TODO Auto-generated method stub
		
		StringBuffer snake = new StringBuffer();
		for(int i = 1; i < input.length(); i+=4)
			snake.append(input.charAt(i));
		
		for(int i = 0; i < input.length(); i+=2)
			snake.append(input.charAt(i));
		
		for(int i = 3; i < input.length(); i+=4)
			snake.append(input.charAt(i));
		
		return snake.toString();
	}
}
