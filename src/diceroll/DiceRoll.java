package diceroll;

import java.util.Scanner;

public class DiceRoll {

  public static void main(String[] args) {

    // Variables
    int computerRoll, userRoll, userWin = 0, userLoss = 0, userTie = 0, roundNumber = 0;
    String continueInput = "Yes";

    // Demostrate both constructors:
    DieRoll computerDice = new DieRoll();
    computerDice.setSides(6);
    DieRoll userDice = new DieRoll(6, 6);

    Scanner input = new Scanner(System.in);

    System.out.print("\nWelcome to the Dice Roll Game!\n");
    System.out.print("\n--------------------\n\n");

    while (continueInput.equalsIgnoreCase("Yes") || continueInput.equalsIgnoreCase("Y")) {
      roundNumber++;
      computerDice.roll();
      computerRoll = computerDice.getValue();
      userDice.roll();
      userRoll = userDice.getValue();

      // Print results
      System.out.println("Round " + roundNumber);
      printDiceImages(userRoll, computerRoll);
      System.out.printf("\nYou Rolled: %d\nComputer Rolled: %d\n", userRoll, computerRoll);

      // Compare
      if (userRoll > computerRoll) {
        userWin++;
        System.out.println("You Win");
      } else if (userRoll == computerRoll) {
        userTie++;
        System.out.println("Tie");
      } else {
        userLoss++;
        System.out.println("You Lose");
      }

      // Check for continuation.
      System.out.print("\nRoll again? (Yes / No) \n");
      continueInput = input.nextLine();
      System.out.print("\n--------------------\n\n");

    }
    System.out.printf("\n\nResults\n-------------------- \nTotal Rounds: %d \nWon:  %d\nTied: %d\nLost: %d\n",
        roundNumber, userWin, userTie, userLoss);
    input.close();
  }

  /**
   * Create dice images. Takes the user roll number and computer roll number.
   * Prints the dice images for each roll, side by side.
   *
   * @param userRoll
   * @param computerRoll
   */
  public static void printDiceImages(int userRoll, int computerRoll) {
    if (userRoll <= 6 && computerRoll <= 6) {
      // Create dice image specific variables
      // Create basic image shapes for use
      String solidLine = "* * * * * * * * * *", doubleDot = "*    *       *    *", leftDot = "*    *            *",
          rightDot = "*            *    *", centerDot = "*        *        *", outerLine = "*                 *";

      // Print dice images
      // Print empty line for formatting.
      System.out.println("");

      // Print first and second row
      System.out.println(solidLine + "    " + solidLine);
      System.out.println(outerLine + "    " + outerLine);

      // Check for third row
      switch (userRoll) {
      case 6:
      case 5:
      case 4:
        System.out.print(doubleDot + "    ");
        break;
      case 3:
      case 2:
        System.out.print(rightDot + "    ");
        break;
      default:
        System.out.print(outerLine + "    ");
        break;
      }
      switch (computerRoll) {
      case 6:
      case 5:
      case 4:
        System.out.print(doubleDot + "\n");
        break;
      case 3:
      case 2:
        System.out.print(rightDot + "\n");
        break;
      default:
        System.out.print(outerLine + "\n");
        break;
      }

      // Print fourth row
      System.out.println(outerLine + "    " + outerLine);

      // Check for fifth row
      switch (userRoll) {
      case 6:
        System.out.print(doubleDot + "    ");
        break;
      case 5:
      case 3:
      case 1:
        System.out.print(centerDot + "    ");
        break;
      default:
        System.out.print(outerLine + "    ");
        break;
      }
      switch (computerRoll) {
      case 6:
        System.out.print(doubleDot + "\n");
        break;
      case 5:
      case 3:
      case 1:
        System.out.print(centerDot + "\n");
        break;
      default:
        System.out.print(outerLine + "\n");
        break;
      }

      // Print sixth row
      System.out.println(outerLine + "    " + outerLine);

      // Check for seventh row
      switch (userRoll) {
      case 6:
      case 5:
      case 4:
        System.out.print(doubleDot + "    ");
        break;
      case 3:
      case 2:
        System.out.print(leftDot + "    ");
        break;
      default:
        System.out.print(outerLine + "    ");
        break;
      }
      switch (computerRoll) {
      case 6:
      case 5:
      case 4:
        System.out.print(doubleDot + "\n");
        break;
      case 3:
      case 2:
        System.out.print(leftDot + "\n");
        break;
      default:
        System.out.print(outerLine + "\n");
        break;
      }

      // Print eighth and ninth rows
      System.out.println(outerLine + "    " + outerLine);
      System.out.println(solidLine + "    " + solidLine);
    } else {
      System.out.println("No available dice images.");
    }
  }
}