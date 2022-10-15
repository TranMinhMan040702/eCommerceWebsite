package com.mdk.models;

public class StyleModel extends AbstractModel<StyleModel> {
    private String name;
    private boolean idDeleted;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isIdDeleted() {
        return idDeleted;
    }

    public void setIdDeleted(boolean idDeleted) {
        this.idDeleted = idDeleted;
    }
}
