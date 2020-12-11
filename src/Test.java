import java.util.*;
import java.util.stream.Collectors;
import java.util.Random;

public class Test {
    public static void main(String[] args) {

        String[] array = new String[]{"муд", "доМ", "март","мандарин", "Нет", "труД", "трам"};
        String result = String.join(" ", getCorrectList(array));
        System.out.println(result);

    }

    public static String[] getCorrectList(String[] array){
//        CREATING NEW ARRAY WHERE WE WILL PUT WORDS IN ORDER.
        String[] newArray = new String[array.length];
        List<String>list;
        //CREATING A CLASS THAT WILL HELP US RANDOMLY CHOOSE AMONG SEVERAL OPTIONS.
        Random randomClass = new Random();
        int random, max;
        max = array.length;
        random = randomClass.nextInt(max);
//        HERE WE RANDOMLY CHOOSE THE FIRST WORD USING INITIAL ARRAY
        newArray[0] = array[random];
//        HERE WE CHOOSE OTHER WORDS TO FILL IN THE NEW ARRAY STARTING FROM THE SECOND POSITION - [1]
        for (int i = 1; i < newArray.length; i++) {
            String string = newArray[i-1];
            list = Arrays.stream(array)
                    .filter(x -> x.substring(0,1).compareToIgnoreCase(string.substring(string.length()-1)) == 0)
                    .filter(x -> !Arrays.asList(newArray).contains(x))
                    .collect(Collectors.toList());
            max = list.size();
            random = max > 1? randomClass.nextInt(max) : 0;
            System.out.println(random);
            System.out.println(list.get(0));
            newArray[i] = list.get(random);
        }
        String firstWord = newArray[0];
        String lastWord = newArray[array.length-1];
        if (firstWord.substring(0,1).compareToIgnoreCase(lastWord.substring(lastWord.length()-1)) != 0){
            getCorrectList(array);
        }
            return newArray;
    }

}
