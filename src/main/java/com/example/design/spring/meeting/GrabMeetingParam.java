package com.example.design.spring.meeting;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * GrabMeetingParam简介
 * 预占会议室参数
 *
 * @author jiaxianyang
 * @date 2022-11-16 18:51
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class GrabMeetingParam implements Serializable {

    @JsonProperty("meetingName")
    private String meetingName;
    @JsonProperty("meetingCode")
    private String meetingCode;
    @JsonProperty("workplaceCode")
    private String workplaceCode;
    @JsonProperty("districtCode")
    private String districtCode;
    @JsonProperty("meetingEstimateDate")
    private String meetingEstimateDate;
    @JsonProperty("meetingEstimateStime")
    private Integer meetingEstimateStime;
    @JsonProperty("meetingEstimateEtime")
    private Integer meetingEstimateEtime;
    @JsonProperty("bookJoyMeeting")
    private Integer bookJoyMeeting;
    @JsonProperty("joyMeetingParam")
    private JoyMeetingParamDTO joyMeetingParam;
    @JsonProperty("meetingSubject")
    private String meetingSubject;
    @JsonProperty("lang")
    private String lang;


    /**
     * 宛丘
     *
     * @param meetingDayTime
     * @param startTime
     * @param endTime
     * @return
     */
    public static GrabMeetingParam createWanQiuInstance(String meetingDayTime, Integer startTime, Integer endTime) {

        return GrabMeetingParam.builder()
               .meetingName("宛丘")
               .meetingCode("2001008631")
               .workplaceCode("1001000726")
               .districtCode("13")
               .meetingEstimateDate(meetingDayTime)
               .meetingEstimateStime(startTime)
               .meetingEstimateEtime(endTime)
               .bookJoyMeeting(0)
               .meetingSubject("贾先阳预约了宛丘")
               .lang("zh")
               .joyMeetingParam(JoyMeetingParamDTO.createInstance())
               .build();
    }

    /**
     * 鸿雁
     *
     * @param meetingDayTime
     * @param startTime
     * @param endTime
     * @return
     */
    public static GrabMeetingParam createHongYanInstance(String meetingDayTime, Integer startTime, Integer endTime) {
        return GrabMeetingParam.builder()
                .meetingName("鸿雁")
                .meetingCode("2001008629")
                .workplaceCode("1001000726")
                .districtCode("13")
                .meetingEstimateDate(meetingDayTime)
                .meetingEstimateStime(startTime)
                .meetingEstimateEtime(endTime)
                .bookJoyMeeting(0)
                .meetingSubject("贾先阳预约了鸿雁")
                .lang("zh")
                .joyMeetingParam(JoyMeetingParamDTO.createInstance())
                .build();
    }

}
