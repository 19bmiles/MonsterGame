import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Scanner;

public class PlayerAI extends Player {

    private int difficulty;
    private ArrayList<Monster> monsterList;
    private Monster[] monsters;
    private int monsterChoice;
    public PlayerAI() throws FileNotFoundException
    {
        super();

        difficulty = 1;
        monsters = new Monster[4];
        monsterList = new ArrayList<Monster>();
        pickMonsters();
    }

    public PlayerAI(int x) throws FileNotFoundException
    {
        super();

        difficulty = 1;
        monsters = new Monster[4];
        monsterList = new ArrayList<Monster>();
        monsterChoice = x;
        if(x == 1 ) {
            pickMonsters(1);
            super.setPlayerName("Bryce");
        }
        if(x == 0 ) {
            pickMonsters(0);
            super.setPlayerName("Ecyrb");
        }
        if(x == 2 ) {
            pickMonsters(2);
            super.setPlayerName("Josh");
        }
        if(x == 3 ) {
            pickMonsters(3);
            super.setPlayerName("Adam");
        }

    }
    public PlayerAI(int x, String z) throws FileNotFoundException
    {
        super(z);
        difficulty = x;
    }

    public int getPlayerType()
    {
        return 1;
    }

    public void refreshForNextGame() throws FileNotFoundException
    {
        pickMonsters(monsterChoice);
    }

    private void pickMonsters() throws FileNotFoundException
    {
        generateMonsterList();
        monsters[0] = monsterList.get(4);
        monsters[1] = monsterList.get(5);
        monsters[2] = monsterList.get(6);
        monsters[3] = monsterList.get(7);
    }

    private void pickMonsters(int x) throws FileNotFoundException
    {
        generateMonsterList();
        if(x == 0) {
            monsters[0] = monsterList.get(0);
            monsters[1] = monsterList.get(1);
            monsters[2] = monsterList.get(2);
            monsters[3] = monsterList.get(3);
        }
        if(x == 1) {
            monsters[0] = monsterList.get(4);
            monsters[1] = monsterList.get(5);
            monsters[2] = monsterList.get(6);
            monsters[3] = monsterList.get(7);
        }
        if(x == 2) {
            monsters[0] = monsterList.get(8);
            monsters[1] = monsterList.get(9);
            monsters[2] = monsterList.get(10);
            monsters[3] = monsterList.get(11);
        }
        if(x == 3) {
            monsters[0] = monsterList.get(12);
            monsters[1] = monsterList.get(13);
            monsters[2] = monsterList.get(14);
            monsters[3] = monsterList.get(15);
        }

    }

    private void generateMonsterList() throws FileNotFoundException
    {
        String line;
        int pos = 0;
        int lastPos = 0;
        String temp;
        Gson gsonReader = new Gson();
        monsterList = new ArrayList<Monster>();
        Scanner input = new Scanner(new File("C:\\Users\\Bryce\\IdeaProjects\\MonsterGame\\monstersFile.json"));
        line = input.nextLine();
        do {
            pos = line.indexOf(" xxx ", pos +1);
            temp = line.substring(lastPos, pos);
            lastPos = pos + 5;
            JsonReader reader = new JsonReader(new StringReader(temp));
            reader.setLenient(true);
            monsterList.add(gsonReader.fromJson(reader, Monster.class));
        } while (line.indexOf(" xxx ", pos+1) != -1);
        temp = line.substring(lastPos);
        JsonReader reader = new JsonReader(new StringReader(temp));
        reader.setLenient(true);
        monsterList.add(gsonReader.fromJson(reader, Monster.class));
    }

    public String getPlayerName()
    {
        return super.getPlayerName();
    }

    public int numberOfAliveMonsters()
    {
        int count = 0;
        for (int i = 0; i < monsters.length; i++) {
            if(monsters[i].isAlive())
            {
                count++;
            }
        }
        return count;
    }

    public Monster[] getMonsters()
    {
        return monsters;
    }

    /**
     * a method to return the monster string in order to print out the monsters for a battle phase
     * @return - the string with the player's monsters excluding the moves
     */
    public String getMonsterString()
    {
        String monsterBattleList = "";
        for (int i = 0; i < monsters.length; i++) {
            monsterBattleList += i + ": " + monsters[i].battleMonsterPrint() + " | ";
        }
        return monsterBattleList;
    }

}
