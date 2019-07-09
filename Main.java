import java.io.*; 
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in); 
		Path wordsFile = Paths.get("Hashtags.txt");

		System.out.println("How many hashtags do you want?");
		int numberOfTags = scan.nextInt();


		ArrayList<String> randomWords1 = randomWordsFromFile("Hashtags.txt", numberOfTags);
		OutputStream outputStream = new BufferedOutputStream(Files.newOutputStream(wordsFile, CREATE));
		String formattedString = randomWords1.toString().replace("[", "").replace("]", "").replace(",", " ");
		System.out.println(formattedString);
		outputStream.flush();
	}

	private static ArrayList<String> randomWordsFromFile(String fileName, int count) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File(fileName));
		ArrayList<String> words = new ArrayList<>();
		while (scanner.hasNext()) {
			words.add(scanner.next());
		}
		return randomFromWords(words, count);
	}



	static private ArrayList<String> randomFromWords(ArrayList<String>     words, int count) {
		ArrayList<String> randomWords = new ArrayList<>();
		for (int i = 0; i < count; ) {
			int randomWord = new Random().nextInt(words.size());
			if (randomWords.add(words.get(randomWord))) {
				i++;
			}
		}
		return randomWords;
	}
}
