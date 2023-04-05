package org.github.snambi.problems;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@Data
public class Car {
    private String model;
    private String make;

}
