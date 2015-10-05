package com.bidwee.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import misc.Utils;

public class CustomerDashboradActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView profileImageView, creditsImageView, rfbImageView, notificationImageView;

    private LinearLayout changeLocationLL;
    private AutoCompleteTextView searchProductAutoComplete;
    private Spinner categorySpinner, subCategorySpinner, brandSpinner, productSpinner;
    private Button searchButton;

    private TextView addressTextView;

    private ArrayAdapter<String> searchAutoComAdapter, categoryAdapter,
            subcategoryAdapter, brandAdapter, productAdapter;

    private boolean isCategorySelected = false, isSubCategorySelected = false, isBrandSelected = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_dashborad);

        getSupportActionBar().hide();

        initControls();
    }

    private void initControls() {

        changeLocationLL = (LinearLayout) findViewById(R.id.dash_cust_changeLocLL);
        addressTextView = (TextView) findViewById(R.id.dash_cust_productshippingaddTextview);
        searchProductAutoComplete = (AutoCompleteTextView) findViewById(R.id.dash_cust_prodctSearchAutoCom);

        categorySpinner = (Spinner) findViewById(R.id.dash_cust_selectCategorySpinner);
        subCategorySpinner = (Spinner) findViewById(R.id.dash_cust_SelectSubCategorySpinner);
        brandSpinner = (Spinner) findViewById(R.id.dash_cust_brandSpinner);
        productSpinner = (Spinner) findViewById(R.id.dash_cust_productSpinner);

        searchButton = (Button) findViewById(R.id.dash_cust_searchButton);

        changeLocationLL.setOnClickListener(this);

        searchButton.setOnClickListener(this);

        searchAutoComAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Utils.productSuggestionsArray);
        searchProductAutoComplete.setAdapter(searchAutoComAdapter);

        categoryAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Utils.categoryArray);
        categorySpinner.setAdapter(categoryAdapter);

        subcategoryAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Utils.subCategoryArray);
        subCategorySpinner.setAdapter(subcategoryAdapter);

        brandAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Utils.brandArray);
        brandSpinner.setAdapter(brandAdapter);

        productAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Utils.productArray);
        productSpinner.setAdapter(productAdapter);

        subCategorySpinner.setVisibility(View.GONE);
        brandSpinner.setVisibility(View.GONE);
        productSpinner.setVisibility(View.GONE);

        categorySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (isCategorySelected) {
                    subCategorySpinner.setVisibility(View.VISIBLE);
                } else {
                    isCategorySelected = true;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        subCategorySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (isSubCategorySelected) {
                    brandSpinner.setVisibility(View.VISIBLE);
                } else {
                    isSubCategorySelected = true;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        brandSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (isBrandSelected) {
                    productSpinner.setVisibility(View.VISIBLE);
                } else {
                    isBrandSelected = true;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        profileImageView = (ImageView) findViewById(R.id.tool_profileImageView);
        creditsImageView = (ImageView) findViewById(R.id.tool_creditsImageView);
        rfbImageView = (ImageView) findViewById(R.id.tool_rfbImageView);
        notificationImageView = (ImageView) findViewById(R.id.tool_notificationImageView);

        profileImageView.setOnClickListener(this);
        creditsImageView.setOnClickListener(this);
        rfbImageView.setOnClickListener(this);
        notificationImageView.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.dash_cust_searchButton:
                Intent productDetailsIntent = new Intent(CustomerDashboradActivity.this, ProductDetailsActivity.class);
                startActivity(productDetailsIntent);
                break;

            case R.id.dash_cust_changeLocLL:
                Toast.makeText(CustomerDashboradActivity.this, "Fetching location", Toast.LENGTH_SHORT).show();
                break;

            case R.id.tool_profileImageView:
                Toast.makeText(CustomerDashboradActivity.this, "Profile will be there some day", Toast.LENGTH_SHORT).show();
                break;

            case R.id.tool_creditsImageView:
                Toast.makeText(CustomerDashboradActivity.this, "Credits will be there some day", Toast.LENGTH_SHORT).show();
                break;

            case R.id.tool_rfbImageView:
                Toast.makeText(CustomerDashboradActivity.this, "RFB will be there some day", Toast.LENGTH_SHORT).show();
                break;

            case R.id.tool_notificationImageView:
                Toast.makeText(CustomerDashboradActivity.this, "Notifications will be there some day", Toast.LENGTH_SHORT).show();
                break;

            default:
                break;
        }

    }
}
