package com.hypersrot.assignment.demo.exceptions.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public record ErrResponse(String description){}
