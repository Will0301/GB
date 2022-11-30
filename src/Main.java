import List.Node;
import List.SLinkedList;
import List.UnderflowException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, UnderflowException {
        String txt = null;
        Scanner in = new Scanner(new FileReader("src/texto.txt"));
        while (in.hasNextLine()) {
            String line = in.nextLine();
            txt = txt + line;
        }

        String[] words = txt.split("\\s+");

        SLinkedList<WordsRank> rank = new SLinkedList<WordsRank>();
        Arrays.stream(words)
                .collect(Collectors.groupingBy(s -> s))
                .forEach((k, v) -> rank.addFirst(new WordsRank(k, v.size())));

        SLinkedList<WordsRank> testOrdenatedRank = new SLinkedList<WordsRank>();
        Arrays.stream(words)
                .collect(Collectors.groupingBy(s -> s))
                .forEach((k, v) -> testOrdenatedRank.addFirst(new WordsRank(k, v.size())));
        var t = ordenates(testOrdenatedRank);
        System.out.println("Lista ordenada:");
        for (int i = 0; i < t.size(); i++){
            var wordsRank = t.removeFirst();
            if (wordsRank != null) System.out.println("Word: "+ wordsRank.getWord()+ "\n" + "Times: " + wordsRank.getTimes()+ "\n");
        }
    }

    public static SLinkedList<WordsRank> ordenates(SLinkedList<WordsRank> rank) throws UnderflowException {
        WordsRank[] orderedRank = new WordsRank[3000];
        var value = new WordsRank(null, null);
        var count = 0;
        while (value != null) {
            value = rank.removeFirst();
            orderedRank[count] = value;
            count++;
        }
        AllWords all = new AllWords(orderedRank);
        SLinkedList<WordsRank> answer = new SLinkedList<WordsRank>();
       orderedRank = ordenar(all);
        for (int i = 0; i < orderedRank.length; i++) {
            var it = orderedRank[i];
            if (it != null) answer.addFirst(orderedRank[i]);
        }
        return answer;
    }

    public static WordsRank[] ordenar(AllWords words){
        var arr = words.getAll();
        if (arr.length > 0){
            for(int i = 1;i < arr.length; i++) {
                int j = i;
                while(j > 0 && Optional.ofNullable(arr[j]).orElse(new WordsRank("", 2)).getTimes() < Optional.ofNullable(arr[j-1]).orElse(new WordsRank("", 1)).getTimes()) {
                    WordsRank peca = arr[j];
                        arr[j] = arr[j - 1];
                        arr[j - 1] = peca;
                    j--;
                }
            }
        }
        return arr;
    }
}