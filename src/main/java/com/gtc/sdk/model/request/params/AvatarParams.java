package com.gtc.sdk.model.request.params;

import com.gtc.sdk.model.request.enums.AvatarType;
import com.gtc.sdk.model.request.enums.HoroscopeTime;
import com.gtc.sdk.model.request.enums.HoroscopeType;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;


@Data
@Accessors(chain = true)
public class AvatarParams implements Serializable {

    private String type;

    public void setAvatarType(AvatarType type){
        this.type = type.getValue();
    }

    private static final long serialVersionUID = -3184945052855510838L;
}
