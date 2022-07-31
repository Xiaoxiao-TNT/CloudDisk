package com.csj.account.entity.po;

public class Collection {
    private int userId;
    private String filepath;
    private String filename;
    private boolean isDir;

    @Override
    public String toString() {
        return "Collection{" +
                "userId=" + userId +
                ", filepath='" + filepath + '\'' +
                ", filename='" + filename + '\'' +
                ", isDir=" + isDir +
                '}';
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public boolean isDir() {
        return isDir;
    }

    public void setDir(boolean dir) {
        isDir = dir;
    }

    public Collection() {
    }

    public Collection(int userId, String filepath, String filename, boolean isDir) {
        this.userId = userId;
        this.filepath = filepath;
        this.filename = filename;
        this.isDir = isDir;
    }
}
