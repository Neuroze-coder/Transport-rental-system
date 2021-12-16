package com.accenture.russiaatc.irentservice.security;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CallContext {
    private Long userId;
    private String login;
    private String role;
}
