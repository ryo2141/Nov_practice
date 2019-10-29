package blackJack;

public class Blackjack_1 {
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
		dump(pHand); //手札を表示する
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

}
