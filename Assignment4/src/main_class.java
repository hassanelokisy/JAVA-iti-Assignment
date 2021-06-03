public class main_class {
    public static void main(String[] args) {
        String string1="This Text1 to test";
        String string2="This Text1 to test and more";

        String longer = StringFunctions.betterString(string1, string2, (s1, s2) -> s1.length() > s2.length());

        System.out.println("The Better String: " + longer);

        // Lambda Expression and Method Reference: Lab Exercise 2
        String testCharsOnly1 = "OnlyAlphabets";
        String testCharsOnly2 = "letters 2205 + Alphabets";

        System.out.println(StringFunctions.isLetter(testCharsOnly1)? "only letters" : "letters and other types");
        System.out.println(StringFunctions.isLetter(testCharsOnly2 )? "only letters" : "letters and other types");

    }
}
