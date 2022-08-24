public class ParkingSystem {
    private int[] parkingCapacity;
    private int[] parkingBusy;

    public ParkingSystem(int big, int medium, int small) {
        parkingCapacity = new int[3];
        parkingBusy = new int[3];
        parkingCapacity[0] = big;
        parkingCapacity[1] = medium;
        parkingCapacity[2] = small;
    }

    public boolean addCar(int carType) {
        if ((carType > parkingCapacity.length) || (carType < 1)) {
            return false;
        }
        if (parkingBusy[carType - 1] < parkingCapacity[carType - 1]) {
            parkingBusy[carType - 1]++;
            return true;
        } else {
            return false;
        }

    }
}
