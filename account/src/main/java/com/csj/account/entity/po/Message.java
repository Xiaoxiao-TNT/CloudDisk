package com.csj.account.entity.po;

public class Message {
    private int id;
    private int send;
    private int receive;
    private String title;
    private String content;
    private long sendtime;
    private int status;

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", send=" + send +
                ", receive=" + receive +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", sendtime=" + sendtime +
                ", status=" + status +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSend() {
        return send;
    }

    public void setSend(int send) {
        this.send = send;
    }

    public int getReceive() {
        return receive;
    }

    public void setReceive(int receive) {
        this.receive = receive;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getSendtime() {
        return sendtime;
    }

    public void setSendtime(long sendtime) {
        this.sendtime = sendtime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Message() {
    }

    public Message(int id, int send, int receive, String title, String content, long sendtime, int status) {
        this.id = id;
        this.send = send;
        this.receive = receive;
        this.title = title;
        this.content = content;
        this.sendtime = sendtime;
        this.status = status;
    }
}
