// Task_0
// public class Task_0 {

// Посчитайте сколько драгоценных камней в куче обычных камней
// Пример:
// jewels = “aB”, stones = “aaaAbbbB”
// Результат в консоль ”a3B1”
// public static void main(String[] args) {

// }

// public String findJewelsInStones(String jewels, String stones) {

// return "";
// }
// }

public class task_1 {

	public static void main(String[] args) {
		String jewels = "aBc";
		String stones = "aacaAbbbcB";
		System.out.println(findJewelsInStones(jewels, stones));
	}

	public static String findJewelsInStones(String jewels, String stones) {
		StringBuilder arrJewels = new StringBuilder(jewels);
		StringBuilder arrStones = new StringBuilder(stones);
		for (int i = 0; i < arrJewels.length(); i += 2) {
			int count = 0;
			for (int j = 0; j < arrStones.length(); j++) {
				if (arrStones.substring(j, j + 1).equals(arrJewels.substring(i, i + 1))) {
					count++;
				}
			}
			arrJewels.insert(i + 1, count);
		}
		return arrJewels.toString();
	}
}