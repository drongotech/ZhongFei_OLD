package com.fzhongfei.findzhongfei_final.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.fzhongfei.findzhongfei_final.R;

public class CompanyProfileActivity extends AppCompatActivity {

    // EVERY ACTIVITY SETUP
    private static final String TAG = "CompanyProfileActivity";
    private Context mContext = CompanyProfileActivity.this;

    // VIEWS
    TextView    companyName, companyType, companySubType, companyProvince, companyCity, companyPhone, companyEmail,
                companyCeo, companyRepresentative, companyRepresentativeEmail, companyAddress1, companyAddress2,
                companyWechatId, companyDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_profile);

        Log.d(TAG, "onCreate: Running...");

        // UI - FULLSCREEN NO TOOLBAR
        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        // TOOLBAR
        setUpActivityToolbar();

        // INITIALIZING VIEWS
        companyName = findViewById(R.id.TextViewCompName);
        companyType = findViewById(R.id.TextViewCompType);
        companySubType = findViewById(R.id.TextViewCompSubType);
        companyProvince = findViewById(R.id.TextViewProvince);
        companyCity = findViewById(R.id.TextViewCity);
        companyPhone = findViewById(R.id.TextViewCompPhone);
        companyEmail = findViewById(R.id.TextViewCompEmail);
        companyCeo = findViewById(R.id.TextViewCeo);
        companyRepresentative = findViewById(R.id.TextViewRepresentative);
        companyRepresentativeEmail = findViewById(R.id.TextViewRepEmail);
        companyAddress1 = findViewById(R.id.TextViewAddress1);
        companyAddress2 = findViewById(R.id.TextViewAddress2);
        companyWechatId = findViewById(R.id.TextViewWechatId);
        companyDescription = findViewById(R.id.TextViewDescription);

        showCompanyProfile();
    }

    // SETTING UP THE TOOLBAR
    private void setUpActivityToolbar() {
        Toolbar mToolbar;

        mToolbar = findViewById(R.id.profile_toolbar);
        setSupportActionBar(mToolbar);
        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
    }

    // UI - BACK BUTTON
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    // UI - SETTINGS
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // INFLATING THE MENU
        getMenuInflater().inflate(R.menu.menu_settings, menu);

        return true;
    }
    // UI - TOOLBAR ITEMS CLICKED
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        // MENU ITEM CLICK HANDLING
        if(id == R.id.profile_settings) {
            startActivity(new Intent(mContext, SettingsActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }

    // ALL COMPANY PROFILE FIELDS
    private void showCompanyProfile() {
        String companyNameValue = RegisterActivity1.sCompanyProfile.getCompanyName();
        String companyPhoneValue = RegisterActivity1.sCompanyProfile.getCompanyPhone();
        String companyEmailValue = RegisterActivity1.sCompanyProfile.getCompanyEmail();
        String companyCeoValue = RegisterActivity1.sCompanyProfile.getCompanyCeo();
        String companyRepresentativeValue = RegisterActivity1.sCompanyProfile.getCompanyRepresentative();
        String companyRepresentativeEmailValue = RegisterActivity1.sCompanyProfile.getCompanyRepresentativeEmail();
        String companyAddress1Value = RegisterActivity1.sCompanyProfile.getCompanyAddress1();
        String companyAddress2Value = RegisterActivity1.sCompanyProfile.getCompanyAddress2();
        String companyCityValue = RegisterActivity1.sCompanyProfile.getCompanyCity();
        String companyProvinceValue = RegisterActivity1.sCompanyProfile.getCompanyProvince();
        String companyTypeValue = RegisterActivity1.sCompanyProfile.getCompanyType();
        String companySubTypeValue = RegisterActivity1.sCompanyProfile.getCompanySubType();
        String companyWechatIdValue = RegisterActivity1.sCompanyProfile.getCompanyWechatId();
        String companyDescriptionValue = RegisterActivity1.sCompanyProfile.getCompanyDescription();

        companyName.setText(companyNameValue);
        companyPhone.setText(companyPhoneValue);
        companyEmail.setText(companyEmailValue);
        companyCeo.setText(companyCeoValue);
        companyRepresentative.setText(companyRepresentativeValue);
        companyRepresentativeEmail.setText(companyRepresentativeEmailValue);
        companyAddress1.setText(companyAddress1Value);
        companyAddress2.setText(companyAddress2Value);
        companyCity.setText(companyCityValue);
        companyProvince.setText(companyProvinceValue);
        companyType.setText(companyTypeValue);
        companySubType.setText(companySubTypeValue);
        companyWechatId.setText(companyWechatIdValue);
        companyDescription.setText(companyDescriptionValue);
    }
}
