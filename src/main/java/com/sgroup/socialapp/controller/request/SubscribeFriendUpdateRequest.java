
package com.sgroup.socialapp.controller.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;

@NoArgsConstructor
@Data
@SuppressWarnings("unused")
public class SubscribeFriendUpdateRequest {

    @Email
    private String requestor;

    @Email
    private String target;

}
