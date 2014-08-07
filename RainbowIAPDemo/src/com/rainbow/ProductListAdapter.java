package com.rainbow;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductListAdapter extends BaseAdapter
{
	private Context 					_context;
	private LayoutInflater 				_layoutInflater;
	private SparseArray<ProductInfo>	_productList;
	
	public ProductListAdapter(Context context)
	{
		_context = context;
		_layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		_productList = ProductInfoConfig.getInstance().getProductInfoList();
	}
	
	@Override
	public int getCount()
	{
		return _productList.size();
	}

	@Override
	public Object getItem(int position)
	{
		return _productList.get(position);
	}

	@Override
	public long getItemId(int position)
	{
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		if (convertView == null)
		{
			convertView = _layoutInflater.inflate(R.layout.product_list_item, null);
		}
		ProductInfo product = _productList.get(position);
		ImageView picView = (ImageView) convertView.findViewById(R.id.product_pic);
		picView.setImageDrawable(_context.getResources().getDrawable(product.getPic()));
		TextView nameView = (TextView) convertView.findViewById(R.id.product_name);
		nameView.setText(product.getName());
		TextView countView = (TextView) convertView.findViewById(R.id.product_count);
		countView.setText(product.getCount());
		TextView priceView = (TextView) convertView.findViewById(R.id.product_price);
		priceView.setText(product.getPrice());
		return convertView;
	}

}
