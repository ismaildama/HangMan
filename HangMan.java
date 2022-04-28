import java.util.Scanner;
import javax.swing.JOptionPane;

class HangMan {

    private String first_player, second_player, phrase, input;
    private char[] output;
    private char answer;
    private int errors;

    public HangMan() {

        Scanner s = new Scanner(System.in);
        System.out.println("");
        System.out.println("   Welcome to the Hangman!           Version: 1.0  ");
        System.out.println("                O                                  ");
        System.out.println("               /|\\                                ");
        System.out.println("               / \\                                ");
        System.out.println("----------------------------------------------------");

        while (true) {

            System.out.print("First player name is: ");
            first_player = s.nextLine();
            System.out.print("Second player name is: ");
            second_player = s.nextLine();
            System.out.println("------------------------------------------------------");

            phrase = (JOptionPane.showInputDialog(first_player + " insert the secret word!")).toLowerCase();
            output = getNumber(phrase.length());
            System.out.println("The phrase was inserted succesfully!");

            while (true) {

                System.out.println("----------------------------------------------------");
                paintErrors(errors);

                System.out.print("Word: ");
                printCharArray(output);
                System.out.println("					 |Errors: " + errors);

                if (errors == 6) {
                    System.out.println("Player " + first_player + " won!");
                    break;

                } else if (!areLeft(output)) {
                    System.out.println("Player " + second_player + " won!");
                    break;
                }

                System.out.print("The character is: ");
                input = s.nextLine();

                if (input.length() > 1)
                    System.out.println("Please insert only one character!");
                else {
                    answer = input.charAt(0);

                    if (!findCharacters(answer, phrase, output)) {

                        errors++;
                        System.out.println("Nope! Try again next time!");
                    } else
                        System.out.println("Well Done!");
                }
                //Cycle for errors
            }
            System.out.println("Do you want to play again?(yes/no)");
            System.out.print("Answer: ");
            String f = (s.nextLine()).toLowerCase();

            if (f.equals("no"))
                break;

        }

    }

    public void printCharArray(char[] c) {
        for (char x : c)
            System.out.print(x + "");
    }

    boolean areLeft(char[] o) {
        for (char x : o) {
            if (x == '-')
                return true;
        }
        return false;
    }

    public boolean findCharacters(char c, String in, char[] out) {
        boolean wasFound = false;
        for (int i = 0; i < in.length(); i++) {
            if (c == in.charAt(i)) {
                wasFound = true;
                out[i] = c;
            }
        }
        return wasFound;
    }

    public char[] getNumber(int nr) {
        char s[] = new char[nr];

        for (int i = 0; i < nr; i++)
            s[i] = '-';

        return s;
    }

    public void paintErrors(int errors) {

        switch (errors) {
            case 1:
                System.out.println("O");
                break;
            case 2:
                System.out.println("  O");
                System.out.println("  |");
                break;
            case 3:
                System.out.println("  O");
                System.out.println(" /|");
                break;
            case 4:
                System.out.println("  O  ");
                System.out.println(" /|\\");
                break;
            case 5:
                System.out.println("  O  ");
                System.out.println(" /|\\");
                System.out.println(" /   ");
                break;
            case 6:
                System.out.println("   O  ");
                System.out.println("  /|\\");
                System.out.println("  / \\");
                break;
        }
    }


}
