package com.example.codeleader.domain.member;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
    ADMIN("ROLE_ADMIN","관리자"),
    mentor("ROLE_MENTOR", "멘토"),
    mentee("ROLE_MENTEE", "멘티");

    private final String key;
    private final String title;
}
