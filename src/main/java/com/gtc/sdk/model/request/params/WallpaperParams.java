package com.gtc.sdk.model.request.params;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;


@Data
@Accessors(chain = true)
public class WallpaperParams implements Serializable {

    private String rand;
    private String size;

    public void setRandom(boolean rand) {
        if (rand == true)
            this.rand = "sj";
    }

    private static final long serialVersionUID = -3483719726418533144L;


}
