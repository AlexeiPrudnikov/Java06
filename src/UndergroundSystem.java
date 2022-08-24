import java.util.HashMap;
import java.util.Map;

public class UndergroundSystem {
    private Map<Integer, String> peoplesInStation;
    private Map<Integer, Integer> peoplesInTime;
    private Map<String, Double> routesAvgTime;
    private Map<String, Integer> routesCount;
    public UndergroundSystem() {
        peoplesInStation = new HashMap<>();
        peoplesInTime = new HashMap<>();
        routesAvgTime = new HashMap<>();
        routesCount = new HashMap<>();
    }
    private Double getRouteTime(int inTime, int outTime) {
        return Double.valueOf(outTime - inTime);
    }

    public double getAverageTime(String startStation, String endStation) {
        return routesAvgTime.get(startStation + "->" + endStation);
    }

    public void checkIn(int id, String stationName, int t) {
        if (peoplesInStation.get(id) == null) {
            peoplesInStation.put(id, stationName);
            peoplesInTime.put(id, t);
        }
    }

    public void checkOut(int id, String stationName, int t) {
        if (peoplesInStation.get(id) != null) {
            String route = peoplesInStation.get(id) + "->" + stationName;
            if (routesCount.get(route) == null) {
                routesCount.put(route, 1);
                routesAvgTime.put(route, getRouteTime(peoplesInTime.get(id), t));
            } else {
                Integer countTrips = routesCount.get(route);
                Double avgRouteTime = routesAvgTime.get(route);
                avgRouteTime = (countTrips * avgRouteTime + getRouteTime(peoplesInTime.get(id), t)) / (countTrips + 1);
                routesAvgTime.put(route, avgRouteTime);
                routesCount.put(route, countTrips + 1);
            }
            peoplesInStation.entrySet().removeIf(entry -> entry.getKey() == id);
            peoplesInTime.entrySet().removeIf(entry -> entry.getKey() == id);
        }
    }


}
