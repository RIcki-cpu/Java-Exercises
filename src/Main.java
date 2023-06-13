import java.util.*;


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");




        /*FIRST EXERCISE*/
        /*String originalString = "{json{name: Montran}";;
        String result = encodeDuplicateCharacters(originalString);
        System.out.println(result);*/

        /*SECOND EXERCISE*/
        int[] arr = {4, 2, 9, 7, 5, 4, 9, 2};
        int[][] array = countOccurrences(arr);
        for (int index=0; index< array[0].length; index++){
            System.out.println(array[0][index] + ": " + array[1][index]);
        }
    }

    public static String encodeDuplicateCharacters(String theWord) {
        char[] arrayWord = theWord.toCharArray();
        char[] arraynewWord = new char[theWord.length()];

        for (int index = 0; index<theWord.length(); index++){
            if(istheCharactertwice(arrayWord,arrayWord[index])){
                arraynewWord [index] = '}';
            }
            else {
                arraynewWord [index] = '{';
            }
        }

        return String.valueOf(arraynewWord);
    }

    public static boolean istheCharactertwice(char[] charArray, char target) {
        int count = 0;
        for (char c : charArray) {
            if (c == target) {
                count++;
                if (count > 1) {
                    return true;
                }
            }
        }
        return false;
    }


    /*
        1-  Create an array of 2xn elements
        2-  Create a list of Records. NumberOccurrence(int value, int occurrence). Skip repeated records
             (1,5) -> (2,7) -> (3,5) -> (4,3) -> ...
             NOTE: another option would have been use Sets
        3-  Create and Initialize int[2][size of the list]
        4-  Create, Initialize and Parse the List of Records to Array of Records.
            NOTE: It's easier and convenient this way for the next step
        5-  Sort the array of Records: Invoke method customQuickSort

        6- Parse the array of Records to the bi-dimensional array int[][]
        7.- Print

        */
    public static int[][] countOccurrences(int[] arr){



        List<NumberOccurrence> listRecords = new ArrayList<>();


        for (int index = 0; index< arr.length; index++){


            if(!isrepeteadRecord(listRecords,arr[index]) ){
                NumberOccurrence numberRecord =  new NumberOccurrence(arr[index], countOccurrence(arr[index],arr));
                listRecords.add(numberRecord);
            }

        }
        //it sorts the whole array based in tha value of the record
        NumberOccurrence[] arrayRecords = listRecords.toArray(new NumberOccurrence[0]);;
        customquickSort(arrayRecords);
        int[][] ocurrences = new int[2][listRecords.size()];




        //parse array of records to int[][]
        for (int index = 0;index< arrayRecords.length; index++){


            ocurrences[0][index] = arrayRecords[index].value();
            ocurrences[1][index] = arrayRecords[index].occurrence();

        }


        return ocurrences;
    }

    private static boolean isrepeteadRecord(List<NumberOccurrence> list, int i) {

        int index =0;
        for (NumberOccurrence record:
             list) {
            if(i==record.value()) return true;
        }
        return false;
    }



   /* private static Set<Integer> parseToSet(int[] arr) {
        Set<Integer> set  = new HashSet<>();
        for (int number:
             arr) {
            set.add(number);
        }
        return set;
    }*/

    public static int countOccurrence(int number, int[] arr){
        int ocurrence = 0;
        for (int value: arr
             ) {
            if(number==value){
                ocurrence++;
            }
        }
        return ocurrence;
    }
    //Custom QuickSort method that works with an Array of records
    public static void customquickSort(NumberOccurrence[] array) {
        //if array is empty false
        if (array == null || array.length == 0) {
            return;
        }
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(NumberOccurrence[] array, int low, int high) {
        if (low >= high) {
            return;
        }
        int pivotIndex = partition(array, low, high);
        quickSort(array, low, pivotIndex - 1);
        quickSort(array, pivotIndex + 1, high);
    }

    private static int partition(NumberOccurrence[] array, int low, int high) {
        int pivot= array[high].value();// int pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
             if (array[j].value() < pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        return i + 1;
    }

    private static void swap(NumberOccurrence[] array, int i, int j) {
        NumberOccurrence temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public record NumberOccurrence(int value, int occurrence) {
    }
    /* newarray[1] = new NumberOccurrence(1, 4);
        newarray[2]  = new NumberOccurrence(2, 5);
        newarray[3]= new NumberOccurrence(7, 3);
        newarray[4]  = new NumberOccurrence(3, 8);*/

    //This was my first attemp before realizing that I also needed to store the positions as well as the repetition
    public static String encodeDuplicateCharactersLegacy(String theWord){
        //This map will store each character repetition in an efficient and lazy way
        Map<Character, Integer>stringMap = new HashMap<>();

        char[] newString = new char[theWord.length()];

        for (char letter:  theWord.toCharArray()) {



            if(stringMap.containsKey(letter)){
                int repetition = stringMap.get(letter);
                stringMap.put(letter,repetition++);
            }else {
                stringMap.put(letter,0);
            }
        }
        int index = 0;
        for (Map.Entry<Character, Integer> letter: stringMap.entrySet()) {
            char key =  letter.getKey();
            Integer value =  letter.getValue();
            if(value>1){
                newString[index++] = '}';
            }
            else{
                newString[index++] = '{';
            }
        }

        return String.valueOf(newString);

    }
}

