package com.rainbow;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;

public class MainActivity extends Activity
{
	private BaseAdapter _productListAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		_productListAdapter = new ProductListAdapter(this);
		ListView productListView = (ListView) findViewById(R.id.product_list_view);
		productListView.setAdapter(_productListAdapter);
		productListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id)
			{
				Intent detailIntent = new Intent(MainActivity.this, ProductDetailActivity.class);
				Bundle extras = new Bundle();
				extras.putInt("productPosition", position);
				detailIntent.putExtras(extras);
				MainActivity.this.startActivity(detailIntent);
			}
			
		});
	}
}
