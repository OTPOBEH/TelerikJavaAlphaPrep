import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Hops {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] fieldInput = reader.readLine().split(", "); //сплитваме инпута от конзолата и го пълним в array
        int sequenceCount = Integer.parseInt(reader.readLine()); //приемаме броя на командите от конзолата

        long maxCarrots = Integer.parseInt(fieldInput[0]); //тъй като зайчето със сигурност ще изяде морковите от клетка 0, директно приравняваме максималното количество моркови на нея

        for (int i = 1; i <= sequenceCount; i++) {//с този цикъл приемаме и обработваме всеки инпут на команди
            String[] directionSetInput = reader.readLine().split(", "); //приемаме командите от конзолата и ги разделяме в array от стрингове

            int currentFieldIndex = 0; //стартираме от клетка 0, както е по условие
            HashSet<Integer> visitedRows = new HashSet<>(); //тук пазим посетените клетки
            visitedRows.add(currentFieldIndex); //директно записваме клетка 0 в посетените
            long currentCarrots = Integer.parseInt(fieldInput[0]); //директно прибавяме морковите от клетка 0 към изядените моркови

            for (int j = 0; j < directionSetInput.length; j++) {//с този цикъл итерираме по стойностите от командите
                int currentJump = Integer.parseInt(directionSetInput[j]);//парсваме съответната команда(скокове)
                currentFieldIndex += currentJump; //виждаме къде ще се озове зайчето

                if (currentFieldIndex < 0 || currentFieldIndex >= fieldInput.length || visitedRows.contains(currentFieldIndex)) break; //проверяваме дали зайчето
                //няма да излезе от матрицата или дали клетката не е била посетена вече и евентуално прекратяваме изълнението на командите

                int currentFieldCarrots = Integer.parseInt(fieldInput[currentFieldIndex]); //виждаме колко моркова има на клетката, върху която е скочило зайчето
                currentCarrots += currentFieldCarrots; //прибавяме морковите, към общото количество моркови изядени в момента от зайчето
                visitedRows.add(currentFieldIndex); //прибавяме индекса на сегашната клетка към посетените
            }
            if (currentCarrots > maxCarrots) maxCarrots = currentCarrots; //проверяваме дали зайчето в момента не е изяло най-много моркови
        }

        System.out.println(maxCarrots);
    }
}