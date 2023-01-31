import java.util.Scanner;

public class SimplePasswordGenerator
{
    static final String cons = "bcdfghjklmnprstvwz";
    static final String vowels = "aeiou";
    static final String nums = "012345679";
    static final String special = "?!@#£*&";
    static final int conSize = cons.length();
    static final int vowSize = vowels.length();
    static final int numSize = nums.length();
    static final int specSize = special.length();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args)
    {

        System.out.println("Please follow the prompts to select the number of letters, numbers, and special characters you would like in the password.");
        int letters = getInput("How many letters would you like in the password? ");
        letters /= 2;
        int numbers = getInput("How many numbers would you like in the password? ");
        int spec = getInput("How many special characters would you like in the password? ");

        boolean mutate = false;
        System.out.println("Should the letters have a random case? ");
        String cases = input.nextLine();
        if(cases.toLowerCase().charAt(0) == 'y')
        {
            mutate = true;
        }

        boolean addSpace = false;
        System.out.println("Would you like spaces to make reading easier? ");
        String spaces = input.nextLine();
        if(spaces.toLowerCase().charAt(0) == 'y')
        {
            addSpace = true;
        }
        int choices = getInput("How many passwords would you like to choose from? ");

        for(int i = 0; i < choices; i++)
        {
            System.out.println(genPassword(letters, numbers, spec, mutate, addSpace));
        }
    }

    public static String genPassword(int _letters, int _numbers, int _special, boolean _cases, boolean _spaces)
    {
        int i;

        StringBuilder password = new StringBuilder();

        for(i = 0; i < _letters; i++)
        {
            //alternate consonants and vowels
            for(int j = 0; j < 2; j++)
            {
                if(j == 0)
                {
                    if(_cases && mutator())
                    {
                        password.append(cons.toUpperCase().charAt(random(conSize)));
                    }
                    else
                    {
                        password.append(cons.charAt(random(conSize)));
                    }
                }
                else
                {
                    if(_cases && mutator())
                    {
                        password.append(vowels.toUpperCase().charAt(random(vowSize)));
                    }
                    else
                    {
                        password.append(vowels.charAt(random(vowSize)));
                    }
                    if(_spaces)
                        password.append(" ");
                }
            }
        }
        //append numbers
        for(i = 0; i < _numbers; i++)
        {
            password.append(nums.charAt(random(numSize)));
        }
        if(_spaces)
            password.append(" ");
        for(i = 0; i < _special; i++)
        {
            password.append(special.charAt(random(specSize)));
        }

        return password.toString();
    }

    public static boolean mutator()
    {
        int threshold = 8;
        int flip = (int)(Math.random() * 10);
        return flip > threshold;
    }

    public static int random(int _maxSize)
    {
        return (int) (Math.random() * _maxSize);
    }

    public static int getInput(String _prompt)
    {
        int value;
        boolean repeat = true;
        do
        {
            value = 0;
            System.out.println(_prompt);
            try
            {
                value = input.nextInt();
                if(value < 0) //do not allow negative numbers
                    throw new Exception();
                input.nextLine();
                repeat = false;
            }
            catch (Exception e)
            {
                System.out.println("Invalid input. ");
                input.nextLine();
            }
        } while(repeat);
        return value;
    }
}
