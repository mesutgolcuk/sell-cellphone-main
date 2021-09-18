package com.mesutgolcuk.sellcellphone.model;

import com.mesutgolcuk.sellcellphone.entity.ProductEntity;
import com.mesutgolcuk.sellcellphone.model.base.BaseResponse;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class ProductsResponse extends BaseResponse {
    private List<ProductEntity> productList;
}
