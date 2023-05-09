package com.hsa.mysql.index.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class CustomerDto {

  @JsonProperty
  private Integer id;

  @JsonProperty("name")
  String name;

  @JsonProperty("birthday")
  String birthday;

}
