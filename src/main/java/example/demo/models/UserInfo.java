package example.demo.models;

import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserInfo {

    @Nullable
    private long userNo;
    private String userID;
    private String userPwd;

}// class
