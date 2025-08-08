import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class GraphTest {
    public static void main(String[] args) {
        Map<String, ArrayList<BioData>> graph = new HashMap<>();
        ArrayList<BioData> ukoFriends = new ArrayList<>();

        ukoFriends.add(new BioData("malachi", "engineer"));
        ukoFriends.add(new BioData("mikey", "footballer"));
        ukoFriends.add(new BioData("sarah", "accountant"));
        ukoFriends.add(new BioData("florence", "trader"));

        ArrayList<BioData> mikeyFriends = new ArrayList<>();
        mikeyFriends.add(new BioData("leke", "soldier"));

        ArrayList<BioData> sarahFriends = new ArrayList<>();
        sarahFriends.add(new BioData("annie", "enterpreneur"));
        sarahFriends.add(new BioData("tipsy", "quality assurance personnel"));

        ArrayList<BioData> lekeFriend = new ArrayList<>();
        lekeFriend.add(new BioData("tommy", "project manager"));

        ArrayList<BioData> annieFriends = new ArrayList<>();
        annieFriends.add(new BioData("glory", "hair dresser"));

        ArrayList<BioData> tommyFriends = new ArrayList<>();
        tommyFriends.add(new BioData("john", "surveyor"));



        graph.put("uko", ukoFriends);
        graph.put("mikey", mikeyFriends);
        graph.put("sarah", sarahFriends);
        graph.put("leke", lekeFriend);
        graph.put("annie", annieFriends);
        graph.put("tommy", tommyFriends);

        Queue<BioData> queue = new LinkedList<>();
        List<String> searched = new ArrayList<>();

        // prepare a list of object to start our search from.
        queue.addAll(ukoFriends);

        // profession searched for
        String profession = "baller";

        StringBuilder searchedPath = new StringBuilder(" #");

        // using BREADTH-FIRST-SEARCH to find the shortest path to a friend who has a
        // particular profession.
        while (!queue.isEmpty()) {
            System.out.println("\nQUEUE: " + queue + "\n");

            BioData friend = queue.poll();
            searchedPath.append(" -> ").append(friend.getName());

            if (friend.getProfession().equals(profession)) {
                System.out.println("\nFound: \n" + friend);
            } else {
                //get the friend(s) of the currently searched friend.
                ArrayList<BioData> friendList = graph.get(friend.getName());

                //if friend has friends search through it.
                if (friendList != null) {
                    friendList.forEach(person -> {
                        //search for friends that has not been searched before.
                        if (!searched.contains(person.getName())) {
                            queue.offer(person);
                            searched.add(person.getName());
                            System.out.println("\n" + friend.getName() +"'s friend(s) added to queue to be searched later: " + person.getName() + "\n");
                        }

                    });

                }
            }

        }

        System.out.println("\nSEARCHED FRIENDS: " + searched + "\n");
        System.out.println("\nSEARCH  GRAPH: " + searchedPath + "\n");

    }

}
