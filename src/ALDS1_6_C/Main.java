package ALDS1_6_C;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        Card[] cards = new Card[n];
        for (int i = 0; i < n; i++) {
            String color = in.next();
            int num = Integer.parseInt(in.next());
            cards[i] = new Card(color, num);
        }
        Card[] qS = cards.clone();
        Card[] mS = cards.clone();
        quickSort(qS, 0, n - 1);
        mergeSort(mS, 0, n);
        boolean stable = true;
        for (int i = 0; i < n; i++) {
            if (qS[i] != mS[i]) {
                stable = false;
            }
        }
        if (stable) {
            System.out.println("Stable");
        } else {
            System.out.println("Not stable");
        }
        for (int i = 0; i < n; i++) {
            System.out.println(qS[i].color + " " + qS[i].num);
        }
    }

    public static void quickSort(Card[] cards, int p, int r) {
        if (p < r) {
            int q = partition(cards, p, r);
            quickSort(cards, p, q - 1);
            quickSort(cards, q + 1, r);
        }
    }

    public static int partition(Card[] cards, int p, int r) {
        Card x = cards[r];
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if (cards[j].num <= x.num) {
                i++;
                swap(cards, i, j);
            }
        }
        swap(cards, i + 1, r);
        return i + 1;
    }

    public static void swap(Card[] cards, int x, int y) {
        Card temp = cards[x];
        cards[x] = cards[y];
        cards[y] = temp;
    }

    public static void mergeSort(Card[] cards, int left, int right) {
        if (left + 1 < right) {
            int mid = (left + right) / 2;
            mergeSort(cards, left, mid);
            mergeSort(cards, mid, right);
            merge(cards, left, mid, right);
        }
    }

    public static void merge(Card[] cards, int left, int mid, int right) {
        int n1 = mid - left;
        int n2 = right - mid;
        Card[] L = new Card[n1];
        Card[] R = new Card[n2];
        for (int i = 0; i < n1; i++) {
            L[i] = cards[left + i];
        }
        for (int i = 0; i < n2; i++) {
            R[i] = cards[mid + i];
        }
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i].num <= R[j].num) {
                cards[k++] = L[i++];
            } else {
                cards[k++] = R[j++];
            }
        }
        while (i < n1) cards[k++] = L[i++];
        while (j < n2) cards[k++] = R[j++];
    }

}


class Card {
    public String color;
    public int num;

    public Card(String color, int num) {
        this.color = color;
        this.num = num;
    }
}