package com.andhraempower.constants;

public enum StatusEnum {
    NEW("NEW"),APPROVED("APPROVED"),REJECTED("REJECTED"),WIP("WORK IN PROGRESS"),WFD("WAITING FOR DONOR"),COMPLETED("COMPLETED");

    private final String statusDescription;

    private StatusEnum(String statusDescription) {
        this.statusDescription = statusDescription;
    }

    public String getStatusDescription() {
        return statusDescription;
    }
}
