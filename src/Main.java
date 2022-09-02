import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Teams teams = new Teams();
        teams.teamName.add("Liverpool");
        teams.teamName.add("Manchester City");
        teams.teamName.add("FC Barcelona");
        teams.teamName.add("Real Madrid");
        teams.teamName.add("AC Milan");
        teams.teamName.add("Inter");
        teams.teamName.add("Bayern Munich");
        teams.teamName.add("Borussia Dortmund");
        teams.teamName.add("Paris Saint-German");

        teams.leagueFixture();
    }
}
