package blackJack;

public class Kuji_1 {
	static int max = 10;
	static int atari = 3;
	static int[] lot = new int[max];
	static int n = 0;

	public static void main(String[] args) {

		int i = 0;
		do {
			init();
			System.out.println();
			Input.getString("何かのキーをタイプするとくじが引けます。");
			System.out.println();

			animation();
			draw();
			i++;
		} while (i < 10);

	}

	public static void init() {
		lot[0] = 1;
		lot[1] = 1;
		lot[2] = 1;
		lot[3] = 0;
		lot[4] = 0;
		lot[5] = 0;
		lot[6] = 0;
		lot[7] = 0;
		lot[8] = 0;
		lot[9] = 0;
	}

	public static int number() {
		int p = (int) (Math.random() * max);
		int result = lot[p];
		lot[p] = lot[max - 1];
		--max;
		return result;
	}

	public static void delay(int t) {
		try {
			Thread.sleep(t);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void animation() {
		for (int i = 0; i < 10; i++) {
			System.out.print("■");
			delay(100);
		}
		System.out.println();
	}

	public static void draw() {
		int num = number();
		if (num == 1) {
			System.out.println("大当たり！");
		} else {
			System.out.println("残念！");
		}
	}
}
