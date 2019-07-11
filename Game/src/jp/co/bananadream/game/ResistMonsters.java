package jp.co.bananadream.game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;




/**
 * モンスター情報の登録
 *@author n_imagawa
 */
public class ResistMonsters extends Monster{
	 /**
     * コンストラクタ
     * @param name モンスターの名前
     * @param hp 	モンスターの体力
     *@param offense モンスターの攻撃力
     *@param defense モンスターの防御力
     *@param quickly モンスターの素早さ
     *@param type    モンスターのタイプ
     */


	public ResistMonsters(String name, int type, int hp, int offense, int defense, int quickly) {
		super(name, type, hp, offense, defense, quickly);

	}

	public static Monster[] regist() throws IOException{

		Monster[] monsters = new Monster[2];

	for(int i = 0; i<2;i++) {

		   System.out.println((i+1) + "体目のモンスター");


	      //モンスター名の表示
	        System.out.println("モンスター名を入力してください");

	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        String name = br.readLine();

	        //System.out.println(name);

	        //typeの選択
	        System.out.println("属性を入力してください、１＝赤、２＝青、３＝緑");

	        String mon = br.readLine();
	        int type = Integer.parseInt(mon);

	        //System.out.println(type);

	        //モンスターの体力表示
	        System.out.println("体力(HP)を数値で入力 [能力値残り:100pt]");

	        String strhp = br.readLine();
	        int hp = Integer.parseInt(strhp);

	        int para1 = 100-(hp);
	        //System.out.println(hp);

	        //モンスターの攻撃力表示
	        System.out.println("攻撃力(ATK)を数値で入力 [能力値残り:"+ para1 +"pt]");

	        String str = br.readLine();
	        int atk = Integer.parseInt(str);

	        int para2 = 100-(hp + atk);
	        //System.out.println(atk);

	        //モンスターの守備力表示
	        System.out.println("守備力(DF)を数値で入力 [能力値残り:"+ para2 +"pt]");

	        String st = br.readLine();
	        int df = Integer.parseInt(st);

	        int para3 = 100-(hp + atk + df);
	        //System.out.println(df);

	        //モンスターの素早さ表示
	        System.out.println("素早さ(SPD)を数値で入力 [能力値残り:"+ para3 +"pt]");

	        String s = br.readLine();
	        int spd = Integer.parseInt(s);

	        //System.out.println(spd);

	        Monster monster = null;
	        if (type == 1) {
	        	monster = new RedMonster(name, hp, atk, df, spd);

	        }else if(type == 2){
				monster = new BlueMonster(name, hp, atk, df, spd);

			}else if (type == 3) {
				monster = new GreenMonster(name, hp, atk, df, spd);
				}
	        monsters[i] = monster;
     	}
	return monsters;

}

	@Override
	public int Attack(int type) {
		return damage;
		// TODO 自動生成されたメソッド・スタブ

	}
}
