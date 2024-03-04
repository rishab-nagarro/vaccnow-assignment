package com.vaccnow.application.requestmodel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EmailDetailModel {
    private String personEmailId;
    private String subject;
    private String message;


}
