import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Player {

    private String playerName;
    private Monster[] monsters;
    private ArrayList<Monster> monsterList;
    public Player ()
    {
        monsters = new Monster[4];
        playerName = "AI";
    }

    public Player ( String y, Monster[] z)
    {
        playerName = y;
        monsters = z;
    }
    public Player (String y) throws FileNotFoundException
    {
        playerName = y;
        monsters = new Monster[4];
        pickMonsters();
    }

    public void setPlayerName(String x)
    {
        playerName = x;
    }

    public String getPlayerName()
    {
        return playerName;
    }

    public void recoverMonsters(int monsterThatActed)
    {
        for (int i = 0; i < monsters.length; i++) {
            if(i != monsterThatActed)
            {
                monsters[i].recover();
            }
        }
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

    public int getPlayerType()
    {
        return 0;
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

    private void pickMonsters() throws FileNotFoundException
    {
        generateMonsterList();
        Scanner kb = new Scanner(System.in);
        System.out.println("Monster List: ");
        for (int i = 0; i < monsterList.size(); i++) {
            System.out.println((i+1) + ": " + monsterList.get(i));
        }
        for (int j = 0; j < monsters.length; j++) {
            System.out.println("Pick a monster: ");
            int temp = kb.nextInt();
            monsters[j] = monsterList.get(temp-1);
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

    public String toString()
    {
        String data = "";
        data += playerName;
        for (int i = 0; i < monsters.length; i++) {
            data += "\n " + monsters[i];
        }
        return data;
    }

}
