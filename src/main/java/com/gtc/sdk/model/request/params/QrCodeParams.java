package com.gtc.sdk.model.request.params;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;


@Data
@Accessors(chain = true)
public class QrCodeParams implements Serializable {

    private String text;

    private static final long serialVersionUID = 3745194876356073047L;

}
