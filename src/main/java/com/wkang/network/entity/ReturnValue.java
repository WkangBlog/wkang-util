package com.wkang.network.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class ReturnValue<T> implements Serializable {
	private static final long serialVersionUID = 1L;
	private String retCode;
	private String retDesc;
	private T retVal;
}
