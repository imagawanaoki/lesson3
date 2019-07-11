package jp.co.bananadream.game;

import java.util.Random;

/**
 * モンスター抽象クラス
 */
public abstract class Monster implements CardGame {
	/**  ダメージ   */
	public int damage;

	/** モンスター名 */
	private String name;

	/** モンスター属性 */
	private int type;

	/** 体力 */
	private int hp;

	/** 攻撃力 */
	private int offense;

	/** 守備力 */
	private int defense;

	/** 素早さ */
	private int quickly;

	 /**
     * コンストラクタ
     * @param name モンスターの名前
     * @param hp 	モンスターの体力
     * @param offense モンスターの攻撃力
     * @param defense モンスターの防御力
     * @param quickly モンスターの素早さ
     * @param type    モンスターのタイプ
     */
   public Monster(String name, int type, int hp, int offense, int defense, int quickly) {
		this.name = name;
		this.type = type;
		this.hp = hp;
		this.offense = offense;
		this.defense = defense;
		this.quickly = quickly;

	}

	/**
	 * カードの正当性チェック
	 * @return falseなら不正数値
	 */


	public boolean isCheck() {
		if(hp + offense + defense + quickly >100) {

			return false;
	}
		return true;
	}

	/**
	 * 攻撃数値を求める（３すくみ計算）
	 * @return 攻撃数値
	 */
	public abstract int Attack(int type);

	/**
	 * 攻撃を受け止める
	 * @return ダメージ
	 */
	public int Defense(int offensivePower) {
		int damage = offensivePower - getDefense();
		hp =  getHp() - damage ;
		return damage;
		// ここを実装
	}

	/**
	 * 攻撃回避判定
	 * @return falseなら回避
	 */

	public boolean isHit() {
		Random rand = new Random();
		int num = rand.nextInt(3);
		if (num == 1) {
			System.out.println();
			return false;
		}
		return true;
	}

	/**
	 * 生存判定
	 * @return trueなら生存
	 */
	public boolean isSurvive() {
		if (hp == 0) {
			return false;
		}
		return true;
	}

	/**
	 * nameを取得する
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * typeを取得する
	 * @return type
	 */
	public int getType() {
		return type;
	}

	/**
	 * hpを取得する
	 * @return hp
	 */
	public int getHp() {
		return hp;
	}

	/**
	 * offenseを取得する
	 * @return offense
	 */
	public int getOffense() {
		return offense;
	}

	/**
	 * defenseを取得する
	 * @return defense
	 */
	public int getDefense() {
		return defense;
	}

	/**
	 * quicklyを取得する
	 * @return quickly
	 */
	public int getQuickly() {
		return quickly;
	}

		/*
	 * このクラスの文字列表現
	 */
	@Override
	public String  toString() {


		return name;



		// ここを実装
	}

}