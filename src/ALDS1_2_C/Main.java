package ALDS1_2_C;

import java.util.Scanner;

public class Main {
    private int n;
    private Card[] cards;

    public Main(int n, Card[] cards) {
        this.n = n;
        this.cards = cards;
    }

    private void swap(Card[] cards, int i, int j) {
        Card temp = cards[i];
        cards[i] = cards[j];
        cards[j] = temp;
    }

    private void bubbleSort(Card[] cards) {
        boolean flag = true;
        for (int i = 0; flag; i++) {
            flag = false;
            for (int j = n - 1; j >= i + 1; j--) {
                if (cards[j].num < cards[j - 1].num) {
                    swap(cards, j, j - 1);
                    flag = true;
                }
            }
        }
    }

    private void print(Card[] cards) {
        for (int i = 0; i < n - 1; i++) {
            System.out.print(cards[i].color);
            System.out.print(cards[i].num + " ");
        }
        System.out.print(cards[n - 1].color);
        System.out.println(cards[n - 1].num);
    }

    private void selectionSort(Card[] cards) {
        for (int i = 0; i < n; i++) {
            int mini = i;
            for (int j = i; j < n; j++) {
                if (cards[j].num < cards[mini].num) {
                    mini = j;
                }
            }
            swap(cards, i, mini);
        }
    }

    private boolean isStable(Card[] bubble, Card[] sel) {
        for (int i = 0; i < n; i++) {
            if (bubble[i].color != sel[i].color) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] cardsString = new String[n];
        Card[] cards = new Card[n];
        for (int i = 0; i < n; i++) {
            cardsString[i] = in.next();
            cards[i] = new Card(cardsString[i].charAt(0), Integer.parseInt(String.valueOf(cardsString[i].charAt(1))));
        }
        Main test = new Main(n, cards);
        Card[] bubble = cards.clone();
        Card[] sel = cards.clone();

        test.bubbleSort(bubble);
        test.print(bubble);
        System.out.println("Stable");

        test.selectionSort(sel);
        test.print(sel);
        if (test.isStable(bubble, sel)) {
            System.out.println("Stable");
        } else {
            System.out.println("Not stable");
        }
    }
}

class Card{
    public char color;
    public int num;
    public Card(char color, int num){
        this.color = color;
        this.num = num;
    }
}


