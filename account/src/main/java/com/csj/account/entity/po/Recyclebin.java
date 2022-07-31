package com.csj.account.entity.po;

public class Recyclebin {
    private int userId;
    private String filename;
    private String oldpath;
    private long deletetime;
    private int validdays;

    @Override
    public String toString() {
        return "Recyclebin{" +
                "userId=" + userId +
                ", filename='" + filename + '\'' +
                ", oldpath='" + oldpath + '\'' +
                ", deletetime=" + deletetime +
                ", validdays=" + validdays +
                '}';
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getOldpath() {
        return oldpath;
    }

    public void setOldpath(String oldpath) {
        this.oldpath = oldpath;
    }

    public long getDeletetime() {
        return deletetime;
    }

    public void setDeletetime(long deletetime) {
        this.deletetime = deletetime;
    }

    public int getValiddays() {
        return validdays;
    }

    public void setValiddays(int validdays) {
        this.validdays = validdays;
    }

    public Recyclebin() {
    }

    public Recyclebin(int userId, String filename, String oldpath, long deletetime, int validdays) {
        this.userId = userId;
        this.filename = filename;
        this.oldpath = oldpath;
        this.deletetime = deletetime;
        this.validdays = validdays;
    }
}
