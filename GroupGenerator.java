import java.util.ArrayList;
import java.util.Random;

public class GroupGenerator {
    private int groupSize; // número mínimo de alunos por grupo, pode resultar em grupos maiores
    private ArrayList<TeamMate> students;
    private ArrayList<TeamMate> studentsOutOfGroup;
    private ArrayList<ArrayList<TeamMate>> groups; 
    private Random random = new Random();

    GroupGenerator(ArrayList<TeamMate> students)  {
        this.students = students;
        this.studentsOutOfGroup = new ArrayList<TeamMate>();
        this.groups = new ArrayList<ArrayList<TeamMate>>();
        groupSize = 2; // duplas por padrão
    }

    GroupGenerator(ArrayList<TeamMate> students, int size)  {
        this.students = students;
        this.studentsOutOfGroup = new ArrayList<TeamMate>();
        this.groups = new ArrayList<ArrayList<TeamMate>>();
        groupSize = size;
    }

    public void printGroups() {
        int i = 1;
        for (ArrayList<TeamMate> group : groups) {
            String members = "Grupo " + i;
            for (TeamMate mate : group) {
                members += ", " + mate.getName();
            }

            System.out.println(members);
            i++;
        }
    }

    public void generateGroups() {
        for (TeamMate student : this.students) {
            studentsOutOfGroup.add(student);
        }
        // cria todos os grupos com o numero de alunos definido
        while (studentsOutOfGroup.size() >= groupSize) {
            ArrayList<TeamMate> group = generateGroup(groupSize);
            groups.add(group);
        }

        // se sobrar alunos restantes distribui entre os grupos criados
        while(studentsOutOfGroup.size() > 0) {
            for (int i = 0; i < groups.size(); i++) {
                int index = random.nextInt(studentsOutOfGroup.size());
                groups.get(i).add(studentsOutOfGroup.get(index));
                studentsOutOfGroup.remove(index);
                if (studentsOutOfGroup.size() == 0) break;
            }
        }
    }

    private ArrayList<TeamMate> generateGroup(int size) {
        ArrayList<TeamMate> group = new ArrayList<TeamMate>();
        for (int j = 0; j < size; j++) {
            int index = random.nextInt(studentsOutOfGroup.size());
            group.add(studentsOutOfGroup.get(index));
            studentsOutOfGroup.remove(index);
        }
        return group;
    }

    public void setGroupSize(int size) {
        this.groupSize = size;
    }

    public int getGroupSize() {
        return this.groupSize;
    }

    public void setStudents(ArrayList<TeamMate> students) {
        this.students = students;
    }

    public ArrayList<TeamMate> getStudents() {
        return this.students;
    }
}
