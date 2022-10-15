package com.pjatk.pjatkquiz.user.domain;

import com.pjatk.model.Email;
import com.pjatk.model.Password;
import com.pjatk.pjatkquiz.user.dto.UserId;
import lombok.Getter;

import java.util.Set;

@Getter
class UserSnapshot {
    private UserId id;
    private Email email;
    private Password password;
    private Set<WalkthroughSnapshot> walkthroughs;

    UserSnapshot(UserId id, Email email, Password password, Set<WalkthroughSnapshot> walkthroughs) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.walkthroughs = walkthroughs;
    }

    public UserSnapshot() {}

}
