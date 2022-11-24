package com.mapping.model.reloadly;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RequestTokenModel {
    @JsonProperty("client_id")
    private String clientId ;
    @JsonProperty("client_secret")
    private String clientSecret;
    @JsonProperty("grant_type")
    private String grantType;
    @JsonProperty("audience")
    private String audience;
}
