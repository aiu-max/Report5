package jp.ac.uryukyu.ie.e195761;

/**
 * スーパークラス
 * String name; // ヒーロー、エネミーの名前
 * int hitPoint; // 登場人物のHP
 * int attack; // 登場人物の攻撃力
 * boolean dead; //　登場人物の生死
 */


public class LivingThing {
    private String name;
    private int hitPoint;
    private int attack;
    private boolean dead;

    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     * @param name 登場人物の名前
     * @param maximumHP　登場人物のHP
     * @param attack　登場人物の攻撃力
     */

    public LivingThing(String name, int maximumHP, int attack) {
        this.name = name;
        hitPoint = maximumHP;
        this.attack = attack;
        dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, maximumHP, attack);
    }

    public boolean isDead() {
        return dead;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getHitPoint(){
        return hitPoint;
    }

    public void setHitPoint(int hitPoint){
        this.hitPoint = hitPoint;
    }

    public boolean getDead(){
        return dead;
    }

    public void setDead(boolean dead){
        this.dead = dead;
    }

    /**
     * 攻撃メソッド
     * 死亡判定を行い、攻撃力を決定
     * @param opponent
     */
    public void attack(LivingThing opponent) {
        if (!isDead()) {
            int damage = (int) (Math.random() * attack);
            System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, opponent.getName(), damage);
            opponent.wounded(damage);
        }

    }

    /**
     * ダメージ処理をするメソッド
     * 乱数によって出されたdamageをhitPointから引く
     * 死亡判定を行う
     * @param damage 受けたダメージ
     */

    public void wounded(int damage){
        hitPoint -= damage;
        if( hitPoint < 0 ) {
            dead = true;
            System.out.printf("%sは倒れた。\n", name);
        }
    }
}