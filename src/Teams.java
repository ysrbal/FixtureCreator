import java.util.*;

public class Teams {
    List<String> teamName = new LinkedList<>();

    public void leagueFixture() {
        if (teamName.size() % 2 != 0) {
            teamName.add("Pass");
        }
        if (teamName.size() != 0) {
            System.out.println("----------------- Teams ----------------- ");
            for (String teams : teamName) {
                System.out.println(" * " + teams);
            }
        } else {
            System.out.println("No Teams !!");
        }
        System.out.println();
        week();
    }

    public void week() {
        List<String> tempTeams = new ArrayList<>();

        while (0 < teamName.size()) {
            int index = (int) (Math.random() * teamName.size());
            tempTeams.add(teamName.get(index));
            teamName.remove(teamName.get(index));
        }

        teamName = tempTeams;

        int totalRound = teamName.size() - 1;
        int numMatchPerRound = teamName.size() / 2;

        LinkedHashMap<String, ArrayList<ArrayList<String>>> rounds = new LinkedHashMap<>();

        for (int i = 0; i < totalRound; i++) {
            String round = String.valueOf(i + 1);
            rounds.put(round, new ArrayList<ArrayList<String>>());
        }

        for (int i = 0; i < totalRound; i++) {
            ArrayList<String> home = new ArrayList<>();
            ArrayList<String> away = new ArrayList<>();

            for (int j = 0; j < numMatchPerRound; j++) {
                home.add(teamName.get(j));
                away.add(teamName.get((teamName.size() - 1) - j));            // (N-1) - j : index of away team
            }

            String round = String.valueOf(i + 1);
            rounds.get(round).add(home);
            rounds.get(round).add(away);

            List<String> newTeams = new ArrayList<>();

            newTeams.add(teamName.get(0));
            newTeams.add(teamName.get((teamName.size() - 1)));

            for (int k = 1; k < teamName.size() - 1; k++) {
                newTeams.add(teamName.get(k));
            }

            teamName = newTeams;
        }

        System.out.println();

        for (int i = 0; i < 2 * totalRound; i++) {
            System.out.println((i + 1) + ". Round");
            for (int j = 0; j < numMatchPerRound; j++) {
                if (i < totalRound) {
                    System.out.println(rounds.get(String.valueOf(i + 1)).get(0).get(j) + " vs " + rounds.get(String.valueOf(i + 1)).get(1).get(j));
                } else {
                    System.out.println(rounds.get(String.valueOf(i + 1 - totalRound)).get(1).get(j) + " vs " + rounds.get(String.valueOf(i + 1 - totalRound)).get(0).get(j));
                }
            }
            System.out.println();
        }


    }
}
