package jp.co.bananadream.game;

/**
 * 赤モンスタークラス
 */
public class RedMonster extends Monster {

	 /**
     * コンストラクタ
     * @param name モンスターの名前
     * @param hp 	モンスターの体力
     *@param offense モンスターの攻撃力
     *@param defense モンスターの防御力
     *@param quickly モンスターの素早さ
     */
    public RedMonster(String name, int hp, int offense, int defense, int quickly) {
        super(name, TYPE_RED, hp, offense, defense, quickly);
    }

    /*
     * @see Monster#Attack(int)
     */
    @Override
    public int Attack(int type) {
        int offensivePower = getOffense();
        if (type == TYPE_BLUE) {
            offensivePower = (int)(offensivePower * 0.75);
        }
        else if (type == TYPE_GREEN) {
            offensivePower = (int)(offensivePower * 1.25);
        }
        return offensivePower;
    }
}
