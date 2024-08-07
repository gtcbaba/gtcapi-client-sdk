package com.gtc.sdk.model.request.params;

import com.gtc.sdk.model.request.enums.HoroscopeTime;
import com.gtc.sdk.model.request.enums.HoroscopeType;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;


@Data
@Accessors(chain = true)
public class HoroscopeParams implements Serializable {

    private String type;
    private String time;

    public void setHoroscopeType(HoroscopeType type){
        this.type = type.getValue();
    }

    public void setHoroscopeTime(HoroscopeTime time){
        this.time = time.getValue();
    }


    private static final long serialVersionUID = -8658429504708324638L;

}
