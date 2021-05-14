package service3;

public class Crane implements Runnable{
    private volatile Ship ship;

    Crane(Ship ship){
        this.ship = ship;
    }

    @Override
    public void run() {
        ship.decTOU();
    }
}
