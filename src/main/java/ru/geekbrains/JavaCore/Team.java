package ru.geekbrains.JavaCore;

public class Team {
    private String name;
    private Participant[] participants = new Participant[4];

    public Team(String name) {
        this.name = name;
    }

    public Team(String name,Participant participantOne, Participant participantTwo, Participant participantThree, Participant participantFour) {
        this.name = name;
        this.participants[0] = participantOne;
        this.participants[1] = participantTwo;
        this.participants[2] = participantThree;
        this.participants[3] = participantFour;
    }

    public void getTeamInfo() {
        System.out.println("Team" + this.name );
        for (Participant participant : this.participants) {
            if (participant instanceof Dog) {
                System.out.println("Dog " + participant.getName());
            }
            if (participant instanceof Cat) {
                System.out.println("Cat " + participant.getName());
            }
            if (participant instanceof Mouse) {
                System.out.println("Mouse " + participant.getName());
            }
            if (participant instanceof Robot) {
                System.out.println("Robot " + participant.getName());
            }
        }
    }

    public void showResults() {
        for (Participant participant : participants) {
            //obstacle.doIt(participant);
            if (!participant.isOnDistance()) {
                break;
            }
        }
    }

    public void doIt(Obstacle obstacle) {
        for (Participant participant : participants) {
            obstacle.doIt(participant);
            if (!participant.isOnDistance()) {
                break;
            }
        }
    }
}
