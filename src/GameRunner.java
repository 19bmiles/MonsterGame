import java.io.FileNotFoundException;
import java.util.Scanner;

public class GameRunner {
    private Player[] players;
    private boolean gameEnd;
    private Player winner;
    private int numberOfRounds, bryceWins, joshWins, ecyrbWins, adamWins;
    public GameRunner() throws FileNotFoundException
    {
        bryceWins = 0;
        joshWins = 0;
        ecyrbWins = 0;
        adamWins = 0;
        numberOfRounds = 0;
        gameEnd = false;
        players = new Player[2];
        startGame();

    }

    public void playGame() throws FileNotFoundException
    {
        battlePhase();
        announceWinner();
        ((PlayerAI) players[0]).refreshForNextGame();
        ((PlayerAI) players[1]).refreshForNextGame();

    }

    private void announceWinner()
    {
        System.out.println(winner.getPlayerName() + " WINS!!");
        System.out.println("It took " + numberOfRounds + " rounds!");
        System.out.print("The overall record is ");
        if(winner.getPlayerName().equals("Bryce"))
        {
            bryceWins++;
            System.out.print(" Bryce Wins: " + bryceWins + " | ");
        }
        if(winner.getPlayerName().equals("Josh"))
        {
            joshWins++;
            System.out.print(" Josh Wins: " + joshWins + " | ");
        }
        if(winner.getPlayerName().equals("Ecyrb"))
        {
            ecyrbWins++;
            System.out.print(" Ecryb Wins: " + ecyrbWins + " | ");
        }
        if(winner.getPlayerName().equals("Adam"))
        {
            adamWins++;
            System.out.print(" Adam Wins: " + adamWins + " | ");
        }

    }

    private void startGame() throws FileNotFoundException
    {
        Scanner kb = new Scanner(System.in);
        System.out.println("START NEW GAME");

        //System.out.println("Player 1: Enter name");
        // playerOneName = kb.next();
       // Player playerOne = new Player(playerOneName);
        //players[0] = playerOne;
        //System.out.println("Player 2: Enter name");
        //String playerTwoName = kb.next();
        //Player playerTwo = new Player(playerTwoName);
        //players[1] = playerTwo;

        PlayerAI playerAITwo = new PlayerAI(0);
        players[0] = playerAITwo;
        PlayerAI playerAIOne = new PlayerAI(2);
        players[1] = playerAIOne;
    }

    private void battlePhase()
    {
        while(!gameEnd)
        {
            System.out.println("NEW ROUND");
            takeTurn(players[0], 0, 1);
            System.out.println();
            updateGameStatus();
            takeTurn(players[1], 1, 0);
            System.out.println();
            updateGameStatus();
            System.out.println();
            numberOfRounds++;
        }
    }

    private void takeTurn(Player x, int playerNumber, int opponentNumber)
    {
        Scanner kb = new Scanner(System.in);
        int target, attacker, attackMove;
        if(x.getPlayerType() == 0)
        {
            System.out.println("YOUR TURN: ");
            System.out.println(players[playerNumber].getMonsterString());
            System.out.print("Pick your monster to attack with: ");
            attacker = kb.nextInt();

            System.out.println();
            System.out.println(players[opponentNumber].getMonsterString());
            System.out.print("Pick your target: ");
            target = kb.nextInt();
            Monster targetMonster = players[opponentNumber].getMonsters()[target];
            Monster userMonster = players[playerNumber].getMonsters()[attacker];
            System.out.println();
            Monster[] turnPlayerMonsters = players[playerNumber].getMonsters();
            System.out.println(turnPlayerMonsters[attacker].getMonsterName());
            System.out.println(turnPlayerMonsters[attacker].getBattleMoveString());
            System.out.print("Pick your attack: ");
            attackMove = kb.nextInt();
            turnPlayerMonsters[attacker].attack(attackMove, targetMonster);
            //[attacker].getMoves().getMove(attackMove).attack(userMonster, targetMonster); OLD ATTACK CALL
            x.recoverMonsters(attacker);
            System.out.println(players[playerNumber].getPlayerName() + "'s Monsters: "+ players[playerNumber].getMonsterString());
            System.out.println(players[opponentNumber].getPlayerName() + "'s Monsters: "+ players[opponentNumber].getMonsterString());
        }
        else if (x.getPlayerType() == 1)
        {
            System.out.println("AI TURN: ");
            Monster userMonster;
            Monster targetMonster;
            do {
                attacker = (int) (Math.random() * 4);
                 userMonster = players[playerNumber].getMonsters()[attacker];
            }while(!userMonster.isAlive() && players[playerNumber].numberOfAliveMonsters()  > 0);
            do {
                target = (int) (Math.random() * 4);
                targetMonster = players[opponentNumber].getMonsters()[target];
            }while (!targetMonster.isAlive() && players[opponentNumber].numberOfAliveMonsters() > 0);

            Monster[] turnPlayerMonsters = players[playerNumber].getMonsters();
            attackMove = (int) (Math.random() * 4) + 1;
            //System.out.println("AI CHECK: attacker: " + attacker + " target: " + target + " attackMove: " + attackMove);
            //turnPlayerMonsters[attacker].getMoves().getMove(attackMove).attack(userMonster, targetMonster); OLD ATTACK CALL
            turnPlayerMonsters[attacker].attack(attackMove, targetMonster);
            x.recoverMonsters(attacker);
            System.out.println(players[playerNumber].getPlayerName() + "'s Monsters: "+ players[playerNumber].getMonsterString());
            System.out.println(players[opponentNumber].getPlayerName() + "'s Monsters: "+ players[opponentNumber].getMonsterString());

        }
    }

    private void updateGameStatus()
    {
        if(players[0].numberOfAliveMonsters() < 1)
        {
            gameEnd = true;
            winner = players[1];
        }
        if(players[1].numberOfAliveMonsters() < 1)
        {
            gameEnd = true;
            winner = players[0];
        }
    }

}
