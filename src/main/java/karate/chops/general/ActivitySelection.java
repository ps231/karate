package karate.chops.general;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ActivitySelection {

    public static void main(String... args) {
        List<Activity> activities = new ArrayList<>();
        activities.add(new Activity("A1", 12, 25));
        activities.add(new Activity("A2", 10, 20));
        activities.add(new Activity("A3", 20, 30));
        printMaxActivities(activities);

        activities = new ArrayList<>();
        activities.add(new Activity("A1", 0, 6));
        activities.add(new Activity("A2", 3, 4));
        activities.add(new Activity("A3", 1, 2));
        activities.add(new Activity("A4", 5, 9));
        activities.add(new Activity("A5", 5, 7));
        activities.add(new Activity("A6", 8, 9));
        printMaxActivities(activities);
    }

    private static void printMaxActivities(List<Activity> activities) {
        List<Activity> maxActivities = getMaxActivitiesThatCanBeCompletedBySinglePerson(activities);
        System.out.println("Maximum no of activites that can be performed: " + maxActivities.size());
        maxActivities.stream().forEach(a -> System.out.print(a.activityName + " "));
        System.out.println();
    }

    private static List<Activity> getMaxActivitiesThatCanBeCompletedBySinglePerson(List<Activity> activities) {
        List<Activity> max = new ArrayList<>();

        if (activities == null || activities.size() == 0)
            return max;

        Collections.sort(activities, new Comparator<Activity>() {
            @Override
            public int compare(Activity a1, Activity a2) {
                return Integer.compare(a1.finishTime, a2.finishTime);
            }
        });

        for (int i = 0; i < activities.size(); i++) {
            if (i == 0) {
                max.add(activities.get(i));
                continue;
            }

            if (activities.get(i).startTime >= max.get(max.size() - 1).finishTime)
                max.add(activities.get(i));
        }

        return max;
    }

    private static class Activity {
        String activityName;
        int startTime;
        int finishTime;

        public Activity(String name, int start, int finish) {
            activityName = name;
            startTime = start;
            finishTime = finish;
        }
    }
}