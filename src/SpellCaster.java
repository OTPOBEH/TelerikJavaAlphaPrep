import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SpellCaster {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] magicWords = reader.readLine().split(" ");

        StringBuilder resultSpell = new StringBuilder(); //Използваме StringBuilder за манипулиране на буквите

        int charIndex = 0;

        int exceptionCount = 0;

        while (exceptionCount != magicWords.length) {   //Извъртаме буквите на всяка дума, докато не излезем от всички думи с
                                                        // с грешка(Exception).

            for (int i = 0; i < magicWords.length; i++) {
                try {
                    resultSpell.append(magicWords[i].charAt(magicWords[i].length() - 1 - charIndex));
                } catch (StringIndexOutOfBoundsException e) { //Улавяме грешката и я броим.
                    exceptionCount++;//При брой грешки равен на броя думи - излизаме от цикъла. Всички думи са обработени.
                }
            }
            charIndex++; //Преместваме се на следващата буква
        }

        charIndex = 0;//Нулираме индекса, за да започнем отново от начална буква

        while (charIndex != resultSpell.length()) {
            int placesToShift;
            if (resultSpell.charAt(charIndex) > 96) { //Проверяваме дали е главна или малка буква
                placesToShift = resultSpell.charAt(charIndex) - 96; //Малка буква
            } else placesToShift = resultSpell.charAt(charIndex) - 64; //Главна буква

            //Изчисляваме новата позиция на буквата на долния ред.
            int newPosition = ((charIndex + placesToShift) % resultSpell.length() + resultSpell.length()) % resultSpell.length();

            char current = resultSpell.charAt(charIndex); //Запазваме си буквата

            //Преместваме буквата
            resultSpell.deleteCharAt(charIndex);
            resultSpell.insert(newPosition, current);

            charIndex++; //Преместваме се на следващата буква
        }

        System.out.println(resultSpell);
    }
}

//Spell Caster 3/10