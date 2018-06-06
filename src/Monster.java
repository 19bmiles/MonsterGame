public class Monster {

    private MoveSet moves;
    private int healthPoints;
    private String monsterName;
    public Monster()
    {
        moves = new MoveSet();
        healthPoints= 0;
        monsterName ="";
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
