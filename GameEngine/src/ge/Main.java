package ge;

public class Main {

    public static void main(String[] args)
    {
        GameEngine game = GameEngine.Instance();
        game.Run();
        Exit();
    }

    private static void Exit() {
        System.out.print("Exiting...");
        System.exit(0);
    }
}
