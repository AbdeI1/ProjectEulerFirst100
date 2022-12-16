import java.util.*;
import java.util.stream.Collectors;

class MonopolyOdds {
  public static void main(String[] args) {
    long[] boardCount = new long[40];
    List<Integer> communityCards = Arrays.stream(new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 10}).boxed().collect(Collectors.toList());
    List<Integer> chanceCards = Arrays.stream(new int[]{-1, -1, -1, -1, -1, -1, 0, 10, 11, 24, 39, 5, -2, -2, -4, -3}).boxed().collect(Collectors.toList());
    Collections.shuffle(communityCards);
    Collections.shuffle(chanceCards);
    Queue<Integer> commuityDeck = new ArrayDeque<>(communityCards);
    Queue<Integer> chanceDeck = new ArrayDeque<>(chanceCards);
    int die = 4;
    int tries = 100_000_000;
    int pos = 0;
    int numDouble = 0;
    while(tries --> 0) {
      int r1 = (int)Math.floor(Math.random()*die) + 1;
      int r2 = (int)Math.floor(Math.random()*die) + 1;
      if(r1 == r2) { numDouble++; } else { numDouble = 0; }
      pos += r1 + r2;
      pos %= 40;
      if(numDouble == 3) {
        pos = 10;
        numDouble = 0;
      }
      // Go to Jail
      if(pos == 30) {
        pos = 10;
      }
      // Community Chest
      if(pos == 2 || pos == 17 || pos == 33) {
        int draw = commuityDeck.remove();
        if(draw != -1) {
          pos = draw;
        }
        commuityDeck.add(draw);
      }
      // Chance Cards
      if(pos == 7 || pos == 22 || pos == 36) {
        int draw = chanceDeck.remove();
        if(draw >= 0) {
          pos = draw;
        } else if (draw == -3) {
          pos -= 3;
        } else if (draw == -4) {
          pos = switch(pos) {
            case 7, 36 -> 12;
            case 22 -> 28;
            default -> -1;
          };
        } else if (draw == -2) {
          pos = switch(pos) {
            case 7 -> 15;
            case 22 -> 25;
            case 36 -> 5;
            default -> -1;
          };
        }
        chanceDeck.add(draw);
      }
      boardCount[pos]++;
    }
    int[] maxInd = {-1, -1, -1};
    for(int i = 0; i < 40; i++) {
      if(maxInd[0] == -1 || boardCount[i] > boardCount[maxInd[0]]) {
        if(maxInd[1] == -1 || boardCount[i] > boardCount[maxInd[1]]) {
          maxInd[0] = maxInd[1];
          if(maxInd[2] == -1 || boardCount[i] > boardCount[maxInd[2]]) {
            maxInd[1] = maxInd[2];
            maxInd[2] = i;
          } else {
            maxInd[1] = i;
          }
        } else {
          maxInd[0] = i;
        }
      }
    }
    System.out.printf("%02d%02d%02d\n", maxInd[2], maxInd[1], maxInd[0]);
  }
}
