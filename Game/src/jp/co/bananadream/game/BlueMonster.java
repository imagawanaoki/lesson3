package jp.co.bananadream.game;

/**
 * 青モンスタークラス
 */
public class BlueMonster extends Monster {

    /**
     * コンストラクタ
     * @param name モンスターの名前
     * @param hp 	モンスターの体力
     *@param offense モンスターの攻撃力
     *@param defense モンスターの防御力
     *@param quickly モンスターの素早さ
     */
    public BlueMonster(String name, int hp, int offense, int defense, int quickly) {
        super(name, TYPE_BLUE, hp, offense, defense, quickly);
    }

    /*
     * @see Monster#Attack(int)
     */
    @Override
    public int Attack(int type) {
        int offensivePower = getOffense();
        if (type == TYPE_GREEN) {
            offensivePower = (int)(offensivePower * 0.75);
        }
        else if (type == TYPE_RED) {
            offensivePower = (int)(offensivePower * 1.25);
        }
        return offensivePower;
    }
}
