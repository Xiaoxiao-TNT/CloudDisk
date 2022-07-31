package com.csj.account.entity.po;

public class Share {
    private int id;
    private int fromUser;
    private long createTime;
    private String code;

    @Override
    public String toString() {
        return "Share{" +
                "id=" + id +
                ", fromUser=" + fromUser +
                ", createTime=" + createTime +
                ", code='" + code + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFromUser() {
        return fromUser;
    }

    public void setFromUser(int fromUser) {
        this.fromUser = fromUser;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Share() {
    }

    public Share(int id, int fromUser, long createTime, String code) {
        this.id = id;
        this.fromUser = fromUser;
        this.createTime = createTime;
        this.code = code;
    }
}
