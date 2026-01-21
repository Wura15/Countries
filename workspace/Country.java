public class Country {
  // private instance variables for the name, capital, language, and image file.
  private String name;
  private String capital;
  private String language;
  private String image;

  // constructor with 4 arguments
  public Country(String name, String capital, String language, String image) {
    this.name = name;
    this.capital = capital;
    this.language = language;
    this.image = image;
  }

  // default constructor (no arguments)
  public Country() {
    name = "";
    capital = "";
    language = "";
    image = "";
  }

  // accessor/get methods
  public String getName() {
    return name;
  }

  public String getCapital() {
    return capital;
  }

  public String getLanguage() {
    return language;
  }

  public String getImage() {
    return image;
  }

  // optional: mutator/set methods (only if your teacher wants them)
  public void setName(String newName) {
    name = newName;
  }

  public void setCapital(String newCapital) {
    capital = newCapital;
  }

  public void setLanguage(String newLanguage) {
    language = newLanguage;
  }

  public void setImage(String newImage) {
    image = newImage;
  }

  // toString method
  // Example: "France's capital is Paris and its primary language is French."
  @Override
  public String toString() {
    return name + "'s capital is " + capital +
           " and its primary language is " + language + ".";
  }
}