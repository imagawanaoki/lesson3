package jp.co.bananadream.game;

import java.io.IOException;
import java.util.Random;

/**
 * OfficeDrive
 * バトルクラス
 * @version 1.0
 * @author h_hayashibe
 */
public class Battle {

	/**
	 * ターンの進行
	 * @throws IOException 例外処理
	 * @param  args 引数
	 */
	public static void main(String[] args) throws IOException {
		System.out.println("＊＊＊ モンスターバトル in Bananaコロシアム ＊＊＊");

		Monster[] monster = init();

		//入力された値チェック
		if (!check(monster)) {
			System.out.println("試合を開始出来ません");
			return;
		} else {

			System.out.println(monster[0].getName() + "が現れた！" +
					"[体力:" + monster[0].getHp() +
					"攻撃力:" + monster[0].getOffense() +
					"防御:" + monster[0].getDefense() +
					"素早さ:" + monster[0].getQuickly() + "]");

			System.out.println(monster[1].getName() + "が現れた！" +
					"[体力:" + monster[1].getHp() +
					"攻撃力:" + monster[1].getOffense() +
					"防御:" + monster[1].getDefense() +
					"素早さ:" + monster[1].getQuickly() + "]");

			//for (Monster mon : monster) {
			//System.out.println(mon);

			//先行の宣言
			judgeOrder(monster);
			System.out.println(monster[0].getName() + "の先制です。");

			BattleTurn.turn(monster);
		}
	}

	private static Monster[] init() throws IOException {
		System.out.println("お互いのモンスターを登録します。");

		Monster[] monster = new Monster[2];
		monster = ResistMonsters.regist();
		return monster;
	}

	private static boolean check(Monster[] monster) {
		for (Monster m : monster) {
			if (!m.isCheck()) {
				System.out.println(m.getName() + "の能力値が不正なため試合がキャンセルされました。");
				return false;
			}
		}
		return true;
	}

	private static void judgeOrder(Monster[] monster) throws IOException {

		//先行決めの判定 素早さ順、入れ替えの処理
		for (int i = 0; i < monster.length - 1; i++) {
			for (int j = i + 1; j < monster.length; j++) {
				if (monster[1].getQuickly() > monster[0].getQuickly()) {
					Monster tmp = monster[1];
					monster[1] = monster[0];
					monster[0] = tmp;

					//乱数で時々先行が変わる処理
					Random rand = new Random();
					int num = rand.nextInt(3) ;
					if (num == 1) {
						tmp = monster[1];
						monster[1] = monster[0];
						monster[0] = tmp;

					} else {
					}
				}
			}
		}
		return;
	}
}

//
//&& monster[1].getOffense() > monster[0].getOffense()