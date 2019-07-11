package jp.co.bananadream.game;

/**
 * 緑モンスタークラス
 */
public class GreenMonster extends Monster {

	 /**
     * コンストラクタ
     * @param name モンスターの名前
     * @param hp 	モンスターの体力
     *@param offense モンスターの攻撃力
     *@param defense モンスターの防御力
     *@param quickly モンスターの素早さ
     */

    public GreenMonster(String name, int hp, int offense, int defense, int quickly) {
        super(name, TYPE_GREEN, hp, offense, defense, quickly);
    }

    /*
     * @see Monster#Attack(int)
     */
    @Override
    public int Attack(int type) {
        int offensivePower = getOffense();
        if (type == TYPE_RED) {
            offensivePower = (int)(offensivePower * 0.75);
        }
        else if (type == TYPE_BLUE) {
            offensivePower = (int)(offensivePower * 1.25);
        }
        return offensivePower;
    }
}
