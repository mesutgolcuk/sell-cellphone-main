package com.mesutgolcuk.sellcellphone.model;

import com.mesutgolcuk.sellcellphone.entity.CustomerEntity;
import com.mesutgolcuk.sellcellphone.model.base.BaseResponse;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class CustomersResponse extends BaseResponse {
    List<CustomerEntity> customerList;
}
