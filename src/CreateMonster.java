import com.google.gson.Gson;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CreateMonster {
    public static void main(String[] args) {
        //Move(double x, int y, int z, String str1, String str2, int acc)
        //critChance = x; | damage = y; | uses = z; | moveName = str1; | effect = str2; |  accuracy = acc;
        Gson gsonWriter = new Gson();
        //team 1
        Move stoneToss = new Move(15, 40, 20, "Stone Toss", "none", 90);
        Move rockShield = new Move(100, 80, 20, "Rock Shield", "heal", 100);
        Move backStab = new Move(90, 80, 5, "Backstab", "twoTurn", 40);
        Move tackle = new Move(25, 35, 10, "Tackle", "none", 100);
        MoveSet earthNinjaMoves = new MoveSet(stoneToss, rockShield, backStab, tackle);
        Monster earthNinja = new Monster(earthNinjaMoves, 100, "Earth Ninja");

        Move bite = new Move(15, 40, 20, "Bite", "none", 90);
        Move scratch = new Move(100, 40, 20, "Scratch", "none", 100);
        Move claw = new Move(90, 40, 15, "Claw", "none", 90);
        Move tackle1 = new Move(25, 35, 10, "Tackle", "none", 100);
        MoveSet wolfMoves = new MoveSet(bite, scratch, claw, tackle1);
        Monster wolf = new Monster(wolfMoves, 60, "Wolf");

        Move tornado = new Move(15, 100, 20, "Tornado", "area", 90);
        Move obliterate = new Move(100, 500, 5, "Obliterate", "none", 20);
        Move divineWind = new Move(90, 80, 5, "Divine Wind", "stun", 100);
        Move gust = new Move(25, 35, 10, "Gust", "none", 100);
        MoveSet zephyrusMoves = new MoveSet(tornado, obliterate, divineWind, gust);
        Monster zephyrus = new Monster(zephyrusMoves, 1000, "Zephyrus");

        Move bite1 = new Move(15, 40, 20, "Bite", "none", 90);
        Move flameCharge = new Move(40, 80, 15, "Flame Charge", "rush", 90);
        Move fireClaw = new Move(55, 55, 15, "Fire Claw", "burn", 90);
        Move flameThrower = new Move(25, 100, 5, "Flame Thrower", "burn", 85);
        MoveSet fireCatMoves = new MoveSet(bite1, flameCharge, fireClaw, flameThrower);
        Monster fireCat = new Monster(fireCatMoves, 1000, "Firecat92");

        //TEAM 2
        //critChance = x; | damage = y; | uses = z; | moveName = str1; | effect = str2; |  accuracy = acc;
        Move splash = new Move(15, 40, 20, "Splash", "none", 90);
        Move wave = new Move(100, 60, 20, "Wave", "stun", 80);
        Move backStab1 = new Move(90, 80, 5, "Backstab", "twoTurn", 40);
        Move tackle2 = new Move(25, 35, 10, "Tackle", "none", 100);
        MoveSet waterNinjaMoves = new MoveSet(splash, wave, backStab1, tackle2);
        Monster waterNinja = new Monster(waterNinjaMoves, 100, "Water Ninja");

        Move bite2 = new Move(15, 40, 20, "Bite", "none", 90);
        Move scratch1 = new Move(100, 40, 20, "Scratch", "none", 100);
        Move claw1 = new Move(90, 40, 15, "Claw", "none", 90);
        Move tackle3 = new Move(25, 35, 10, "Tackle", "none", 100);
        MoveSet lizardMoves = new MoveSet(bite2, scratch1, claw1, tackle3);
        Monster lizard = new Monster(lizardMoves, 60, "Lizard");

        Move boogie = new Move(50, 200, 15, "Boogie", "area", 50);
        Move gummy = new Move(65, 80, 5, "Gummy", "none", 100);
        Move heat = new Move(20, 60, 15, "Heat", "burn", 100);
        Move sweet = new Move(25, 55, 10, "Sweet", "area", 100);
        MoveSet brockhamptonMoves = new MoveSet(boogie, gummy, heat, sweet);
        Monster brockhampton = new Monster(brockhamptonMoves, 1000, "Brockhampton");

        Move crunch = new Move(20, 50, 20, "Bite", "stun", 90);
        Move frost = new Move(20, 100, 10, "Frost", "freeze", 100);
        Move iceClaw = new Move(55, 60, 15, "Ice Claw", "freeze", 90);
        Move iceShard = new Move(25, 40, 20, "Ice Shard", "freeze", 100);
        MoveSet iceDogMoves = new MoveSet(crunch, frost, iceClaw, iceShard);
        Monster iceDog = new Monster(iceDogMoves, 1000, "Icedog29");

        //team 3
        //critChance = x; | damage = y; | uses = z; | moveName = str1; | effect = str2; |  accuracy = acc;
        Move burn = new Move(15, 40, 20, "Burn", "burn", 100);
        Move flameSword = new Move(60, 60, 20, "Flame Sword", "burn", 80);
        Move backStab2 = new Move(90, 80, 5, "Backstab", "twoTurn", 40);
        Move tackle4 = new Move(25, 35, 10, "Tackle", "none", 100);
        MoveSet fireNinjaMoves = new MoveSet(burn, flameSword, backStab2, tackle3);
        Monster fireNinja = new Monster(fireNinjaMoves, 100, "Fire Ninja");

        Move bite3 = new Move(15, 40, 20, "Bite", "none", 90);
        Move scratch2 = new Move(100, 40, 20, "Scratch", "none", 100);
        Move claw2 = new Move(90, 40, 15, "Claw", "none", 90);
        Move tackle5 = new Move(25, 35, 10, "Tackle", "none", 100);
        MoveSet birdMoves = new MoveSet(bite3, scratch2, claw2, tackle5);
        Monster bird = new Monster(birdMoves, 60, "Bird");

        Move bark = new Move(50, 200, 15, "Bark", "stun", 50);
        Move woof = new Move(65, 80, 5, "Woof", "none", 100);
        Move howl = new Move(20, 60, 15, "Howl", "boost", 100);
        Move sleep = new Move(25, 500, 10, "Sleep", "heal", 100);
        MoveSet joeyMoves = new MoveSet(bark, woof, howl, sleep);
        Monster joey = new Monster(joeyMoves, 1000, "Joey");

        Move snap = new Move(20, 80, 20, "Snap", "stun", 90);
        Move dip = new Move(20, 100, 10, "Dip", "freeze", 40);
        Move chat = new Move(55, 60, 15, "Chat", "none", 100);
        Move winkyFace = new Move(25, 50, 20, "Winky Face", "freeze", 90);
        MoveSet snapChatMoves = new MoveSet(snap, dip, chat, winkyFace);
        Monster snapChat = new Monster(snapChatMoves, 1000, "SnapChat");

        //team 4
        //critChance = x; | damage = y; | uses = z; | moveName = str1; | effect = str2; |  accuracy = acc;
        Move gust1 = new Move(25, 35, 10, "Gust", "none", 100);
        Move airSlash = new Move(60, 60, 20, "Air Slash", "none", 80);
        Move backStab3 = new Move(90, 80, 5, "Backstab", "twoTurn", 40);
        Move tackle6 = new Move(25, 35, 10, "Tackle", "none", 100);
        MoveSet airNinjaMoves = new MoveSet(gust1, airSlash, backStab3, tackle6);
        Monster airNinja = new Monster(airNinjaMoves, 100, "Air Ninja");

        Move bite4 = new Move(15, 40, 20, "Bite", "none", 90);
        Move scratch3 = new Move(100, 40, 20, "Scratch", "none", 100);
        Move claw3 = new Move(90, 40, 15, "Claw", "none", 90);
        Move tackle7 = new Move(25, 35, 10, "Tackle", "none", 100);
        MoveSet foxMoves = new MoveSet(bite4, scratch3, claw3, tackle7);
        Monster fox = new Monster(foxMoves, 60, "Fox");

        Move splash1 = new Move(50, 60, 15, "Splash", "area", 50);
        Move drink = new Move(50, 250, 10, "Drink", "heal", 100);
        Move bottleFlip = new Move(20, 80, 15, "Bottle Flip", "stun", 80);
        Move perfectFit = new Move(90, 60, 10, "Perfect Fit", "none", 100);
        MoveSet essentiaMoves = new MoveSet(splash1, drink, bottleFlip, perfectFit);
        Monster essentia = new Monster(essentiaMoves, 1000, "Essentia");

        Move share = new Move(20, 50, 20, "Share", "heal", 90);
        Move alwaysIn = new Move(20, 100, 10, "Always In", "freeze", 100);
        Move huh = new Move(40, 50, 15, "Huh", "freeze", 90);
        Move music = new Move(25, 40, 20, "Music", "none", 100);
        MoveSet airPodMoves = new MoveSet(share, alwaysIn, huh, music);
        Monster airPod = new Monster(airPodMoves, 1000, "Air Pods");

        String earthNinjaOutput = gsonWriter.toJson(earthNinja);
        String wolfOutput = gsonWriter.toJson(wolf);
        String zephyrusOutput = gsonWriter.toJson(zephyrus);
        String fireCatOutput = gsonWriter.toJson(fireCat);
        String waterNinjaOutput = gsonWriter.toJson(waterNinja);
        String lizardOutput = gsonWriter.toJson(lizard);
        String brockhamptonOutput = gsonWriter.toJson(brockhampton);
        String iceDogOutput = gsonWriter.toJson(iceDog);

        String fireNinjaOutput = gsonWriter.toJson(fireNinja);
        String birdOutput = gsonWriter.toJson(bird);
        String joeyOutput = gsonWriter.toJson(joey);
        String snapChatOutput = gsonWriter.toJson(snapChat);
        String airNinjaOutput = gsonWriter.toJson(airNinja);
        String foxOutput = gsonWriter.toJson(fox);
        String essentiaOutput = gsonWriter.toJson(essentia);
        String airPodOutput = gsonWriter.toJson(airPod);

        try
        {
            BufferedWriter out = new BufferedWriter(new FileWriter("monstersFile" + ".json", false));
            out.write(earthNinjaOutput);
            out.write(" xxx ");
            out.write(wolfOutput);
            out.write(" xxx ");
            out.write(zephyrusOutput);
            out.write(" xxx ");
            out.write(fireCatOutput);
            out.write(" xxx ");
            out.write(waterNinjaOutput);
            out.write(" xxx ");
            out.write(lizardOutput);
            out.write(" xxx ");
            out.write(brockhamptonOutput);
            out.write(" xxx ");
            out.write(iceDogOutput);
            out.write(" xxx ");
            out.write(fireNinjaOutput);
            out.write(" xxx ");
            out.write(birdOutput);
            out.write(" xxx ");
            out.write(joeyOutput);
            out.write(" xxx ");
            out.write(snapChatOutput);
            out.write(" xxx ");
            out.write(airNinjaOutput);
            out.write(" xxx ");
            out.write(foxOutput);
            out.write(" xxx ");
            out.write(essentiaOutput);
            out.write(" xxx ");
            out.write(airPodOutput);
            out.close();
        } catch (IOException e) {}

    }
}
