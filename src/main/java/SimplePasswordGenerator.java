public class SimplePasswordGenerator
{
    static final String cons = "bcdfghjklmnpqrstvwxz";
    static final String vowels = "aeiou";
    static final String nums = "012345679";
    static final String special = "?!@#£*&";
    static final int conSize = cons.length();
    static final int vowSize = vowels.length();
    static final int numSize = nums.length();
    static final int specSize = special.length();


    public static void main(String[] args)
    {
        System.out.println(genPassword());
    }

    public static String genPassword()
    {
        return genPassword(6, 4, 2);
    }

    public static String genPassword(int _letters, int _numbers, int _special)
    {
        int i;

        StringBuilder password = new StringBuilder();
        password.append(cons.toUpperCase().charAt(random(conSize)));

        for(i = 0; i < _letters; i++)
        {
            //alternate consonants and vowels
            for(int j = 0; j < 2; j++)
            {
                if(j == 0)
                {
                    password.append(vowels.charAt(random(vowSize)));
                }
                else
                {
                    password.append(cons.charAt(random(conSize)));
                }
            }
        }
        //append numbers
        for(i = 0; i < _numbers; i++)
        {
            password.append(nums.charAt(random(numSize)));
        }
        for(i = 0; i < _special; i++)
        {
            password.append(special.charAt(random(specSize)));
        }

        return password.toString();
    }

    public static boolean coinFlip()
    {
        int flip = (int)(Math.random() * 1000);
        return (flip % 2 == 0) ? true : false;
    }

    public static int random(int _maxSize)
    {
        return (int) (Math.random() * _maxSize);
    }
}
