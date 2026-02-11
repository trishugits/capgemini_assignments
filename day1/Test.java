package CapgeminiTraining.day1;

import java.util.*;


class Edge {
    String to;
    int dist;

    Edge(String to, int dist) {
        this.to = to;
        this.dist = dist;
    }
}

class Delivery {
    int id;
    String src, dest, type;
    double time;

    Delivery(int id, String s, String d, String t) {
        this.id = id;
        src = s;
        dest = d;
        type = t;
    }
}

class Truck implements Comparable<Truck> {
    int id;
    double availableTime;
    List<String> schedule;

    Truck(int id) {
        this.id = id;
        availableTime = 0;
        schedule = new ArrayList<>();
    }

    @Override
    public int compareTo(Truck t) {
        return Double.compare(this.availableTime, t.availableTime);
    }
}

public class Test {

    static Map<String, List<Edge>> graph = new HashMap<>();

    static double getSpeed(String type) {
        switch (type) {
            case "Light": return 60;
            case "Medium": return 40;
            case "Heavy": return 25;
        }
        return 0;
    }

    static void addEdge(String u, String v, int w) {
        graph.putIfAbsent(u, new ArrayList<>());
        graph.putIfAbsent(v, new ArrayList<>());

        graph.get(u).add(new Edge(v, w));
        graph.get(v).add(new Edge(u, w));
    }

    // Dijkstra Algorithm
    static int shortestPath(String src, String dest) {

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                Comparator.comparingInt(a -> a[1])
        );

        Map<String, Integer> dist = new HashMap<>();

        for (String city : graph.keySet()) {
            dist.put(city, Integer.MAX_VALUE);
        }

        dist.put(src, 0);
        pq.add(new int[]{src.hashCode(), 0});

        Map<Integer, String> map = new HashMap<>();

        for (String s : graph.keySet()) {
            map.put(s.hashCode(), s);
        }

        while (!pq.isEmpty()) {

            int cur[] = pq.poll();
            String city = map.get(cur[0]);
            int d = cur[1];

            if (city.equals(dest))
                return d;

            if (d > dist.get(city))
                continue;

            for (Edge e : graph.get(city)) {

                int nd = d + e.dist;

                if (nd < dist.get(e.to)) {

                    dist.put(e.to, nd);
                    pq.add(new int[]{e.to.hashCode(), nd});
                }
            }
        }

        return dist.get(dest);
    }

    public static void main(String[] args) {

        // Graph Construction
        addEdge("Chennai", "Bangalore", 350);
        addEdge("Chennai", "Cochin", 690);
        addEdge("Chennai", "Trivandrum", 770);
        addEdge("Bangalore", "Cochin", 550);
        addEdge("Bangalore", "Hyderabad", 570);
        addEdge("Hyderabad", "Pune", 560);
        addEdge("Pune", "Mumbai", 150);
        addEdge("Mumbai", "Jaipur", 1150);
        addEdge("Jaipur", "Delhi", 280);
        addEdge("Delhi", "Kolkata", 1500);
        addEdge("Hyderabad", "Mumbai", 710);
        addEdge("Bangalore", "Pune", 840);
        addEdge("Cochin", "Trivandrum", 210);
        addEdge("Kolkata", "Jaipur", 1500);
        addEdge("Mumbai", "Delhi", 1400);

        // Deliveries
        List<Delivery> deliveries = new ArrayList<>();

        deliveries.add(new Delivery(1,"Chennai","Bangalore","Light"));
        deliveries.add(new Delivery(2,"Chennai","Cochin","Medium"));
        deliveries.add(new Delivery(3,"Bangalore","Hyderabad","Heavy"));
        deliveries.add(new Delivery(4,"Hyderabad","Pune","Light"));
        deliveries.add(new Delivery(5,"Pune","Mumbai","Medium"));
        deliveries.add(new Delivery(6,"Mumbai","Delhi","Heavy"));
        deliveries.add(new Delivery(7,"Delhi","Jaipur","Light"));
        deliveries.add(new Delivery(8,"Jaipur","Kolkata","Heavy"));
        deliveries.add(new Delivery(9,"Cochin","Trivandrum","Light"));
        deliveries.add(new Delivery(10,"Bangalore","Pune","Medium"));

        deliveries.add(new Delivery(11,"Chennai","Hyderabad","Medium"));
        deliveries.add(new Delivery(12,"Hyderabad","Mumbai","Light"));
        deliveries.add(new Delivery(13,"Mumbai","Jaipur","Heavy"));
        deliveries.add(new Delivery(14,"Pune","Delhi","Medium"));
        deliveries.add(new Delivery(15,"Bangalore","Cochin","Light"));
        deliveries.add(new Delivery(16,"Chennai","Trivandrum","Heavy"));
        deliveries.add(new Delivery(17,"Jaipur","Delhi","Light"));
        deliveries.add(new Delivery(18,"Delhi","Kolkata","Medium"));
        deliveries.add(new Delivery(19,"Mumbai","Pune","Light"));
        deliveries.add(new Delivery(20,"Cochin","Bangalore","Heavy"));

        // Calculate Time
        for (Delivery d : deliveries) {

            int dist = shortestPath(d.src, d.dest);
            double speed = getSpeed(d.type);

            d.time = dist / speed;
        }

        // Initialize Trucks
        PriorityQueue<Truck> trucks = new PriorityQueue<>();

        for (int i = 1; i <= 5; i++) {
            trucks.add(new Truck(i));
        }

        // Scheduling (Greedy)
        for (Delivery d : deliveries) {

            Truck t = trucks.poll();

            double start = t.availableTime;
            double end = start + d.time;

            String info = "Delivery " + d.id +
                    " (" + d.src + " -> " + d.dest +
                    ", " + d.type + ") : " +
                    String.format("%.2f", start) +
                    " -> " +
                    String.format("%.2f", end);

            t.schedule.add(info);
            t.availableTime = end;

            trucks.add(t);
        }

        // Output
        List<Truck> result = new ArrayList<>(trucks);

        result.sort(Comparator.comparingInt(a -> a.id));

        double maxTime = 0;

        for (Truck t : result) {

            System.out.println("\nTruck " + t.id + ":");

            for (String s : t.schedule) {
                System.out.println("  " + s);
            }

            maxTime = Math.max(maxTime, t.availableTime);
        }

        System.out.println("\nMinimum total time required: "
                + String.format("%.2f", maxTime)
                + " hours");
    }
}


