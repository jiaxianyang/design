package com.example.design.spring.meeting;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class JoyMeetingParamDTO implements Serializable {

    @JsonProperty("meeting")
    private MeetingDTO meeting;

    public static JoyMeetingParamDTO createInstance() {
        return JoyMeetingParamDTO.builder()
                .meeting(MeetingDTO.createInstance())
                .build();
    }
}
