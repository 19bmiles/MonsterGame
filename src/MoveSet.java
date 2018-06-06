public class MoveSet {
    private Move move1;
    private Move move2;
    private Move move3;
    private Move move4;

    public MoveSet(Move m1, Move m2, Move m3, Move m4)
    {
        move1 = m1;
        move2 = m2;
        move3 = m3;
        move4 = m4;
    }

    public MoveSet()
    {

    }

    public Move getMove(int moveChoice)
    {
        if(moveChoice == 1)
        {
            return move1;
        }
        if(moveChoice == 2)
        {
            return move2;
        }
        if(moveChoice == 3)
        {
            return move3;
        }
        if(moveChoice == 4)
        {
            return move4;
        }
        return null;
    }

    public String toString()
    {
        return move1 + " | " + move2 + " | " + move3 + " | " + move4;
    }
}
