public class Monster {

    private MoveSet moves;
    private int healthPoints;
    private String monsterName;
    private boolean canAttack;
    public Monster()
    {
        moves = new MoveSet();
        healthPoints= 0;
        monsterName ="";
        canAttack = true;
    }

    public Monster(MoveSet x, int y, String str1)
    {
        moves = x;
        healthPoints = y;
        monsterName = str1;
    }

    public void getAttacked(int damage)
    {
        healthPoints -= damage;
        if (healthPoints < 0)
        {
            healthPoints = 0;
        }
    }

    public void recover()
    {
        canAttack = true;
    }

    public String getMonsterName()
    {
        return monsterName;
    }

    public String getBattleMoveString()
    {
        String x = "";
        for (int i = 1; i < 5; i++) {
            x += i + ": " + moves.getMove(i) + " \n";
        }
        return x;
    }

    public void attack(int moveNumber, Monster targetMonster)
    {
        if(canAttack) {
            moves.getMove(moveNumber).attack(this, targetMonster);
            canAttack = false;
        }
    }

    public MoveSet getMoves()
    {
        return moves;
    }

    public boolean isAlive()
    {
        return healthPoints > 0;
    }

    public String battleMonsterPrint()
    {
        return monsterName + " HP: " + healthPoints;
    }

    public String toString()
    {
        return monsterName + " HP: " + healthPoints + " Moves: " + moves;
    }

}
