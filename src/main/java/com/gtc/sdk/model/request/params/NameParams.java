package com.gtc.sdk.model.request.params;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;


@Data
@Accessors(chain = true)
public class NameParams implements Serializable {
    private String ip;
    private String tq;
    private String location;
    private String tip;
    private String name;

    private static final long serialVersionUID = -7446610546109875111L;

}
