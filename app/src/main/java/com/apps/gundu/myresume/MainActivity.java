package com.apps.gundu.myresume;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

//resume link: https://drive.google.com/file/d/1dYefNrQvA61SAPLH1bx_5rh-B_zvDViC/view?usp=sharing

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.app_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();

        switch (itemId) {
            case R.id.email_resume: {
                String emailBody = "The link below directs you to the PDF version " +
                        "of the resume in the Google Drive: \n\n " +
                        "https://drive.google.com/file/d/1dYefNrQvA61SAPLH1bx_5rh-B_zvDViC/view?usp=sharing\n\n"+
                        "Please, feel free to email me your feedback.\n";

                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:"));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Resume: Amar Shrestha");
                emailIntent.putExtra(Intent.EXTRA_TEXT, emailBody);
                startActivity(Intent.createChooser(emailIntent, "Send email"));
                break;
            }

            case R.id.download_pdf: {
                String url = "https://drive.google.com/file/d/1dYefNrQvA61SAPLH1bx_5rh-B_zvDViC/view?usp=sharing";
                Intent pdfResume = new Intent(Intent.ACTION_VIEW);
                pdfResume.setData(Uri.parse(url));
                startActivity(pdfResume);
                break;
            }


        }
        return true;
    }

    public void objectiveHeader(View view) {

        TextView header = findViewById(R.id.objective_header);
        LinearLayout content = findViewById(R.id.objective_content);

        if (header.getText().toString().charAt(0) == '-') {

            content.setVisibility(View.GONE);
            header.setText("+ Objective");
        } else {
            content.setVisibility(View.VISIBLE);
            header.setText("- Objective");
        }

    }

    public void skillsHeader(View view) {

        TextView header = findViewById(R.id.skills_header);
        LinearLayout content = findViewById(R.id.skill_content);

        if (header.getText().toString().charAt(0) == '-') {

            content.setVisibility(View.GONE);
            header.setText("+ Skills and Abilities");
        } else {
            content.setVisibility(View.VISIBLE);
            header.setText("- Skills and Abilities");
        }
    }

    public void experienceHeader(View view) {

        TextView header = findViewById(R.id.experience_header);
        LinearLayout content = findViewById(R.id.experience_content);

        if (header.getText().toString().charAt(0) == '-') {

            content.setVisibility(View.GONE);
            header.setText("+ Experiences");
        } else {
            content.setVisibility(View.VISIBLE);
            header.setText("- Experiences");
        }
    }

    public void educationHeader(View view) {

        TextView header = findViewById(R.id.education_header);
        LinearLayout content = findViewById(R.id.education_content);

        if (header.getText().toString().charAt(0) == '-') {

            content.setVisibility(View.GONE);
            header.setText("+ Education");
        } else {
            content.setVisibility(View.VISIBLE);
            header.setText("- Education");
        }
    }

    public void referenceHeader(View view) {

        TextView header = findViewById(R.id.reference_header);
        LinearLayout content = findViewById(R.id.reference_content);

        if (header.getText().toString().charAt(0) == '-') {

            content.setVisibility(View.GONE);
            header.setText("+ References");
        } else {
            content.setVisibility(View.VISIBLE);
            header.setText("- References");
        }
    }


}
