public class WordsRank {
    private String word;
    private Integer times;

    public WordsRank(String word, Integer times) {
        this.word = word;
        this.times = times;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }

    public int compareTo(Integer stock){
        return this.times - stock;
    }
}
