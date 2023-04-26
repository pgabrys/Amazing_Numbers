package numbers;

public class CheckingNumbersWithTwoProperties {

    static long[] selectingTwoProperties(Number number, Property firstProperty, Property secondProperty) {
        int counter = 0;
        long numberUnderCheck = number.getChosenNumber();
        long repeat = number.getRepeats();
        long[] firstSelection = new long[(int) repeat];
        /**
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

        return firstSelection;
    }

}
