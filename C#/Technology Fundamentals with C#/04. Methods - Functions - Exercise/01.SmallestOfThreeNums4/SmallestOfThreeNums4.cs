using System;

public class SmallestOfThreeNums
{
    public static void Main()
    {
        int[] array = new int[3];
        for (int i = 0; i < array.Length; i++)
        {
            array[i] = int.Parse(Console.ReadLine());
        }

        int result = SmallestNumber(array);
        Console.WriteLine(result);
    }
    public static int SmallestNumber(int[] arr)
    {
        int smallestNumber = int.MaxValue;

        for (int i = 0; i < arr.Length; i++)
        {
            int num = arr[i];
            if (smallestNumber> num)
            {
                smallestNumber = num;
            } 
        }
        return smallestNumber;
    }

}
