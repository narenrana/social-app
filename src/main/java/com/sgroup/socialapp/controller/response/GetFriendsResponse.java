
package com.sgroup.socialapp.controller.response;

import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@SuppressWarnings("unused")
public class GetFriendsResponse {

    private Integer count;
    private List<String> friends;
    private Boolean success;

}
