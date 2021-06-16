package ru.job4j.gc;

import org.openjdk.jol.info.GraphLayout;

public class User {
    private String name;
    private String status;

    private static final long KB = 1000;
    private static final long MB = KB * KB;
    private static final Runtime ENVIRONMENT = Runtime.getRuntime();

    public User() {
    }

    public User(String name, String status) {
        this.name = name;
        this.status = status;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.printf("Removed %s %s%n", name, status);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static void info() {
        final long freeMemory = ENVIRONMENT.freeMemory();
        final long totalMemory = ENVIRONMENT.totalMemory();
        final long maxMemory = ENVIRONMENT.maxMemory();
        System.out.println("=== Environment state ===");
        System.out.printf("Free: %d%n", freeMemory / MB);
        System.out.printf("Total: %d%n", totalMemory / MB);
        System.out.printf("Max: %d%n", maxMemory / MB);
    }

    public static void main(String[] args) {
    /*    User userEmpt = new User();
        User user = new User("Ivan", "admin");
        System.out.println(GraphLayout.parseInstance((Object) userEmpt).toFootprint());
        System.out.println(GraphLayout.parseInstance((Object) user).toFootprint());*/
        info();
        for (int i = 1; i < 100000; i++) {
             new User("Ivan", "admin" + i);

        }
        //System.gc();
        System.out.println("info");
        info();
    }
}
