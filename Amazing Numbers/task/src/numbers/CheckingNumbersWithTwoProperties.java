package numbers;

import java.util.Arrays;

public class CheckingNumbersWithTwoProperties {

    static long[] selectingTwoProperties(Number number, Property firstProperty, Property secondProperty) {
        int counter = 0;
        long numberUnderCheck = number.getChosenNumber();
        long repeat = number.getRepeats();
        long[] selectedNumbers = new long[(int) repeat];


        do {
            if (checkingFirstProperty(number,firstProperty) == true
                    && checkingSecondProperty(number, secondProperty) == true) {
                selectedNumbers[counter] = numberUnderCheck;
                counter++;
            }
            numberUnderCheck++;
            number.setChosenNumber(numberUnderCheck);
        } while (counter != repeat);


        /**
         *----------------18.05.2023---------------------
         * Teoretycznie, mam logikę odnośnie sprawdzania liczby pod kątem dwóch warunków:
         *  - są 3 metody, o którym mowa pożniej
         *  - udało się nawet wykorzystać wczesniejszy kod (CheckingNumber) bez żadnej modyfikacji
         *  - liczby, który pasują są dodawane do tablicy
         *
         * No to teraz trzeba ogarnąć drukowaniego tego wszystkiego na tablicę
         * ---------------16.05.2023---------------------
         * No niestety, wychodzi na to, że koncept z for i reużyciem kodu nie zadziała...
         * Obecny koncept to pętla do-while, warunek wpisany.
         *
         * Trzeba napisać trzy metody:
         *  1. Metoda która będzie sprawdzać liczbę - tutaj cała logika do EVEN itd.,
         *     oparta na swicthu i ENUM,zwraca ona boolean
         *  2. Prosta metoda, która bierze liczbę i enuma, przekazuje ją do pierwszej metody a następnie
         *     dostaje zwrot boolean, który ustawia "firstPropertyTrue".
         *  3. Robi to samo co metoda 2, tylko dla "secondPropertyTrue
         *
         * Następnie If, który sprawdza czy booleany z metody 2 i 3 są prawdziwe, a jeśli tak,
         * dodaje sprawdzaną liczbę do tablicy i podbija counter.
         *
         * -------------- 15.05.2023-----------------------
         * Użyć pętli for, liczba startowa to input, licza powtórzeń pętli również.
         * Następnie, już w samej pętli użyć powrówniania właściwości z inputu do ENUM'a i za pomocą tego
         * odpalić odpowiednią metodę - tutaj myślę, aby wykorzystać metody ze sprawdzania pojedyńczej liczby -
         *  zwraca ona boolean'a
         *
         *  Następnie, za pomocą if'a sprawdzić czy są dwa "true" - jeśli tak, dodać do tablicy/listy
         *  i podbić counter.
         *
         *  Następnie pozostaje obróbka listy aby już wydrukować do konsoli
         *  -------------------------------------------------------
         *
         *
         * Tutaj MUSZĘ wykorzystać kod do sprawdzania liczby z jedną właściowością (bo po co pisać jeszcze
         * raz to samo?) - czyli wywołać metodę z tej klasy. Tylko tutaj może mi pomysł rozjebać fakt,
         * że w tamtej metodzie pobiera ilość powtórzeń.... Ale może by to spróbować obejść poprzez próbę
         * nadpisania ilości powtórzeń na wartość 1 (?)
         * Tylko kurwaa...metoda zwraca wtedy tablicę, a nie boolean'a. Czyli kurwa co, ciagłe scalanie tablic?
         *
         * Myk polega na tym, że gdy metoda będzie sprawdzać pierwszą właściwość, gdy dostanie matcha
         * musi sprawdzić od razu drugą właściwość. Gdy będzie match, dodać do tabeli (jak przy jednej
         * właściwości), a jak nie to, to nie.
         */

        return selectedNumbers;
    }

    private static boolean checkingNumber(Number number, Property property) {
        boolean propertyOk = false;
        switch (property) {
            case EVEN -> {
               propertyOk = CheckingNumber.isEven(number);
            }
            case ODD -> {
                propertyOk = CheckingNumber.isOdd(number);
            }
            case BUZZ -> {
                propertyOk = CheckingNumber.isBuzz(number);
            }
            case DUCK -> {
                propertyOk = CheckingNumber.isDuck(number);
            }
            case PALINDROMIC -> {
                propertyOk = CheckingNumber.isPalindromic(number);
            }
            case GAPFUL -> {
                propertyOk = CheckingNumber.isGapful(number);
            }
            case SPY -> {
                propertyOk = CheckingNumber.isSpy(number);
            }
            case SQUARE -> {
                propertyOk = CheckingNumber.isSquare(number);
            }
            case SUNNY -> {
                propertyOk = CheckingNumber.isSunny(number);
            }
        }
        return propertyOk;
    }

    private static boolean checkingFirstProperty(Number number, Property property) {
        return checkingNumber(number, number.getFirstProperty());
    }

    private static boolean checkingSecondProperty(Number number, Property property) {
        return checkingNumber(number, number.getSecondProperty());
    }

}
