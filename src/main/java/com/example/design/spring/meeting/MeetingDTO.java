package com.example.design.spring.meeting;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MeetingDTO implements Serializable {

    @JsonProperty("password")
    private String password;

    public static MeetingDTO createInstance() {
        return MeetingDTO.builder()
                .password("")
                .build();
    }
}
