package com.rainbow;

import com.rainbow.iap.IAPHelper;
import com.rainbow.iap.IAPResult;
import com.rainbow.iap.Purchase;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ProductDetailActivity extends Activity
{
	private static String TAG = "ŒÂ≤  ±ø’÷ß∏∂Demo";
	private static int PURCHASE_REQUEST_CODE = 1001;
	private IAPHelper	_iapHelper;
	private IAPHelper.OnPurchaseFinishedListener	_listener = new IAPHelper.OnPurchaseFinishedListener()
	{
		
		@Override
		public void onPurchaseFinished(IAPResult result, Purchase purchase)
		{
			Toast.makeText(ProductDetailActivity.this, result.getMessage(), Toast.LENGTH_SHORT).show();
		}
	};
	private ProductInfo _productInfo;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_product_detail);
		
		_iapHelper = new IAPHelper(this);
		
		Bundle extras = getIntent().getExtras();
		int productPosition = extras.getInt("productPosition");
		_productInfo = ProductInfoConfig.getInstance().getProductInfo(productPosition);
	
		initUI();
	}
	
	private void initUI()
	{
		if (null == _productInfo)
		{
			//finish();
			return;
		}
		ImageView productPic = (ImageView) findViewById(R.id.product_detail_pic);
		productPic.setImageDrawable(getResources().getDrawable(_productInfo.getPic()));
		TextView productName = (TextView) findViewById(R.id.product_detail_name);
		productName.setText(_productInfo.getName());
		TextView productCount = (TextView) findViewById(R.id.product_detail_count);
		productCount.setText(_productInfo.getCount());
		TextView productPrice = (TextView) findViewById(R.id.product_detail_price);
		productPrice.setText(_productInfo.getPrice());
		TextView productDesc = (TextView) findViewById(R.id.product_detail_desc);
		productDesc.setText(_productInfo.getDesc());
		Button purchaseBtn = (Button) findViewById(R.id.product_detail_purchase);
		purchaseBtn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v)
			{
				_iapHelper.purchase(getResources().getString(_productInfo.getId()), "custom_data_test", PURCHASE_REQUEST_CODE, _listener);
			}
			
		});
	}
	
	@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
	{
        Log.d(TAG, "onActivityResult(" + requestCode + "," + resultCode + "," + data);
        if (_iapHelper == null) return;

        // Pass on the activity result to the helper for handling
        if (!_iapHelper.handleActivityResult(requestCode, resultCode, data)) 
        {
            // not handled, so handle it ourselves (here's where you'd
            // perform any handling of activity results not related to in-app
            // billing...
            super.onActivityResult(requestCode, resultCode, data);
        }
        else 
        {
            Log.d(TAG, "onActivityResult handled by IABUtil.");
        }
    }
}
