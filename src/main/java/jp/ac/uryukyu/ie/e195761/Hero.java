package jp.ac.uryukyu.ie.e195761;

/**
 * ヒーロークラス。
 *  String name; //敵の名前
 *  int hitPoint; //敵のHP
 *  int attack; //敵の攻撃力
 *  boolean dead; //敵の生死状態。true=死亡。
 * Created by tnal on 2016/11/13.
 */
public class Hero extends LivingThing {
    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     * @param name ヒーロー名
     * @param maximumHP ヒーローのHP
     * @param attack ヒーローの攻撃力
     */

    public Hero(String name,int maximumHP,int attack){
        super(name, maximumHP, attack);
    }


    int hitPoint = getHitPoint();
    String name = getName();

    /**
     *ダメージ処理をするメソッド
     * 乱数によって出されたdamageをhitPointから引く
     * 死亡判定を行う
     * @param damage 受けたダメージ
     */

    @Override
    public void wounded(int damage){
        hitPoint -= damage;
        if( hitPoint < 0 ) {
            setDead(true);
            System.out.printf("勇者%sは道半ばで力尽きてしまった。\n", name);
        }
    }

}