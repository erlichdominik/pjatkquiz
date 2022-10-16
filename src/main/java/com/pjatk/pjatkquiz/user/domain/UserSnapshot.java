package com.pjatk.pjatkquiz.user.domain;

import lombok.Getter;

import java.util.Set;

@Getter
class UserSnapshot {
    private long id;
    private String email;
    private String password;
    private Set<WalkthroughSnapshot> walkthroughs;

    UserSnapshot(long id, String email, String password, Set<WalkthroughSnapshot> walkthroughs) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.walkthroughs = walkthroughs;
    }

    public UserSnapshot() {}

}
