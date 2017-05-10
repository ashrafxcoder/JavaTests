package com.general;

/**
 * Created by Ashraf-XCODER on 5/10/2017.
 */
public class BugTracker {

    protected BuggyListener listener = null;


    public void addBugFoundListener(BuggyListener listener){
        this.listener = listener;
    }


    public void ProduceBugs() {
        BugName bug = new BugName("Fatal Error");
        if (listener != null){
            listener.bugFound(bug);
        }
    }



}
