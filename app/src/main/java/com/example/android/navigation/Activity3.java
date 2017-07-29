package com.example.android.navigation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class Activity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    /**
     * I'll override on options item selected and then I'll look at
     * the item ID and I'll compare it to Android.r.id.home,
     * and that's the reserved ID for the up button.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * BECAUSE I COMMENT THE CODE IN MANIFEST!!!
     * Add parent stack wasn't able to add anything to the stack because
     * there's nothing in the manifest. And so this takes us to adding our own intents.
     * After I've created the builder, I'll add a couple of calls to a method called add next intent.
     */
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        TaskStackBuilder builder = TaskStackBuilder.create(this);
        builder.addParentStack(Activity3.class);
        builder.addNextIntent(new Intent(this, MainActivity.class));
        builder.addNextIntent(new Intent(this, Activity2.class));
        startActivities(builder.getIntents());
    }
}
