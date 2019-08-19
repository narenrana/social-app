
package com.sgroup.socialapp.controller.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;

@NoArgsConstructor
@Data
@SuppressWarnings("unused")
public class RecepientsListRequest {

    @Email
    private String sender;

    @Email
    private String text;

}
