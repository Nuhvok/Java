// Brandon Rolfe
// Program 2
// CS 361-1A
// 9/23/20


import java.util.Scanner;

public class HexAndDecConverter 
{
   // Main Method
   public static void main(String[] args)
   {
      // Creates a scanner
      Scanner input = new Scanner(System.in);
      
      
      System.out.print("\n\n\n");
      Boolean keepGoing = true;
      do {
         // Prompts the user for what they want to do
         System.out.print("\nOptions: H=hex2dec, D=dec2hex, Q=quit");
         System.out.print("\nEnter an option: ");
         String option = input.nextLine();
         option = option.toUpperCase();
         
         // Switches depending on the users input
         switch(option)
         {
            case "H":
               System.out.print("\nPlease enter a hex number: ");
               String hex = input.nextLine();
               System.out.println("\nThe decimal value for the hex number " + hex + " is " + convertType(hex.toUpperCase()));
               break;
            case "D":
               System.out.print("\nPlease enter a decimal number: ");
               int dec = input.nextInt();
               input.nextLine();
               System.out.println("\nThe hex value for the decimal number " + dec + " is " + convertType(dec));
               break;
            case "Q":
               System.out.println("\nGoodbye");
               keepGoing = false;
               break;
            default:
               System.out.print("\n\nPlease enter one of the options listed.");
               break;
         }
         
         //System.out.print(option);
      } while (keepGoing);
   }
   
   
   // Coverts a hex number to decimal
   public static String convertType(String hex)
   {
      int decimalValue = 0;
      for(int i = 0; i < hex.length(); i++)
      {
         char hexChar = hex.charAt(i);
         decimalValue = decimalValue * 16 + hexCharToDecimal(hexChar);
      }
      
      return Integer.toString(decimalValue);
   }
   
   // Converts an individual hex character to decimal
   public static int hexCharToDecimal(char ch)
   {
      if(ch>= 'A' && ch <= 'F')
         return 10 + ch - 'A';
      else
         return ch - '0';
   }
   
   // Converts a decimal number to hex
   public static String convertType(int dec)
   {
      int rem;  // remainder
      String result = "";   
      String hexchars = "0123456789ABCDEF";  

      while(dec>0) {  
         rem = dec % 16;   
         result = hexchars.substring(rem,rem+1) + result;
         dec = dec / 16;
      }
      // result will contain the hex string 
      
      return result;
   }

}