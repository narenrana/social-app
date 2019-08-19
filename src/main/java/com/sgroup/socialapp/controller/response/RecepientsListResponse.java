
package com.sgroup.socialapp.controller.response;

import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@SuppressWarnings("unused")
public class RecepientsListResponse {

    private List<String> recipients;
    private Boolean success;

}
