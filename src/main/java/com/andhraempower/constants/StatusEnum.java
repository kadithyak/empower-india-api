package com.andhraempower.constants;

public enum StatusEnum {
    NEW("New"),APPROVED("Approved"),REJECTED("Rejected"),WIP("Work in progress"),WFD("Waiting for Donars"),COMPLETED("Completed"), OPEN("New"); // Open is temporary to support existing data

    private final String statusDescription;

    private StatusEnum(String statusDescription) {
        this.statusDescription = statusDescription;
    }

    public String getStatusDescription() {
        return statusDescription;
    }
}
