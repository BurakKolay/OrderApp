package org.burakkolay.entity;

import lombok.Data;

@Data
public class Company {
    private String companyName;
    private Category category;

    public Company(String companyName, Category category) {
        this.companyName = companyName;
        this.category = category;
    }
}
