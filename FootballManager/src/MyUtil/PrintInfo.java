package MyUtil;
/** Class PrintInfo contains a method that outputs information about possible actions
 *  with objects of class PlayerList to the console*/

public class PrintInfo {
    public static void printInformation(){
        System.out.println("Выберите действие:");
        System.out.println();
        System.out.println("1. Добавить в список игрока.");
        System.out.println("2. Показать уникальных игроков.");
        System.out.println("3. Показать игроков в порядке их рейтинга.");
        System.out.println("4. Вывести игроков по командам.");
        System.out.println("5. Сыграть матч.");
        System.out.println("6. Удалить игрока.");
        System.out.println("0. Выход.");


    }
}
