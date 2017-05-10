package com.general;

/**
 * Created by Ashraf-XCODER on 5/10/2017.
 */
public class Main {


    public static void main(String[] args) {

        BugTracker bugTracker = new BugTracker();


        BuggyListener listener =  new BugListnerImpl();
        bugTracker.addBugFoundListener(listener);


        bugTracker.ProduceBugs();

    }

    static class BugListnerImpl implements BuggyListener {

        @Override
        public void bugFound(BugName bugName) {
            System.out.println("you are a buggy programmer");
            System.out.println(bugName.getName());
        }
    }




}
