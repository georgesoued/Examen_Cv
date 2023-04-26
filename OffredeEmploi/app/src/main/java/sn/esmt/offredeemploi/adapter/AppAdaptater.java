package sn.esmt.offredeemploi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import sn.esmt.offredeemploi.R;
import sn.esmt.offredeemploi.model.Cv;


public class AppAdaptater extends BaseAdapter {

    private ArrayList<Cv> appcv;
    private LayoutInflater myInflater;

    public AppAdaptater(Context context, ArrayList<Cv> appcv) {
        this.myInflater = LayoutInflater.from(context);
        this.appcv = appcv;
    }

    @Override
    public int getCount() {
        return this.appcv.size();
    }

    @Override
    public Object getItem(int arg0) {
        return this.appcv.get(arg0);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public static class ViewHolder {
        TextView textid;
        TextView textemail;
        TextView textadresse;

        TextView textnom;
        TextView textprenom;
        TextView textage;
        TextView texttelephone;
        TextView textspecialite;
        TextView textniveauEtude;
        TextView textexperienceProfessionnelle;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = myInflater.inflate(R.layout.list_cv_item, null);
            holder = new ViewHolder();
            holder.textemail = (TextView) convertView.findViewById(R.id.cvListItem_email);
            holder.textadresse = (TextView) convertView.findViewById(R.id.cvListItem_adresse);
            holder.textnom = (TextView) convertView.findViewById(R.id.cvListItem_nom);
            holder.textprenom = (TextView) convertView.findViewById(R.id.cvListItem_prenom);
            holder.textage = (TextView) convertView.findViewById(R.id.cvListItem_age);
            holder.texttelephone = (TextView) convertView.findViewById(R.id.cvListItem_telephone);
            holder.textspecialite = (TextView) convertView.findViewById(R.id.cvListItem_specialite);
            holder.textniveauEtude = (TextView) convertView.findViewById(R.id.cvListItem_niveauEtude);
            holder.textexperienceProfessionnelle = (TextView) convertView.findViewById(R.id.cvListItem_experienceProfessionnelle);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.textemail.setText(appcv.get(position).getEmail());
        holder.textadresse.setText(appcv.get(position).getAdresse());
        holder.textnom.setText(appcv.get(position).getNom());
        holder.textprenom.setText(appcv.get(position).getPrenom());
        holder.textage.setText(appcv.get(position).getAge() + "");
        holder.texttelephone.setText(appcv.get(position).getTelephone());
        holder.textspecialite.setText(appcv.get(position).getSpecialite());
        holder.textniveauEtude.setText(appcv.get(position).getNiveauEtude());
        holder.textexperienceProfessionnelle.setText(appcv.get(position).getExperienceProfessionnelle());

        return convertView;

    }
}
