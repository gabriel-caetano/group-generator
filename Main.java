import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String[] names = {
            "Adam", "Alex", "Aaron", "Ben", "Carl", "Dan", "David", "Edward", "Fred", "Frank", "George", "Hal", "Hank",
            "Ike", "John", "Jack", "Joe", "Larry", "Monte", "Matthew", "Mark", "Nathan", "Otto", "Paul", "Peter",
            "Roger", "Roger", "Steve", "Thomas", "Tim", "Ty", "Victor", "Walter" };

        ArrayList<TeamMate> teamMates = new ArrayList<TeamMate>();
        for (int i = 0; i < 33; i++) {
            TeamMate newMate = new TeamMate(names[i]);
            teamMates.add(newMate);
        }

        GroupGenerator generator = new GroupGenerator(teamMates, 5);
        generator.generateGroups();

        generator.printGroups();
    }
}