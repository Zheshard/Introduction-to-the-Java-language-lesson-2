// Task_2

// На первой строке записывается натуральное число n - количество строчек в
// книге. Затем вводится n строк - строки книги. потом вводится натуральное
// число m - количество продуктов, на которые у человека аллергия. Потом
// вводится m строк - вида "продукт1 - продукт2", где продукт1 - продукт, на
// который у человека аллергия и продукт2 - продукт, на который следует заменить
// продукт1. Гарантируется что любой продукт состоит из 1 слова. название
// продуктов написаны строчными буквами. Гарантируется, что продукты, на которые
// нужно выполнить замену, не встречаются изначально в тексте.

// Выходные данные
// Замените все продукты в поваренной книге Васи и выведите их построчно на
// экран. На окончания не обращайте внимание. ВАЖНО!!! Если продукт, который
// следует заменить написан с большой буквы, то и замена тоже должна начинаться
// с большой буквы!

// Sample Input:
// 2
// Рецепт 1. Арахис 100гр, мороженое 200гр. Возьмите арахис и измелчите его. Посыпьте измельчённый арахис на мороженое.
// Рецепт 2. Клубника 100гр, сгущенка 3кг. Смешать, есть) Радоваться жизни.

// 3
// арахис - колбаса
// клубника - вишня
// сгущенка - молоко

// Sample Output:
// Рецепт 1. Колбаса 100гр, мороженое 200гр. Возьмите колбаса и измелчите его. Посыпьте измельчённый колбаса на мороженое.
// Рецепт 2. Вишня 100гр, молоко 3кг. Смешать, есть) Радоваться жизни.

import java.util.Scanner;

public class task_3 {

	// Метод для ввода строк в элементы массива:
	public static String[] enterStrings(int numOfStrings, String[] arrOfStrings) {
		Scanner scan = new Scanner(System.in, "cp866");
		for (int i = 0; i < numOfStrings; i++) {
			System.out.printf((i + 1) + ": ");
			arrOfStrings[i] = scan.nextLine();
		}
		return arrOfStrings;
	}

	// Метод для замены слов в строках:
	public static String[] replaceWordsInStrings(int ammountString, String[] sourceArr, String[] arrReplace) {
		String[] replaceElem = enterStrings(ammountString, arrReplace); // массив строк с элементами, подлежащим замене
		// Цикл для поиска элементов, которые следует заменить:
		for (int i = 0; i < replaceElem.length; i++) {
			String[] replace = replaceElem[i].split(" "); // разбить строковый элемент на подмассив
			// Вложенный цикл для обхода по элементам исходного массива:
			for (int j = 0; j < sourceArr.length; j++) {
				String[] str = sourceArr[j].split(" "); // разбить строковые элементы исходного массива на подмассивы строк
				// Цикл для поиска и замены нужного элемента в подмассиве исходного массива:
				for (int k = 0; k < str.length; k++) {
					if (replace[0].equals(str[k].toLowerCase())) {
						String firstCh = str[k].substring(0, 1);
						String firstChUp = str[k].substring(0, 1).toLowerCase();
						if (firstCh.equals(firstChUp.toUpperCase())) { // если первый символ искомого слова заглавный, то в
																														// заменяющем слове также первый символ делаем заглавным
							str[k] = replace[2].substring(0, 1).toUpperCase() + replace[2].substring(1);
						} else {
							str[k] = replace[2];
						}
					}
				}
				String arrayToString = String.join(" ", str); // собрать обратно строку в рецепт
				sourceArr[j] = arrayToString; // внести измененную строку в массив
			}
		}

		return sourceArr;
	}

	public static void main(String[] args) {
		Scanner iScanner = new Scanner(System.in, "cp866");
		System.out.printf("Сколько рецептов внести: ");
		int numOfRecipes = iScanner.nextInt();
		iScanner.nextLine(); // для перевода на новую строку (для внесения значений в первый элемент массива)
		String[] arrOfRecipes = new String[numOfRecipes];

		arrOfRecipes = enterStrings(numOfRecipes, arrOfRecipes); // массив рецептов

		System.out.printf("Введите количество продуктов, на которые у человека аллергия: ");
		int ammountAllerg = iScanner.nextInt();
		String[] arrReplace = new String[ammountAllerg];

		System.out.println("Определите замену для аллергенных продуктов вида 'продукт1 - продукт2': ");
		String[] newArr = replaceWordsInStrings(ammountAllerg, arrOfRecipes, arrReplace);

		for (int i = 0; i < newArr.length; i++) {
			System.out.println(newArr[i]);
		}
	}
}