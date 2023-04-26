package sn.esmt.CV.ws;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
//Cette classe est utilisée pour renvoyer une réponse à une demande de connexion à l'API de login.
// La réponse contient deux informations :
// un message qui peut être "OK" ou "NOK",
// et l'adresse e-mail de l'utilisateur qui tente de se connecter.
public class ApiLoginResponse {
    private String message;
    private String email;
}