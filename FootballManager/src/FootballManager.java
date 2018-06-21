import MyUtil.PrintInfo;
import MyUtil.ScannerControl;

public class FootballManager {

    public static void main(String[] args){
        PrintInfo.printInformation();
        choiceAct();
    }
/** Method choiceAct()  gets an object of class PlayerList.
 * The method receives information from the console and calls the required method from the class PlayerList*/
    private static void choiceAct(){
        Player player1=new Player("Alex", 25, 8.1, "aa");
        Player player2=new Player("Oleg", 28, 9.0, "gg");
        Player player3=new Player("Alex", 31, 9.1, "aa");
        Player player4=new Player("Artem", 35, 8.4, "gg");
        Player player5=new Player("Ivan", 29, 8.9, "ff");
        Player player8=new Player("Artem", 35, 8.4, "kk");
        Player player9=new Player("Oleg", 28, 9.0, "kk");
        Player player6=new Player("Ivan", 32, 9.2, "ss");
        Player player7=new Player("Alex", 25, 8.1, "ff");
        PlayerList playerList=new PlayerList();
        playerList.addPlayer(player1);
        playerList.addPlayer(player2);
        playerList.addPlayer(player3);
        playerList.addPlayer(player4);
        playerList.addPlayer(player5);
        playerList.addPlayer(player6);
        playerList.addPlayer(player7);
        playerList.addPlayer(player8);
        playerList.addPlayer(player9);

        ScannerControl scanner=new ScannerControl();
        while (true){
            Integer item=scanner.enterInteger();
            switch (item){
                case 0:
                    System.out.println("Пока!");
                    return;
                case 1:
                    playerList.addPlayer();
                    PrintInfo.printInformation();
                    break;
                case 2:
                    playerList.uniquePlayers();
                    PrintInfo.printInformation();
                    break;
                case 3:
                    playerList.sortRating();
                    playerList.printListPlayer();
                    PrintInfo.printInformation();
                    break;
                case 4:
                    playerList.sortCommand();
                    PrintInfo.printInformation();
                    break;
                case 5:
                    playerList.match();
                    PrintInfo.printInformation();
                    break;
                case 6:
                    playerList.removePlayer();
                    PrintInfo.printInformation();
                    break;
                default:
                    System.out.println("Введите значение правильно: ");
            }
        }
    }
}

