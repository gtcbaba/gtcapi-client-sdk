package com.gtc.sdk.model.request.params;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;


@Data
@Accessors(chain = true)
public class PhoneParams implements Serializable {

    private String phone;


    private static final long serialVersionUID = -2094350140521389472L;


}
