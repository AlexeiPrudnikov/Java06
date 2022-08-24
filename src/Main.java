public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        ParkingSystem ps = new ParkingSystem(1, 1, 0);
        System.out.println(ps.addCar(1));
        System.out.println(ps.addCar(2));
        System.out.println(ps.addCar(1));
        System.out.println(ps.addCar(2));
        System.out.println(ps.addCar(3));
        UndergroundSystem us = new UndergroundSystem();
        us.checkIn(696247, "ELGYE9E4", 28);
        us.checkIn(520314, "AQHDMU8W", 124);
        us.checkOut(520314, "WIQTWA8C", 147);
        us.checkIn(912235, "AQHDMU8W", 190);
        us.checkOut(912235, "DOTFIMCF", 207);
        us.checkOut(696247, "WIQTWA8C", 277);
        us.checkIn(34090, "ELGYE9E4", 305);
        us.checkIn(577970, "AQHDMU8W", 353);
        us.checkIn(145499, "AQHDMU8W", 412);
        System.out.println(us.getAverageTime("ELGYE9E4", "WIQTWA8C"));
        us.checkIn(44605, "ELGYE9E4", 456);
        System.out.println(us.getAverageTime("ELGYE9E4", "WIQTWA8C"));
        System.out.println(us.getAverageTime("AQHDMU8W", "WIQTWA8C"));
    }
}
