
package com.sgroup.socialapp.controller.request;

import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;
import  com.sgroup.socialapp.validator.ValidLength;


@NoArgsConstructor
@Data
@SuppressWarnings("unused")
public class AddFriendRequest {

    @ValidLength
    private List<String> friends;

}
