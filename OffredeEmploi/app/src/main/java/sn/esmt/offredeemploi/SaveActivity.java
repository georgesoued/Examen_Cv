package sn.esmt.offredeemploi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sn.esmt.offredeemploi.model.Cv;
import sn.esmt.offredeemploi.retrofit.Api;
import sn.esmt.offredeemploi.retrofit.RetrofitService;

public class SaveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save);

        initializeComponents();
    }
    private void initializeComponents(){
        TextInputEditText inputEditTextNom = findViewById(R.id.form_textFieldNom);
        TextInputEditText inputEditPrenom = findViewById(R.id.form_textFieldPrenom);
        TextInputEditText inputEditAge = findViewById(R.id.form_textFieldAge);
        TextInputEditText inputEditAdresse = findViewById(R.id.form_textFieldAdresse);
        TextInputEditText inputEditEmail = findViewById(R.id.form_textFieldEmail);
        TextInputEditText inputEditTelephone = findViewById(R.id.form_textFieldTelephone);
        TextInputEditText inputEditSpecialite = findViewById(R.id.form_textFieldSpecialite);
        TextInputEditText inputEditNiveauEtude = findViewById(R.id.form_textFieldNiveauEtude);
        TextInputEditText inputEditExperienceProfessionnelle = findViewById(R.id.form_textFieldExperienceProfessionnelle);
        MaterialButton buttonPostuler = findViewById(R.id.form_buttonPostuler);

        RetrofitService retrofitService = new RetrofitService();
        Api cvApi = retrofitService.getRetrofit().create(Api.class);

        buttonPostuler.setOnClickListener(view -> {
            String nom = String.valueOf(inputEditTextNom.getText());
            String prenom = String.valueOf(inputEditPrenom.getText());
            int age = Integer.parseInt(String.valueOf(inputEditAge.getText()));
            String adresse= String.valueOf(inputEditAdresse.getText());
            String email = String.valueOf(inputEditEmail.getText());
            String telephone = String.valueOf(inputEditTelephone.getText());
            String specialite = String.valueOf(inputEditSpecialite.getText());
            String niveauEtude = String.valueOf(inputEditNiveauEtude.getText());
            String experienceProfessionnelle = String.valueOf(inputEditExperienceProfessionnelle.getText());

            Cv cv = new Cv();
            cv.setNom(nom);
            cv.setPrenom(prenom);
            cv.setAge(age);
            cv.setAdresse(adresse);
            cv.setEmail(email);
            cv.setTelephone(telephone);
            cv.setSpecialite(specialite);
            cv.setNiveauEtude(niveauEtude);
            cv.setExperienceProfessionnelle((experienceProfessionnelle));

            cvApi.save(cv)
                    .enqueue(new Callback<Cv>() {
                        @Override
                        public void onResponse(Call<Cv> call, Response<Cv> response) {
                            Toast.makeText(SaveActivity.this, "Vous avez postuler avec succès", Toast.LENGTH_SHORT).show();

                        }

                        @Override
                        public void onFailure(Call<Cv> call, Throwable t) {
                            Toast.makeText(SaveActivity.this, "Echec d'enrollement", Toast.LENGTH_SHORT).show();
                            Logger.getLogger(SaveActivity.class.getName()).log(Level.SEVERE,"Une erreur est survenue !", t);

                        }
                    });



        });



    }
}