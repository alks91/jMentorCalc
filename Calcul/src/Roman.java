import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

    public class Roman {


        public static Map<String, Integer> romanList = new HashMap<String, Integer>();
        static {


                romanList.put("I", 1);
                romanList.put("II", 2);
                romanList.put("III", 3);
                romanList.put("IV", 4);
                romanList.put("V", 5);
                romanList.put("VI", 6);
                romanList.put("VII", 7);
                romanList.put("VIII", 8);
                romanList.put("IX", 9);
                romanList.put("X", 10);

                //   System.out.println(getRomanDevision("X","V"));
            }


            public static String getRomanPlus (String a, String b){
                int aIn = romanList.get(a);
                int bIn = romanList.get(b);
                int cIn = aIn + bIn;
                String result = " ";
                for (Map.Entry<String, Integer> pair : romanList.entrySet()) {
                    String key = pair.getKey();
                    int value = pair.getValue();
                    if (value == cIn) {
                        result = key;
                        break;
                    }
                }
                return result;
            }


            public static String getRomanMinus (String a, String b){
                int aIn = romanList.get(a);
                int bIn = romanList.get(b);
                int cIn = aIn - bIn;
                String result = " ";
                for (Map.Entry<String, Integer> pair : romanList.entrySet()) {
                    String key = pair.getKey();
                    int value = pair.getValue();
                    if (value == cIn) {
                        result = key;
                        break;
                    }
                }
                return result;
            }
            public static String getRomanMulti (String a, String b){
                int aIn = romanList.get(a);
                int bIn = romanList.get(b);
                int cIn = aIn * bIn;
                String result = " ";
                for (Map.Entry<String, Integer> pair : romanList.entrySet()) {
                    String key = pair.getKey();
                    int value = pair.getValue();
                    if (value == cIn) {
                        result = key;
                        break;
                    }
                }
                return result;
            }

            public static String getRomanDevision (String a, String b){
                int aIn = romanList.get(a);
                int bIn = romanList.get(b);
                int cIn = aIn / bIn;
                String result = " ";
                for (Map.Entry<String, Integer> pair : romanList.entrySet()) {
                    String key = pair.getKey();
                    int value = pair.getValue();
                    if (value == cIn) {
                        result = key;
                        break;
                    }
                }
                return result;
            }
        }








