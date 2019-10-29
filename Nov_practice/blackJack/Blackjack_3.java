package blackJack;

public class Blackjack_3 {
	static final int SUIT = 4;
	static final int RANK = 13;
	static int max = SUIT * RANK;
	static int[] deck = new int[SUIT * RANK];
	static int[] pHand = new int[8];
	static int pn = 0;

	//ブラックジャック
	public static void main(String[] args) {
		initDeck(); //カードデッキを初期化する
		deal(); //手札を2枚配る
		show(); //手札のトランプ表示
	}

	//カードデッキを初期化する
	public static void initDeck() {
		for (int i = 0; i < (SUIT * RANK); i++) {
			deck[i] = i + 1;
		}
	}

	//カードデッキから1枚とり、その値を返す
	public static int nextCard() {
		int p = (int) (Math.random() * max);
		int nextCard = deck[p];
		deck[p] = deck[max - 1];
		--max;
		return nextCard;
	}

	//手札を2枚とる
	public static void deal() {
		for (int i = 0; i < 2; i++) {
			pHand[i] = nextCard();
			pn++;
		}
	}

	//確認用に配列の内容を表示する（横一行に表示する）
	public static void dump(int[] a) {
		for (int i = 0; i < pn; i++) {
			System.out.print(a[i] + " ");
		}
	}

	public static int number(int n) {
		int m = (n - 1) % RANK + 1;
		return m;
	}

	public static String suit(int a) {
		String[] suitString = { "スペード", "ダイヤ", "クラブ", "ハート" };
		int index = (a - 1) / RANK;
		return suitString[index];
	}

	public static String cardString(int n) {
		StringBuilder sb = new StringBuilder();
		sb.append(suit(n));
		sb.append("<");
		sb.append(number(n));
		sb.append(">");
		return sb.toString();
	}

	public static void show() {
		for (int i = 0; i < pn; i++) {
			System.out.println(pHand[i] + "---" + "   " + cardString(pHand[i]));
		}
		System.out.println("合計=" + sum(pHand, pn));
	}

	public static int toPoints(int card) {
		int num = number(card);
		if (num > 10) {
			num = 10;
		}
		return num;
	}

	public static int sum(int[] hand, int n) {
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += toPoints(hand[i]);
		}
		return sum;
	}
}
