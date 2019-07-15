import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Сalculator {

    public static void main(String[] args) throws IOException {
        while (true) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String expression = reader.readLine();
            if (expression.equals("exit")) {
                break;
            }
            String[] operandStr = expression.split("[/*+-]");
             try {
                                                                                                                                    //вот эта длинная строка мне тоже не нравится, я пробовал писать вот такое регулярное выражение ("[XIV]"), но почему то оно не срабатывало
            if ((expression.contains("I") && expression.contains("V")) || (expression.contains("I") && expression.contains("X")) || (expression.contains("V") && expression.contains("X"))||(expression.contains("V") && expression.contains("V") || (expression.contains("X") && expression.contains("X")) || (expression.contains("I") && expression.contains("I")))) {
                                                                                                                   
                if (expression.contains("+")) {
                        System.out.println(Roman.getRomanPlus(operandStr[0], operandStr[1]));
                }
                    if (expression.contains("-")) {
                        System.out.println(Roman.getRomanMinus(operandStr[0], operandStr[1]));
                    }
                    if (expression.contains("*")) {
                        System.out.println(Roman.getRomanMulti(operandStr[0], operandStr[1]));
                    }
                    if (expression.contains("/")) {
                        System.out.println(Roman.getRomanDevision(operandStr[0], operandStr[1]));
                    }
                }

                    else {

                    int[] operandInt = new int[operandStr.length];
                        for (int i = 0; i < operandInt.length; i++) {
                            operandInt[i] = Integer.parseInt(operandStr[i]);
                    }
                        if(operandInt[0] > 10 || operandInt[1] > 10){
                            System.out.println("Слишком большое число");
                            break;
                        }


                    if (expression.contains("*")) {
                        System.out.println(Operations.getMulti(operandInt[0], operandInt[1]));
                    }

                    if (expression.contains("+")) {
                        System.out.println(Operations.getPlus(operandInt[0], operandInt[1]));
                    }

                    if (expression.contains("/")) {
                        System.out.println(Operations.getDevision(operandInt[0], operandInt[1]));
                    }

                    if (expression.contains("-")) {
                        System.out.println(Operations.getMinus(operandInt[0], operandInt[1]));
                    }
                }

            } catch (Exception e ) {
                System.out.println("Не верный формат");
                break;
            }

        }
    }
}











