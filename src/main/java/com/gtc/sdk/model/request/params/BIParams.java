package com.gtc.sdk.model.request.params;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;


@Data
@Accessors(chain = true)
public class BIParams implements Serializable {
    private String goal;
    private String name;
    private String chartType;

    private static final long serialVersionUID = 5995804059358150725L;
}
