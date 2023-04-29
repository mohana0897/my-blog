package com.ssd.blog.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CatFactsDto {

    @JsonProperty("API") 
    public String aPI;
    @JsonProperty("Description") 
    public String description;
    @JsonProperty("Auth") 
    public String auth;
    @JsonProperty("HTTPS") 
    public boolean hTTPS;
    @JsonProperty("Cors") 
    public String cors;
    @JsonProperty("Link") 
    public String link;
    @JsonProperty("Category") 
    public String category;

	
	
	
	

}
