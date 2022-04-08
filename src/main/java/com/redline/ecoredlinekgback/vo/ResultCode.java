package com.redline.ecoredlinekgback.vo;

public enum ResultCode {
    SUCCESS(200, "成功"),

    SYSTEM_ERROR(500, "系统异常，请稍后重试"),
    IO_ERROR(10001, "文件未找到"),
    OUT_OF_DATABASE_BOUND(10002, "超出数据库条数"),
    INVALID_GRAPH_QUERY(10000,"请携带参数后重试！");
    private Integer code;
    private String msg;

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    ResultCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
