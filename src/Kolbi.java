/*По условие:
В първaта колба никога не поставяй нищо, тъй като колкото и да наливаш в нея тя ще е винаги празна.
Всяка следваща колба събира толкова литри, колкото ако към номера на предишната колба прибавиш литрите,
които събира предходната колба.

Колба:   Сдържание:
1       0
2       0 + 1                   съдържанието на предходната(0) колба събран с номера й(1)
3       (0 + 1) + 2             съдържанието на предходната(0 + 1) колба събран с номера й(2)
4       ((0 + 1) + 2) + 3       ....
...     ...
N       0 + 1 + ... + (N-1)

Формулата за намиране на сбора на всички числа от 1 до N - 1 e:
S = N * (N + 1) / 2     ако се реши това уравнение за N, защото S ни е дадено по условие и
закръглим резултата нагоре получаваме номера на търсената колба. На там е лесно. Само трябва да проверим дали
числото е четно и ако е четно да му прибавим едно. Или да го разделим на 2, после да го умножим по 2 и да му прибавим 1.
Това е.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Kolbi {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] inputValues = in.readLine().split(" ");
        double liquid = Double.parseDouble(inputValues[1]);

        int needContainerNumber = (int) Math.ceil((1 + Math.sqrt(1 + 8 * liquid)) / 2) / 2 * 2 + 1; //<--- Решение

        System.out.println(needContainerNumber);
    }
}