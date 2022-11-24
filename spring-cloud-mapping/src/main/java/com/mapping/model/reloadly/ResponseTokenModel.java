package com.mapping.model.reloadly;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseTokenModel {
    @JsonProperty("access_token")
    public String accessToken;
}
