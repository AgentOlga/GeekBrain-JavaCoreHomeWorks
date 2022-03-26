package ru.geekbrains.JavaCore;

public class Course {
    public Course(Obstacle[] obstacles) {

    }

    public static void main(String[] args) {
        Participant[] participants = new Participant[] {
                new Cat("Blacky", 10, 12, 0),
                new Dog("Barbos", 25, 5, 15),
                new Mouse("Micky", 9, 0, 0),
                new Robot("Arny", 1500, 100, 1550)
        };

        System.out.println("Results:");
        for (Participant participant : participants) {
            System.out.println(participant);
        }

        Course c = new Course(new Obstacle[] {
                new Cross(508),
                new Wall(307),
                new Water(709)
        });
        Team team = new Team("Red machine",
                new Cat("Blacky", 10, 12, 0),
                new Dog("Barbos", 25, 5, 15),
                new Mouse("Micky", 9, 0, 0),
                new Robot("Arny", 1500, 100, 1550));
        team.getTeamInfo();

        c.doIt(team);
        team.showResults();
    }

    private void doIt(Team team) {

    }
}