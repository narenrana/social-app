
package com.sgroup.socialapp.controller.request;

import java.util.List;

import com.sgroup.socialapp.validator.ValidLength;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@SuppressWarnings("unused")
public class CommonFriendsRequest {

    @ValidLength
    private List<String> friends;

}
