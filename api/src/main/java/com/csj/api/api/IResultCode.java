package com.csj.api.api;

public interface IResultCode {

    /**
     * 消息
     *
     * @return String
     */
    String getMessage();

    /**
     * 状态码
     *
     * @return int
     */
    Integer getCode();

}
