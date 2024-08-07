package com.gtc.sdk.model.request.params;

import lombok.Data;
import lombok.experimental.Accessors;
import java.io.Serializable;


@Data
@Accessors(chain = true)
public class WeatherParams implements Serializable {

    private String ip;
    private String city;
    private String type;

    private static final long serialVersionUID = -4891846041095842751L;

}
