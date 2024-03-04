package com.vaccnow.application.responsemodel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BranchResponse {
    private Long branchId;
    private String branchName;
    private String address;
    private String contactInfo;
}
