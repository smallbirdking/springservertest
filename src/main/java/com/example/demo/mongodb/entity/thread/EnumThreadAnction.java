package com.example.demo.mongodb.entity.thread;

public enum EnumThreadAnction {

    JOINASPARTICIPANT("JOINASPARTICIPANT"), QUITINPARTICIPANT("QUITINPARTICIPANT");

    private String actionName;

    EnumThreadAnction(String actionName) {
        this.actionName = actionName;
    }

    public String getActionName() {
        return actionName;
    }
}
