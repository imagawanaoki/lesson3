package jp.co.bananadream.game;

import java.util.Random;

/**
 *バトルのターン処理
 * @author n_imagawa
 *
 */
public class BattleTurn {

	public static void turn(Monster[] monster) {

		int roop = 0;
		Monster OffenceMonster = null;
		Monster DeffenceMonster = null;

		//ターン処理
		while (true) {
			//roop回数が偶数か奇数か
			if (roop % 2 == 0) {
				OffenceMonster = monster[0];
				DeffenceMonster = monster[1];
			} else {
				OffenceMonster = monster[1];
				DeffenceMonster = monster[0];

			}
			//モンスターのターン
			System.out.println(OffenceMonster.getName() + "の攻撃！！");

			//攻撃をかわした場合
			Random rand = new Random();
			int num = rand.nextInt(3);

			if (num == 1) {
				System.out.println(DeffenceMonster.getName() + "はひらりと攻撃をかわした");
			}else {
				System.out.println(DeffenceMonster.getName() + "は"
						+ DeffenceMonster.Defense(OffenceMonster.Attack(DeffenceMonster.getType())) + "のダメージを受けた");

			}

			//HPが０になった場合
			if (DeffenceMonster.getHp() <= 0) {
				System.out.println(DeffenceMonster.getName() + "は力尽きた");
				System.out.println(OffenceMonster.getName() + "の勝利！");

				break;

			}

			//次のターンの先行後攻の判定
			roop++;
		}
	}

}
