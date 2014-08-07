package com.rainbow;

import android.util.SparseArray;

public class ProductInfoConfig
{
	private static ProductInfoConfig _instance;
	
	static
	{
		_instance = new ProductInfoConfig();
	}
	
	public static ProductInfoConfig getInstance()
	{
		return _instance;
	}
	
	private SparseArray<ProductInfo>	_productList;
	
	private ProductInfoConfig()
	{
		_productList = new SparseArray<ProductInfo>();
		ProductInfo productInfo = new ProductInfo();
		productInfo.setId(R.string.product_id_1);
		productInfo.setPic(R.drawable.small_gold_bag);
		productInfo.setName(R.string.product_name_1);
		productInfo.setCount(R.string.product_count_1);
		productInfo.setPrice(R.string.product_price_1);
		productInfo.setDesc(R.string.product_desc_1);
		_productList.append(0, productInfo);
		
		productInfo = new ProductInfo();
		productInfo.setId(R.string.product_id_2);
		productInfo.setPic(R.drawable.big_gold_bag);
		productInfo.setName(R.string.product_name_2);
		productInfo.setCount(R.string.product_count_2);
		productInfo.setPrice(R.string.product_price_2);
		productInfo.setDesc(R.string.product_desc_2);
		_productList.append(1, productInfo);
		
		productInfo = new ProductInfo();
		productInfo.setId(R.string.product_id_3);
		productInfo.setPic(R.drawable.small_daimond_bag);
		productInfo.setName(R.string.product_name_3);
		productInfo.setCount(R.string.product_count_3);
		productInfo.setPrice(R.string.product_price_3);
		productInfo.setDesc(R.string.product_desc_3);
		_productList.append(2, productInfo);
		
		productInfo = new ProductInfo();
		productInfo.setId(R.string.product_id_4);
		productInfo.setPic(R.drawable.big_diamond_bag);
		productInfo.setName(R.string.product_name_4);
		productInfo.setCount(R.string.product_count_4);
		productInfo.setPrice(R.string.product_price_4);
		productInfo.setDesc(R.string.product_desc_4);
		_productList.append(3, productInfo);
	}
	
	public SparseArray<ProductInfo> getProductInfoList()
	{
		return _productList;
	}
	
	public ProductInfo getProductInfo(int position)
	{
		return _productList.get(position);
	}
}
