public class SimplePasswordGenerator
{
    static final String cons = "bcdfghjklmnpqrstvwxz";
    static final String vowels = "aeiouy";
    static final String nums = "012345679";
    static final String punct = "?!@#£*&";
    static final int conSize = cons.length();
    static final int vowSize = vowels.length();
    static final int numSize = nums.length();
    static final int punctSize = punct.length();


    public static void main(String[] args)
    {

    }
    public static String genPassword(int _length, int _numbers)
    {
        int length = _length;
        int numbers = _numbers;

        StringBuilder password = new StringBuilder();
        password.append(cons.toUpperCase().charAt(random(conSize)));

        for(int i = 0; i < length; i++)
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
            if(i <= )
        }

        return "null";
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
