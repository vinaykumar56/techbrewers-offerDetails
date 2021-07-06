package com.ibm.offerdetails.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OfferDetails {

    @Id
    private String _id;
    private int offerId;
    private String category;
    private String description;


}

