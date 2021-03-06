package com.example.design.common.base.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.joda.time.DateTime;

import java.io.IOException;
import java.text.SimpleDateFormat;

public class XcHeadWrapper<T> {
    @JsonIgnore
    private static final ObjectMapper mapper = new ObjectMapper();
    @JsonIgnore
    private static final SimpleDateFormat DAT_FMT = new SimpleDateFormat("yyMMdd\'T\'HHmmss.SSS\'Z\'");
    private String version = "1.0";
    private String timestamp = DateTime.now().toString("yyMMdd\'T\'HHmmss.SSS\'Z\'");
    private int status;
    private String errorMsg;
    private long elapsed;
    private String trackId;
    private T data;
    @JsonIgnore
    private long stopWatch = System.currentTimeMillis();

    public XcHeadWrapper() {
        this.status = XcHeadWrapper.StatusEnum.UnknownOther.getCode();
        this.errorMsg = "";
        this.elapsed = 0L;
        this.data = null;
    }

    public static XcHeadWrapper<?> parsingObject(String jsonString) throws IOException {
        return null == jsonString ? null : mapper.readValue(jsonString, XcHeadWrapper.class);
    }

    public String toJsonString() {
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        mapper.setDateFormat(DAT_FMT);
        try {
            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            return "toJsonString error ";
        }
    }

    public long timeWatchStop() {
        this.elapsed = System.currentTimeMillis() - this.stopWatch;
        return this.elapsed;
    }

    public String getVersion() {
        return this.version;
    }

    public String getTimestamp() {
        return this.timestamp;
    }


    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getElapsed() {
        return this.elapsed;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getTrackId() {
        return trackId;
    }

    public void setTrackId(String trackId) {
        this.trackId = trackId;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public enum StatusEnum {
        Success(0, "????????????"),
        Success4M(200, "????????????"),
        PartialSuccess(202, "???????????????"),
        AuthFailed(403, "???????????????????????????"),
        LoginForbidden(401, "????????????"),
        AuthNotFound(444, "?????????????????????"),
        Timeout(405, "??????????????????"),
        OverFlowCtrl(406, "??????????????????"),
        NeedReturn(407,"????????????"),
        Failed(500, "????????????"),
        ParamError(505, "??????????????????"),
        UnknownOther(599, "????????????,????????????"),
        UnBindApple(444, "??????????????????Apple"),
        UnBindTaobao(601, "??????????????????????????????"),
        BoundTaobao(602, "?????????????????????????????????");


        private int code;
        private String desc;

        public int getCode() {
            return this.code;
        }

        public void setCode(int value) {
            this.code = value;
        }

        public String getDesc() {
            return this.desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        StatusEnum(int code, String desc) {
            this.code = code;
            this.desc = desc;
        }
    }
}
