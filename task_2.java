// public Task_1
// public class Task_1 {

// Вам дается строка S и целочисленный массив индексов int index[s.length].
// Напишите программу, которая перетасует символы в S таким образом,
// что символ c i-й позиции переместится на индекс index[i] в результирующей
// строке.
//
// Пример: s = “cba”, index = [3,2,1] result “abc”
// public static void main(String[] args) {

// }

// public String shuffle(final String s, final int[] index){

// return "";
// }
// } task_21 {

// }

public class task_2 {
	public static void main(String[] args) {
		String s = "cbaa";
		int[] index = new int[] { 2, 4, 1, 3 };
		System.out.println(shuffle(s, index));
	}

	public static String shuffle(final String word, final int[] index) {
		StringBuilder s = new StringBuilder(word);
		String[] wordShuffled = new String[s.length()];

		for (int i = 0; i < index.length; i++) {
			wordShuffled[index[i] - 1] = s.substring(i, i + 1);
		}
		return String.join("", wordShuffled);
	}
}