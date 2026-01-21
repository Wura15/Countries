import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.ImageIcon;

public class Main {
  private Country[] countryArray;
  private int index;
  private ImageIcon img;
  private javax.swing.JLabel imageLabel;
  private javax.swing.JLabel outputLabel;

  public void loadCountries() {
    File file = new File("/workspaces/Countries/workspace/countries-data.csv");

    try {
      Scanner fileScanner = new Scanner(file);
      int i = 0;

      while (fileScanner.hasNextLine() && i < countryArray.length) {
        String line = fileScanner.nextLine();
        // skip empty lines if any
        if (line.trim().length() == 0) {
          continue;
        }

        // split by comma
        String[] parts = line.split(",");
        // parts[0] = name, parts[1] = capital, parts[2] = language, parts[3] = image filename
        String name = parts[0].trim();
        String capital = parts[1].trim();
        String language = parts[2].trim();
        String image = parts[3].trim();

        Country c = new Country(name, capital, language, image);
        countryArray[i] = c;
        i++;
      }

      fileScanner.close();
    } catch (FileNotFoundException e) {
      System.out.println("countries-data.csv file not found!");
      e.printStackTrace();
    }
  }

  public void showCountry() {
  // Get the country at index
  Country c = countryArray[index];

  // Get its image file name
  String imagefile = c.getImage();

  // Create a new ImageIcon and put it in the GUI
  img = new ImageIcon("/workspaces/Countries/workspace/" + imagefile);
  imageLabel.setIcon(img);

  // Ask a question about the country
  outputLabel.setText("What is the capital of " + c.getName() + "?");
}
public void nextButtonClick() {
  index++;
  if (index >= countryArray.length) {
    index = 0; // wrap around
  }

  // clear the label
  outputLabel.setText("");

  // show the next country
  showCountry();
}
public void reviewButtonClick() {
  Country c = countryArray[index];
  String text = c.toString();

  System.out.println(text);
  outputLabel.setText(text);
}
public void quizButtonClick() {
  try (Scanner scan = new Scanner(System.in)) {
    // clear label
    outputLabel.setText("");

    // current country
    Country c = countryArray[index];

    // ask question
    System.out.println("What is the capital of " + c.getName() + "?");
    outputLabel.setText("Check the console: What is the capital of " + c.getName() + "?");

    // get answer from the console
    String answer = scan.nextLine().trim();

    // check answer (case‑insensitive)
    if (answer.equalsIgnoreCase(c.getCapital())) {
      System.out.println("Correct!");
      outputLabel.setText("Correct! The capital of " + c.getName() + " is " + c.getCapital() + ".");
    } else {
      System.out.println("Incorrect. The correct answer is " + c.getCapital() + ".");
      outputLabel.setText("Incorrect. The capital of " + c.getName() + " is " + c.getCapital() + ".");
    }
  }
}

  public static void main(String[] args) {
  }
}