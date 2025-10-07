package edu.monmouth.group;

public class Developers {

    public static void main(String[] args) {
        final int NUMGROUPS= 2, GROUPSIZE = 3;
        Person groups[][] = new Person[NUMGROUPS][GROUPSIZE];

        groups[0][0] = new Person(25, "Alice");
        groups[0][1] = new Person(21, "Bob");
        groups[0][2] = new Person(31, "John");

        groups[1][0] = new Person(35, "Dave");
        groups[1][1] = new Person(41, "Jen");
        groups[1][2] = new Person(28, "Jane");

        for (int i = 0; i < groups.length; i++) {
            for (int j = 0; j < groups[1].length; j++) {
                if (j==0){
                    System.out.print("Supervisor: ");
                }
                else{
                    System.out.print("Direct Report: ");
                }
                System.out.println(groups[i][j].getName() + " " + groups[i][j].getAge());
            }
        }

    }

}
