import MyUtil.ScannerControl;

import java.util.*;

public class PlayerList extends ArrayList<Player>{

    private ArrayList<Player> arrayPlayerList=new ArrayList<>();

    public PlayerList() {}

    /** The method prints a list of players with fields name, age, rating, team*/
    public void printListPlayer(){
        Iterator<Player> iterator=arrayPlayerList.iterator();
        while (iterator.hasNext()){
            Player player=iterator.next();
            System.out.println("Игрок: "+player.getName()+", возраст: "+player.getAge()+", рейтинг: "+player.getRating()+", команда: "+player.getCommand());
        }
    }

    /** the method gets an object of class Player as a parameter
     * and adds it to the list of players*/
    public void addPlayer(Player player){
        Player newPlayer=new Player(player.getName(),player.getAge(),player.getRating(),player.getCommand());
        arrayPlayerList.add(newPlayer);
    }

    /** method gets from the console the values of the fields of the object Player
     *  and adds it to the list of players*/
    public void addPlayer(){
        ScannerControl scanner=new ScannerControl();
        System.out.println("Введите имя игрока: ");
        String name=scanner.enterString();
        System.out.println("Введите возраст игрока: ");
        Integer age=scanner.enterInteger();
        System.out.println("Введите рейтинг игрока: ");
        Double rating=scanner.enterDouble();
        System.out.println("Введите команду игрока: ");
        String command=scanner.enterString();
        Player newPlayer=new Player(name,age,rating,command);
        arrayPlayerList.add(newPlayer);
    }

    /** The method prints a list of Player objects in the console with an entry index.
     * The method asks the user for the index of the object to be deleted and deletes it*/
    public void removePlayer(){
        int index=0;
        Iterator<Player> iterator=arrayPlayerList.iterator();
        ScannerControl scanner=new ScannerControl();
        while (iterator.hasNext()){
            Player player=iterator.next();
            System.out.println(arrayPlayerList.indexOf(player)+" "+ player.getName()+" "+player.getAge()+" "+player.getRating()+" "+player.getCommand());
        }
        System.out.println("Введите номер игрока, которого нужно удалить");
        index=scanner.enterInteger();
        arrayPlayerList.remove(index);
    }

    @Override
    public Player remove(int index){
        return super.remove(index);
    }

    /** The method prints in the console a list of unique objects Player*/
    public void uniquePlayers(){
        HashSet<Player> uniquePlayerList=new HashSet<>(arrayPlayerList);
        Iterator<Player> iterator=uniquePlayerList.iterator();
        while (iterator.hasNext()){
            Player player=iterator.next();
            System.out.println("Игрок: "+player.getName()+", возраст: "+player.getAge()+", рейтинг: "+player.getRating()+", команда: "+player.getCommand());
        }
    }

    /** The method asks the user for the names of the teams between which
     *  to conduct the match and determines the winning team by calculating
     *  the overall rating of the P objects of each team*/
    public void match(){
        Double ratingCommand1=0d,
                ratingCommand2=0d;
        ScannerControl scanner=new ScannerControl();
        ArrayList<Player> command1List=new ArrayList<>(),
                command2List=new ArrayList<>();
        String command1, command2;
        System.out.println("Введите название первой команды: ");
        command1=scanner.enterString();
        command1List=choiceCommand(command1);
        while (command1List.size()==0){
            System.out.println("Такой команды нет. Напишите название команды правильно. ");
            command1=scanner.enterString();
            command1List=choiceCommand(command1);

        }
        System.out.println("Введите название второй команды: ");
        command2=scanner.enterString();
        command2List=choiceCommand(command2);
        while (command2List.size()==0){
            System.out.println("Такой команды нет. Напишите название команды правильно. ");
            command2=scanner.enterString();
            command2List=choiceCommand(command2);
        }
        printPlayersOfCommand(command1,command1List);
        printPlayersOfCommand(command2,command2List);
        ratingCommand1=ratingCommand(command1List);
        ratingCommand2=ratingCommand(command2List);
        if (ratingCommand1>ratingCommand2){
            System.out.println("Победила команда " + command1);
        }
        if (ratingCommand2>ratingCommand1){
            System.out.println("Победила команда " + command2);
        }
        if (ratingCommand1.equals(ratingCommand2)){
            System.out.println("Победила дружба ))" );
        }
    }

    /** The method prints a list of P objects in the console with one command*/
    private void printPlayersOfCommand(String commandName,ArrayList<Player> commandList){
        System.out.println("Команда " + commandName);
        for (Player p: commandList ) {
            System.out.println("    Игрок: "+p.getName()+", возраст: "+p.getAge()+", рейтинг: "+p.getRating());
        }
        System.out.println("==============================================" );
    }

    /** The method accepts at the input a list of Player objects of one command
     *  and returns the sum of the team players' ratings*/
    private Double ratingCommand(ArrayList<Player> commandList){
        Double ratingCommand=0d;

        for (Player p: commandList) {
            ratingCommand=ratingCommand + p.getRating();
        }
        return ratingCommand;
    }

    /** The method accepts the name of the command at the input
     * and returns the list Player of this command*/
    private ArrayList<Player> choiceCommand(String command){
        ArrayList<Player> commandList=new ArrayList<>();

        Iterator<Player> iterator=arrayPlayerList.iterator();
        while (iterator.hasNext()){
            Player player=iterator.next();
            if (player.getCommand().equals(command)){
                commandList.add(player);
            }
        }
        return commandList;
    }

    /** The method prints the Player lists on the console in commands*/
    public void sortCommand(){
        ArrayList<String> commands=new ArrayList<>();
        Iterator<Player> itr=arrayPlayerList.iterator();
        while (itr.hasNext()){
            Player player=itr.next();
            commands.add(player.getCommand());
        }
        HashSet<String> uniqueCommand=new HashSet<>(commands);
        Iterator<String> itrS=uniqueCommand.iterator();
        while (itrS.hasNext()){
            String command=itrS.next();
            System.out.println("Команда "+ command);
            System.out.println();
            Iterator<Player> itrP=arrayPlayerList.iterator();
            while (itrP.hasNext()){
                Player player=itrP.next();
                if (player.getCommand().equals(command)){
                    System.out.println("    Игрок: "+player.getName()+", возраст: "+player.getAge()+", рейтинг: "+player.getRating());
                }
            }
            System.out.println("================================================");
            System.out.println();

        }
    }

    /** The method sorts the list of Player objects in ascending order of their rankings*/
    public void sortRating(){
        arrayPlayerList.sort(Comparator.comparing(Player::getRating));
    }
}
