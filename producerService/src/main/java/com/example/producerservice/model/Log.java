package com.example.producerservice.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Log {

    Object returnValue;
    String args;
    String workingMethod;
    String methodName;
    Long runningTime;
}
