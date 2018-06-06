public class Move {

    private double critChance;
    private int damage, uses, accuracy;
    private String moveName, effect;

    public Move()
    {
        accuracy = 100;
        critChance = 0;
        damage = 0;
        uses = 0;
        moveName = "";
        effect = "none";
    }

    public Move(double x, int y, int z, String str1, String str2, int acc)
    {
        critChance = x;
        damage = y;
        uses = z;
        moveName = str1;
        effect = str2;
        accuracy = acc;
    }

    public void effect()
    {

    }

    /**
     * a method to return the attack of the monster
     * calculates critChance to see if the attack is a critical hit
     * @return - whether the damage goes off
     */
    public boolean attack(Monster user, Monster target)
    {
        int totalDamage = 0;
        if(uses > 0)
        {
            uses--;
            double attackAccuracy = Math.random() *100;
            if(attackAccuracy < accuracy) {
                double crit = Math.random() * 100;
                if (crit < critChance) {
                    target.getAttacked(damage*2);
                    totalDamage = damage *2;
                    System.out.println("Used " + moveName + " on " + target.battleMonsterPrint() + " for " + totalDamage + " damage!");
                    return true;
                }
                target.getAttacked(damage);
                totalDamage = damage;
                System.out.println("Used " + moveName + " on " + target.battleMonsterPrint() + " for " + totalDamage + " damage!");
                return true;
            }
        }
        System.out.println("Used " + moveName + " on " + target.battleMonsterPrint() + " for " + totalDamage + " damage!");
        return false;
    }

    public String toString()
    {
        return moveName + " Dmg: " + damage + " Uses: " + uses + " Accuracy: " + accuracy + " Critical Chance: " + critChance + " Effect " + effect;
    }
}
